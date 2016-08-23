package com.shaman;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
    	int cappass=0;
    	int capcargo=0;
    	Scanner sc = new Scanner (System.in);
    	ArrayList<AerialVehicle> kolymaAL = new ArrayList<AerialVehicle>(); //������� ������ ��������� ��������� ���������
    	//������������
    	kolymaAL.add (new PassPlane("Boeing", "737-700", 850, 4.3f, 26.02f, 149));
    	kolymaAL.add (new PassPlane("AirBus", "A320", 840, 4.46f, 23.86f, 180));
    	kolymaAL.add (new PassPlane("Boeing", "787-9", 910, 9.024f, 138.7f, 280));
    	kolymaAL.add (new PassPlane("Boeing", "757-300", 850, 6.781f, 43.4f, 279));
    	kolymaAL.add (new PassPlane("�������", "��-96-300", 900, 15.3f, 150.4f, 300));
    	kolymaAL.add (new PassPlane("�������", "��-154�", 850, 10.19f, 39.75f, 180));
    	kolymaAL.add (new PassPlane("�����", "SSJ-95LR", 925, 3.576f, 15.805f, 98));
    	kolymaAL.add (new PassPlane("AirBus", "A380", 925, 20.667f, 310.0f, 700));
    	kolymaAL.add (new PassPlane("Embraer", "E-195LR", 890, 4.07f, 16.25f, 118));
    	kolymaAL.add (new PassPlane("Bombardier", "CRJ-900LR", 830, 2.594f, 8.82f, 86));
    	//��������
    	kolymaAL.add (new CargoPlane("�������", "��-96-400�", 830, 12.987f, 150.4f, 92));
    	kolymaAL.add (new CargoPlane("�������", "��-225 ����", 850, 24.35f, 375.0f, 250));
    	kolymaAL.add (new CargoPlane("AirBus", "A300-600ST", 750, 13.22f, 68.75f, 69));
    	kolymaAL.add (new CargoPlane("Hughes", "H-4 Hercules", 408, 9.406f, 52.996f, 59));
    	kolymaAL.add (new PassPlane("Boeing", "747 LCF Dreamlifter", 878, 25.53f, 199.15f, 183));
    	kolymaAL.add (new CargoPlane("�������", "��-22 �����", 560, 24.42f, 127.62f, 105));
    	//������� ����� ����������� ��� ������������
    	for (AerialVehicle av: kolymaAL) {
    		//if (av.getTypeOfAE()== "������������") {
    		if (av instanceof PassPlane) {
    			//PassPlane pp = (PassPlane) av;
    			//cappass = cappass + pp.getSeating();
    			cappass = cappass + ((PassPlane) av).getSeating();
    		} else { 
    			if (av instanceof CargoPlane) {
    				capcargo = capcargo + ((CargoPlane) av).getCarrying();
    			}
    		}
    	}
    	System.out.println("����� ����������� ������������ ��������� �� \"��������� ���������\" \t" + cappass + " �������");
    	System.out.println("����� ����������� �������� ��������� �� \"��������� ���������\" \t" + capcargo + " ����");
    	Collections.sort(kolymaAL, new Comparator<AerialVehicle>() {
    		//@Override
    		public int compare(AerialVehicle av1, AerialVehicle av2) {
    			return Float.compare(av1.getMaxrange() , av2.getMaxrange() );
    		}
    	});
    	int counter = 0;
    	for (AerialVehicle av: kolymaAL) {
    		counter++;
    		System.out.println(counter + ". " + av.getManufacturer() + " " + av.getModel() + " - ������������ ��������� ������ - " + av.getMaxrange() + "��");
    	}
    	int ii=0;
    	System.out.println("�������� ������ ��������:");
    	System.out.println("1. ������������ ���������");
    	System.out.println("2. ������ �������");
    	System.out.println("3. ����������� ��������");
    	if (sc.hasNextInt()){ 
        	ii = sc.nextInt(); 
        } else {
        	System.out.println( "�� ����� �����-�� ������" ); //����� ��������� �� ������ �����
        	//sc.close();
        	return;
        }
    	switch (ii) {
     	case 1: float minL;
     			float maxL;
     			System.out.println("������� ����������� �������� � ��������� (������������ ���������, ��)");
     			minL = readNumFromConsole(); 
     			System.out.println("������� ������������ �������� � ��������� (������������ ���������, ��)");
     			maxL = readNumFromConsole(); 
     			for (AerialVehicle av: kolymaAL) {
     				if (av.getMaxrange()>= minL && av.getMaxrange()<= maxL ) {
     					System.out.println(av.getManufacturer() + " " + av.getModel() + " - ������������ ��������� ������ - " + av.getMaxrange() + " ��");
     				}
     			}
    			break;
    	case 2:	float minC;
				float maxC;
     			System.out.println("������� ����������� �������� � ��������� (������ �������, ���.�./1000��)");
     			minC = readNumFromConsole(); 
    			System.out.println("������� ������������ �������� � ��������� (������ �������, ���.�./1000��)");
    			maxC = readNumFromConsole(); 
    			for (AerialVehicle av: kolymaAL) {
     				if (av.getFcons()>= minC && av.getFcons()<= maxC ) {
     					System.out.println(av.getManufacturer() + " " + av.getModel() + " - ������ ������� - " + av.getFcons() + " ���.�/1000 ��");
     				}
     			}
    			break;
     	case 3:	float minS;
     			float maxS;
     			System.out.println("������� ����������� �������� � ��������� (����������� ��������,  ��/�)");
     			minS = readNumFromConsole(); 
				System.out.println("������� ������������ �������� � ��������� (����������� ��������� ��/�)");
				maxS = readNumFromConsole(); 
				for (AerialVehicle av: kolymaAL) {
     				if (av.getCspeed()>= minS && av.getCspeed()<= maxS ) {
     					System.out.println(av.getManufacturer() + " " + av.getModel() + " -  ����������� �������� - " + av.getCspeed() + " ��/���");
     				}
     			}
				break;
    		
    	};
    	
    sc.close();
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
   
}
