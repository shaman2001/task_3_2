package com.shaman;

public class CargoPlane extends Plane {
	private int carrying; //грузоподъемность, тн
	
	public CargoPlane () {
		
	}
	public CargoPlane(String mf, String mod, int cs, float fc, float tc) {
		super(mf, mod, cs, fc, tc);
		// TODO Auto-generated constructor stub
	}
	public CargoPlane(String mf, String mod, int cs, float fc, float tc, int cr) {
		super(mf, mod, cs, fc, tc);
		this.carrying = cr;
	}
	public int getCarrying () {
		return carrying;
	}
	public void setCarrying (int cr) {
		this.carrying = cr;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("грузовой ");
		builder.append(super.toString());
		builder.append(", грузоподъемность-");
		builder.append(this.carrying);
		builder.append(" тн.");
		return builder.toString();
	}
}
