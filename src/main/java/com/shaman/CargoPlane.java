package com.shaman;

public class CargoPlane extends AerialVehicle implements Flight{
	private int carrying; //����������������, ��
	private static final String TYPEOFAV = "��������";
	

	public CargoPlane(String mf, String mod, int cs, float fc, float tc) {
		super(mf, mod, cs, fc, tc);
		// TODO Auto-generated constructor stub
	}
	public CargoPlane(String mf, String mod, int cs, float fc, float tc, int cr) {
		super(mf, mod, cs, fc, tc);
		this.carrying = cr;
	}
		
	public int getCarrying () {
		return  carrying;
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
		System.out.println("���� �������������. ��������");
	};
	//@Override
	public void alertMessage() {
		System.out.println("��������! ������ � ���� ��������������");
	};
	//@Override
	public void fallMessage(){
		System.out.println("�� ������! ���� ������ ��������!");
	};
	//@Override
	public void aircraftCapMessage(int height) {
		System.out.println("������, ������ ����� �� �� ������ " + height + " ������ ���������� � ����?");
	};
	
}
