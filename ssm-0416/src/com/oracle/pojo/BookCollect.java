package com.oracle.pojo;

import java.io.Serializable;

public class BookCollect implements Serializable {
    private Integer bookId;

    private Integer userId;
    
    private String bookName;
    private String username;
    private Integer price;
    

    public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	private static final long serialVersionUID = 1L;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "BookCollect [bookId=" + bookId + ", userId=" + userId + ", bookName=" + bookName + ", username="
				+ username + ", price=" + price + "]";
	}
    
}