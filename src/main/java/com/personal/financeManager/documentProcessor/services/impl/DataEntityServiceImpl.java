package com.personal.financeManager.documentProcessor.services.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.personal.financeManager.documentProcessor.models.DataEntityBean;
import com.personal.financeManager.documentProcessor.models.SuccessResponse;
import com.personal.financeManager.documentProcessor.services.DataEntityService;

@Service
public class DataEntityServiceImpl implements DataEntityService {

	@Override
	public SuccessResponse createDataEntity(DataEntityBean dataEntityBean) {

		if (dataEntityBean.getDataEntityID() == null || dataEntityBean.getDataEntityID().trim().isEmpty()) {
			dataEntityBean.setDataEntityID(Long.toString(System.currentTimeMillis()));
		}

		JSONObject data = new JSONObject(dataEntityBean.getData());

		String DataEntityID = Long.toString(System.currentTimeMillis());
		String effectiveFromTimestamp = DataEntityID;
		String documentType = "2";
		String version = "000";
		String documentID = String.format("%s:%s:%s:%s:%s", documentType, dataEntityBean.getFeatureID(),
				dataEntityBean.getFeatureVariantID(), dataEntityBean.getDataEntityID(), version);

		JSONObject header = new JSONObject();
		header.put("DocumentType", documentType);
		header.put("FeatureID", dataEntityBean.getFeatureID());
		header.put("FeatureVariantID", dataEntityBean.getFeatureVariantID());
		header.put("DataEntityID", dataEntityBean.getDataEntityID());
		header.put("Version", version);
		header.put("DocumentID", documentID);
		header.put("EffectiveFromTimestamp", effectiveFromTimestamp);
		header.put("EffectiveTillTimestamp", "");
		header.put("Status", "1");

		JSONObject document = new JSONObject();
		document.put("Header", header);
		document.put("Data", data);

		// JsonObject cbDoc = JsonObject.from(document.toMap());
		// System.out.println("Final doc: "+cbDoc.toString());

		SuccessResponse response = new SuccessResponse();
		response.setFeatureID(dataEntityBean.getFeatureID());
		response.setFeatureVariantID(dataEntityBean.getFeatureVariantID());
		response.setDataEntityID(dataEntityBean.getDataEntityID());
		response.setDocumentID(documentID);
		response.setMessage("Document Inserted");

		System.out.println("Response : " + response.toString());

		return response;
	}

}
