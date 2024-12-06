package com.rosenzest.rest.client;

import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.enums.ApiResultEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象接口
 * 
 * @author fronttang
 * @date 2021/08/27
 */
@Slf4j
public abstract class AbstractApi<PARAM, RESULT> implements IRetryApi<PARAM, RESULT> {

    @Override
    public RESULT execute(PARAM request, boolean retry) throws BusinessException {

        try {
            // 前置处理
            request = beforeExecute(request);

            // 执行调用
            RESULT result = doExecute(request, retry);

            // 后置处理
            return afterExecute(request, result);

        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("", e);
            throw new BusinessException(ApiResultEnum.API_CALL_FAIL);
        }
    }

    /**
     * 执行调用
     * 
     * @param param
     * @param retry
     * @return
     */
    protected abstract RESULT doExecute(PARAM request, boolean retry) throws BusinessException;

}
