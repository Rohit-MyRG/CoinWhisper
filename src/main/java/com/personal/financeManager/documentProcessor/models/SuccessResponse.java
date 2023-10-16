package com.personal.financeManager.documentProcessor.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse {
	private String featureID;
	private String featureVariantID;
	private String transactionID;
	private String documentID;
	private String dataEntityID;
	private String message;
}
