package CameraRentalApp;

import java.util.*;

public class cameraDetails implements Comparable<cameraDetails>{
	
	private int camId;
	private String brand;
	private String model;
	private double rent;
	private String status;
	
	public int getCamId() {
		return camId;
	}
	public void setCamId(int camId) {
		this.camId = camId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public cameraDetails(int camId, String brand, String model, double rent, String status) {
		this.camId = camId;
		this.brand = brand;
		this.model = model;
		this.rent = rent;
		this.status = status;
	}
	public cameraDetails() {
		super();
	}
	
	@Override
	public int compareTo(cameraDetails o) {
		if (this.getCamId() > o.getCamId())
		return 1;
		else if (this.getCamId() == o.getCamId())
		return 0;
		else 
		return -1;
	}
	
	
	
}
	

