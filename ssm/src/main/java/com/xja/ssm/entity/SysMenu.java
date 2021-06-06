package com.xja.ssm.entity;

public class SysMenu {
    private Integer id;

    private String title;

    private String icon;

    private String href;

    private String status;

    private Integer pid;
    
    private String pName;//pName为隐藏域中的只读框
    
    private String remark;

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getpName() {//应为json格式的值只调用get方法所以在get方法中赋值
    	if(pName==null) {
    		pName="当前是：一级菜单";	
    		}
		return pName;
	}

	public void setpName(String pName) {
		
		this.pName = pName;
	}

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
        this.title = title == null ? null : title.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}