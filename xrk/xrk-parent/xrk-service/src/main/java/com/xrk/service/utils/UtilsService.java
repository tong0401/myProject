package com.xrk.service.utils;

import com.xrk.utils.exception.GMException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 套餐
 * 
 * @author tong
 *
 */
public interface UtilsService {

	Map<String, String> uploadImg(HttpServletRequest request) throws GMException;

}
