package com.personal.financeManager.documentProcessor.services;

import org.springframework.stereotype.Service;

import com.personal.financeManager.documentProcessor.models.DataEntityBean;
import com.personal.financeManager.documentProcessor.models.SuccessResponse;

@Service
public interface DataEntityService {

	SuccessResponse createDataEntity(DataEntityBean dataEntityBean);

}
