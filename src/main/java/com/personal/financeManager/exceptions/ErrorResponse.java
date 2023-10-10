package com.personal.financeManager.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	private Integer errorCode;
    private String errorMessage;
    private String description;
    private Date timeStamp;
}
