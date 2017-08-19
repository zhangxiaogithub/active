package com.active.exception;

/**
 * 主要用于参数无效性的检验
 * 
 * @author zhang
 *
 */
public class ParamsException extends SystemException {

	private static final long serialVersionUID = 7661551017351994173L;

	public ParamsException() {
		super();
	}

	public ParamsException(String message) {
		super(message);
	}

	public ParamsException(String format, Object... params) {
		super(format, params);
	}
}
