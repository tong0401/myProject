package com.xrk.service.log;

import com.xrk.dao.LogMapper;
import com.xrk.entity.Log;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("logService")
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;

	public PageView query(PageView pageView, Log log) {
		List<Log> list = logMapper.query(pageView, log);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(Log log) {
		logMapper.add(log);
	}

	public void delete(String id) {
		logMapper.delete(id);
	}

	public Log getById(String id) {
		return logMapper.getById(id);
	}

	public void modify(Log log) {
		logMapper.modify(log);
	}

	public List<Log> findAll(Log log) {
		return logMapper.queryAll(log);
	}

}
