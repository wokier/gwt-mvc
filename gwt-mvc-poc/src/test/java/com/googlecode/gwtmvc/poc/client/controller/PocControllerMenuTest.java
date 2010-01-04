package com.googlecode.gwtmvc.poc.client.controller;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.gwtmvc.ControllerTestCase;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerRoot.PocRootAction;

public class PocControllerMenuTest extends ControllerTestCase {

	PocControllerRoot controller;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		controller = new PocControllerRoot();

		controller.pocViewMenu = mockView("pocViewMenuMock");
		controller.pocViewIntro = mockView("pocViewIntroMock");
		
		controller.content = mockDomPlacer("content");
		controller.menu = mockDomPlacer("menu");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInit() throws Exception {
		mockery.checking(new Expectations() {
			{

//				oneOf(controller.pocViewMenu).render();
				oneOf(controller.menu).clearAndAdd(controller.pocViewMenu);

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
//				oneOf(controller.pocViewMenu).render();
				oneOf(controller.menu).clearAndAdd(controller.pocViewMenu);
//				oneOf(controller.pocViewIntro).render();
				oneOf(controller.content).clearAndAdd(controller.pocViewIntro);

			}
		});
		controller.call(new MvcEvent<String>(PocRootAction.SHOW_INTRO));

		assertTrue(controller.isInitialised());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEvent() {
		assertEquals(PocRootAction.SHOW_INTRO,controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("SHOW_INTRO")).getAction());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventCase() {
		assertEquals(PocRootAction.SHOW_INTRO,controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("show_intro")).getAction());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventCase404() {
		assertNull(controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("unknown")));
	}

	public void testGetRootController()throws Exception {
		PocControllerRoot rootController = new PocControllerRoot();
		for (Controller child : rootController.getChildren()) {
			assertEquals(rootController, child.getRootController());
		}
		assertEquals(rootController, rootController.getRootController());
	}
	
}
