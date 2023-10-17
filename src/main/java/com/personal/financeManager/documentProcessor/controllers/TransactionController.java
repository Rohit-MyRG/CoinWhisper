package com.personal.financeManager.documentProcessor.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.models.TransactionBean;
import com.personal.financeManager.documentProcessor.services.TransactionService;

@RestController
@RequestMapping("/personal/finance-manager")
public class TransactionController {

	    
		 @Autowired
		 TransactionService transactionService;
		 
		 @PostMapping(value = "/api/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
		 //@ResponseBody
		 @ResponseStatus(value = HttpStatus.OK)
		 public SuccessResponse createTransaction(@Valid @RequestBody TransactionBean transactionBean){	
		         return transactionService.createTransaction(transactionBean);
		 }

}
