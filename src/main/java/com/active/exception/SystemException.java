package com.active.exception;

import com.active.base.ResultInfo;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: SystemException
 * @Description: 系统共用的运行时异常
 * @author tjf
 * @date 2016年11月7日下午2:18:37
 */
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 8705571580755677233L;

	private String message;

	// private String showMessage;

	private ResultInfo resultInfo = ResultInfo.get();

	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
		this.message = message;
		// logger.error(message);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String format, Object... params) {
		message = format;
		format = format.replace("{}", "%S");
		message = message.replace("{}", "");
		// 用于打印日志信息
		// showMessage = String.format(format, params);
		// 用于前端提示信息
		message = String.format(message, params);
		// logger.error(showMessage);
	}

	public SystemException(Integer httpCode, String code, String message) {
		resultInfo.setMessage(message);
		resultInfo.setCode(code);
		resultInfo.setHttpCode(httpCode);
		// logger.error(message);
		this.message = JSONObject.toJSONString(resultInfo);
	}

	public SystemException(Integer httpCode, String code, String format, Object... params) {
		this(format, params);
		resultInfo.setMessage(this.message);
		resultInfo.setCode(code);
		resultInfo.setHttpCode(httpCode);
		// logger.error(message);
		this.message = JSONObject.toJSONString(resultInfo);
	}

	@Override
	public String getMessage() {
		return message;
	}
}
