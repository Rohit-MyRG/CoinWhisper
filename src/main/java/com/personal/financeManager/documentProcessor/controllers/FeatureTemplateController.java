package com.personal.financeManager.documentProcessor.controllers;

import com.personal.financeManager.documentProcessor.models.FeatureTemplateBean;
import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.services.FeatureTemplateService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal/finance-manager")
public class FeatureTemplateController {
    
        @Autowired
        FeatureTemplateService featureTemplateService;

        @PostMapping(value = "/api/featureTemplate", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        @ResponseStatus(value = HttpStatus.OK)
        public SuccessResponse createFeatureTemplate(@Valid @RequestBody FeatureTemplateBean featureTemplateBean){	
                return featureTemplateService.createTemplate(featureTemplateBean);
        }
}