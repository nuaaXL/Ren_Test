package com.nuaa.pop.entity;

public class Request {
	int num;//���
	String time;//����
	int flag; //��λ��1��      2ȡ           ʮλ��0 to do  1 doing  2 done  3 error
	          //��λ��1��������           2�ķ�����                           ǧλ��1˳��   2Բͨ   3��ͨ   4��ͨ   5����   6�ϴ�   7����
	int point;//֧������
	String publisher,//������ 
	       p_number, //������ѧ��
	       p_phone,//��������ϵ��ʽ
	       helper,//�ӵ���
	       h_number,//�ӵ���ѧ��
	       h_phone,//�ӵ�����ϵ��ʽ
	       user_loc,//������λ��
	       url;
    
	String content,//��������
           infor,//��ע
           r_nameORmessage, //1�ռ�������      2ȡ������
           r_locORpackage_loc,//1�ռ���λ��     2����λ��
           r_phoneORphone,  //1�ռ�����ϵ��ʽ         2ȡ���ֻ����� 
           nullORpackage_Id;//1��       2��ݺ�
    
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getPublisher() {
		if(publisher==null)
			publisher="��";
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getP_number() {
		return p_number;
	}
	public void setP_number(String p_number) {
		this.p_number = p_number;
	}
	public String getP_phone() {
		return p_phone;
	}
	public void setP_phone(String p_phone) {
		this.p_phone = p_phone;
	}
	public String getHelper() {
		if(helper==null)
			helper="��";
		return helper;
	}
	public void setHelper(String helper) {
		this.helper = helper;
	}
	public String getH_number() {
		return h_number;
	}
	public void setH_number(String h_number) {
		this.h_number = h_number;
	}
	public String getH_phone() {
		return h_phone;
	}
	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
	}
	public String getUser_loc() {
		if(user_loc==null)
			user_loc="��";
		return user_loc;
	}
	public void setUser_loc(String user_loc) {
		this.user_loc = user_loc;
	}
	public String getContent() {
		if(content==null)
			content="��";
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInfor() {
		if(infor==null)
			infor="��";
		return infor;
	}
	public void setInfor(String infor) {
		this.infor = infor;
	}
	public String getR_nameORmessage() {
		if(r_nameORmessage==null)
			r_nameORmessage="��";
		return r_nameORmessage;
	}
	public void setR_nameORmessage(String r_nameORmessage) {
		this.r_nameORmessage = r_nameORmessage;
	}
	public String getR_locORpackage_loc() {
		if(r_locORpackage_loc==null)
			r_locORpackage_loc="��";
		return r_locORpackage_loc;
	}
	public void setR_locORpackage_loc(String r_locORpackage_loc) {
		this.r_locORpackage_loc = r_locORpackage_loc;
	}
	public String getR_phoneORphone() {
		return r_phoneORphone;
	}
	public void setR_phoneORphone(String r_phoneORphone) {
		this.r_phoneORphone = r_phoneORphone;
	}
	public String getNullORpackage_Id() {
		return nullORpackage_Id;
	}
	public void setNullORpackage_Id(String nullORpackage_Id) {
		this.nullORpackage_Id = nullORpackage_Id;
	}
      
}