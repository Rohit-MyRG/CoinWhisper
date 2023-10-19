package com.personal.financeManager.documentProcessor.services;

import com.personal.financeManager.documentProcessor.models.FeatureTemplateBean;
import com.personal.financeManager.documentProcessor.models.SuccessResponse;

public interface FeatureTemplateService {

    /**
     * Create Feature Template document in the {@code Resource} bucket for the
     * {@code Data Entity} and {@code Transaction document}.
     * 
     * @param featureTemplateBean The {@code FeatureTemplateBean} instance.
     * @return ResponseBodyBean instance with {@code ResponseEntity}
     */
    SuccessResponse createTemplate(FeatureTemplateBean featureTemplateBean);

}