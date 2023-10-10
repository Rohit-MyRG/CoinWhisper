package com.personal.financeManager.databaseUtility;

import org.springframework.stereotype.Component;

import com.couchbase.client.java.Cluster;

/**
 * Do not modify this interface. 
 */
@Component
public interface DatabaseConnection {

    /**
     * It will provide you Database connection.
     * @return Cluster
     */
    public Cluster getConnection();
}
