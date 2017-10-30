package it.f2informatica.couchbase.biblioteca.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.Bucket;

import it.f2informatica.couchbase.biblioteca.database.DBManager;

@Service
public class TestService {
	private final static Logger logger = LoggerFactory.getLogger(TestService.class);

	public static String testConnection() {
		logger.debug("Cerco di creare la connessione al bucket");
		Bucket b = DBManager.getBucket();
		if (b != null) {
			logger.debug("OK");
			return "OK";
		} else {
			logger.debug("KO");
			return "KO";
		}
	}

}
