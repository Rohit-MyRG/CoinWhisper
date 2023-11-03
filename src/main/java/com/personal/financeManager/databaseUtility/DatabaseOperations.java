package com.personal.financeManager.databaseUtility;

import org.bson.Document;
import org.json.JSONObject;

public interface DatabaseOperations {

    /**
     * Create template document
     * 
     * @param jsonObject
     */
    public void createFeatureTemplateByDocumentId(JSONObject jsonObject);

    /**
     * It will get the query as a string and return the result in list of
     * JSONObject.
     * 
     * @param featureId
     * @param featureVariantID
     * @return Document
     */
    public Document executeQuery(String featureId, String featureVariantID);
}
