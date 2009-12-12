package com.googlecode.gwtmvc.poc.client.view.components;

import com.googlecode.gwtmvc.poc.client.PocGWTTestCase;

//add src/test/java to class path to run the test, as gwt could find the sources
public class PocIntegerLabelGwtTest extends PocGWTTestCase {

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
	
	public void testMask() throws Exception {
		new PocIntegerLabel().mask();
	}
	
	public void testUnmask() throws Exception {
		new PocIntegerLabel().unmask();
	}

}
