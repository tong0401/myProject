package com.xrk.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xrk.entity.Album;
import com.xrk.entity.Cover;

public class WebProductVo {
	private Integer id;

	private String name;

	private Integer shootingPlaceId;

	private Integer productLineId;

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

	private byte[] enabled;

	private String album;

	private String cover;

	private Integer clothingPrice;
	private Integer shootingPlacePrice;
	private Integer productStockPrice;
	private Integer cameramanPrice;

	private List<Album> albumList = new ArrayList<Album>();

	private List<Cover> coverList = new ArrayList<Cover>();

	private String deleteImg;

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

	public Integer getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(Integer productLineId) {
		this.productLineId = productLineId;
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
		this.productStockName = productStockName == null ? null : productStockName.trim();
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

	public byte[] getEnabled() {
		return enabled;
	}

	public void setEnabled(byte[] enabled) {
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

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

	public List<Cover> getCoverList() {
		return coverList;
	}

	public void setCoverList(List<Cover> coverList) {
		this.coverList = coverList;
	}

	public String getDeleteImg() {
		return deleteImg;
	}

	public void setDeleteImg(String deleteImg) {
		this.deleteImg = deleteImg;
	}

}