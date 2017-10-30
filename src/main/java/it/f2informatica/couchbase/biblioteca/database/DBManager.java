package it.f2informatica.couchbase.biblioteca.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

@ConfigurationProperties(prefix = "couchbase")
@Component
public class DBManager {

	private static String bucketName;
	private static String host;

	// STEP 1: Database credentials
	private static String user;
	private static String password;

	private static Cluster cluster;
	private static Bucket bucket;
	// Definisco il logger
	private final static Logger logger = LoggerFactory.getLogger(DBManager.class);

	@Autowired
	public DBManager(@Value("${couchbase.host}") String host, @Value("${couchbase.bucket}") String bucketName, @Value("${couchbase.user}") String user,
			@Value("${couchbase.password}") String password) {

		setHost(host);
		setBucketName(bucketName);
		setUser(user);
		setPassword(password);

	}

	public static String getBucketName() {
		return bucketName;
	}

	public static void setBucketName(String bucketName) {
		DBManager.bucketName = bucketName;
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		DBManager.host = host;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		DBManager.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DBManager.password = password;
	}

	public static Bucket getBucket() {
		if (bucket == null || bucket.isClosed()) {
			logger.debug("Configurazione: host " + host + ", bucket " + bucketName + ", user " + user + ", password "
					+ password);
			// Creazione del riferimento al bucket
			// Initialize the Connection
			logger.debug("Creo un riferimento al cluster");
			cluster = CouchbaseCluster.create(host).authenticate(user, password);
			// cluster.authenticate("pier", "pierluigi");
			logger.debug("Apro il bucket " + bucketName);
			bucket = cluster.openBucket(bucketName);
			return bucket;
		} else {
			return bucket;
		}
	}

	public static void closeConnection() {
		if (cluster != null) {
			cluster.disconnect();
		}
	}

}
