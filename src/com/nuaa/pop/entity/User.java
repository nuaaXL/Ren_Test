package com.nuaa.pop.entity;

public class User {
	String userId,//ѧ�� 
	       name, //����
	       passwd, //����
	       phone, //��ϵ�绰
	       school,//ѧУ
			url;//ͷ���ַ

	int gender, //�Ա� 1��   2 Ů
	    point;//����
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		if(name==null)
			name="��";
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
