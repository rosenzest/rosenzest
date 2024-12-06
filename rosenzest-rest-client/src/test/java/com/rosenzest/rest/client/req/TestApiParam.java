package com.rosenzest.rest.client.req;

import com.rosenzest.rest.client.IExecutableApiRequest;
import com.rosenzest.rest.client.TestApi;
import com.rosenzest.rest.client.annotation.ApiExecutor;
import com.rosenzest.rest.client.resp.TestApiResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiExecutor(TestApi.class)
public class TestApiParam implements IExecutableApiRequest<TestApiResult> {

    private String username;

    private String password;
}
