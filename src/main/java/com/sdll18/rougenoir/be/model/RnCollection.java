package com.sdll18.rougenoir.be.model;

import java.util.Date;

public class RnCollection extends RnCollectionKey {
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}