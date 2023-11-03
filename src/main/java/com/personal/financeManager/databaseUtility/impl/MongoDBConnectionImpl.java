package com.personal.financeManager.databaseUtility.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.personal.financeManager.databaseUtility.DatabaseConnection;

/**
 * Do not modify this class.
 */
@Component
public class MongoDBConnectionImpl implements DatabaseConnection {

	@Autowired
	private Environment springEnvironment;

	private MongoClient mongoClient;

	public void initializeDatabaseProperties() {

		String url = springEnvironment.getProperty("spring.data.mongodb.url");

		mongoClient = MongoClients.create(url);

	}

	public MongoClient getConnection() {

		if (mongoClient == null)
			this.initializeDatabaseProperties();
		return mongoClient;
	}
}
