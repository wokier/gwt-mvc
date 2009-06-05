package com.googlecode.gwtmvc.poc.client.controller;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.gwtmvc.ControllerTestCase;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerMenu;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerMenu.PocMenuAction;
import com.googlecode.gwtmvc.poc.client.view.PocViewIntro;

public class PocControllerMenuTest extends ControllerTestCase {

	PocControllerMenu controller;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		controller = new PocControllerMenu();

		controller.pocViewMenu = mockView("pocViewMenuMock");
		controller.pocViewIntro = mockView("pocViewIntroMock");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInit() throws Exception {
		mockery.checking(new Expectations() {
			{

				one(controller.pocViewMenu).render();

			}
		});

		controller.init();
	}

	public void testShowHome() throws Exception {
		controller.showHomeView();

		// The root controller is initialised by the entryPoint
		assertFalse(controller.isInitialised());

	}

	@Test
	public void testCall() {
		mockery.checking(new Expectations() {
			{
				one(controller.pocViewMenu).render();
				one(controller.pocViewIntro).render();

			}
		});
		controller.call(new Event<String, PocMenuAction>(PocMenuAction.SHOW_INTRO));

		assertTrue(controller.isInitialised());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEvent() {
		assertEquals(PocMenuAction.SHOW_INTRO,controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("SHOW_INTRO")).getAction());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventCase() {
		assertEquals(PocMenuAction.SHOW_INTRO,controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("show_intro")).getAction());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventCase404() {
		assertNull(controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("unknown")));
	}

}
