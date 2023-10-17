package com.personal.financeManager.documentProcessor.services;

import org.springframework.stereotype.Service;

import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.models.TransactionBean;

@Service
public interface TransactionService {
	
	 /**
     * Create Transaction document in the {@code Resource} bucket for the {@code Data Entity} and {@code Transaction document}.
     * 
     * @param transactionBean The {@code TransactionBean} instance.
     * @return ResponseBodyBean instance with {@code ResponseEntity}
     */
 
	SuccessResponse createTransaction(TransactionBean transactionBean);

}
