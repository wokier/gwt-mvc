package com.googlecode.gwtmvc.client;

import junit.framework.TestCase;

public class BrowserEventTest extends TestCase {

	public void testBrowserEventActionOnly() {
		BrowserEvent browserEvent = new BrowserEvent("action");
		assertEquals("ACTION", browserEvent.getAction());
		assertTrue(browserEvent.getParams().isEmpty());
	}

	public void testBrowserEventActionAnd1Param() {
		BrowserEvent browserEvent = new BrowserEvent("action?param1=value1");
		assertEquals("ACTION", browserEvent.getAction());
		assertEquals("value1", browserEvent.getParams().get("param1"));
	}

	public void testBrowserEventActionAnd2Params() {
		BrowserEvent browserEvent = new BrowserEvent("action?param1=value1&param2=value2");
		assertEquals("ACTION", browserEvent.getAction());
		assertEquals("value1", browserEvent.getParams().get("param1"));
		assertEquals("value2", browserEvent.getParams().get("param2"));
	}

	public void testBrowserEventNoParams() {
		BrowserEvent browserEvent = new BrowserEvent("action?");
		assertEquals("ACTION", browserEvent.getAction());
		assertTrue(browserEvent.getParams().isEmpty());
	}

	public void testBrowserEventMalformedParamsNoEqual() {
		BrowserEvent browserEvent = new BrowserEvent("action?param1");
		assertEquals("ACTION", browserEvent.getAction());
		assertTrue(browserEvent.getParams().isEmpty());
	}

	public void testBrowserEventMalformedFirstParam() {
		BrowserEvent browserEvent = new BrowserEvent("action?&param2=value2");
		assertEquals("ACTION", browserEvent.getAction());
		assertFalse(browserEvent.getParams().containsKey("param1"));
		assertEquals("value2", browserEvent.getParams().get("param2"));
	}

	public void testBrowserEventMalformedSecondParam() {
		BrowserEvent browserEvent = new BrowserEvent("action?param1=value1&");
		assertEquals("ACTION", browserEvent.getAction());
		assertEquals("value1", browserEvent.getParams().get("param1"));
		assertFalse(browserEvent.getParams().containsKey("param2"));
	}

}
