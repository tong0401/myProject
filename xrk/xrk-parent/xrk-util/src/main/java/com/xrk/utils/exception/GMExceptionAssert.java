package com.xrk.utils.exception;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;


/**
 * SOA异常的断言，当断言不成立时，抛出SOA异常 
 * @author 吴春海 Molo.Wu
 * @since 2013-6-21
 */
public class GMExceptionAssert {
	
	/** 判断是否成功保存或更新数据。若否，则抛异常
	 * @param updatesRow
	 * @throws com.xrk.utils.exception.GMException
	 */
	public static void isSaveOrUpdateSuccess(int updatesRow) throws GMException{
		if(updatesRow<1)
			throw new GMException(GMExceptionConstant.FAILED_SAVE_UPDATE);
	}
	
	/** 判断是否成功删除数据。若否，则抛异常
	 * @param updatesRow
	 * @throws com.xrk.utils.exception.GMException
	 */
	public static void isDeleteSuccess(int updatesRow) throws GMException{
		if(updatesRow>=1)
			throw new GMException(GMExceptionConstant.SUCCESS_DELETE);
	}
	
	/** 判断需更新条数和已更新条数是否相等。若否，抛异常
	 * @param total 需更新条数
	 * @param updatesRow 已更新条数
	 * @throws com.xrk.utils.exception.GMException
	 */
	public static void isBatchSaveOrUpdate(int total,int updatesRow) throws GMException{
		if(total!=updatesRow)
			throw new GMException(GMExceptionConstant.FAILED_SAVE_UPDATE);
	}
	
	
	/**
	 * Assert a boolean expression, throwing <code>GMException</code>
	 * if the test result is <code>false</code>.
	 * <pre class="code">Assert.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
	 * @param expression a boolean expression
	 * @param message the exception message to use if the assertion fails
	 * @throws com.xrk.utils.exception.GMException if expression is <code>false</code>
	 */
	public static void isTrue(boolean expression, String errorCode, String message) throws GMException {
		if (!expression) {
			throw new GMException(errorCode, message);
		}
	}

	/**
	 * Assert that an object is <code>null</code> .
	 * <pre class="code">Assert.isNull(value, "The value must be null");</pre>
	 * @param object the object to check
	 * @param message the exception message to use if the assertion fails
	 * @throws com.xrk.utils.exception.GMException if the object is not <code>null</code>
	 */
	public static void isNull(Object object, String errorCode, String message) throws GMException {
		if (object != null) {
			throw new GMException(errorCode, message);
		}
	}
	
	/**
	 * 判断值是否为空，否则抛出异常
	 * @param object
	 * @param errorCode
	 * @param message
	 * @author 吴春海 Molo.Wu
	 * @throws com.xrk.utils.exception.GMException
	 * @since 2013-6-21
	 */
	public static void isNotNull(Object object, String errorCode, String message) throws GMException {
		if (object == null) {
			throw new GMException(errorCode, message);
		}
	}

	/**
	 * Assert that an object is not <code>null</code> .
	 * <pre class="code">Assert.notNull(clazz, "The class must not be null");</pre>
	 * @param object the object to check
	 * @param message the exception message to use if the assertion fails
	 * @throws com.xrk.utils.exception.GMException if the object is <code>null</code>
	 */
	public static void notNull(Object object, String errorCode, String message) throws GMException {
		if (object == null) {
			throw new GMException(errorCode, message);
		}
	}
	
	/**
	 * 判断是否为空， 如果为空（null/单个空格/多个空格），则抛出异常
	 * @param text 判断的字符串
	 * @param errorCode 错误码
	 * @param message 错误信息
	 * @author 吴春海 Molo.Wu
	 * @throws com.xrk.utils.exception.GMException
	 * @since 2013-6-21
	 */
	public static void isNotBlank(String text, String errorCode, String message) throws GMException{
		if(!org.apache.commons.lang.StringUtils.isNotBlank(text)) {
			throw new GMException(errorCode, message);
		}
	}
	
	/**
	 * 判断字符串是否为空，如果为空（null/单个空格），则抛出异常
	 * @param StringUtils 判断的字符串
	 * @param errorCode 错误码
	 * @param message 错误信息
	 * @author 吴春海 Molo.Wu
	 * @throws com.xrk.utils.exception.GMException
	 * @since 2013-6-21
	 */
	public static void isNotEmpty(String text, String errorCode, String message) throws GMException {
		if (org.apache.commons.lang.StringUtils.isEmpty(text)) {
			throw new GMException(errorCode, message);
		}
	}
	
	/**
	 * 判断值是否有值， 如果为空或0，则抛出异常
	 * @param value 判断的值
	 * @param errorCode 错误码
	 * @param message 错误信息
	 * @author 吴春海 Molo.Wu
	 * @throws com.xrk.utils.exception.GMException
	 * @since 2013-6-21
	 */
	public static void hasValue(Long value, String errorCode, String message) throws GMException{
		if(value == null || value.equals(0L)) {
			throw new GMException(errorCode, message);
		}
	}
	
