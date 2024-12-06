package com.rosenzest.rest.client.resp;

import lombok.Data;

@Data
public class TestApiResult {

    private String accessToken;

    private String expiresAt;

    private String tokenType;
}
