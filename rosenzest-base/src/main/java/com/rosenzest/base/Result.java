package com.rosenzest.base;

import org.slf4j.MDC;

import com.rosenzest.base.constant.RequestConstant;
import com.rosenzest.base.constant.ResultCode;
import com.rosenzest.base.constant.ResultMsg;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回数据
 * 
 * @author fronttang
 * @date 2021/08/05
 */
public class Result<T> implements IResult {

	private static final long serialVersionUID = 1L;

	@Setter
	@Getter
	protected Integer code = ResultCode.SUCCESS_CODE;

	@Setter
	protected String msg = ResultMsg.SUCCESS;

	protected String serNo;

	protected T data;

	public Result() {
	}

	public Result(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Result(IResult result) {
		super();
		this.code = result.code();
		this.msg = result.msg();
	}

	public Result(T data) {
		super();
		this.data = data;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getSerNo() {
		return MDC.get(RequestConstant.REQUEST_NO_HEADER_NAME);
	}
	
}
