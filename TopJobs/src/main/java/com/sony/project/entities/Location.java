package com.sony.project.entities;

public class Location {

	private int locationId;
	private String streetAdddress;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	public int getLocationId() {
		return locationId;
	}
	
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	public String getStreetAdddress() {
		return streetAdddress;
	}
	public void setStreetAdddress(String streetAdddress) {
		this.streetAdddress = streetAdddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
