package com.myplay.model;

public class Goods {
    private Integer id;

    private String name;

    private String picture;

    private Float price;

    private String introduce;

    private Integer typeId;

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

	public Goods(Integer id, String name, String picture, Float price, String introduce, Integer typeId) {
		super();
		this.id = id;
		this.name = name;
		this.picture = picture;
		this.price = price;
		this.introduce = introduce;
		this.typeId = typeId;
	}
    
}