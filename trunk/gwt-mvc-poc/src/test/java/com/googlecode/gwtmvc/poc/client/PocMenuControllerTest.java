package com.googlecode.gwtmvc.poc.client;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.gwtmvc.ControllerTestCase;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.poc.client.PocControllerMenu.PocMenuAction;

public class PocMenuControllerTest extends ControllerTestCase {

	PocControllerMenu controller;
	
	IView pocViewIntroMock;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		controller = new PocControllerMenu();
	
		pocViewIntroMock = mockery.mock(IView.class);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testHandleUserEvent() {
		mockery.checking(new Expectations(){{
			one(pocViewIntroMock).getKey();
			will(returnValue(PocViewIntro.KEY));
			
		}});
		controller.addView(pocViewIntroMock);
		controller.handleEvent(new Event<String, PocMenuAction>(PocMenuAction.SHOW_INTRO));
	}

	@Test
	public void testTryConvertBrowserEventToControllerEvent() {
		controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("SHOW_INTRO"));
	}
	
	@Test
	public void testTryConvertBrowserEventToControllerEventCase() {
		controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("show_intro"));
	}
	
	@Test
	public void testTryConvertBrowserEventToControllerEventCase404() {
		try{
			controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("unknown"));
			fail();
		}catch (IllegalArgumentException e) {
			// success
		}
	}

}
