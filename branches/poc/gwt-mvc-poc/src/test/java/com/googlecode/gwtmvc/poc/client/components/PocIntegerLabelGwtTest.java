package com.googlecode.gwtmvc.poc.client.components;

import com.google.gwt.junit.client.GWTTestCase;

//add src/test/java to class path to run the test, as gwt could find the sources
public class PocIntegerLabelGwtTest extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.googlecode.gwtmvc.poc.GwtMvcPoc";
	}
	
	//Just a test to show that componants are 'GWTTestCase' testable
	public void testGetValueFromValue() {
		PocIntegerLabel label = new PocIntegerLabel();
		label.setValue(5);
		assertEquals(5, label.getValue().intValue());
	}
	
	public void testGetValueFromText() {
		PocIntegerLabel label = new PocIntegerLabel();
		label.setText("5");
		assertEquals(5, label.getValue().intValue());
	}

}
