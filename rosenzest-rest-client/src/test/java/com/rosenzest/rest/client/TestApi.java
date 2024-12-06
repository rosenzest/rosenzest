package com.rosenzest.rest.client;

import com.alibaba.fastjson2.JSON;
import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.annotation.Api;
import com.rosenzest.rest.client.req.TestApiParam;
import com.rosenzest.rest.client.resp.TestApiResult;

import cn.hutool.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(host = "https://uat-api.wb-game.dev", path = "/partner/login")
public class TestApi extends AbstractHttpClientApi<TestApiParam, TestApiResult> {

    @Override
    protected TestApiResult doExecute(TestApiParam request, boolean retry) throws BusinessException {

        String url = getRequestUri(request).toString();

        HttpRequest req = HttpRequest.post(url);
        req.addHeaders(getRequestHeader());
        req.body(getRequestBody(request).toString());

        String body = req.execute().body();
        return JSON.parseObject(body, TestApiResult.class);
    }

    public static void main(String[] args) {
        TestApiParam param = new TestApiParam("1Block_usd", "123456");
        TestApiResult result = param.execute();
        log.info("execute:{}", result.toString());
    }
}
