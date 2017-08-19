package com.active.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.active.base.BaseResult;
import com.active.base.ErrorInfoConsts;
import com.active.base.ResultInfo;
import com.active.exception.BaseException;
import com.active.exception.NotLoginException;
import com.active.exception.ParamsException;
import com.alibaba.fastjson.JSON;

/**
 * @ClassName: ExceptionTranslator
 * @Description: 统一处理本系统的异常处理类， 一般分为三大类型异常，1、参数型异常 400 2、账号型异常 401 403 3、业务型异常
 *               200 400 500 4、数据型异常 500
 * @author hztjf
 * @date 2017年5月11日上午10:45:59
 */
@ControllerAdvice
public class ExceptionTranslator {

	// 数据库异常
	@ExceptionHandler(DataAccessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseResult<?> processDataAccessException(DataAccessException e) {
		e.printStackTrace();
		return new BaseResult<>(ErrorInfoConsts.DB_ERROR_CODE_50002, ErrorInfoConsts.RESULT_MESSAGE_ERROR_DB);
	}

	// 使用字段验证validate
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResult<?> processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldErrors(fieldErrors);
	}

	private BaseResult<?> processFieldErrors(List<FieldError> fieldErrors) {
		// TODO 字段校验异常自动捕捉
		// for (FieldError fieldError : fieldErrors) {
		// // dto.add(fieldError.getObjectName(), fieldError.getField(),
		// // fieldError.getCode());
		// }

		return new BaseResult<>();
	}

	// 40000x系列参数异常
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResult<?> processParameterizedValidationError(ParamsException e) {
		ResultInfo resultInfo = JSON.parseObject(e.getMessage(), ResultInfo.class);
		return new BaseResult<>(resultInfo.getCode(), resultInfo.getMessage());
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResult<?> processParameterMissingError(MissingServletRequestParameterException e) {
		ResultInfo resultInfo = JSON.parseObject(e.getMessage(), ResultInfo.class);
		return new BaseResult<>(resultInfo.getCode(), resultInfo.getMessage());
	}

	// 业务异常
	@ExceptionHandler(BaseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResult<?> processBaseException(BaseException e) {
		ResultInfo resultInfo = JSON.parseObject(e.getMessage(), ResultInfo.class);
		return new BaseResult<>(resultInfo.getCode(), resultInfo.getMessage());
	}

	@ExceptionHandler(NotLoginException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public BaseResult<?> processNotLoginException(NotLoginException e) {
		String code = ErrorInfoConsts.INTERNAL_ERROR_CODE_40100;
		String message = ErrorInfoConsts.RESULT_MESSAGE_NO_LOGIN;
		return new BaseResult<>(code, message);
	}

	// 405访问方法异常
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public BaseResult<?> processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
		return new BaseResult<>(ErrorInfoConsts.INTERNAL_ERROR_CODE_40500,
				ErrorInfoConsts.RESULT_MESSAGE_ERROR_NOT_METHOD);
	}

	// 其他无法预知的异常， 比如空指针异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public BaseResult<?> processRuntimeException(Exception ex) {
		ex.printStackTrace();
		return new BaseResult<>(ErrorInfoConsts.SYSTEM_ERROR_CODE_50000, ErrorInfoConsts.SYSTEM_ERROR);
	}
}
