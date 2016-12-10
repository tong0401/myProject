package com.xrk.service.serverinfo;

import com.xrk.entity.ServerInfo;
import com.xrk.utils.PageView;

import java.util.List;

public interface ServerInfoService{
	PageView query(PageView pageView, ServerInfo serverInfo);
	
	List<ServerInfo> queryAll(ServerInfo serverInfo);
	
	void add(ServerInfo serverInfo);
	
	void delete(String id);
	
	ServerInfo getById(String id);
	
	void modify(ServerInfo serverInfo);
}
