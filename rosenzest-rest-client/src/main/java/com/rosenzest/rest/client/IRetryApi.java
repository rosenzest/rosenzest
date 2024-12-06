/**
 * 
 */
package com.rosenzest.rest.client;

import com.rosenzest.base.exception.BusinessException;

/**
 * 可重试接口定义
 * 
 * @author fronttang
 * @date 2021/08/25
 */
public interface IRetryApi<PARAM, RESULT> extends IApi<PARAM, RESULT> {

    @Override
    default RESULT execute(PARAM param) throws BusinessException {
        return execute(param, true);
    }

    @Override
    default RESULT execute() throws BusinessException {
        return execute(null, true);
    }

    /**
     * 执行调用
     * 
     * @param param
     * @param retry
     * @return
     * @throws BusinessException
     */
    RESULT execute(PARAM param, boolean retry) throws BusinessException;

    /**
     * 执行无参调用
     * 
     * @param retry
     * @return
     * @throws BusinessException
     */
    default RESULT execute(boolean retry) throws BusinessException {
        return execute(null, retry);
    }
}
