package com.rosenzest.rest.client;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.annotation.GetApi;
import com.rosenzest.rest.client.util.ApiUtils;

import cn.hutool.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@GetApi(host = "https://api.dat.kingpey.cn", path = "/v2/api-docs")
public class TestGetApi extends AbstractHttpClientApi<Void, JSONObject> {

    @Override
    protected JSONObject doExecute(Void param, boolean retry) throws BusinessException {

        HttpRequest request = HttpRequest.get(getRequestUri(param).toString());
        String body = request.execute().body();
        return JSON.parseObject(body);
    }

    public static void main(String[] args) {
        TestGetApi api = ApiUtils.getApi(TestGetApi.class);
        api.init();

        JSONObject result = api.execute();
        log.info("result:{}", result);
    }

}
