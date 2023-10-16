package com.personal.financeManager.documentProcessor.models;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataEntityBean {
	
	@NotBlank(message = "featureID cannot be null or blank")
	private String featureID;
	
	@NotBlank(message = "featureVariantID cannot be null or blank")
	private String featureVariantID;
	
	@NotBlank(message = "datEntityID cannot be null or blank")
	private String dataEntityID;
	
	@NotEmpty(message = "data cannot be null or empty")
	private Map<String, Object> data;
	

}
