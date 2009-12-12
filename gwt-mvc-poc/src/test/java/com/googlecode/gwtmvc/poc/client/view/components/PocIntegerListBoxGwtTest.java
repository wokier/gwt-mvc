package com.googlecode.gwtmvc.poc.client.view.components;

import com.googlecode.gwtmvc.poc.client.PocGWTTestCase;

//add src/test/java to class path to run the test, as gwt could find the sources
public class PocIntegerListBoxGwtTest extends PocGWTTestCase {

	// Just a test to show that componants are 'GWTTestCase' testable

	public void testConstructor() throws Exception {
		PocIntegerListBox listBox = new PocIntegerListBox(5, 10);
		assertEquals(-1, listBox.getSelectedIndex());
	}

	public void testGetValueFromValue() {
		PocIntegerListBox listBox = new PocIntegerListBox(5, 10);
		listBox.setValue(5);
		assertEquals(0, listBox.getSelectedIndex());
		assertEquals(5, listBox.getIntegerValue().intValue());
	}

	public void testValidate() throws Exception {
		PocIntegerListBox listBox = new PocIntegerListBox(5, 10);
		listBox.setValue(5);
		assertTrue(listBox.validate());
	}

	public void testValidateMandatory() throws Exception {
		PocIntegerListBox listBox = new PocIntegerListBox(5, 10);
		assertFalse(listBox.validate());
	}

	public void testGetValues() throws Exception {
		PocIntegerListBox listBox = new PocIntegerListBox(5, 10);
		assertEquals(6, listBox.getValues().size());
	}

	public void testMask() throws Exception {
		new PocIntegerTextBox().mask();
	}

	public void testUnmask() throws Exception {
		new PocIntegerTextBox().unmask();
	}

}
