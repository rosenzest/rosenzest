/**
 * 
 */
package com.rosenzest.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 基础返回结果枚举,不要在此处定义业务上的返回结果枚举
 * 
 * @author fronttang
 */
@Getter
@AllArgsConstructor
public enum ResultEnum implements IResultEnum {

    /**
     * 成功
     */
    SUCCESS(ResultCode.SUCCESS_CODE, ResultMsg.SUCCESS),

    /**
     * 业务失败
     */
    BUSINESS_ERROR(ResultCode.BUSINESS_ERROR_CODE, ResultMsg.BUSINESS_ERROR),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(ResultCode.SYSTEM_ERROR_CODE, ResultMsg.SYSTEM_ERROR),

    /**
     * 资源未找到
     */
    RESOURCE_NOT_EXIST(ResultCode.NOT_FOUD, ResultMsg.RESOURCE_NOT_FOUND),

    /**
     * 未授权
     */
    UNAUTHOZIED(ResultCode.UNAUTHOZIED, ResultMsg.UNAUTHOZIED),

    /**
     * 没有权限
     */
    FORBIDDEN(ResultCode.FORBIDDEN, ResultMsg.FORBIDDEN),

    /**
     * 参数错误
     */
    PARAM_BIND_ERROR(ResultCode.PARAM_BIND_ERROR_CODE, ResultMsg.PARAM_BIND_ERROR),

    /**
     * 文件过大错误
     */
    UPLOAD_SIZE_EXCEEDED_ERROR(ResultCode.UPLOAD_SIZE_EXCEEDED_ERROR_CODE, ResultMsg.UPLOAD_SIZE_EXCEEDED_ERROR),

    ;

    final Integer code;

    final String msg;
}
