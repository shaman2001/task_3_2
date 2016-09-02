package com.shaman.task_3_2.service_funcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shaman.task_3_2.classes.CargoPlane;
import com.shaman.task_3_2.classes.PassPlane;
import com.shaman.task_3_2.classes.Plane;
import com.shaman.task_3_2.exceptions.InvalidPlaneTypeException;
import com.shaman.task_3_2.interfases.IDataLoader;

public class DBDataLoader  {
	private static final String dbURL = "jdbc:derby:E:\\vovan\\DerbyDB\\AirCompany";
    private static final String tableName = "Planes";
    // jdbc Connection
    private static Connection conn;
    private static Statement st1;
    //private static ArrayList<Plane> planesList; 

	public  DBDataLoader() {
		// TODO Auto-generated constructor stub
		//this.planesList = new ArrayList<Plane>();
	}
	public static ArrayList<Plane> readData() {
		ArrayList<Plane> planesList = new ArrayList<Plane>();
		//Connection conn;
		//Statement st1;
		createConnection();
		executeQuery();
		closeConnection();
		//planesList.clear();
		return planesList;
	}
	public static void writeData() {
		// TODO Auto-generated method stub
		System.out.println("Метод не реализован");
	}
	private static void createConnection() {
        try {
        	Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
        	conn = DriverManager.getConnection(dbURL); 
        } catch (ClassNotFoundException e) {
        	System.err.println(e);  
        } catch (InstantiationException e) {
        	System.err.println(e);  
        } catch (IllegalAccessException e) {
        	System.err.println(e);  
        } catch (SQLException e) {
        	System.err.println("Ошибка соединения с базой данных");  
        } 
    }
	
	private  static ArrayList<Planes> executeQuery() {
	    try {
	    	st1 = conn.createStatement();
	        ResultSet results = st1.executeQuery("select * from " + tableName);
	        Plane tmpPlane;
	        int planetype;
	        while(results.next()) {
	        	switch (planetype = results.getInt(1)) { 
					case 2: tmpPlane = new CargoPlane();
							break;
					case 1: tmpPlane = new PassPlane();
							break;
					default: throw new InvalidPlaneTypeException("Invalid Plane type in DataBase"); 
		        }
	        	tmpPlane.setMfact(results.getString(2));
	        	tmpPlane.setModel(results.getString(3));
	        	tmpPlane.setCspeed(results.getInt(4));
	    	
	        	tmpPlane.setFcons(results.getFloat(5));
	        	tmpPlane.setTcapacity(results.getFloat(6));
	        	switch (planetype) { 
					case 1: {
						((PassPlane)tmpPlane).setSeating(results.getInt(6));
						break;
					}
					case 2: {
						((CargoPlane)tmpPlane).setCarrying(results.getInt(6));
						break;
					}
	        	}
	        	planesList.add(tmpPlane);
	        }
	        results.close();
	        st1.close();
	    } catch (SQLException e) {
	        System.err.println(e + "Ошибка чтения данных");  
	    } catch (InvalidPlaneTypeException e) {
	        System.err.println(e + "Не верный тип самолета в базе");  
	    }
	}
	 private static void closeConnection() {
        try {
        	if (st1 != null)  st1.close();
	        if (conn != null) {
	        	DriverManager.getConnection(dbURL + ";shutdown=true");
	            conn.close();
	        }           
        } catch (SQLException e) {
        	System.err.println(e);     
	    }
	 }
}
