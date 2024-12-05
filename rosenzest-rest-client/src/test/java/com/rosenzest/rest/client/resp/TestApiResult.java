package com.rosenzest.rest.client.resp;

import com.rosenzest.rest.client.IApiResponse;

import lombok.Data;

@Data
public class TestApiResult implements IApiResponse {

	private static final long serialVersionUID = 1L;

	private String accessToken;
	
	private String expiresAt;
	
	private String tokenType;
}
