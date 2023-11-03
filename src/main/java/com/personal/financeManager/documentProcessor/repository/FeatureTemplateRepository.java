package com.personal.financeManager.documentProcessor.repository;

import org.bson.Document;
import org.json.JSONObject;

public interface FeatureTemplateRepository {
    public void createFeatureTemplate(JSONObject jsonObject);

    public Document getFeatureTemplate(String featureId, String featureVariantID);
}