	/**
	 * 判断值是否有值， 如果为空或0，则抛出异常
	 * @param value 判断的值
	 * @param errorCode 错误码
	 * @param message 错误信息
	 * @author 吴春海 Molo.Wu
	 * @throws com.xrk.utils.exception.GMException
	 * @since 2013-6-21
	 */
	public static void hasValue(Integer value, String errorCode, String message) throws GMException{
		if(value == null || value.equals(0)) {
			throw new GMException(errorCode, message);
		}
	}

	/**
	 * Assert that the given text does not contain the given substring.
	 * <pre class="code">Assert.doesNotContain(name, "rod", "Name must not contain 'rod'");</pre>
	 * @param textToSearch the text to search
	 * @param substring the substring to find within the text
	 * @param message the exception message to use if the assertion fails
	 * @throws com.xrk.utils.exception.GMException
	 */
	public static void doesNotContain(String textToSearch, String substring, String errorCode, String message) throws GMException {
		if (!org.apache.commons.lang.StringUtils.contains(textToSearch, substring)) {
			throw new GMException(errorCode, message);
		}
	}


	/**
	 * Assert that an array has elements; that is, it must not be
	 * <code>null</code> and must have at least one element.
	 * <pre class="code">Assert.notEmpty(array, "The array must have elements");</pre>
	 * @param array the array to check
	 * @param message the exception message to use if the assertion fails
	 * @throws com.xrk.utils.exception.GMException if the object array is <code>null</code> or has no elements
	 */
	public static void isNotEmpty(Object[] array, String errorCode, String message) throws GMException {
		if (ObjectUtils.isEmpty(array)) {
			throw new GMException(errorCode, message);
		}
	}

	/**
	 * Assert that an array has no null elements.
	 * Note: Does not complain if the array is empty!
	 * <pre class="code">Assert.noNullElements(array, "The array must have non-null elements");</pre>
	 * @param array the array to check
	 * @param message the exception message to use if the assertion fails
	 * @throws com.xrk.utils.exception.GMException if the object array contains a <code>null</code> element
	 */
	public static void hasNoNullElements(Object[] array, String errorCode, String message) throws GMException {
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					throw new GMException(errorCode, message);
				}
			}
		}
	}

	/**
	 * Assert that a collection has elements; that is, it must not be
	 * <code>null</code> and must have at least one element.
	 * <pre class="code">Assert.notEmpty(collection, "Collection must have elements");</pre>
	 * @param collection the collection to check
	 * @param message the exception message to use if the assertion fails
	 * @throws com.xrk.utils.exception.GMException if the collection is <code>null</code> or has no elements
	 */
	public static void isNotEmpty(Collection<?> collection, String errorCode, String message) throws GMException {
		if (CollectionUtils.isEmpty(collection)) {
			throw new GMException(errorCode, message);
		}
	}

	/**
	 * Assert that a Map has entries; that is, it must not be <code>null</code>
	 * and must have at least one entry.
	 * <pre class="code">Assert.notEmpty(map, "Map must have entries");</pre>
	 * @param map the map to check
	 * @param message the exception message to use if the assertion fails
	 * @throws com.xrk.utils.exception.GMException if the map is <code>null</code> or has no entries
	 */
	public static void isNotEmpty(Map<?, ?> map, String errorCode, String message) throws GMException {
		if (CollectionUtils.isEmpty(map)) {
			throw new GMException(errorCode, message);
		}
	}

	/**
	 * Assert that the provided object is an instance of the provided class.
	 * <pre class="code">Assert.instanceOf(Foo.class, foo);</pre>
	 * @param type the type to check against
	 * @param obj the object to check
	 * @param message a message which will be prepended to the message produced by
	 * the function itself, and which may be used to provide context. It should
	 * normally end in a ": " or ". " so that the function generate message looks
	 * ok when prepended to it.
	 * @throws com.xrk.utils.exception.GMException if the object is not an instance of clazz
	 * @see Class#isInstance
	 */
	public static void isInstanceOf(Class<?> type, Object obj, String errorCode, String message) throws GMException {
		notNull(type, errorCode, message + ": type is null");
		if (!type.isInstance(obj)) {
			throw new GMException(errorCode, message +
					"Object of class [" + (obj != null ? obj.getClass().getName() : "null") +
					"] must be an instance of " + type);
		}
	}

	/**
	 * Assert that <code>superType.isAssignableFrom(subType)</code> is <code>true</code>.
	 * <pre class="code">Assert.isAssignable(Number.class, myClass);</pre>
	 * @param superType the super type to check against
	 * @param subType the sub type to check
	 * @param message a message which will be prepended to the message produced by
	 * the function itself, and which may be used to provide context. It should
	 * normally end in a ": " or ". " so that the function generate message looks
	 * ok when prepended to it.
	 * @throws com.xrk.utils.exception.GMException if the classes are not assignable
	 */
	public static void isAssignable(Class<?> superType, Class<?> subType, String errorCode, String message) throws GMException {
		notNull(superType, errorCode, message + ": superType is null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			throw new GMException(errorCode, message + subType + " is not assignable to " + superType);
		}
	}
}