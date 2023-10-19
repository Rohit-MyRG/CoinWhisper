package com.personal.financeManager.documentProcessor.services;

import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.models.TransactionBean;

public interface TransactionService {

     /**
      * Create Transaction document in the {@code Transaction} bucket.
      * 
      * @param transactionBean The {@code TransactionBean} instance.
      * @return ResponseBodyBean instance with {@code ResponseEntity}
      */

     SuccessResponse createTransaction(TransactionBean transactionBean);

}
