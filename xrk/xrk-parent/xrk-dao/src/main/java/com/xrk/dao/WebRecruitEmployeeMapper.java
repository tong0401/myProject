package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebRecruitEmployee;

public interface WebRecruitEmployeeMapper extends BaseMapper<WebRecruitEmployee> {
    int deleteByPrimaryKey(Integer id);

    int insert(WebRecruitEmployee record);

    int insertSelective(WebRecruitEmployee record);

    WebRecruitEmployee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebRecruitEmployee record);

    int updateByPrimaryKey(WebRecruitEmployee record);
}