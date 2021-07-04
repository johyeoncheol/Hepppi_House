package com.happyhouse.vo;

public class ApartInfo {
	private int no;
	private String dong;
	private String AptName;
	private String dealAmount;
	private String area;
	private String floor;
	private String buildYear;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String type;// 아파트매매, 아파트 전월세, 연립다세대 매매, 연립다세대 매매 
	private double lat; //위도
	private double lng; //경도
	private String totalCount; //총 갯수
	private int favorite;//찜 여부
	
	public ApartInfo() {}

	public int getfavorite() {
		return favorite;
	}

	public void setfavorite(int favorite) {
		this.favorite = favorite;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public ApartInfo(int no, String dong, String aptName, String dealAmount, String area, String floor,
			String buildYear, String dealYear, String dealMonth, String dealDay, String type, double lat, double lng,
			String totalCount, int favorite) {
		super();
		this.no = no;
		this.dong = dong;
		AptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.floor = floor;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.type = type;
		this.lat = lat;
		this.lng = lng;
		this.totalCount = totalCount;
		this.favorite = favorite;
	}
	
	
	
}	
