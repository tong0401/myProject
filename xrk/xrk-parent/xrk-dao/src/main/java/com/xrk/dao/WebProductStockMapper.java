package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebProductStock;

import java.util.List;

public interface WebProductStockMapper extends BaseMapper<WebProductStock> {

	List<WebProductStock> findAll();
}