package com.sdll18.rougenoir.be.model;

import java.util.Date;

public class RnBrowseHistory extends RnBrowseHistoryKey {
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}