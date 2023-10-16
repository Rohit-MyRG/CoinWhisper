package com.personal.financeManager.documentProcessor.services.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.models.TransactionBean;
import com.personal.financeManager.documentProcessor.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	
	public SuccessResponse createTransaction(TransactionBean transactionBean)	{
		
	     
        
        // #1) handle data section
        JSONObject data = new JSONObject(transactionBean.getData());
        
        
        // #2) Generate DocumentID
        
        String documentType = "3"; // 3 is for Transaction documents
        String version = "002"; // Replace with the appropriate version
        String documentID = String.format("%s:%s:%s:%s", documentType, transactionBean.getFeatureID(), 
        transactionBean.getFeatureVariantID(),transactionBean.getTransactionID(),version);
       
        
        // #3) Handle all Header fields
        JSONObject header = new JSONObject();
        header.put("DocumentType", documentType);
        header.put("FeatureID", transactionBean.getFeatureID());
        header.put("FeatureVariantID", transactionBean.getFeatureVariantID());
        header.put("TransactionID", transactionBean.getTransactionID());
        header.put("Version", version);
        header.put("DocumentID",documentID);
        header.put("Status", "1");
        
        JSONObject document = new JSONObject();
        document.put("Header", header);
        document.put("Data", data);
     
		
        // #4) Make success response
        SuccessResponse response = new SuccessResponse();
        response.setFeatureID(transactionBean.getFeatureID());
        response.setFeatureVariantID(transactionBean.getFeatureVariantID());
        response.setDocumentID(documentID);   
        response.setMessage("Document Inserted");

        System.out.println("Response : " + response.toString());
         
		return response;
	}

}
