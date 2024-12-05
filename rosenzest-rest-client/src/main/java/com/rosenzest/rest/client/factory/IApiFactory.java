package com.rosenzest.rest.client.factory;

import org.springframework.core.annotation.AnnotatedElementUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.IApi;
import com.rosenzest.rest.client.IApiRequest;
import com.rosenzest.rest.client.IApiResponse;
import com.rosenzest.rest.client.annotation.ApiFactory;
import com.rosenzest.rest.client.util.ApiUtils;

/**
 * 定义API factory
 * 
 * @author fronttang
 * @date 2021/08/25
 */
public interface IApiFactory<R extends IApiResponse> {

    /**
     * 执行调用
     * 
     * @return
     */
    R execute() throws BusinessException;

    /**
     * 获取API实现类
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    default IApi<IApiRequest, R> getApi() throws BusinessException {
        return ApiUtils.getApi(getApiClass());
    }

    /**
     * 获取API实现类 类型
     * 
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    @JsonIgnore
    default Class<? extends IApi> getApiClass() {
        ApiFactory annotation = AnnotatedElementUtils.findMergedAnnotation(getClass(), ApiFactory.class);
        Class<? extends IApi> executer = annotation.exec();
        return executer;
    }
}
