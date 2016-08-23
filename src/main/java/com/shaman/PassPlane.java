package com.shaman;

public class PassPlane extends AerialVehicle implements Flight{
	private int seating; //пассажировместимость, чел
	private static final String TYPEOFAV = "Пассажирский";
	

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
		System.out.println("Уважаемые пассажиры. Пристегните ремни. Взлетаем");
	};
	//@Override
	public void alertMessage() {
		System.out.println("Внимание! Самолет проходит грозовой фронт. Пристегните ремни");
	};
	//@Override
	public void fallMessage(){
		System.out.println("Всем капец! Мы падаем! Спасайся кто может!");
	};
	//@Override
	public void aircraftCapMessage(int height) {
		System.out.println("Уважаемые пассажиры. Наш полет проходит на высоте " + height + " метров");
	};	
	
}
