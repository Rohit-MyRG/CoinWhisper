package com.personal.financeManager.databaseUtility.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.ClusterOptions;
import com.couchbase.client.java.env.ClusterEnvironment;
import com.personal.financeManager.databaseUtility.DatabaseConnection;

/**
 * Do not modify this class. 
 */
@Component
public class CouchbaseConnectionImpl implements DatabaseConnection {
    
	@Autowired
	private Environment springEnvironment;

	private Cluster cluster;

	private ClusterEnvironment clusterEnvironment;

	public void initializeDatabaseProperties() {
		clusterEnvironment = ClusterEnvironment.builder().build();
		String ipAddress = springEnvironment.getProperty("couchbase.ipAddress");
		String userName = springEnvironment.getProperty("couchbase.username");
		String password = springEnvironment.getProperty("couchbase.password");
		
		cluster = Cluster.connect(ipAddress,
				ClusterOptions.clusterOptions(userName, password).environment(clusterEnvironment));
	}

	public Cluster getConnection() {
		if(cluster==null)
			this.initializeDatabaseProperties();
		return cluster;
	}
}
