package com.xrk.utils;

import com.xrk.utils.exception.GMException;
import com.xrk.utils.exception.GMExceptionConstant;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/** 对象复制
 * <p> 对org.apache.commons.beanutils.PropertyUtils再封装，自定义抛出GMException</p>
 * @author crescents
 * 
 * @param <Dest> 目标对象的类型
 * @param <Orig> 源对象的类型
 */
public class BeanUtil<Dest,Orig> {
	public static void  copyBean(Object dest,Object orig) throws GMException{
		try {
			PropertyUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			throw new GMException(GMExceptionConstant.FAILED_COPY_PROPERTIES_ILLEGALACCESS);
		} catch (InvocationTargetException e) {
			throw new GMException(GMExceptionConstant.FAILED_COPY_PROPERTIES_INVOCATIONTARGET);
		} catch (NoSuchMethodException e) {
			throw new GMException(GMExceptionConstant.FAILED_COPY_PROPERTIES_NOSUCHMETHOD);
		}
	};
	

	/** 复制list
	 * @param destClazz 目标对象Class
	 * @param origList 源list
	 * @return
	 * @throws com.xrk.utils.exception.GMException
	 */
	public  List<Dest> copyList(Class<?> destClazz,List<Orig> origList) throws GMException{
		List<Dest> destList = new ArrayList<Dest>(origList.size());
		for (int i = 0; i < origList.size(); i++) {
			try {
				Dest destObject = (Dest)destClazz.newInstance();
				PropertyUtils.copyProperties(destObject, origList.get(i));
				destList.add(destObject);
			} catch (IllegalAccessException e) {
				throw new GMException(GMExceptionConstant.FAILED_COPY_PROPERTIES_ILLEGALACCESS);
			} catch (InvocationTargetException e) {
				throw new GMException(GMExceptionConstant.FAILED_COPY_PROPERTIES_INVOCATIONTARGET);
			} catch (NoSuchMethodException e) {
				throw new GMException(GMExceptionConstant.FAILED_COPY_PROPERTIES_NOSUCHMETHOD);
			} catch (InstantiationException e) {
				throw new GMException(GMExceptionConstant.FAILED_COPY_PROPERTIES);
			}
		}
		return destList;
	}
}
