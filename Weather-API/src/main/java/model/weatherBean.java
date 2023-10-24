package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class weatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;
	
    private String sunRiseStr;
    
    private String sunSetStr;
    
    private String windStr;


	public String getSunSetStr() {
		return sunSetStr;
	}

	public void setSunSetStr(String sunSetStr) {
		this.sunSetStr = sunSetStr;
	}

	public String getWindStr() {
		return windStr;
	}

	public void setWindStr(String windStr) {
		this.windStr = windStr;
	}

	public String getSunRiseStr() {
		return sunRiseStr;
	}

	public void setSunRiseStr(String sunRiseStr) {
		this.sunRiseStr = sunRiseStr;
	}

	public weatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}
		public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}
}
