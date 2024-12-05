package com.rosenzest.rest.client.factory;

import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.IApiRequest;
import com.rosenzest.rest.client.IApiResponse;

/**
 * 抽象接口factory
 * 
 * @author fronttang
 * @date 2021/08/25
 */
public abstract class AbstractApiFactory<R extends IApiResponse> implements IApiFactory<R> {

    /**
     * 接口入参
     */
    protected IApiRequest param;

    protected AbstractApiFactory(IApiRequest param) {
        this.param = param;
    }

    @Override
    public R execute() throws BusinessException {
        return getApi().execute(this.param);
    }
}
