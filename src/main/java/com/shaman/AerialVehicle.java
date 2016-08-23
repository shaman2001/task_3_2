package com.shaman;

public abstract class AerialVehicle {
	
	private String mfact; //производитель
	private String model; //модель
	private int cspeed; //крейсерская скорость, км/ч
	private float fuelcons; //расход топлива, тыс.л/1000км
	private float tcapacity; // емкость баков, тыс.л
	AerialVehicle (String mf, String mod, int cs, float fc, float tc) {
		mfact = mf;
		model = mod;
		cspeed = cs;
		fuelcons = fc;
		tcapacity = tc;
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
	
	public int getCspeed () {
		return  cspeed;
	}
	public float getFcons () {
		return  fuelcons;
	}
	public void setFcons (float fc) {
		this.fuelcons = fc;
	}
	public float getTcapacity () {
		return  tcapacity;
	}
	public void setTcapacity (float tc) {
		this.tcapacity = tc;
	}
	public abstract float getMaxrange () ; //дальность полета
	public abstract String getTypeOfAE (); //возвращает тип летательного средства	
	
}
