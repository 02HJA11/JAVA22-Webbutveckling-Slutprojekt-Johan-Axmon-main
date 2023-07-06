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
    
    private String cookieStr;
    

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
		
		public String getCookieStr() {
			 return cookieStr;
	
	}

	public void setCookieStr(String cookieStr) {
		this.cookieStr = cookieStr;
	}
	
	
	
	// Method that splits the cookie string values and puts the values in an arraylist and then returns the arraylist
	public List<String> cookieSplit() {
		String strSplit = this.cookieStr;
		 List <String> arrOfStr = new ArrayList<String>(Arrays.asList(strSplit.split(":")));
		 
		 return arrOfStr;
		 
	}
		
		
		
		
		
		
		
		
		
		
		

}
