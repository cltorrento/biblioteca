package it.f2informatica.couchbase.biblioteca.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.f2informatica.couchbase.biblioteca.domain.Libro;
import it.f2informatica.couchbase.biblioteca.service.LibriService;
import it.f2informatica.couchbase.biblioteca.service.TestService;

@RestController
@RequestMapping("/biblioteca")
public class MainController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET, value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> testCB() {
		String esito;
		logger.debug("Nel metodo testCB()");
		esito = TestService.testConnection();
		return new ResponseEntity<String>(esito, HttpStatus.ACCEPTED);

	}

	// ------------------- Ricerco tutti i libri
	// ---------------------------------------------

	@RequestMapping(value = "/libri/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> listAllBooks() {
		List<Libro> libri = LibriService.findAllBooks();
		if (libri.isEmpty()) {
			return new ResponseEntity<List<Libro>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Libro>>(libri, HttpStatus.OK);
	}

	// -------------- inserire un singolo libro
	// ---------------------------------------------
	@RequestMapping(method = RequestMethod.POST, value = "/insertlibro/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> insertLibro(@RequestBody Libro libro) {
		logger.debug("Ricevuto l'oggetto: " + libro.toString());

		boolean result = LibriService.upsertBook(libro);
		if (result) {
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ------------------- Ricerco un singolo libro
	// ---------------------------------------------

	@RequestMapping(value = "/getlibro/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> readLibro(@RequestParam String isbn) {
		Libro libro = LibriService.findBook(isbn);
		if (libro == null) {
			return new ResponseEntity<Libro>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}

	// -------------- modificare un singolo libro
	// ---------------------------------------------
	@RequestMapping(method = RequestMethod.PUT, value = "/updatelibro/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateLibro(@RequestBody Libro libro) {
		logger.debug("Ricevuto l'oggetto: " + libro.toString());

		boolean result = LibriService.upsertBook(libro);
		if (result) {
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// -------------- cancellare un singolo libro
	// ---------------------------------------------
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletelibro/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteLibro(@RequestBody Libro libro) {
		logger.debug("Ricevuto l'oggetto: " + libro.toString());

		boolean result = LibriService.deleteBook(libro.getIsbn());
		if (result) {
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
