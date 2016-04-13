package com.onlinetechvision.user;

public class UserBIS {
	
	private int id;
    private String name;
    private String otherData;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOtherData() {
		return otherData;
	}
	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}
	public UserBIS(int id, String name, String otherData) {
		super();
		this.id = id;
		this.name = name;
		this.otherData = otherData;
	}
	@Override
	public String toString() {
		return "UserBIS [id=" + id + ", name=" + name + ", otherData=" + otherData + "]";
	}
	
	
    
}
