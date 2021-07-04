package com.happyhouse.vo;

public class Environment {
	private String WRKP_NM; //이름
	private String DRT_INSP_YMD; //점검일
	private String WRKP_ADDR; //주소
	
	public String getWRKP_NM() {
		return WRKP_NM;
	}
	public void setWRKP_NM(String wRKP_NM) {
		WRKP_NM = wRKP_NM;
	}
	public String getDRT_INSP_YMD() {
		return DRT_INSP_YMD;
	}
	public void setDRT_INSP_YMD(String dRT_INSP_YMD) {
		DRT_INSP_YMD = dRT_INSP_YMD;
	}
	public String getWRKP_ADDR() {
		return WRKP_ADDR;
	}
	public void setWRKP_ADDR(String wRKP_ADDR) {
		WRKP_ADDR = wRKP_ADDR;
	}
	
	public Environment(String wRKP_NM, String dRT_INSP_YMD, String wRKP_ADDR) {
		super();
		WRKP_NM = wRKP_NM;
		DRT_INSP_YMD = dRT_INSP_YMD;
		WRKP_ADDR = wRKP_ADDR;
	}
	
	
	
	
}
