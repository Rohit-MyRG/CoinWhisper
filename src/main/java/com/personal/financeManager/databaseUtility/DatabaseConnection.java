package com.personal.financeManager.databaseUtility;

import com.mongodb.client.MongoClient;

/**
 * Do not modify this interface.
 */

public interface DatabaseConnection {

    /**
     * It will provide you Database connection.
     * 
     * @return MongoClient
     */
    public MongoClient getConnection();
}
