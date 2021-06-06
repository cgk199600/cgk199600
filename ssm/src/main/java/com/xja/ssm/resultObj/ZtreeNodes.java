package com.xja.ssm.resultObj;

public class ZtreeNodes {
	private Integer id;
	private String title;
	private Integer pid;
	private boolean checked;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public boolean isChecked() {
		return checked;
	}
	//判断是否是选中的状态
	public void setChecked(String checked) {
		if(checked.equals("0")) {
			this.checked=true;
		}else {
			this.checked=false;
		}
	}
	

}
