package com.shaman.task_3_2.classes;

import java.lang.Thread;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import com.shaman.task_3_2.service_funcs.*;
import com.shaman.task_3_2.exceptions.*;
//import com.shaman.AirCompany;
//import java.util.concurrent.TimeUnit;

public class App {
		
    public static void main( String[] args ) {
    	final int MRANGE = 1;
    	final int FCONS = 2;
    	final int CSPEED = 3;
    	//final int PASS = 1;
    	//final int CARGO = 2;
    	AirCompany kolymaAL = new AirCompany("АвиаКолыма");
     	/*//пассажирские
    	kolymaAL.addPlane (new PassPlane("Boeing", "737-700", 850, 4.3f, 26.02f, 149));
    	kolymaAL.addPlane (new PassPlane("AirBus", "A320", 840, 4.46f, 23.86f, 180));
    	kolymaAL.addPlane (new PassPlane("Boeing", "787-9", 910, 9.024f, 138.7f, 280));
    	kolymaAL.addPlane (new PassPlane("Boeing", "757-300", 850, 6.781f, 43.4f, 279));
    	kolymaAL.addPlane (new PassPlane("Ильюшин", "ИЛ-96-300", 900, 15.3f, 150.4f, 300));
    	kolymaAL.addPlane (new PassPlane("Туполев", "Ту-154М", 850, 10.19f, 39.75f, 180));
    	kolymaAL.addPlane (new PassPlane("Сухой", "SSJ-95LR", 925, 3.576f, 15.805f, 98));
    	kolymaAL.addPlane (new PassPlane("AirBus", "A380", 925, 20.667f, 310.0f, 700));
    	kolymaAL.addPlane (new PassPlane("Embraer", "E-195LR", 890, 4.07f, 16.25f, 118));
    	kolymaAL.addPlane (new PassPlane("Bombardier", "CRJ-900LR", 830, 2.594f, 8.82f, 86));
    	//грузовые
    	kolymaAL.addPlane (new CargoPlane("Ильюшин", "ИЛ-96-400Т", 830, 12.987f, 150.4f, 92));
    	kolymaAL.addPlane (new CargoPlane("Антонов", "Ан-225 Мрия", 850, 24.35f, 375.0f, 250));
    	kolymaAL.addPlane (new CargoPlane("AirBus", "A300-600ST", 750, 13.22f, 68.75f, 69));
    	kolymaAL.addPlane (new CargoPlane("Hughes", "H-4 Hercules", 408, 9.406f, 52.996f, 59));
    	kolymaAL.addPlane (new PassPlane("Boeing", "747 LCF Dreamlifter", 878, 25.53f, 199.15f, 183));
    	kolymaAL.addPlane (new CargoPlane("Антонов", "Ан-22 Антей", 560, 24.42f, 127.62f, 105));*/
    	//считаем общую вместимость для пассажирских
    	try {
	    	if (!kolymaAL.loadPlanesFromFile("files\\planes.txt")) {
	    		throw new LoadPlanesFromFileException("Loading planes from file error!");
	    	}
    	} catch (LoadPlanesFromFileException e) {
    		System.err.println(e.getMessage());
    		return;
    	} catch (IOException e) {
    		System.err.println(e.getMessage());
    		return;
    	}
    	System.out.println("Общая вместимость пассажирских самолетов АК \"Колымские авиалинии\" \t" + kolymaAL.getTotalSeating() + " человек");
    	System.out.println("Общая вместимость грузовых самолетов АК \"Колымские авиалинии\" \t" + kolymaAL.getTotalCarrying() + " тонн");
    	try {
	    	System.out.println("Сортируем список самолетов по крейсерской скорости");
	    	kolymaAL.sortPlanesByCruiseSpeed();
	    	System.out.println(kolymaAL.toString(kolymaAL.getPlanes()));
	    	Thread.sleep(1000);
	    	System.out.println("Сортируем список самолетов по дальности полета");
	    	kolymaAL.sortPlanesByMaxRange();
	    	System.out.println(kolymaAL.toString(kolymaAL.getPlanes()));
	    	Thread.sleep(1000);
	    	System.out.println("Сортируем список самолетов по расходу топлива на 1000 км");
	    	kolymaAL.sortPlanesByFuelCons();
	    	System.out.println(kolymaAL.toString(kolymaAL.getPlanes()));
	    	Thread.sleep(1000);
    	} catch (InterruptedException e) {
    		System.err.println(e);
    	}
    	System.out.println("Введите критерий поиска самолета:");
    	System.out.println("1. максимальная дальность");
    	System.out.println("2. расход топлива");
    	System.out.println("3. крейсерская скорость");
    	Scanner sc = new Scanner (System.in);
    	int ii=0;
    	ii = (int)InputUtil.readNumFromConsole(sc);
    	try {
	    	switch (ii) {
		     	case 1: float minL;
		     			float maxL;
		     			System.out.println("Введите минимальную величину в диапазоне (максимальная дальность, км)");
		     			minL = InputUtil.readNumFromConsole(sc);
		     			System.out.println("Введите максимальную величину в диапазоне (максимальная дальность, км)");
		     			maxL = InputUtil.readNumFromConsole(sc);
		      			System.out.println(kolymaAL.toString(kolymaAL.filterPlanesByParam(MRANGE, minL, maxL)));
		    			break;
		    	case 2:	float minC;
						float maxC;
		     			System.out.println("Введите минимальную величину в диапазоне (расход топлива, тыс.л./1000км)");
		     			minC = InputUtil.readNumFromConsole(sc);
		    			System.out.println("Введите максимальную величину в диапазоне (расход топлива, тыс.л./1000км)");
		    			maxC = InputUtil.readNumFromConsole(sc);
		    			System.out.println(kolymaAL.toString(kolymaAL.filterPlanesByParam(FCONS, minC, maxC)));
		    			break;
		     	case 3:	float minS;
		     			float maxS;
		     			System.out.println("Введите минимальную величину в диапазоне (крейсерская скорость,  км/ч)");
		     			minS = InputUtil.readNumFromConsole(sc);
						System.out.println("Введите максимальную величину в диапазоне (крейсерская скоростьб км/ч)");
						maxS = InputUtil.readNumFromConsole(sc);
						System.out.println(kolymaAL.toString(kolymaAL.filterPlanesByParam(CSPEED, minS, maxS)));
						break;
		     	default: {
					throw new InvalidCaseSelectException("Не правильный выбор. ВВедите цифру от 1 до 3");
				}
    	
	    	}
    	} catch (InvalidCaseSelectException e) {
    		System.out.println(e);
    	}
	    System.out.println("Выполняем тестовый полет на случайном самолете");
	    Plane selectedPlane = kolymaAL.getPlanes().get((int)Math.round(Math.random()*kolymaAL.getPlanes().size()));
	    selectedPlane.takeoff("Москва", "Нью-Васюки", 5360);
	    selectedPlane.fly(11300);
	    selectedPlane.landing();
	    System.out.println("The game is over");
	    if (sc!=null) sc.close();
	    //Пишем в файл
	    if (kolymaAL.WriteACtoFile("files/kolyma.txt")) {
	    	System.out.println("Успешно");
	    } else {
	    	System.out.println("Не удалось записать джанные в файл");
	    }
	    //sortRandomLists();
    }
       
