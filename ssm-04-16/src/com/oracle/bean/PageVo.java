package com.oracle.bean;

import java.util.List;

import com.oracle.pojo.Book;



public class PageVo {
	private Integer pageIndex;
	private Integer pageCount;
	private Integer TotalPage;
	private Integer allPage;
	private List<Book> list;
	
	public Integer getallPage() {
		return allPage;
	}
	public void setallPage(Integer allPage) {
		this.allPage = allPage;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotalPage() {
		return TotalPage;
	}
	public void setTotalPage(Integer totalPage) {
		TotalPage = totalPage;
	}
	
	
	
	public PageVo(Integer pageIndex, Integer pageCount, Integer totalPage, Integer allPage, List<Book> list) {
		super();
		this.pageIndex = pageIndex;
		this.pageCount = pageCount;
		TotalPage = totalPage;
		this.allPage = allPage;
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageVo [pageIndex=" + pageIndex + ", pageCount=" + pageCount + ", TotalPage=" + TotalPage
				+ ", allPage=" + allPage + ", list=" + list + "]";
	}
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	public PageVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
