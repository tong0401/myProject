/**
 * 
 */
package com.xrk.utils;

import org.springframework.util.DigestUtils;

/**
 * @Description: md5加密
 * @author Chaohua Lee
 * @date 2014-4-10 上午12:55:37
 * @version V1.0
 */
public class EncryptUtil {
	/** 加密UUID
	 * @author Chaohua Lee
	 * @param uuid
	 * @return
	 */
	public static String encrytUUID(String uuid){
		return DigestUtils.md5DigestAsHex((uuid + EncryptKey.UUID.getValue()).getBytes());
	}
	
	/** 加密password
	 * @author Chaohua Lee
	 * @param password
	 * @return
	 */
	public static String encrytPassword(String password){
		return DigestUtils.md5DigestAsHex((password + EncryptKey.PASSWORD.getValue()).getBytes());
	}
	
	/** 加密 图片名
	 * @author Chaohua Lee
	 * @param imageName
	 * @return
	 */
	public static String encrytImageName(String imageName){
		return DigestUtils.md5DigestAsHex((imageName + EncryptKey.IMAGENAME.getValue()).getBytes());
	}
	
	
}
