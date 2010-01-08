package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.junit.client.GWTTestCase;

public abstract class PocGWTTestCase extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.googlecode.gwtmvc.poc.GwtMvcPoc";
	}

}
