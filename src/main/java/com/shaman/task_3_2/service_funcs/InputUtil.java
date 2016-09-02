package com.shaman.task_3_2.service_funcs;

import java.text.NumberFormat;
import java.text.ParseException;
//import com.shaman.task_3_2.exceptions.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtil {

	 public static float readNumFromConsole(Scanner scan1) {
 	 	//Scanner scan1 = new Scanner(System.in);
 	    String str = null;
 	    Pattern p = Pattern.compile("^\\d+(?:\\.\\d+)?$");
 	    Matcher m = null;
 	    int counter = 0;
 	  	do {
 	  		if (counter != 0) {
 	  			System.out.println("Invalid numeric input");
 	  		}
 	  		str = scan1.nextLine();
 	  		m = p.matcher(str);
 	  		counter++;
	 	} while(!m.matches());
  	    //scan1.close();
 	    return Float.parseFloat(str);
	 }
	 
	 public static float toFloat (String str) throws ParseException  {
		 NumberFormat formatter = NumberFormat.getInstance();
		 //String s = formatter.format(1234.56);//On Rus s = "1 234,56"
		 return formatter.parse(str).floatValue();//d = 1234.56
	 }
	
	 
	 
}
