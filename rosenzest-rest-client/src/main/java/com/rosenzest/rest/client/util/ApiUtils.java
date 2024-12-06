package com.rosenzest.rest.client.util;

import java.util.Objects;

import org.springframework.core.annotation.AnnotatedElementUtils;

import com.rosenzest.base.constant.SymbolConstant;
import com.rosenzest.base.exception.BusinessException;
import com.rosenzest.rest.client.IApi;
import com.rosenzest.rest.client.annotation.Api;
import com.rosenzest.rest.client.enums.ApiResultEnum;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;

/**
 * API 工具类
 * 
 * @author fronttang
 * @date 2021/09/01
 */
public final class ApiUtils {

    /**
     * 获取API对象
     * 
     * @param <T>
     * @param clazz
     * @return
     */
    public static <PARAM, RESULT, API extends IApi<PARAM, RESULT>> API getApi(Class<API> clazz) {
        API api = null;
        try {
            api = SpringUtil.getBean(clazz);
        } catch (Exception e) {
            // ignore
        } finally {
            if (Objects.isNull(api)) {
                api = ReflectUtil.newInstanceIfPossible(clazz);
            }
        }
        if (Objects.isNull(api)) {
            throw new BusinessException(ApiResultEnum.API_CALL_FAIL);
        }

        return api;
    }

    /**
     * 获取接口名称
     * 
     * @param clazz
     * @return
     */
    public static String getApiName(Class<?> clazz) {

        StringBuilder apiName = new StringBuilder(clazz.getName());

        Api api = AnnotatedElementUtils.findMergedAnnotation(clazz, Api.class);
        if (Objects.nonNull(api)) {
            if (StrUtil.isNotBlank(api.name())) {
                apiName.append(SymbolConstant.LEFT_ROUND_BRACKETS).append(api.name())
                    .append(SymbolConstant.RIGHT_ROUND_BRACKETS);
            }
        }

        return apiName.toString();
    }
}
