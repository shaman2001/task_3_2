package com.shaman.task_3_2.exceptions;

import java.io.IOException;

public class InvalidCaseSelectException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1791514473258093725L;

	public InvalidCaseSelectException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidCaseSelectException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidCaseSelectException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
		
	}

	public InvalidCaseSelectException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
