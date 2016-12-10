package com.xrk.entity;

import java.io.Serializable;

/**
 * 上传图片信息
 * 
 * @author tong
 *
 */
public class Cover implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2276954903608053809L;
	private String url;
	private String item;
	private String title;
	private String content;
	private String fileName;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
