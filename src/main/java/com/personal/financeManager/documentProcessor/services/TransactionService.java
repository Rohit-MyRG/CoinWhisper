package com.personal.financeManager.documentProcessor.services;

import org.springframework.stereotype.Service;

import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.models.TransactionBean;

@Service
public interface TransactionService {

	SuccessResponse createTransaction(TransactionBean transactionBean);
}
