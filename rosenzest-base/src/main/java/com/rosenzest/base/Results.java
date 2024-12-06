package com.rosenzest.base;

import java.util.List;

import com.rosenzest.base.constant.ResultCode;
import com.rosenzest.base.constant.ResultEnum;

public final class Results {

    public static <T> Result<T> error() {
        return new Result<T>(ResultEnum.BUSINESS_ERROR);
    }

    public static <T> Result<T> ok() {
        return new Result<T>(ResultEnum.SUCCESS);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(IResult result) {
        return new Result<>(result);
    }

    public static <T> Result<T> error(Integer code, String msg) {
        return new Result<T>(code, msg);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<T>(ResultCode.BUSINESS_ERROR_CODE, msg);
    }

    public static final <T> ListResult<T> ok(Long totalNum, List<T> data) {
        return new ListResult<T>(totalNum, data);
    }

    public static final <T> ListResult<T> ok(Integer totalNum, List<T> data) {
        return new ListResult<T>(totalNum, data);
    }
}
