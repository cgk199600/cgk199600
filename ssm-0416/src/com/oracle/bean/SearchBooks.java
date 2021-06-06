package com.oracle.bean;

import java.math.BigDecimal;

import org.hamcrest.core.IsNull;

public class SearchBooks {
	private Integer typeId;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private String boosName;
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getBoosName() {
		return boosName;
	}
	public void setBoosName(String boosName) {
		this.boosName = boosName;
	}
	@Override
	public String toString() {
		return "SearchBooks [typeId=" + typeId + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", boosName="
				+ boosName + "]";
	}
	public SearchBooks(Integer typeId, BigDecimal minPrice, BigDecimal maxPrice, String boosName) {
		super();
		this.typeId = typeId;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.boosName = boosName;
	}
	public SearchBooks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
