package com.xrk.utils;


import java.util.HashMap;
 
public class ResultHashMap extends HashMap<String, Object> {

	private static final long serialVersionUID = -4970973511892646114L;
	public final static String ERROR="error";
	public final static String RESULT="result";

	public ResultHashMap() {
		this.put(ERROR, false);
 	}

	public ResultHashMap(Object result) {
		this.put(ERROR, false);
		this.put(RESULT, result);
	}
	

}
