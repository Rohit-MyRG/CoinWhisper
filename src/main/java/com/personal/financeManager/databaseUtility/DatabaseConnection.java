package com.personal.financeManager.databaseUtility;

import com.couchbase.client.java.Cluster;

/**
 * Do not modify this interface.
 */

public interface DatabaseConnection {

    /**
     * It will provide you Database connection.
     * 
     * @return Cluster
     */
    public Cluster getConnection();
}
