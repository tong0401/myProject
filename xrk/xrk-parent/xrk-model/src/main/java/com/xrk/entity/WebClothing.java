package com.xrk.entity;

@SuppressWarnings("serial")
public class WebClothing implements java.io.Serializable{
    private Integer id;

    private String name;

    private Integer price;

    private String description;

    public WebClothing() {
		super();
	}

	public WebClothing(Integer id, String name, Integer price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
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
        this.description = description == null ? null : description.trim();
    }
}