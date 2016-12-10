package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebShootingPlace;

import java.util.List;

public interface WebShootingPlaceMapper extends BaseMapper<WebShootingPlace> {

	List<WebShootingPlace> findAll();
    
}