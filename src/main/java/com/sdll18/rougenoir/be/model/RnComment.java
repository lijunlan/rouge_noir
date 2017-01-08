package com.sdll18.rougenoir.be.model;

import java.util.Date;

public class RnComment {
    private Integer id;

    private Integer fromUserId;

    private Integer toOrderId;

    private String content;

    private Date createTime;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToOrderId() {
        return toOrderId;
    }

    public void setToOrderId(Integer toOrderId) {
        this.toOrderId = toOrderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}