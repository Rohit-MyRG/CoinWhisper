package com.personal.financeManager.databaseUtility.impl;

import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.personal.financeManager.databaseUtility.DatabaseConnection;
import com.personal.financeManager.databaseUtility.DatabaseOperations;

@Component
public class DatabaseOperationsImpl implements DatabaseOperations {

    @Value("${mongodb.resources-database-name}")
    private String resourcesDatabaseName;

    @Value("${mongodb.features-database-name}")
    private String featuresDatabaseName;

    @Autowired
    DatabaseConnection databaseConnection;

    public void createFeatureTemplateByDocumentId(JSONObject jsonObject) {

        // 1 Database Connection
        MongoClient mongoClient = databaseConnection.getConnection();

        MongoDatabase mongoDatabase = mongoClient.getDatabase(featuresDatabaseName);

        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("default");

        // 2 Convert JSON to MongoDB Document
        String documentId = jsonObject.getJSONObject("Header").getString("DocumentID");

        jsonObject.put("_id", documentId);

        Document doc = Document.parse(jsonObject.toString());

        InsertOneResult insertOneResult = mongoCollection.insertOne(doc);

        // 3 Print Inserted Document
        System.out.println("Insert One Result: " + insertOneResult.getInsertedId());

        // 4 Create Collection in Resources Database
        String featureId = jsonObject.getJSONObject("Header").getString("FeatureID");

        mongoDatabase = mongoClient.getDatabase(resourcesDatabaseName);

        try {
            mongoDatabase.createCollection(featureId);
            System.out.println("Collection Created");

        } catch (Exception e) {
            System.out.println("Collection Exist " + e);

        }

    }

    public Document executeQuery(String featureId, String featureVariantID) {

        // 1 Database Connection
        MongoClient mongoClient = databaseConnection.getConnection();

        MongoDatabase mongoDatabase = mongoClient.getDatabase(featuresDatabaseName);

        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("default");

        // 2 Execute Query on Database
        Document document = mongoCollection.find(Filters.and(Filters.eq("Header.FeatureID", featureId),
                Filters.eq("Header.FeatureVariantID", featureVariantID))).first();

        // 3 Print Query Result
        System.out.println(document);

        return document;

    }
}
