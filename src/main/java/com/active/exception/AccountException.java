package com.active.exception;

/**
 * 账户异常处理，如401，403异常
 * 
 * @author zhang
 *
 */
public class AccountException extends SystemException {

	private static final long serialVersionUID = 8710148750320023669L;

	public AccountException() {
		super();
	}

	public AccountException(String message) {
		super(message);
	}

	public AccountException(String format, Object... params) {
		super(format, params);
	}

	/**
	 * 401，403异常
	 * 
	 * @param httpCode
	 * @param code
	 * @param message
	 */
	public AccountException(String code, String message) {
		super(401, code, message);
	}

	/**
	 * 401，403异常
	 * 
	 * @param httpCode
	 * @param code
	 * @param message
	 */
	public AccountException(Integer httpCode, String code, String message) {
		super(httpCode, code, message);
	}
}
