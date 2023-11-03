package com.personal.financeManager.documentProcessor.repository.impl;

import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.personal.financeManager.databaseUtility.DatabaseOperations;
import com.personal.financeManager.documentProcessor.repository.FeatureTemplateRepository;
import com.personal.financeManager.exceptions.DatabaseOperationException;

@Component
public class FeatureTemplateRepositoryImpl implements FeatureTemplateRepository {

    @Autowired
    DatabaseOperations databaseOperations;

    public void createFeatureTemplate(JSONObject jsonObject) {
        try {
            databaseOperations.createFeatureTemplateByDocumentId(jsonObject);
        } catch (Exception e) {
            System.out.println("Exception while create feature Template. " + e.getMessage());
            throw new DatabaseOperationException("Sorry! Something went wrong while doing database operation.");
        }
    }

    public Document getFeatureTemplate(String featureId, String featureVariantID) {
        try {

            Document doc = databaseOperations.executeQuery(featureId, featureVariantID);
            return doc;
        } catch (Exception e) {
            System.out.println("Exception while checking if feature exists. " + e.getMessage());
            throw new DatabaseOperationException("Sorry! Something went wrong while querying the database.");
        }
    }

}
