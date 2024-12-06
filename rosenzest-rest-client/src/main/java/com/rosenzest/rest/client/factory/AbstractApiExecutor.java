package com.rosenzest.rest.client.factory;

import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.IApiRequest;

/**
 * 抽象接口执行者
 * 
 * @author fronttang
 * @date 2021/08/25
 */
public abstract class AbstractApiExecutor<RESULT> implements IApiExecutor<RESULT> {

    /**
     * 接口入参
     */
    protected IApiRequest param;

    protected AbstractApiExecutor(IApiRequest param) {
        this.param = param;
    }

    @Override
    public RESULT execute() throws BusinessException {
        return getApi().execute(this.param);
    }
}
