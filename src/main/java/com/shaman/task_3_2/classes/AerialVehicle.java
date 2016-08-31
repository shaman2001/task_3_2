package com.shaman.task_3_2.classes;

public abstract class AerialVehicle {
	
	private String mfact; //производитель
	private String model; //модель
	private boolean flying; //летит?
	
	
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
	public String getMfact () {
		return  mfact;
	}
	public void setMfact(String mf) {
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
