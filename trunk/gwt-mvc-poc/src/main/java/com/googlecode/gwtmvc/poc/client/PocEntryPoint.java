package com.googlecode.gwtmvc.poc.client;

import com.allen_sauer.gwt.log.client.Log;
import com.googlecode.gwtmvc.client.MvcEntryPoint;


public class PocEntryPoint extends MvcEntryPoint {

	public PocEntryPoint() {
		super(new PocControllerMenu());
	}
	
}
