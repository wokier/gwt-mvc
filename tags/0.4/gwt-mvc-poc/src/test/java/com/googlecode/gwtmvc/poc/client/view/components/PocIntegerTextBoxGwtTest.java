package com.googlecode.gwtmvc.poc.client.view.components;

import com.googlecode.gwtmvc.poc.client.PocGWTTestCase;

//add src/test/java to class path to run the test, as gwt could find the sources
public class PocIntegerTextBoxGwtTest extends PocGWTTestCase {

	// Just a test to show that componants are 'GWTTestCase' testable
	public void testGetValueFromValue() {
		PocIntegerTextBox textBox = new PocIntegerTextBox();
		textBox.setValue(5);
		assertEquals(5, textBox.getIntegerValue().intValue());
	}

	public void testGetValueFromText() {
		PocIntegerTextBox textBox = new PocIntegerTextBox();
		textBox.setText("5");
		assertEquals(5, textBox.getIntegerValue().intValue());
	}

	public void testValidate() throws Exception {
		PocIntegerTextBox textBox = new PocIntegerTextBox();
		textBox.setText("5");
		assertTrue(textBox.validate());
	}

	public void testValidateNaN() throws Exception {
		PocIntegerTextBox textBox = new PocIntegerTextBox();
		textBox.setText("NaN");
		assertFalse(textBox.validate());
	}

	public void testMask() throws Exception {
		new PocIntegerTextBox().mask();
	}

	public void testUnmask() throws Exception {
		new PocIntegerTextBox().unmask();
	}

}
