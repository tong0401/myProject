package com.xrk.utils;

/**
 * @Description 加密关键字
 * @author Chaohua Lee
 * @date 2014-4-11
 */
public enum EncryptKey {
	/**MD5 UUID 噪点*/
	UUID("zR4pRS*AjrjPyF%u3cKOHKj7&fkM1rhC"),
	/**MD5 密码 噪点*/
	PASSWORD("Mu&zD8FajdC$HxmjKL1O%!Np7D8spU@0"),
	/**图片  噪点*/
	IMAGENAME("!g1&sR0EmtMJ^D@L#Xg4@gd011#q6rQF");
	private String key;
	EncryptKey(String key){
		this.key = key;
	}
	
	public String getValue() {
		return this.key;
	}
	
}
