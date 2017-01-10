package com.sdll18.rougenoir.be.model;

public class RnHomePage {
    private Integer id;

    private Integer commodityId;

    private String description;

    private String title;

    private String cover;

    private Integer rnIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public Integer getRnIndex() {
        return rnIndex;
    }

    public void setRnIndex(Integer rnIndex) {
        this.rnIndex = rnIndex;
    }
}