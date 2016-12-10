package com.xrk.service.log;

import com.xrk.entity.Log;
import com.xrk.utils.PageView;

import java.util.List;

public interface LogService{
	PageView query(PageView pageView, Log log);
	
	void add(Log log);
	
	void delete(String id);
	
	void modify(Log log);
	
	Log getById(String id);
	
	List<Log> findAll(Log log);
	
}
