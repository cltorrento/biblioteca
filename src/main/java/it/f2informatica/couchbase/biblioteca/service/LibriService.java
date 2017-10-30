package it.f2informatica.couchbase.biblioteca.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.LegacyDocument;
import com.google.gson.Gson;

import it.f2informatica.couchbase.biblioteca.database.DBManager;
import it.f2informatica.couchbase.biblioteca.domain.Libro;

@Service
public class LibriService {
	private final static Logger logger = LoggerFactory.getLogger(LibriService.class);

	public static boolean upsertLibro(Libro libro) {
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

}
