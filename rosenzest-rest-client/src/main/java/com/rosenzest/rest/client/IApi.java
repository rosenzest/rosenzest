/**
 * 
 */
package com.rosenzest.rest.client;

import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;

import com.rosenzest.base.exception.BusinessException;

/**
 * 对外接口定义
 * 
 * @author fronttang
 * @date 2021/08/25
 */
public interface IApi<PARAM, RESULT> {

    /**
     * 接口初始化
     */
    default void init() {

    }

    /**
     * 执行前处理逻辑,可以对请求参数进行包装处理
     * 
     * @param param
     * @return
     * @throws BusinessException
     */
    default PARAM beforeExecute(PARAM request) throws BusinessException {
        return request;
    }

    /**
     * 执行调用
     * 
     * @param param
     * @return
     * @throws BusinessException
     */
    RESULT execute(PARAM request) throws BusinessException;

    /**
     * 无参请求
     * 
     * @return
     * @throws BusinessException
     */
    default RESULT execute() throws BusinessException {
        return execute(null);
    }

    /**
     * 执行后处理逻辑，可以对返回结果进行再处理
     * 
     * @param param
     * @param result
     * @return
     * @throws BusinessException
     */
    default RESULT afterExecute(PARAM request, RESULT response) throws BusinessException {
        return response;
    }

    /**
     * 获取返回结果的类型
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    default Class<RESULT> getResponseType() {
        Class<RESULT> clazz = (Class<RESULT>)getGenericType(1);
        return clazz;
    }

    /**
     * 获取入参的类型
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    default Class<PARAM> getRequestType() {
        Class<PARAM> clazz = (Class<PARAM>)getGenericType(0);
        return clazz;
    }

    /**
     * 获取泛型类型
     * 
     * @param index
     * @return
     */
    default Class<?> getGenericType(int index) {
        Class<?> userClass = ClassUtils.getUserClass(getClass());
        ResolvableType resolvableType = ResolvableType.forClass(userClass);

        return resolvableType.as(IApi.class).getGeneric(index).resolve();
    }
}
