package com.shaman.task_3_2.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.InputMismatchException;
//import java.io.BufferedReader;
import java.io.LineNumberReader;
import com.shaman.task_3_2.exceptions.*;
import com.shaman.task_3_2.service_funcs.*;



public class AirCompany {
	 final int MRANGE = 1;
	 final int FCONS = 2;
	 final int CSPEED = 3;
	 final int PASS = 1;
	 final int CARGO = 2;
	
	private String name; //название компании
	//int passplanesnum; //количество пассажирских самолетов
	//int cargoplanesnum; //количество грузовых самолетов
	private ArrayList<Plane> planes; //список самолетов компании
	
	public AirCompany () {
		this.name = "Default AirCompany";
		this.planes = new ArrayList<Plane>();
	}
	public AirCompany (String name) {
		this.name = name;
		this.planes = new ArrayList<Plane>();
	}
	public AirCompany (String  name, ArrayList<Plane> planes){
		this.name = name;
		this.planes = planes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Plane> getPlanes() {
		return this.planes;
	}
	public void setPlanes (ArrayList<Plane> planeslist) {
		planes = planeslist;
	}
	public void addPlane (Plane pl){
		this.planes.add(pl);
	}
	public boolean removePlane (Plane pl) {
		return this.planes.remove(pl);
	}
	public Plane removePlane (int plnum) {
		return this.planes.remove(plnum);
	}
	public ArrayList<Plane> filterPlanesByParam (int filterParam, float minValue, float maxValue) {
		ArrayList<Plane> tmpList = new ArrayList<Plane>();
		for (Plane pl: this.getPlanes()) {
			switch (filterParam) {
				case MRANGE: {
					if (pl.getMaxrange()>= minValue && pl.getMaxrange() <= maxValue) tmpList.add(pl);
					break;
				}
				case FCONS: {
					if (pl.getFcons()>= minValue && pl.getFcons() <= maxValue) tmpList.add(pl);
					break;
				}
				case CSPEED: {
					if (pl.getCspeed()>= minValue && pl.getCspeed() <= maxValue) tmpList.add(pl);
					break;
				}
			}
		}
		return tmpList;
	}
		
	public boolean loadPlanesFromFS (String filepath) {
		try {
			FileReader fr = new FileReader(filepath);
			Scanner scan = new Scanner(fr);
			Plane tmpPlane;
			int planetype;
			while (scan.hasNext()){
				planetype = scan.nextInt();
		    	switch (planetype) { 
					case 2: tmpPlane = new CargoPlane();
							break;
					case 1: tmpPlane = new PassPlane();
							break;
					default: tmpPlane = new CargoPlane(); 
							break;
		    	}
		    	tmpPlane.setMfact(scan.next());
		    	tmpPlane.setModel(scan.next());
		    	tmpPlane.setCspeed(scan.nextInt());
		    	tmpPlane.setFcons(scan.nextFloat());
		    	tmpPlane.setTcapacity(scan.nextFloat());
		    	switch (planetype) { 
					case 1: {
						((PassPlane)tmpPlane).setSeating(scan.nextInt());
						break;
					}
					case 2: {
						((CargoPlane)tmpPlane).setCarrying(scan.nextInt());
						break;
					}
		    	}
				planes.add(tmpPlane);
			}
			if (scan!=null)scan.close();
			if (fr!=null) fr.close();
			return true;
		} catch (IOException e) {
			System.out.println(e);
			return false;
	   	} 
	}
	public boolean loadPlanesFromFile (String filepath) throws IOException {
		LineNumberReader inputStream = null;
		try {
			inputStream = new LineNumberReader( new FileReader (filepath));
			int planetype;
			Plane tmpPlane;
			String line;
			while ((line = inputStream.readLine())!=null) {
				switch (planetype = Integer.valueOf(line.trim())) { 
					case 2: tmpPlane = new CargoPlane();
							break;
					case 1: tmpPlane = new PassPlane();
							break;
					default: throw new InvalidPlaneTypeException("Invalid Plane type in the input stream"); 
				}
				tmpPlane.setMfact(inputStream.readLine());
		    	tmpPlane.setModel(inputStream.readLine());
		    	tmpPlane.setCspeed(Integer.valueOf(inputStream.readLine().trim()));
		    	
		    	tmpPlane.setFcons(InputUtil.toFloat(inputStream.readLine().trim()));
		    	tmpPlane.setTcapacity(InputUtil.toFloat(inputStream.readLine().trim()));
		    	switch (planetype) { 
					case 1: {
						((PassPlane)tmpPlane).setSeating(Integer.valueOf(inputStream.readLine().trim()));
						break;
					}
					case 2: {
						((CargoPlane)tmpPlane).setCarrying(Integer.valueOf(inputStream.readLine().trim()));
						break;
					}
		    	}
				planes.add(tmpPlane);
				//inputStream.getLineNumber();
			}
			return true;
		} catch (InvalidPlaneTypeException e) {
			System.err.println(e.getMessage() + " line " + inputStream.getLineNumber() + " in file " + filepath);
			return false;
		} catch (FileNotFoundException e) {
			System.err.println(e);
			return false;
		} catch (NumberFormatException e) {
			System.err.println(e + " line " + inputStream.getLineNumber() + " in file " + filepath);
			return false;
		} catch (InputMismatchException e) {
			System.err.println(e + " line " + inputStream.getLineNumber() + " in file " + filepath);
			return false;
		} catch (ParseException e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			if (inputStream != null) {
			inputStream.close();
		}
	}
		
		
		
	}
	/*public void outputPlanesToConsole(ArrayList<Plane> pl) {
		for (Plane pl: planes) {
			switch (outputData) {
				case PRINT_MRANGE: {
					System.out.printf("%s %s - максимальная дальность полета - %f.1 км", pl.getManufacturer(), pl.getModel(), pl.getMaxrange());
					break;
					//System.out.println(av.getManufacturer() + " " + av.getModel() + " - максимальная дальность полета - " + av.getMaxrange() + " км");
				}
				case PRINT_FCONS: {
					System.out.printf("%s %s - расход топлива - %f.1 тыс.л/1000 км", pl.getManufacturer(), pl.getModel(), pl.getFcons());
					break;
				}
				case PRINT_CSPEED: {
					System.out.printf("%s %s - крейсерская скорость - %f.1 км/ч", pl.getManufacturer(), pl.getModel(), pl.getFcons());
					break;
				}
			}
			
		}
	}*/
	public int getPassPlanesNum() {
		int i=0;
		for (Plane pl: planes) {
    		if (pl instanceof PassPlane) i++;
     	}
		return i;
	}
	public int getCargoPlanesNum() {
		int i=0;
		for (Plane pl: planes) {
    		if (pl instanceof CargoPlane) i++;
     	}
		return i;
	}
	public int getTotalSeating(){  //
		int cappass = 0;
		for (Plane pl: planes) {
    		if (pl instanceof PassPlane) {
    			cappass += ((PassPlane) pl).getSeating();
    		} 
    	}
		return cappass;
	}
	public int getTotalCarrying(){  //
		int capcargo = 0;
		for (Plane pl: planes) {
			if (pl instanceof CargoPlane) {
				capcargo += ((CargoPlane) pl).getCarrying();
			}
    	}
		return capcargo;
	}
	public void sortPlanesByMaxRange(){
		planes.sort(new Comparator<Plane>(){
			//@Override
			public int compare(Plane pl1, Plane pl2) {
    			return Float.compare(pl1.getMaxrange(), pl2.getMaxrange());
    		}
		});	
	}
	public void sortPlanesByFuelCons () {
		planes.sort(new Comparator<Plane>() {
			public int compare (Plane pl1, Plane pl2) {
				return Float.compare(pl1.getFcons(), pl2.getFcons());
			}
		});
	}
	public void sortPlanesByCruiseSpeed () {
		planes.sort(new Comparator<Plane>() {
			public int compare (Plane pl1, Plane pl2) {
				return Integer.compare(pl1.getCspeed(), pl2.getCspeed());
			}
		});
	}
	//@Override
	public String toString(ArrayList<Plane> list) {
		StringBuilder builder = new StringBuilder("AirCompany ");
		builder.append(this.getName());
		builder.append("\nСпиок самолетов:\n");
		int ii = 0;
		for (Plane pl: list) {
			ii++;
			builder.append(ii);
			builder.append(". ");
			builder.append(pl.toString());
			builder.append("\n");   
		}
		return builder.toString();
	}
	
	
}
