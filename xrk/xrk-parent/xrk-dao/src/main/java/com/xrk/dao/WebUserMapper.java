package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebUser;

public interface WebUserMapper extends BaseMapper<WebUser> {
    int deleteByPrimaryKey(Integer id);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    WebUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKeyWithBLOBs(WebUser record);

    int updateByPrimaryKey(WebUser record);
}