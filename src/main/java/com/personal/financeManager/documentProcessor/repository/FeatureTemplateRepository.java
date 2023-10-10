package com.personal.financeManager.documentProcessor.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.couchbase.client.java.json.JsonObject;

@Component
public interface FeatureTemplateRepository {
    public void createFeatureTemplate(String documentId, JsonObject jsonObject);
    
    public List<JsonObject> getFeatureTemplate(String featureId, String featureVariantID);
}
