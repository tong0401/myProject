package com.xrk.utils.exception;

public enum GMExceptionConstant {

	/** object is null*/
	OBJECT_NULL_EXCEPTION("OBJECT_NULL_EXCEPTION","This argument is required; it must not be null!"),
	/** 为空（null/单个空格)*/
	TEXT_EMPTY_EXCEPTION("OBJECT_NULL_EXCEPTION","It must not be empty!"),
	/** 为空（null/单个空格)*/
	COLLECTION_EMPTY_EXCEPTION("COLLECTION_NULL_EXCEPTION","Collection must not be empty!"),
	
	
	
	
	/**failed to copy properties*/
	FAILED_COPY_PROPERTIES("FAILED_COPY_PROPERTIES","failed to copy properties"),
	FAILED_COPY_PROPERTIES_ILLEGALACCESS("FAILED_COPY_PROPERTIES_ILLEGALACCESS","failed to copy properties,throw IllegalAccessException!"),
	FAILED_COPY_PROPERTIES_INVOCATIONTARGET("FAILED_COPY_PROPERTIES_INVOCATIONTARGET","failed to copy properties,throw InvocationTargetException!"),
	FAILED_COPY_PROPERTIES_NOSUCHMETHOD("FAILED_COPY_PROPERTIES_NOSUCHMETHOD","failed to copy properties,throw NoSuchMethodException!"),
	
	
	
	
	/***************************system**************************************/
	/**需要session*/
	IHF_NEED_SESSION_EXCEPTION("IHF_NEED_SESSION_EXCEPTION","you should login first."),
	
	/***************************User**************************************/
	
	/**不存在此用户*/
	USER_IS_NOT_EXIST("USER_IS_NOT_EXIST","the user is not existed"),
	/**存在此用户*/
	USER_IS_EXIST("USER_IS_EXIST","the user is exist"),
	/**存在此新闻批次名称*/
	BATCHNAME_IS_EXIST("BATCHNAME_IS_EXIST","the batchname is exist"),
	/**存在此资讯分类名称*/
	CATEGORYNAME_IS_EXIST("CATEGORYNAME_IS_EXIST","the categoryname is exist"),
	/**存在此视听分类名称*/
	VIDEOCATEGORYNAME_IS_EXIST("VIDEOCATEGORYNAME_IS_EXIST","the videocategoryname is exist"),
	/**此用户已经申请过VIP*/
	USERVIP_IS_EXIST("USERVIP_IS_EXIST","the user had apply vip"),
	/**此用户已经申请过VIP*/
	USERALIAS_IS_EXIST("USERALIAS_IS_EXIST","the user alias is exist"),
	/**昵称已存在*/
	NICKNAME_IS_EXIST("NICKNAME_IS_EXIST","the nickname is exist"),
	/**名称已存在*/
	NAME_IS_EXIST("NAME_IS_EXIST","the name is exist"),
	/**存在此手机号*/
	MOBILE_IS_EXIST("MOBILE_IS_EXIST","the mobile is exist"),
	/**不存在此手机号*/
	MOBILE_IS_NOT_EXIST("MOBILE_IS_NOT_EXIST","the mobile is not exist"),
	/**存在此邮箱*/
	EMAIL_IS_EXIST("EMAIL_IS_EXIST","the email is exist"),
	/**不存在此邮箱*/
	EMAIL_IS_NOT_EXIST("EMAIL_IS_NOT_EXIST","the email is not exist"),
	/**邮箱验证码错误*/
	EMAIL_VALIDATECODE_WRONG("EMAIL_VALIDATECODE_WRONG","Email's validateCode is wrong"),
	/**手机验证码错误*/
	MOBILE_VALIDATECODE_WRONG("MOBILE_VALIDATECODE_WRONG","mobile's validateCode is wrong"),
	
	/**邮箱格式错误*/
	EMAIL_FORMAT_WRONG("EMAIL_FORMAT_WRONG","Email's format is wrong"),
	/**邮箱格式错误*/
	MOBILE_FORMAT_WRONG("MOBILE_FORMAT_WRONG","Mobile's format is wrong"),
	
	/**邮箱发送次数太多*/
	EMAIL_SEND_FREQUENCY("EMAIL_SEND_TIME_TOO_MANY","email send frequency! please wait until date."),
	/**手机发送次数太多*/
	MOBILE_SEND_FREQUENCY("MOBILE_SEND_TIME_TOO_MANY","mobile send frequency! please wait until date."),
	/**此新闻已经被当前用户收藏*/
	COLLECTION_IS_EXIST("COLLECTION_IS_EXIST","this news had collection by this user"),
	/**登录失败次数太多*/
	LOGIN_FAILED_FREQUENCY("LOGIN_FAILED_FREQUENCY","login failed frequency! please wait."),
	
	
	
	/*****************************************************msecurity************************************/
	/**不存在此新闻*/
	ARTICLE_IS_NOT_EXIST("ARTICLE_IS_NOT_EXIST","the article is not existed"),

	/**mybatis delete */
	SUCCESS_DELETE("SUCCESS_DELETE","success to delete data"),

	/**用户已经申请记者 */
	REPORTER_IS_EXIST("REPORTER_IS_EXIST","reporter had register"),
	
	
	
	/*****************************************************msecurity************************************/
	/**不存在此安全表数据*/
	MSECURITY_IS_NOT_EXIST("MSECURITY_IS_NOT_EXIST","the msecurity is not existed"),
	
	/**mybatis update */
	FAILED_SAVE_UPDATE("FAILED_SAVE_UPDATE","failed to saveOrUpdate data");
	
	
	private final String errorCode;
	private final String errorMsg;
	
	GMExceptionConstant(String errorCode,String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public String getErrorCode(){
		return errorCode;
	}
	
	public String getErrorMsg(){
		return errorMsg;
	}
	
}
