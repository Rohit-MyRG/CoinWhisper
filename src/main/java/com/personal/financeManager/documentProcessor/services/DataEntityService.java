package com.personal.financeManager.documentProcessor.services;

import com.personal.financeManager.documentProcessor.models.DataEntityBean;
import com.personal.financeManager.documentProcessor.models.SuccessResponse;

public interface DataEntityService {

	SuccessResponse createDataEntity(DataEntityBean dataEntityBean);

}
