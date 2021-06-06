package com.oracle.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Book implements Serializable {
    private Integer bookId;

    private String bookName;

    private BigDecimal price;

    private Integer bookNum;

    private String bookInfo;

    private String bookImage;

    private Integer bookState;

    private Integer typeId;

    private static final long serialVersionUID = 1L;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo == null ? null : bookInfo.trim();
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage == null ? null : bookImage.trim();
    }

    public Integer getBookState() {
        return bookState;
    }

    public void setBookState(Integer bookState) {
        this.bookState = bookState;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + ", bookNum=" + bookNum
				+ ", bookInfo=" + bookInfo + ", bookImage=" + bookImage + ", bookState=" + bookState + ", typeId="
				+ typeId + "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bookId, String bookName, BigDecimal price, Integer bookNum, String bookInfo, String bookImage,
			Integer bookState, Integer typeId) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.bookNum = bookNum;
		this.bookInfo = bookInfo;
		this.bookImage = bookImage;
		this.bookState = bookState;
		this.typeId = typeId;
	}
    
}