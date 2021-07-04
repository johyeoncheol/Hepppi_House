package com.happyhouse.Favorite.vo;

public class favorite {
	private int no;
	private String ID;
	private String dong;
	private String AptName;
	private String dealAmount;
	private String area;
	private String floor;
	private String buildYear;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private double lat; //위도
	private double lng; //경도
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return ID;
	}
	public void setId(String id) {
		this.ID = id;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		AptName = aptName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public favorite() {}
	public favorite(int no, String id, String dong, String aptName, String dealAmount, String area, String floor,
			String buildYear, String dealYear, String dealMonth, String dealDay, double lat, double lng) {
		super();
		this.no = no;
		this.ID = id;
		this.dong = dong;
		AptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.floor = floor;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.lat = lat;
		this.lng = lng;
	}
	
	
}
