package com.rosenzest.rest.client;

import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.annotation.ApiFactory;
import com.rosenzest.rest.client.factory.IApiFactory;

/**
 * 可执行入参 </br>
 * 实现该接口的入参，构建接口入参对象后，可以直接调用入参对象的 {@link #execute} 方法进行接口调用<br/>
 * 该接口入参必须加上 {@link ApiFactory} 注解
 * 
 * @author fronttang
 * @date 2021/08/25
 */
public interface IExecutableApiRequest<R extends IApiResponse> extends IApiRequest, IApiFactory<R> {

    /**
     * 执行调用
     * 
     * @return
     */
    @Override
    default R execute() throws BusinessException {
        return getApi().execute(this);
    }
}
