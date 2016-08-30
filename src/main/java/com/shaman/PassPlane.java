package com.shaman;

public class PassPlane extends Plane {
	private int seating; //пассажировместимость, чел
	
	public PassPlane () {
		
	}
	public PassPlane(String mf, String mod, int cs, float fc, float tc) {
		super(mf, mod, cs, fc, tc);
		// TODO Auto-generated constructor stub
	}
	public PassPlane(String mf, String mod, int cs, float fc, float tc, int st) {
		super(mf, mod, cs, fc, tc);
		this.seating = st;
	}
	
	public int getSeating () {
		return  seating;
	}
	public void setSeating (int st) {
		this.seating = st;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("пассажирский ");
		builder.append(super.toString());
		builder.append(", пассажировместимость-");
		builder.append(this.seating);
		builder.append(" мест");
		return builder.toString();
	}
	
}
