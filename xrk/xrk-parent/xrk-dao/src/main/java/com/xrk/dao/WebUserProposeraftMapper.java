package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebUserProposeraft;

public interface WebUserProposeraftMapper extends BaseMapper<WebUserProposeraft> {
    int deleteByPrimaryKey(Integer id);

    int insert(WebUserProposeraft record);

    int insertSelective(WebUserProposeraft record);

    WebUserProposeraft selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebUserProposeraft record);

    int updateByPrimaryKey(WebUserProposeraft record);
}