package com.xrk.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WebShootingPlace implements Serializable{
    private Integer id;

    private String description;

    private Boolean enabled;

    private String name;

    public WebShootingPlace() {
		super();
	}

	public WebShootingPlace(Integer id, String description, Boolean enabled, String name) {
		super();
		this.id = id;
		this.description = description;
		this.enabled = enabled;
		this.name = name;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}