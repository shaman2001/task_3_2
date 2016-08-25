package com.shaman;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

public class App 
{
    public static void main( String[] args ) {
    	int cappass=0;
    	int capcargo=0;
    	Scanner sc = new Scanner (System.in);
    	ArrayList<AerialVehicle> kolymaAL = new ArrayList<AerialVehicle>(); //создаем список самолетов
    	//пассажирские
    	kolymaAL.add (new PassPlane("Boeing", "737-700", 850, 4.3f, 26.02f, 149));
    	kolymaAL.add (new PassPlane("AirBus", "A320", 840, 4.46f, 23.86f, 180));
    	kolymaAL.add (new PassPlane("Boeing", "787-9", 910, 9.024f, 138.7f, 280));
    	kolymaAL.add (new PassPlane("Boeing", "757-300", 850, 6.781f, 43.4f, 279));
    	kolymaAL.add (new PassPlane("Ильюшин", "ИЛ-96-300", 900, 15.3f, 150.4f, 300));
    	kolymaAL.add (new PassPlane("Туполев", "Ту-154М", 850, 10.19f, 39.75f, 180));
    	kolymaAL.add (new PassPlane("Сухой", "SSJ-95LR", 925, 3.576f, 15.805f, 98));
    	kolymaAL.add (new PassPlane("AirBus", "A380", 925, 20.667f, 310.0f, 700));
    	kolymaAL.add (new PassPlane("Embraer", "E-195LR", 890, 4.07f, 16.25f, 118));
    	kolymaAL.add (new PassPlane("Bombardier", "CRJ-900LR", 830, 2.594f, 8.82f, 86));
    	//грузовые
    	kolymaAL.add (new CargoPlane("Ильюшин", "ИЛ-96-400Т", 830, 12.987f, 150.4f, 92));
    	kolymaAL.add (new CargoPlane("Антонов", "Ан-225 Мрия", 850, 24.35f, 375.0f, 250));
    	kolymaAL.add (new CargoPlane("AirBus", "A300-600ST", 750, 13.22f, 68.75f, 69));
    	kolymaAL.add (new CargoPlane("Hughes", "H-4 Hercules", 408, 9.406f, 52.996f, 59));
    	kolymaAL.add (new PassPlane("Boeing", "747 LCF Dreamlifter", 878, 25.53f, 199.15f, 183));
    	kolymaAL.add (new CargoPlane("Антонов", "Ан-22 Антей", 560, 24.42f, 127.62f, 105));
    	//считаем общую вместимость для пассажирских
    	for (AerialVehicle av: kolymaAL) {
    		//if (av.getTypeOfAE()== "Пассажирский") {
    		if (av instanceof PassPlane) {
    			cappass = cappass + ((PassPlane) av).getSeating();
    		} else { 
    			if (av instanceof CargoPlane) {
    				capcargo = capcargo + ((CargoPlane) av).getCarrying();
    			}
    		}
    	}
    	System.out.println("Общая вместимость пассажирских самолетов АК \"Колымские авиалинии\" \t" + cappass + " человек");
    	System.out.println("Общая вместимость грузовых самолетов АК \"Колымские авиалинии\" \t" + capcargo + " тонн");
    	System.out.println("Сортируем список самолетов по максимальной дальности");
    	Collections.sort(kolymaAL, new Comparator<AerialVehicle>() {
    		//@Override
    		public int compare(AerialVehicle av1, AerialVehicle av2) {
    			return Float.compare(av1.getMaxrange() , av2.getMaxrange() );
    		}
    	});
    	int counter = 0;
    	for (AerialVehicle av: kolymaAL) {
    		counter++;
    		System.out.println(counter + ". " + av.getManufacturer() + " " + av.getModel() + " - максимальная дальность полета - " + av.getMaxrange() + "км");
    	}
    	int ii=0;
    	System.out.println("Критерии поиска самолета:");
    	System.out.println("1. максимальная дальность");
    	System.out.println("2. расход топлива");
    	System.out.println("3. крейсерская скорость");
    	if (sc.hasNextInt()){ 
        	ii = sc.nextInt(); 
        } else {
        	System.out.println( "Вы ввели какую-то ерунду" ); //вывод сообщения об ошибке ввода
        	//sc.close();
        	return;
        }
    	switch (ii) {
     	case 1: float minL;
     			float maxL;
     			System.out.println("Введите минимальную величину в диапазоне (максимальная дальность, км)");
     			minL = readNumFromConsole(); 
     			System.out.println("Введите максимальную величину в диапазоне (максимальная дальность, км)");
     			maxL = readNumFromConsole(); 
     			for (AerialVehicle av: kolymaAL) {
     				if (av.getMaxrange()>= minL && av.getMaxrange()<= maxL ) {
     					System.out.println(av.getManufacturer() + " " + av.getModel() + " - максимальная дальность полета - " + av.getMaxrange() + " км");
     				}
     			}
    			break;
    	case 2:	float minC;
				float maxC;
     			System.out.println("Введите минимальную величину в диапазоне (расход топлива, тыс.л./1000км)");
     			minC = readNumFromConsole(); 
    			System.out.println("Введите максимальную величину в диапазоне (расход топлива, тыс.л./1000км)");
    			maxC = readNumFromConsole(); 
    			for (AerialVehicle av: kolymaAL) {
     				if (av.getFcons()>= minC && av.getFcons()<= maxC ) {
     					System.out.println(av.getManufacturer() + " " + av.getModel() + " - расход топлива - " + av.getFcons() + " тыс.л/1000 км");
     				}
     			}
    			break;
     	case 3:	float minS;
     			float maxS;
     			System.out.println("Введите минимальную величину в диапазоне (крейсерская скорость,  км/ч)");
     			minS = readNumFromConsole(); 
				System.out.println("Введите максимальную величину в диапазоне (крейсерская скоростьб км/ч)");
				maxS = readNumFromConsole(); 
				for (AerialVehicle av: kolymaAL) {
     				if (av.getCspeed()>= minS && av.getCspeed()<= maxS ) {
     					System.out.println(av.getManufacturer() + " " + av.getModel() + " -  крейсерская скорость - " + av.getCspeed() + " км/час");
     				}
     			}
				break;
    		
    	};
    	
    sc.close();
    sortRandomLists();
    }
    
    public static float readNumFromConsole() {
    	 	Scanner scan1 = new Scanner(System.in);
    	    String str = null;
    	    Pattern p = Pattern.compile("^\\d+(?:\\.\\d+)?$");
    	    Matcher m = null;
     	    do
    	    {
    	        str = scan1.nextLine();
    	        m = p.matcher(str);
    	    } while(!m.matches());
     	    //scan1.close();
    	    return Float.parseFloat(str);
    }
    
    public static String randstr (int n) {
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
    	for (int j = 0;j < 100000; j++ ) {
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
    
    }
    
}
