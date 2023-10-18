package com.personal.financeManager.documentProcessor.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.personal.financeManager.documentProcessor.models.DataEntityBean;
import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.services.DataEntityService;

@RestController
@RequestMapping("/personal/finance-manager")
public class DataEntityController {

    @Autowired
    private DataEntityService dataEntityService;

    @PostMapping(value = "/api/createDataEntity")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public SuccessResponse createDataEntity(@Valid @RequestBody DataEntityBean dataEntityBean) {
        return dataEntityService.createDataEntity(dataEntityBean);
    }
}