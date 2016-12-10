package com.xrk.entity;

public class WebProductStock {
    private Integer id;

    private String name;

    private String spec;

    private Integer number;

    private Integer price;

    private Integer cameramanId;

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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCameramanId() {
        return cameramanId;
    }

    public void setCameramanId(Integer cameramanId) {
        this.cameramanId = cameramanId;
    }
}