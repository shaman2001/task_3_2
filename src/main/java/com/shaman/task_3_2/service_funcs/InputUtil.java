package com.shaman.task_3_2.service_funcs;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtil {

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
