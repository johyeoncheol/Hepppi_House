package com.happyhouse.vo;

public class Member {
	private String id;
	private String pass;
	private String name;
	private String address;
	private String admCd;
	private String rnMgtSn;
	private String udrtYn;
	private String buldMnnm;
	private String buldSlno;
	private double lng;
	private double lat;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdmCd() {
		return admCd;
	}
	public void setAdmCd(String admCd) {
		this.admCd = admCd;
	}
	public String getRnMgtSn() {
		return rnMgtSn;
	}
	public void setRnMgtSn(String rnMgtSn) {
		this.rnMgtSn = rnMgtSn;
	}
	public String getUdrtYn() {
		return udrtYn;
	}
	public void setUdrtYn(String udrtYn) {
		this.udrtYn = udrtYn;
	}
	public String getBuldMnnm() {
		return buldMnnm;
	}
	public void setBuldMnnm(String buldMnnm) {
		this.buldMnnm = buldMnnm;
	}
	public String getBuldSlno() {
		return buldSlno;
	}
	public void setBuldSlno(String buldSlno) {
		this.buldSlno = buldSlno;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public Member() {}
	
	public Member(String id, String pass, String name, String address, String admCd, String rnMgtSn, String udrtYn,
			String buldMnnm, String buldSlno, double lng, double lat) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.admCd = admCd;
		this.rnMgtSn = rnMgtSn;
		this.udrtYn = udrtYn;
		this.buldMnnm = buldMnnm;
		this.buldSlno = buldSlno;
		this.lng = lng;
		this.lat = lat;
	}
	
	
	
	


}
