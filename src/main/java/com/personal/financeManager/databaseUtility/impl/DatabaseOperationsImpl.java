package com.personal.financeManager.databaseUtility.impl;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.kv.InsertOptions;
import com.couchbase.client.java.kv.MutationResult;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;
import com.personal.financeManager.databaseUtility.DatabaseConnection;
import com.personal.financeManager.databaseUtility.DatabaseOperations;

@Component
public class DatabaseOperationsImpl implements DatabaseOperations {

    @Value("${couchbase.resource-bucket-name}")
    private String resourceBucketName;
    
    @Value("${couchbase.transaction-bucket-name}")
    private String transactionBucketName;

    @Autowired
    DatabaseConnection databaseConnection;

    public void createFeatureTemplateByDocumentId(String documentId, JsonObject jsonObject) {
        Cluster cluster = databaseConnection.getConnection();
        Bucket bucket = cluster.bucket(resourceBucketName);
        MutationResult mutationResult = bucket.defaultCollection().insert(documentId, jsonObject,
                InsertOptions.insertOptions().timeout(Duration.ofMinutes(5)));
        System.out.println("Mutation Result: "+mutationResult.mutationToken());
    }
    

    public List<JsonObject> executeQuery(String query) {
        Cluster cluster = databaseConnection.getConnection();
        QueryResult result = cluster.query(query,QueryOptions.queryOptions().timeout(Duration.ofMinutes(20)));
        List<JsonObject> list = result.rowsAsObject();   
        return list;	
    } 
}
