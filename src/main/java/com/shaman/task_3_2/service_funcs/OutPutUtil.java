package com.shaman.task_3_2.service_funcs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.shaman.task_3_2.classes.*;

public class OutPutUtil {

	public OutPutUtil() {
		
	}
	public static boolean outPutToFile (AirCompany comp, String filepath)  throws IOException{
		PrintWriter outFileStream = null;
		boolean result = false;
		try {
			outFileStream = new PrintWriter(new FileWriter(filepath));
			outFileStream.print(comp.toString(comp.getPlanes()));
			result = true;
		} finally {
			if (outFileStream!=null) outFileStream.close();
			return result;
		}
	}
	
}
