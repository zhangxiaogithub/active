package com.active.base;

import java.io.Serializable;

public class ResultInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer httpCode; // http code
	private String code;// 状态
	private String message;// 消息
	private Object data;// 数据

	public ResultInfo() {
		httpCode = 200;
		code = ErrorInfoConsts.RESULT_STATUS_OK;
		message = ErrorInfoConsts.RESULT_MESSAGE_OK;
	}

	public ResultInfo(String code, String msg) {
		this.httpCode = 200;
		this.code = code;
		this.message = msg;
	}

	public ResultInfo(Integer httpCode, String code, String msg) {
		this.httpCode = httpCode;
		this.code = code;
		this.message = msg;
	}

	public static ResultInfo get() {
		return new ResultInfo();
	}

	public static ResultInfo get(String code, String msg) {
		return new ResultInfo(code, msg);
	}

	public static ResultInfo get(Integer httpCode, String code, String msg) {
		return new ResultInfo(httpCode, code, msg);
	}

	public ResultInfo data(Object data) {
		this.data = data;
		return this;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public ResultInfo setCode(String code) {
		this.code = code;
		return this;
	}

	public ResultInfo setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResultInfo setData(Object data) {
		this.data = data;
		return this;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}
}
