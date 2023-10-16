package com.personal.financeManager.documentProcessor.services.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.json.JsonObject;
import com.personal.financeManager.documentProcessor.models.FeatureTemplateBean;
import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.repository.FeatureTemplateRepository;
import com.personal.financeManager.documentProcessor.services.FeatureTemplateService;
import com.personal.financeManager.exceptions.DocumentAlreadyExistsException;

@Service
public class FeatureTemplateServiceImpl implements FeatureTemplateService {

    @Autowired
    FeatureTemplateRepository featureTemplateRepository;

    @Override
    public SuccessResponse createTemplate(FeatureTemplateBean featureTemplateBean) {        
      
        // #1) Check does document already exist with the same featureID and featureVarientID.
        List<JsonObject> ftDoc = featureTemplateRepository.getFeatureTemplate(featureTemplateBean.getFeatureID(), featureTemplateBean.getFeatureVariantID());
        if(!ftDoc.isEmpty()) 
        	throw new DocumentAlreadyExistsException("Provided feature template is already exist with featureID & featureVariantID " + featureTemplateBean.getFeatureID()+":"+featureTemplateBean.getFeatureVariantID());
        
        // #2) handle data section
        JSONObject data = new JSONObject(featureTemplateBean.getData());
        
        // #3) Generate DocumentID
        String effectiveFromTimestamp = Long.toString(System.currentTimeMillis());
        String documentType = "1"; // 1 is for Template documents
        String version = "000"; // Replace with the appropriate version
        String documentID = String.format("%s:%s:%s:%s", documentType, featureTemplateBean.getFeatureID(), 
        featureTemplateBean.getFeatureVariantID(),version);
        
        // #4) Handle all Header fields
        JSONObject header = new JSONObject();
        header.put("DocumentType", documentType);
        header.put("FeatureID", featureTemplateBean.getFeatureID());
        header.put("FeatureVariantID", featureTemplateBean.getFeatureVariantID());
        header.put("Version", version);
        header.put("DocumentID",documentID);
        header.put("EffectiveFromTimestamp", effectiveFromTimestamp);
        header.put("EffectiveTillTimestamp", "");
        header.put("Status", "1");
        
        JSONObject document = new JSONObject();
        document.put("Header", header);
        document.put("Data", data);

        
        // #5) Convert JSONObject to couchbase JsonObject
        JsonObject cbDoc = JsonObject.from(document.toMap());
        System.out.println("Final doc: "+cbDoc.toString());
        
        // #6) call databaseOperations to create Template
        featureTemplateRepository.createFeatureTemplate(documentID, cbDoc);
        
        // #7) Make success response
        SuccessResponse response = new SuccessResponse();
        response.setFeatureID(featureTemplateBean.getFeatureID());
        response.setFeatureVariantID(featureTemplateBean.getFeatureVariantID());
        response.setDocumentID(documentID);   
        response.setMessage("Document Inserted");

        System.out.println("Response : " + response.toString());
         
        return response;
    }
    
}
