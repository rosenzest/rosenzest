package com.rosenzest.rest.client;

import org.springframework.http.HttpMethod;

import com.alibaba.fastjson2.JSON;
import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.annotation.Api;
import com.rosenzest.rest.client.req.TestApiParam;
import com.rosenzest.rest.client.resp.TestApiResult;

import cn.hutool.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(host = "https://uat-api.wb-game.dev", path = "/partner/login", method = HttpMethod.POST)
public class TestApi extends AbstractHttpClientApi<TestApiParam, TestApiResult> {

	@Override
	protected TestApiResult doExecute(TestApiParam request, boolean retry) throws BusinessException {
		
		//getRequestUri(request).toURL();
		
		HttpRequest req = HttpRequest.post("https://uat-api.wb-game.dev/partner/login");
		req.addHeaders(getRequestHeader());
		req.body(getRequestBody(request).toString());
		
		String body = req.execute().body();
		return JSON.parseObject(body, TestApiResult.class);
	}

	public static void main(String[] args) {
		TestApiParam param = new TestApiParam("1Block_usd", "123456");
		TestApiResult execute = param.execute();
		log.info("execute:{}", execute.toString());
	}
}
