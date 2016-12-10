package com.xrk.base;

import com.xrk.utils.PageView;

import java.util.List;

/**
 * 集合持久层的公用的增，删，改，查接口
 * <T> 表示传入实体类
 * @author tong
 * 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 * @param <T>
 */
public interface BaseMapper<T> {
	/**
	 * 返回分页后的数据
	 * @param pageView
	 * @param t
	 * @return
	 */
	public List<T> query(PageView pageView, T t);
	/**
	 * 返回所有数据
	 * @param t
	 * @return
	 */
	public List<T> queryAll(T t);
	public int delete(String id);

	public int deleteById(String id);
	public int modify(T t);

	public int update(T t);
	public T getById(String id);
	public int add(T t);
}
