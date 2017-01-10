package com.sdll18.rougenoir.be.model;

public class RnCategory {
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer rnIndex;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getRnIndex() {
        return rnIndex;
    }

    public void setRnIndex(Integer rnIndex) {
        this.rnIndex = rnIndex;
    }
}