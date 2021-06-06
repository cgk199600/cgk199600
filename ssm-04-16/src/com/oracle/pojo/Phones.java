package com.oracle.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Phones implements Serializable {
    private Integer phId;

    private String phName;

    private BigDecimal phPrice;

    private String phInfo;

    private String phImage;

    private Integer phNum;

    private static final long serialVersionUID = 1L;

    public Integer getPhId() {
        return phId;
    }

    public void setPhId(Integer phId) {
        this.phId = phId;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName == null ? null : phName.trim();
    }

    public BigDecimal getPhPrice() {
        return phPrice;
    }

    public void setPhPrice(BigDecimal phPrice) {
        this.phPrice = phPrice;
    }

    public String getPhInfo() {
        return phInfo;
    }

    public void setPhInfo(String phInfo) {
        this.phInfo = phInfo == null ? null : phInfo.trim();
    }

    public String getPhImage() {
        return phImage;
    }

    public void setPhImage(String phImage) {
        this.phImage = phImage == null ? null : phImage.trim();
    }

    public Integer getPhNum() {
        return phNum;
    }

    public void setPhNum(Integer phNum) {
        this.phNum = phNum;
    }
}