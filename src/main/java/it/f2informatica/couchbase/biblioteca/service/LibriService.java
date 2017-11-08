package it.f2informatica.couchbase.biblioteca.service;

import static com.couchbase.client.java.query.Select.select;
import static com.couchbase.client.java.query.dsl.Expression.i;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.couchbase.client.core.CouchbaseException;
import com.couchbase.client.java.AsyncBucket;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.LegacyDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.AsyncN1qlQueryRow;
import com.google.gson.Gson;

import it.f2informatica.couchbase.biblioteca.database.DBManager;
import it.f2informatica.couchbase.biblioteca.domain.Libro;
import rx.Observable;

/**
 * @author pier
 *
 */
@Service
public class LibriService {
	private final static Logger logger = LoggerFactory.getLogger(LibriService.class);
	static ArrayList<Libro> lista;
	
	
	/**
	 * @return
	 */
	public static List<Libro> findAllBooks() {
		logger.debug("Ricavo la lista dei libri");
		AsyncBucket bucket = DBManager.getBucket().async();
		executeQuery(bucket);
		return lista;
	}
	
	
	/**
	 * @param isbn
	 * @return
	 */
	public static Libro findBook(String isbn) {
		logger.debug("Ricavo i dati del libro con ISBN="+isbn);
		Libro libro=null;
		Bucket bucket =DBManager.getBucket();
		Gson gson = new Gson();
		LegacyDocument legacy = bucket.get(isbn, LegacyDocument.class);
		libro =gson.fromJson((String) legacy.content(),Libro.class);
		return libro;

		
	}
	/**
	 * @param libro
	 * @return
	 */
	public static boolean upsertBook(Libro libro) {
		boolean result = false;
		logger.debug("Inserisco nel bucket il documento " + libro.toString());
		Gson gson = new Gson();
		Bucket bucket = DBManager.getBucket();
		LegacyDocument document = LegacyDocument.create(libro.getIsbn(), gson.toJson(libro));
		Object obj = bucket.upsert(document);
		if (obj != null) {
			logger.debug("Documento inserito");
			result = true;
		} else {
			logger.debug("Errore nell'inserimento del documento");
			result = false;
		}
		return result;
	}
	
	/**
	 * @param isbn
	 * @return
	 */
	public static boolean deleteBook(String isbn) {
		boolean result = false;
		logger.debug("Cancello dal bucket il documento con ISBN: " + isbn);
		Bucket bucket = DBManager.getBucket();
		Object obj = bucket.remove(isbn);
		if (obj != null) {
			logger.debug("Documento cancellato.");
			result = true;
		} else {
			logger.debug("Errore nella cancellazione del documento");
			result = false;
		}
		return result;
	}
	
	/**
	 * @param bucket
	 */
	private static void executeQuery(AsyncBucket bucket) {
		lista = new ArrayList<Libro>();
		logger.debug("Eseguo la query...");
		bucket
		.query(
				select("*")
				.from(i("test"))
				.where("isbn is not null"))
				
				
		.flatMap(result -> result.errors()
				.flatMap(
				e -> Observable.<AsyncN1qlQueryRow>error(new CouchbaseException("N1QL Error/Warning: " + e)))
				.switchIfEmpty(result.rows()))
		.map(AsyncN1qlQueryRow::value).toBlocking()
		.subscribe(rowContent -> addBookToList(rowContent), runtimeError -> runtimeError.printStackTrace());

	}
	/**
	 * @param obj
	 */
	private static void addBookToList(JsonObject obj) {
		logger.debug("Letto: "+obj.getObject("test").toString());
		Libro l = new Libro();
		Gson gson = new Gson();
		String json = obj.getObject("test").toString();
		l = gson.fromJson(json, Libro.class);
		lista.add(l);

	}
}