    //вторая часть задания+++++++++++<<<<<<<<<<<<*****************>>>>>>>>>>>>>>>>>++++++++++++++++
    
 /*   public static String randstr (int n) {
		String s ="";
		String abd ="abcdefghijklmnopqrstuvwxyz0123456789";
		int aL = abd.length();
			while (s.length() < n) {
				s+=abd.charAt((int)(Math.random() * aL));
			}
		return s;
	} 
    
    public static void sortRandomLists() {
    	class EObj {
    		String str1;
    		int int1;
    		EObj (String s, int i){
    			str1 = s;
    			int1 = i;
    		}
    	}
    	String tmpstr1, tmpstr2;
    	int tmpint1, tmpint2;
    	EObj eo11, eo22;
    	
    	ArrayList<EObj> alist = new ArrayList<EObj> ();
    	LinkedList<EObj> blist = new LinkedList<EObj>();
    	for (int j = 0;j < 10000; j++ ) {
    		//tmpstr=randstr(10);
    		//tmpint = (int)Math.random()*;
    		EObj tmpeobj = new EObj (randstr(10), (int)(Math.random()*20000));
    		alist.add(tmpeobj);	
    		blist.add(tmpeobj);
    	}
    	//записи для дальнейшего поиска после сортировки
    	tmpstr1=alist.get(1).str1 ;
    	tmpstr2=blist.getFirst().str1 ;
    	eo11=alist.get(1);
    	eo22=blist.getFirst();
    	System.out.println("");
    	
    	System.out.println("Сортируем ArrayList объемом " + alist.size() + " записей по строковому полю");
    	Long moment = System.currentTimeMillis();
    	Collections.sort(alist, new Comparator<EObj>() {
    		//@Override
    		public int compare(EObj eo1, EObj eo2) {
    			return eo1.str1.compareTo(eo2.str1);
    		}
    	});
    	moment = System.currentTimeMillis() - moment;
    	System.out.println("Время сортировки - " + moment + "сек*10-3");
    	
    	System.out.println("Сортируем LinkedList объемом " + blist.size() + " записей по строковому полю");
    	moment = System.currentTimeMillis();
    	Collections.sort(blist, new Comparator<EObj>() {
    		//@Override
    		public int compare(EObj eo1, EObj eo2) {
    			return eo1.str1.compareTo(eo2.str1);
    		}
    	});
    	moment = System.currentTimeMillis() - moment;
    	System.out.println("Время сортировки - " + moment + "сек*10-3");
    	
    	System.out.println("Сортируем ArrayList объемом " + alist.size() + " записей по целочисленному полю");
     	moment = System.currentTimeMillis();
    	Collections.sort(alist, new Comparator<EObj>() {
    		//@Override
    		public int compare(EObj eo1, EObj eo2) {
    			return Integer.compare(eo1.int1 , eo2.int1);
    		}
    	});
    	moment = System.currentTimeMillis() - moment;
    	System.out.println("Время сортировки - " + moment+ "сек*10-3");
    	
    	System.out.println("Сортируем LinkedList объемом " + blist.size() + " записей по целочисленному полю");
    	moment = System.currentTimeMillis();
    	Collections.sort(blist, new Comparator<EObj>() {
    		//@Override
    		public int compare(EObj eo1, EObj eo2) {
    			return Integer.compare(eo1.int1 , eo2.int1);
    		}
    	});
    	moment = System.currentTimeMillis() - moment;
    	System.out.println("Время сортировки - " + moment + "сек*10-3");
    	System.out.println("");
    	System.out.println("Выполняем добавление, поиск, удаление произвольного элемента в коллекции ArrayList");
    	moment = System.currentTimeMillis();
    	alist.add(new EObj("poiuytrewq", 189));
    	System.out.println("Индекс искомого элемента - " + alist.indexOf(eo11));
    	alist.remove(eo11);
    	System.out.println("Время выполнения операций - " + (System.currentTimeMillis() - moment) + "сек*10-3");
    	//TimeUnit.SECONDS.sleep(1);
    	System.out.println("");
    	System.out.println("Выполняем добавление, поиск, удаление произвольного элемента в коллекции LinkedList");
    	moment = System.currentTimeMillis();
    	blist.add(new EObj("poiuytrewq", 189));
    	System.out.println("Индекс искомого элемента - " + blist.indexOf(eo11));
    	blist.remove(eo11);
    	System.out.println("Время выполнения операций - " + (System.currentTimeMillis() - moment) + "сек*10-3");
    
    }*/
}
