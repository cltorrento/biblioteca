package it.f2informatica.couchbase.biblioteca.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	//Insert a Book
	@RequestMapping(method = RequestMethod.POST, value = "/insertlibro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> insertLibro(@RequestBody Libro libro) {
		boolean result = LibriService.upsertLibro(libro);
		if (result) {
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
