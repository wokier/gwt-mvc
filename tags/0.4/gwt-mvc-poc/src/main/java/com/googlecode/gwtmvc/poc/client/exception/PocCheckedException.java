package com.googlecode.gwtmvc.poc.client.exception;

import java.io.Serializable;

public class PocCheckedException extends Exception implements Serializable {

	public PocCheckedException() {
		super();
	}
	
	public PocCheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PocCheckedException(String message) {
		super(message);
	}

}
