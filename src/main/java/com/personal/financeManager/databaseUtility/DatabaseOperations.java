package com.personal.financeManager.databaseUtility;

import java.util.List;

import org.springframework.stereotype.Component;

import com.couchbase.client.java.json.JsonObject;

@Component
public interface DatabaseOperations {

    /**
     * Create template document
     * @param documentId
     * @param jsonObject
     */
    public void createFeatureTemplateByDocumentId(String documentId, JsonObject jsonObject);

    /**
     * It will get the query as a string and return the result in list of JsonObject.
     * @param query
     * @return List<JsonObject>
     */
	public List<JsonObject> executeQuery(String query);	
}
