package com.xrk.utils.exception;


public class GMSOAException extends RuntimeException {

	private static final long serialVersionUID = -2396344394815479161L;

	public static final String ISP = "ISP";//系统内部
	public static final String ISV = "ISV";//用户导致错误
	
	private String errorCode;
	private String subCode;

	public GMSOAException(String subCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = ISV;
		this.subCode=subCode;
	}
	
	public GMSOAException(String subCode, Throwable cause) {
		super(cause);
		this.errorCode = ISV;
		this.subCode=subCode;
	}
	
	/**
	 * 
	 */
	public GMSOAException(String subCode,String message) {
		super(message);
		this.errorCode = ISV;
		this.subCode=subCode;
	}
	public GMSOAException(String message) {
		super(message);
		this.errorCode = ISV;
		this.subCode=GMSOAExceptionConstant.UPAL_UNDEFINED_EXCEPTION;
	}
	

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	
}
