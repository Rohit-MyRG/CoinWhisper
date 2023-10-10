package com.personal.financeManager.documentProcessor.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.json.JsonObject;
import com.personal.financeManager.databaseUtility.DatabaseOperations;
import com.personal.financeManager.documentProcessor.repository.FeatureTemplateRepository;
import com.personal.financeManager.exceptions.DatabaseOperationException;

@Component
public class FeatureTemplateRepositoryImpl implements FeatureTemplateRepository{
    
    @Autowired
    DatabaseOperations databaseOperations;

    public void createFeatureTemplate(String documentId, JsonObject jsonObject) {
        try{
            databaseOperations.createFeatureTemplateByDocumentId(documentId, jsonObject);
        } catch (Exception e) {
            System.out.println("Exception while create feature Template. "+e.getMessage());
            throw new DatabaseOperationException("Sorry! Something went wrong while doing database operation.");
        }
    }
    
    public List<JsonObject> getFeatureTemplate(String featureId, String featureVariantID) {
        try {
            String query = "select * from `Resource`.`_default`.`_default` where Header.FeatureID='"+featureId+"' and Header.FeatureVariantID='"+featureVariantID+"' ";
            List<JsonObject> rows= databaseOperations.executeQuery(query);
            return rows;
        } catch (Exception e) {
            System.out.println("Exception while checking if feature exists. " + e.getMessage());
            throw new DatabaseOperationException("Sorry! Something went wrong while querying the database.");
        }
    }
   

    
    
}
