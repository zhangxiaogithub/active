package com.active.base;

/**
 * @ClassName: ErrorInfoConsts
 * @Description: 错误信息常量
 * @author tjf
 * @date 2017年3月1日下午5:31:57
 */
public class ErrorInfoConsts {

	public final static String ITEMTYPE = "all";
	public final static String RESULT_STATUS_OK = "200"; // 请求成功
	public final static String RESULT_STATUS_INVALID = "300"; // 请求无效
	public final static String RESULT_STATUS_PARAM_ERROR = "400"; // 请求参数不正确
	public final static String RESULT_STATUS_NO_LOGIN = "401"; // 尚未登录
	public final static String RESULT_STATUS_PERMISSION_DENIED = "403"; // 权限不足
	public final static String RESULT_STATUS_NOT_FOUND = "404"; // 请求地址不正确
	public final static String RESULT_STATUS_NOT_METHOD = "405"; // 请求方法不正确
	public final static String RESULT_STATUS_ERROR = "500"; // 服务器出错

	public final static String RESULT_MESSAGE_OK = "OK";
	public final static String RESULT_MESSAGE_ERROR_NOT_FOUND = "Not Found";
	public final static String RESULT_MESSAGE_ERROR_NOT_METHOD = "Method Not Allowed";
	public final static String RESULT_MESSAGE_NO_LOGIN = "用户尚未登录";
	public final static String RESULT_MESSAGE_PERMISSION_DENIED = "用户权限不足";
	public final static String RESULT_MESSAGE_ERROR_NONE = "未找到任何记录";
	public final static String RESULT_MESSAGE_ERROR_ADD = "添加数据失败";
	public final static String RESULT_MESSAGE_ERROR_UPDATE = "更新数据失败";
	public final static String RESULT_MESSAGE_ERROR_DELETE = "删除数据失败";
	public final static String RESULT_MESSAGE_ERROR_FIND = "查询数据失败";
	public final static String RESULT_MESSAGE_ERROR_DB = "数据库出错";

	public final static String RESULT_MESSAGE_PARAM_NOT = "缺少必入参数";
	public final static String RESULT_MESSAGE_PARAM_TYPE_ERROR = "参数类型不正确";
	public final static String RESULT_MESSAGE_PARAM_INVALID = "传入参数无效";
	public final static String RESULT_MESSAGE_PARAM_REALNAME = "您还未开通北京银行账户  ，点击“立即开通”按钮";
	public final static String RESULT_MESSAGE_ORDER_SERVICE_ERROR = "订单系统服务异常";
	public final static String RESULT_MESSAGE_LOAN_SERVICE_ERROR = "标的系统服务异常";

	public final static String SYSTEM_ERROR = "系统异常";
	public final static String SERVICE_ERROR = "服务异常";

	// 参数异常内部码系列
	public final static String PARAM_ERROR_CODE_40000 = "40000";
	public final static String PARAM_ERROR_CODE_40001 = "40001";
	public final static String PARAM_ERROR_CODE_40002 = "40002";
	public final static String PARAM_ERROR_CODE_40003 = "40003";
	public final static String PARAM_ERROR_CODE_40004 = "40004";
	public final static String PARAM_ERROR_CODE_40005 = "40005";
	public final static String PARAM_ERROR_CODE_40006 = "40006";

	// 业务型异常内部码系列
	public final static String BUSINESS_ERROR_CODE_41000 = "41000";
	public final static String BUSINESS_ERROR_CODE_41001 = "41001";
	public final static String BUSINESS_ERROR_CODE_41002 = "41002";
	public final static String BUSINESS_ERROR_CODE_41003 = "41003";
	public final static String BUSINESS_ERROR_CODE_41004 = "41004";
	public final static String BUSINESS_ERROR_CODE_41005 = "41005";
	public final static String BUSINESS_ERROR_CODE_41006 = "41006";
	public final static String BUSINESS_ERROR_CODE_41007 = "41007";
	public final static String BUSINESS_ERROR_CODE_41008 = "41008";
	public final static String BUSINESS_ERROR_CODE_41100 = "41100"; // 验证密码失败专用
	public final static String BUSINESS_ERROR_CODE_41101 = "41101"; // 结算时间失败专用
	public final static String BUSINESS_ERROR_CODE_41102 = "41102"; // 交易关闭专用
	public final static String BUSINESS_ERROR_CODE_41103 = "41103"; // 后台渠道回购专用

	public final static String BUSINESS_ERROR_CODE_41104 = "41104"; // 卡劵异常专用
	public final static String BUSINESS_ERROR_CODE_41105 = "41105"; // 投资金额校验专用
	public final static String BUSINESS_ERROR_CODE_41106 = "41106"; // TB校验专用
	public final static String BUSINESS_ERROR_CODE_41107 = "41107"; // 用户信息异常专用
	public final static String BUSINESS_ERROR_CODE_41108 = "41108"; // 订单校验专用
	public final static String BUSINESS_ERROR_CODE_41109 = "41109"; // 未设置密码专用
	public final static String BUSINESS_ERROR_CODE_41110 = "41110"; // 未开户专用
	public final static String BUSINESS_ERROR_CODE_41111 = "41111"; // 渠道回购
	public final static String BUSINESS_ERROR_CODE_41112 = "41112"; // T+X普通转让专用

	// 401，403，404，405系列
	public final static String INTERNAL_ERROR_CODE_40100 = "40100";
	public final static String INTERNAL_ERROR_CODE_40101 = "40101"; // 未实名
	public final static String INTERNAL_ERROR_CODE_40300 = "40300";
	public final static String INTERNAL_ERROR_CODE_40400 = "40400";
	public final static String INTERNAL_ERROR_CODE_40500 = "40500";

	// 服务器或系统异常内部码系列（包括业务型内部码系列）
	public final static String SYSTEM_ERROR_CODE_50000 = "50000";
	public final static String SERVICE_ERROR_CODE_50001 = "50001";
	public final static String DB_ERROR_CODE_50002 = "50002";
	public final static String BUSINESS_ERROR_CODE_51000 = "51000";
	public final static String BUSINESS_ERROR_CODE_51001 = "51001";
	public final static String BUSINESS_ERROR_CODE_51002 = "51002";
	public final static String BUSINESS_ERROR_CODE_51003 = "51003";
	public final static String BUSINESS_ERROR_CODE_51004 = "51004";
	public final static String BUSINESS_ERROR_CODE_51005 = "51005";
	public final static String BUSINESS_ERROR_CODE_51006 = "51006";
	public final static String BUSINESS_ERROR_CODE_51007 = "51007";
	public final static String BUSINESS_ERROR_CODE_51008 = "51008";
	public final static String BUSINESS_ERROR_CODE_51009 = "51009";
	public final static String BUSINESS_ERROR_CODE_51010 = "51010";
	public final static String BUSINESS_ERROR_CODE_51011 = "51011";
}
