package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebLinkOur;

public interface WebLinkOurMapper extends BaseMapper<WebLinkOur> {
    int deleteByPrimaryKey(Integer id);

    int insert(WebLinkOur record);

    int insertSelective(WebLinkOur record);

    WebLinkOur selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebLinkOur record);

    int updateByPrimaryKey(WebLinkOur record);
}