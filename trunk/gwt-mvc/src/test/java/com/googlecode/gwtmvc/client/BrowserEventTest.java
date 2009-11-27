package com.googlecode.gwtmvc.client;

import org.junit.Test;

import junit.framework.TestCase;

public class BrowserEventTest extends TestCase {

	@Test
	public void testBrowserEventActionOnly() {
		BrowserEvent browserEvent = new BrowserEvent("action");
		assertEquals("ACTION", browserEvent.getAction());
		assertTrue(browserEvent.getParams().isEmpty());
	}

	@Test
	public void testBrowserEventActionAnd1Param() {
		BrowserEvent browserEvent = new BrowserEvent("action?param1=value1");
		assertEquals("ACTION", browserEvent.getAction());
		assertEquals("value1", browserEvent.getParams().get("param1"));
	}

	@Test
	public void testBrowserEventActionAnd2Params() {
		BrowserEvent browserEvent = new BrowserEvent("action?param1=value1&param2=value2");
		assertEquals("ACTION", browserEvent.getAction());
		assertEquals("value1", browserEvent.getParams().get("param1"));
		assertEquals("value2", browserEvent.getParams().get("param2"));
	}

	@Test
	public void testBrowserEventNoParams() {
		BrowserEvent browserEvent = new BrowserEvent("action?");
		assertEquals("ACTION", browserEvent.getAction());
		assertTrue(browserEvent.getParams().isEmpty());
	}

	@Test
	public void testBrowserEventMalformedParamsNoEqual() {
		BrowserEvent browserEvent = new BrowserEvent("action?param1");
		assertEquals("ACTION", browserEvent.getAction());
		assertTrue(browserEvent.getParams().isEmpty());
	}

	@Test
	public void testBrowserEventMalformedFirstParam() {
		BrowserEvent browserEvent = new BrowserEvent("action?&param2=value2");
		assertEquals("ACTION", browserEvent.getAction());
		assertFalse(browserEvent.getParams().containsKey("param1"));
		assertEquals("value2", browserEvent.getParams().get("param2"));
	}

	@Test
	public void testBrowserEventMalformedSecondParam() {
		BrowserEvent browserEvent = new BrowserEvent("action?param1=value1&");
		assertEquals("ACTION", browserEvent.getAction());
		assertEquals("value1", browserEvent.getParams().get("param1"));
		assertFalse(browserEvent.getParams().containsKey("param2"));
	}

}
