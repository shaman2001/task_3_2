package com.shaman;

public class PassPlane extends AerialVehicle implements Flight{
	private int seating; //��������������������, ���
	private static final String TYPEOFAV = "������������";
	

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
	
	@Override
	public float getMaxrange() {
		return (this.getTcapacity()/this.getFcons()*1000);
	}
	@Override
	public String getTypeOfAE() {
		return TYPEOFAV;
	}
	
	//@Override
	public void flightMessage() {
		System.out.println("��������� ���������. ����������� �����. ��������");
	};
	//@Override
	public void alertMessage() {
		System.out.println("��������! ������� �������� �������� �����. ����������� �����");
	};
	//@Override
	public void fallMessage(){
		System.out.println("���� �����! �� ������! �������� ��� �����!");
	};
	//@Override
	public void aircraftCapMessage(int height) {
		System.out.println("��������� ���������. ��� ����� �������� �� ������ " + height + " ������");
	};	
	
}
