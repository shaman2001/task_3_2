package com.shaman.task_3_2.exceptions;

import java.io.IOException;

public class InvalidPlaneTypeException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4523108554903188469L;

	public InvalidPlaneTypeException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidPlaneTypeException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidPlaneTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
		
	}

	public InvalidPlaneTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
