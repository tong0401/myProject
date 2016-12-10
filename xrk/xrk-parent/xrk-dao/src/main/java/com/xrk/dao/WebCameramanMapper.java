package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.WebCameraman;

import java.util.List;

public interface WebCameramanMapper extends BaseMapper<WebCameraman> {

	List<WebCameraman> findAll();
}