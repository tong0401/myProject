package com.xrk.service.serverinfo;

import com.xrk.dao.ServerInfoMapper;
import com.xrk.entity.ServerInfo;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("serverInfoService")
public class ServerInfoServiceImpl implements ServerInfoService{
	@Autowired
	private ServerInfoMapper serverInfoMapper;

	public void add(ServerInfo serverInfo) {
		serverInfoMapper.add(serverInfo);
	}

	public void delete(String id) {
		serverInfoMapper.delete(id);
	}

	public ServerInfo getById(String id) {
		return serverInfoMapper.getById(id);
	}
	
	//编译指令
	public PageView query(PageView pageView, ServerInfo serverInfo) {
		List<ServerInfo> list = serverInfoMapper.query(pageView, serverInfo);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<ServerInfo> queryAll(ServerInfo serverInfo) {
		return serverInfoMapper.queryAll(serverInfo);
	}

	public void modify(ServerInfo serverInfo) {
		serverInfoMapper.modify(serverInfo);
	}
	
}
