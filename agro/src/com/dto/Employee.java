package com.dto;

public class Employee {
	private String userName;
	private String customerName;
	private String password;
	private String farmerName;
	private String designation;
	private String mandal;
	private String district;
	private String location;
	private String product;
	private int quantity;
	private String farmerMobileNo;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Employee(String userName, String password, String designation) {
		this.userName = userName;
		this.password = password;
		this.designation = designation;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String farmerName,String location, String mandal, String district,String product,int quantity,String farmerMobileNo) {
		this.farmerName=farmerName;
		this.location=location;
		this.mandal=mandal;
		this.district=district;
		this.product = product;
		this.quantity=quantity;
		this.farmerMobileNo=farmerMobileNo;
	}
	
	public Employee(String customerName, String location, String mandal, String district,String product,int quantity) {
		this.customerName=customerName;
		this.location=location;
		this.mandal=mandal;
		this.district=district;
		this.product = product;
		this.quantity=quantity;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmerMobileNo() {
		return farmerMobileNo;
	}

	public void setFarmerMobileNo(String farmerMobileNo) {
		this.farmerMobileNo = farmerMobileNo;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", customerName=" + customerName + ", password=" + password
				+ ", farmerName=" + farmerName + ", designation=" + designation + ", mandal=" + mandal + ", district="
				+ district + ", location=" + location + ", product=" + product + ", quantity=" + quantity
				+ ", farmerMobileNo=" + farmerMobileNo + "]";
	}

	

	
}