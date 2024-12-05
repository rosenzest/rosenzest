package com.rosenzest.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rosenzest.base.constant.ResultCode;

/**
 * 抽象返回
 * 
 * @author fronttang
 * @date 2021/08/05
 */
public interface IResult extends Serializable {

	/**
	 * 获取返回信息
	 * 
	 * @return 返回信息
	 */
	default String msg() {
		return getMsg();
	}

	/**
	 * 获取返回码
	 * 
	 * @return 返回码
	 */
	default Integer code() {
		return getCode();
	}

	/**
	 * 获取返回码
	 * 
	 * @return 返回码
	 */
	Integer getCode();

	/**
	 * 获取返回信息
	 * 
	 * @return 返回信息
	 */
	String getMsg();

	/**
	 * 构建返回对象
	 * 
	 * @return
	 */
	default <T> Result<T> toResult() {
		return Results.error(this);
	}

	/**
	 * 是否成功
	 * 
	 * @return
	 */
	@JsonIgnore
	default boolean isSuccess() {
		return ResultCode.SUCCESS_CODE == code();
	}
}
