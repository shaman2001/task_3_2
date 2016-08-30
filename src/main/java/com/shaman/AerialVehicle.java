package com.shaman;

public abstract class AerialVehicle {
	
	protected String mfact; //производитель
	protected String model; //модель
	protected boolean flying; //летит?
	
	
	public AerialVehicle () {
		mfact = "default";
		model = "default";	
		flying = false;
	}
	public AerialVehicle (String mf, String mod) {
		mfact = mf;
		model = mod;
		flying = false;
		
	} 
	public String getManufacturer () {
		return  mfact;
	}
	public void setManufacturer(String mf) {
		this.mfact = mf;
	}
	public String getModel () {
		return  model;
	}
	public void setModel(String mod) {
		this.model = mod;
	}
	public boolean isFlying() {
		return flying;
	}
	public void fly() {
		if (!flying) flying = true; 
	}
	public void land() {
		if (flying) flying = false; 
	}

}
