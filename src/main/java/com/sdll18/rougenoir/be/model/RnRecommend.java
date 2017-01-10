package com.sdll18.rougenoir.be.model;

import java.util.Date;

public class RnRecommend {
    private Integer id;

    private Integer commodityId;

    private Integer rnIndex;

    private Date createTime;

    private Date updateTime;

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

    public Integer getRnIndex() {
        return rnIndex;
    }

    public void setRnIndex(Integer rnIndex) {
        this.rnIndex = rnIndex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}