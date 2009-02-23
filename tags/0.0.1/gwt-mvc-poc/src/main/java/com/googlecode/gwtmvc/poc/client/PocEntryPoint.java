package com.googlecode.gwtmvc.poc.client;

import com.googlecode.gwtmvc.client.MvcEntryPoint;


public class PocEntryPoint extends MvcEntryPoint {

	public PocEntryPoint() {
		super(new PocControllerMenu());
	}
	
}
