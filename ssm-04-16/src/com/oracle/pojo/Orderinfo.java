package com.oracle.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Orderinfo implements Serializable {
    private Integer infoId;

    private Integer oredersId;

    private Integer bookId;

    private BigDecimal buyprice;

    private Integer buyNum;

    private static final long serialVersionUID = 1L;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getOredersId() {
        return oredersId;
    }

    public void setOredersId(Integer oredersId) {
        this.oredersId = oredersId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public BigDecimal getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(BigDecimal buyprice) {
        this.buyprice = buyprice;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }
}