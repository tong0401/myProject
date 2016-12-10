package com.xrk.utils.exception;

public class GMSOAExceptionConstant {
	
	public static final String UPAL_SOA_EXCEPTION                  = "UPAL_SOA_EXCEPTION";
	public static final String UPAL_NEED_SESSION_EXCEPTION         = "UPAL_NEED_SESSION_EXCEPTION";
	public static final String UPAL_NEED_SESSION_EXCEPTION_MESSAGE = "you should login first.";
    /** 参数错误 **/
    public static final String UPAL_PARAM_REQUIRED_EXCEPTION        			 = "UPAL_PARAM_ERROR";
    /** 远程调用失败，例如webservice异常 **/
    public static final String UPAL_REMOTE_SERVICE_ERROR           = "UPAL_REMOTE_SERVICE_ERROR";
    /** 数据库数据错误，例如存在两个相同记录或者记录不存在等等不符合业务逻辑的情况 **/
    public static final String UPAL_DB_DATA_ERROR           		 = "UPAL_DB_DATA_ERROR";
    /** 数据库执行异常 **/
    public static final String UPAL_DB_QUERY_ERROR     		 	 = "UPAL_DB_QUERY_ERROR";
    /** 数据库链接异常 **/
    public static final String UPAL_DB_CONNECTION_ERROR     		 = "UPAL_DB_CONNECTION_ERROR";
    /** 未定义异常 **/
    public static final String UPAL_UNDEFINED_EXCEPTION            = "UPAL_UNDEFINED_EXCEPTION";
    /** 未知异常 **/
    public static final String UPAL_UNKNOWN_EXCEPTION              = "UPAL_UNKNOWN_EXCEPTION";
    /** 要操作/读取的实体不属于此用户，如买家读取update一个不属于祂的buyneed**/
    public static final String UPAL_ENTITY_BELONGING               = "UPAL_ENTITY_BELONGING";
}
