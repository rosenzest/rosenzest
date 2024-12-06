package com.rosenzest.rest.client.factory;

import org.springframework.core.annotation.AnnotatedElementUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.IApi;
import com.rosenzest.rest.client.annotation.ApiExecutor;
import com.rosenzest.rest.client.util.ApiUtils;

/**
 * 定义API factory
 * 
 * @author fronttang
 * @date 2021/08/25
 */
public interface IApiExecutor<RESULT> {

    /**
     * 执行调用
     * 
     * @return
     */
    RESULT execute() throws BusinessException;

    /**
     * 获取API实现类
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    default <PARAM> IApi<PARAM, RESULT> getApi() throws BusinessException {
        IApi<PARAM, RESULT> api = ApiUtils.getApi(getApiClass());
        api.init();
        return api;
    }

    /**
     * 获取API实现类 类型
     * 
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    @JsonIgnore
    default Class<? extends IApi> getApiClass() {
        ApiExecutor annotation = AnnotatedElementUtils.findMergedAnnotation(getClass(), ApiExecutor.class);
        Class<? extends IApi> executer = annotation.exec();
        return executer;
    }
}
