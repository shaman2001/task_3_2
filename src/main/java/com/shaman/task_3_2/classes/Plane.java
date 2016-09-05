package com.shaman.task_3_2.classes;

import java.util.concurrent.TimeUnit;

import com.shaman.task_3_2.interfases.Flight;

public class Plane extends AerialVehicle implements Flight {
	private int cspeed; //крейсерская скорость, км/ч
	private float fuelcons; //расход топлива, тыс.л/1000км
	private float tcapacity; // емкость топливных баков, тыс.л.
	private float fuelquantity; //количество топлива в баках, тыс. л.
	public String depart; //откуда
	public String dest; //пункт назначения
	public float distance; //расстояние перелета
	
	public Plane () {
		
	}
	public Plane(String mf, String mod, int cs, float fc, float tc) {
		super (mf, mod);
		this.cspeed = cs;
		this.fuelcons = fc;
		this.tcapacity = tc;
		this.fuelquantity = (float) Math.random()* tc;
	}
	public int getCspeed () {
		return  cspeed;
	}
	public void setCspeed (int cs) {
		this.cspeed =  cs;
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
		this.fuelquantity = (float) Math.random()* tc;
	}
	public float getFquantity() {
		return fuelquantity;
	}
	public void setFquantity(float fq) {
		if (fq<=this.tcapacity) {
			this.fuelquantity = fq;
		} else {
			this.fuelquantity = this.tcapacity;
		}
	}
	 //возвращает максимальную дальность тыс.км.
	public float getMaxrange () {
		return (this.getTcapacity()/this.getFcons()*1000);
	}
	
	//@Override
	public void takeoff(String dprt, String dst, float dist) { //dist в в километрах
		if (this.isFlying()) {
			System.out.println("Самолет уже находится в воздухе");
			return;
		}
		try {
			System.out.println("Проверка систем самолета " + this.getMfact() + " " + this.getModel());
			if (this.getFquantity() < this.getFcons() * dist / 1000) {
				System.out.println("Топлива в баках не хватит для выполнение перелета в " + dst);
				Thread.sleep(1000);
				float fvol = (this.fuelcons * dist / 1000) - this.fuelquantity;
				System.out.printf("Необходимо заправить %.3f тыс. литров топлива \n", fvol);
				Thread.sleep(1000);
				refueling(fvol);
			} else if (this.tcapacity < this.fuelcons * dist / 1000) {
				System.out.println("Топлива в баках не хватит для выполнение перелета в " + dst + " без дозаправки");
				Thread.sleep(1000);
				System.out.println("Заправляем полные баки");
				this.refueling(this.tcapacity - this.fuelquantity);
			}
			//Thread.sleep(1000);
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Прогрев двигателей");
			Thread.sleep(2000);
			System.out.println("Взлет");
			Thread.sleep(3000);
			this.depart = dprt;
			this.dest = dst;
			this.distance = dist;
			this.fly();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fly(int height) {
		if (this instanceof PassPlane) {
			StringBuilder tmpstr = new StringBuilder("Уважаемые пассажиры. Лайнер ");
				tmpstr.append(this.getMfact());
				tmpstr.append(" ");
				tmpstr.append(this.getModel());
				tmpstr.append(" выполняет рейс по маршруту ");
				tmpstr.append(this.depart);
				tmpstr.append(" - ");
				tmpstr.append(this.dest);
				tmpstr.append(". Высота - ");
				tmpstr.append(Integer.toString(height));
				tmpstr.append(" метров. Время в пути - ");
				tmpstr.append(String.format("%.1f", this.distance/this.cspeed));
				tmpstr.append(" часов.");
			System.out.println(tmpstr.toString());
		} else if (this instanceof CargoPlane) {
			StringBuilder tmpstr = new StringBuilder("Диспетчерская, прием! Грузовой самолет ");
				tmpstr.append(this.getMfact());
				tmpstr.append(" ");
				tmpstr.append(this.getModel());
				tmpstr.append(" выполняет рейс по маршруту ");
				tmpstr.append(this.depart);
				tmpstr.append(" - ");
				tmpstr.append(this.dest);
				tmpstr.append(". Высота - ");
				tmpstr.append(Integer.toString(height));
				tmpstr.append(" метров. Время в пути - ");
				tmpstr.append(String.format("%.1f", this.distance/this.cspeed));
				tmpstr.append(" часов.");
			System.out.println(tmpstr.toString());
		}
	}
	public void refueling(float fuelQty) {
		if (!this.isFlying()) {
			if ((this.fuelquantity + fuelQty)<= this.tcapacity ) {
				this.fuelquantity+=fuelQty;
				System.out.println("Заправлено " + fuelQty + " тыс. литров топлива");
			} else {
				System.out.println("Полные баки. Заправлено " + (this.tcapacity - this.fuelquantity) + " тыс. литров топлива");
				this.fuelquantity = this.tcapacity;
			}
		} else {
			System.out.println("Самолет находится в воздухе. Для дозаправки необходимо произвести посадку");
		}
	}
	public void landing() {
		if (!this.isFlying()) {
			System.out.println("Самолет находится находится на земле");
			return;
		}
		try {
			Thread.sleep(3000);
			System.out.println("Начинаем снижение. Пристегните ремли!");
			Thread.sleep(3000);
			System.out.println("Наш самолет совершил посадку в аэтопорту города " + this.dest);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("самолет ");
		builder.append(this.getMfact());
		builder.append(" ");
		builder.append(this.getModel());
		builder.append(" кр.скорость-");
		builder.append(this.cspeed);
		builder.append(" км/ч, макс.дальность-");
		builder.append(getMaxrange());
		builder.append(" км");
		return builder.toString();
	}
}
