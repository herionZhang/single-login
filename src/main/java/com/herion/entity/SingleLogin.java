package com.herion.entity;

import javax.servlet.http.HttpSession;

public class SingleLogin {
	private String name;
	private long type;
	private HttpSession session;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	@Override
	public String toString() {
		return "SingleLogin [name=" + name + ", type=" + type + ", session="
				+ session + "]";
	}
	
	
}
