package com.xja.ssm.common;

public class JsonBean {
	private int code;//-1为有。0为无，-999为系统异常
	
	private String msg;//返回的消息
	 
	private Object data;//返回的数据

	@Override
	public String toString() {
		return "JsonBean [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

	public JsonBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonBean(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
