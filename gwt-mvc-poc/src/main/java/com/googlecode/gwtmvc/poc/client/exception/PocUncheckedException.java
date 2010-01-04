package com.googlecode.gwtmvc.poc.client.exception;

public class PocUncheckedException extends RuntimeException {

	public PocUncheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PocUncheckedException(String message) {
		super(message);
	}

}
