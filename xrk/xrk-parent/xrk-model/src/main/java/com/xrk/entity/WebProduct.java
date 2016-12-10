package com.xrk.entity;

import java.util.Date;

public class WebProduct {
	private Integer id;

	private String name;

	private Integer shootingPlaceId;

	private Integer productStockId;

	private Integer cameramanId;

	private Integer clothingId;

	private Integer lookCount;

	private Integer praiseCount;

	private Date shoTime;

	private Integer price;
	private String description;

	private String shootingPlaceName;

	private String productStockName;

	private String clothingName;

	private String cameramanName;

	private Boolean enabled;

	private String album;

	private String cover;

	private Integer clothingPrice;
	private Integer shootingPlacePrice;
	private Integer productStockPrice;
	private Integer cameramanPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getShootingPlaceId() {
		return shootingPlaceId;
	}

	public void setShootingPlaceId(Integer shootingPlaceId) {
		this.shootingPlaceId = shootingPlaceId;
	}

	public Integer getProductStockId() {
		return productStockId;
	}

	public void setProductStockId(Integer productStockId) {
		this.productStockId = productStockId;
	}

	public Integer getCameramanId() {
		return cameramanId;
	}

	public void setCameramanId(Integer cameramanId) {
		this.cameramanId = cameramanId;
	}

	public Integer getClothingId() {
		return clothingId;
	}

	public void setClothingId(Integer clothingId) {
		this.clothingId = clothingId;
	}

	public Integer getLookCount() {
		return lookCount;
	}

	public void setLookCount(Integer lookCount) {
		this.lookCount = lookCount;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public Date getShoTime() {
		return shoTime;
	}

	public void setShoTime(Date shoTime) {
		this.shoTime = shoTime;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShootingPlaceName() {
		return shootingPlaceName;
	}

	public void setShootingPlaceName(String shootingPlaceName) {
		this.shootingPlaceName = shootingPlaceName == null ? null : shootingPlaceName.trim();
	}

	public String getProductStockName() {
		return productStockName;
	}

	public void setProductStockName(String productStockName) {
		this.productStockName = productStockName == null ? null : productStockName.trim();;
	}

	public String getClothingName() {
		return clothingName;
	}

	public void setClothingName(String clothingName) {
		this.clothingName = clothingName == null ? null : clothingName.trim();
	}

	public String getCameramanName() {
		return cameramanName;
	}

	public void setCameramanName(String cameramanName) {
		this.cameramanName = cameramanName == null ? null : cameramanName.trim();
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Integer getClothingPrice() {
		return clothingPrice;
	}

	public void setClothingPrice(Integer clothingPrice) {
		this.clothingPrice = clothingPrice;
	}

	public Integer getShootingPlacePrice() {
		return shootingPlacePrice;
	}

	public void setShootingPlacePrice(Integer shootingPlacePrice) {
		this.shootingPlacePrice = shootingPlacePrice;
	}

	public Integer getProductStockPrice() {
		return productStockPrice;
	}

	public void setProductStockPrice(Integer productStockPrice) {
		this.productStockPrice = productStockPrice;
	}

	public Integer getCameramanPrice() {
		return cameramanPrice;
	}

	public void setCameramanPrice(Integer cameramanPrice) {
		this.cameramanPrice = cameramanPrice;
	}

}