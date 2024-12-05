package com.rosenzest.rest.client.req;

import com.rosenzest.rest.client.IExecutableApiRequest;
import com.rosenzest.rest.client.TestApi;
import com.rosenzest.rest.client.annotation.ApiFactory;
import com.rosenzest.rest.client.resp.TestApiResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiFactory(TestApi.class)
public class TestApiParam implements IExecutableApiRequest<TestApiResult> {

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
}
