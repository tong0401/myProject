package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebClothing;

import java.util.List;

public interface WebClothingMapper extends BaseMapper<WebClothing> {

	List<WebClothing> findAll();

}