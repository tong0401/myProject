package com.xrk.entity;

/**
 * 摄影师实体类
 * @author tong
 *
 */
@SuppressWarnings("serial")
public class WebCameraman implements java.io.Serializable {

	private Integer id;

	private String name;

	private Integer evaluationCount;

	private Integer productionCount;

	private Integer bespeakCount;

	private String tel;

	private String email;

	private String description;

	public WebCameraman() {
	}

	public WebCameraman(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

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
		this.name = name == null ? null : name.trim();
	}

	public Integer getEvaluationCount() {
		return evaluationCount;
	}

	public void setEvaluationCount(Integer evaluationCount) {
		this.evaluationCount = evaluationCount;
	}

	public Integer getProductionCount() {
		return productionCount;
	}

	public void setProductionCount(Integer productionCount) {
		this.productionCount = productionCount;
	}

	public Integer getBespeakCount() {
		return bespeakCount;
	}

	public void setBespeakCount(Integer bespeakCount) {
		this.bespeakCount = bespeakCount;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}