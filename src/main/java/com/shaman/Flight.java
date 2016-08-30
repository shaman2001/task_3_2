package com.shaman;

public interface Flight {
	
	public void takeoff(String dprt, String dst, float dist);
	public void fly(int height);
	public void refueling(float fuelQty);
	public void landing();
}
