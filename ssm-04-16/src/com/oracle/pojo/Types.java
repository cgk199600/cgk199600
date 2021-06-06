package com.oracle.pojo;

import java.io.Serializable;

public class Types implements Serializable {
    private Integer typeid;

    private String typename;

    private static final long serialVersionUID = 1L;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}