package com.personal.financeManager.documentProcessor.models;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TransactionBean {

	 private String transactionID;
	  
	 @NotBlank(message = "featureID cannot be null or blank")
	 private String featureID;
	    
	 @NotBlank(message = "featureVariantID cannot be null or blank")
	 private String featureVariantID;
	    
	 @NotEmpty(message = "data cannot be null or empty")
	 private Map<String, Object> data;    
	
}
