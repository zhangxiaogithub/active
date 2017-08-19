package com.active.exception;

import com.active.base.ErrorInfoConsts;

public class NotLoginException extends AccountException {
	private static final long serialVersionUID = 8347222176159737622L;

	public NotLoginException() {
		super(ErrorInfoConsts.RESULT_STATUS_NO_LOGIN, ErrorInfoConsts.RESULT_MESSAGE_NO_LOGIN);
	}
}
