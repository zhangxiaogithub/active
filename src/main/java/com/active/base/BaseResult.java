package com.active.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 基础数据返回对象
 * @author tjf
 * @date 2016年11月7日下午1:31:52
 */
public class BaseResult<T> implements Serializable {

	private static final long serialVersionUID = -814929216218701299L;

	// 服务返回内部码，如40001， 200暂时不变
	private String code;

	// 服务消息
	private String message;

	// 服务具体数据
	private T data;

	/**
	 * 默认构造函数
	 */
	public BaseResult() {
		super();
		this.code = ErrorInfoConsts.RESULT_STATUS_OK;
		this.message = ErrorInfoConsts.RESULT_MESSAGE_OK;
		// 没有数据为null
		// this.data = (T) new HashMap<>();
		this.data = null;
	}

	/**
	 * 默认构造函数
	 */
	public BaseResult(T data) {
		super();
		this.code = ErrorInfoConsts.RESULT_STATUS_OK;
		this.message = ErrorInfoConsts.RESULT_MESSAGE_OK;
		// 没有数据为null
		// this.data = (T) new HashMap<>();
		this.data = data;
	}

	/**
	 *
	 * @param errorCode
	 * @param errorMessage
	 */
	public BaseResult(String errorCode, String errorMessage) {
		super();
		this.code = errorCode;
		this.message = errorMessage;
	}

	/**
	 * Getter method for property <tt>code</tt>.
	 * 
	 * @return property value of code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter method for property <tt>code</tt>.
	 * 
	 * @param code
	 *            value to be assigned to property code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter method for property <tt>message</tt>.
	 * 
	 * @return property value of message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter method for property <tt>message</tt>.
	 * 
	 * @param message
	 *            value to be assigned to property message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Getter method for property <tt>dal</tt>.
	 * 
	 * @return property value of dal
	 */
	public T getData() {
		return data;
	}

	/**
	 * Setter method for property <tt>dal</tt>.
	 * 
	 * @param data
	 *            value to be assigned to property dal
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
