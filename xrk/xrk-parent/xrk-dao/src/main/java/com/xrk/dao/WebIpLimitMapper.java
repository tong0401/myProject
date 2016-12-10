package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebIpLimit;

public interface WebIpLimitMapper extends BaseMapper<WebIpLimit> {
    int deleteByPrimaryKey(Integer id);

    int insert(WebIpLimit record);

    int insertSelective(WebIpLimit record);

    WebIpLimit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebIpLimit record);

    int updateByPrimaryKey(WebIpLimit record);
}