package com.active.exception;

public class BaseException extends SystemException {

	private static final long serialVersionUID = 6407557033768666962L;

	public BaseException(Integer httpCode, String code, String message) {
		super(httpCode, code, message);
	}
}
