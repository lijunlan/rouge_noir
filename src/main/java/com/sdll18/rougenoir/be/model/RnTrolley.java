package com.sdll18.rougenoir.be.model;

import java.util.Date;

public class RnTrolley extends RnTrolleyKey {
    private Date createTime;

    private Integer count;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}