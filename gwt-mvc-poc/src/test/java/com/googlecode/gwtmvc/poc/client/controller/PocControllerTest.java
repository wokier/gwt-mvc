package com.googlecode.gwtmvc.poc.client.controller;

import java.awt.Color;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.gwtmvc.ControllerTestCase;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.UnavailableActionException;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerChild.ChildAction;
import com.googlecode.gwtmvc.poc.client.model.PocModel;

public class PocControllerTest extends ControllerTestCase {

	PocController controller;
	PocControllerChild childControllerMock;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		childControllerMock = mockChildController(PocControllerChild.class);
		controller = new PocController(childControllerMock);

		controller.modelA = mockModel(PocModel.class, "modelAMock");
		controller.modelB = mockModel(PocModel.class, "modelBMock");

		controller.pocViewNumeric = mockView("pocViewNumericMock");
		controller.pocViewNumericB = mockView("pocViewNumericBMock");
		controller.pocViewGraphical = mockView("pocViewGraphicalMock");

		controller.pocViewNumericWithMasker = mockView("pocViewNumericWithMaskerMock");
		controller.pocViewNumericWithMaskable = mockView("pocViewNumericWithMaskableMock");

		controller.content = mockDomPlacer("content");

	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCallSHOW_SIMPLE_1() {
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();

				oneOf(controller.modelB).init();

				// oneOf(controller.pocViewNumeric).render();
				oneOf(controller.content).clearAndAdd(controller.pocViewNumeric);
			}
		});
		controller.call(new Event<String, PocAction>(PocAction.SHOW_SIMPLE_1));

		assertTrue(controller.isInitialised());

		mockery.assertIsSatisfied();
	}

	@Test
	public void testCallSHOW_COMPLEX_2() {
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				// oneOf(controller.pocViewNumeric).render();
				oneOf(controller.content).clearAndAdd(controller.pocViewNumeric);
				// oneOf(controller.pocViewNumericB).render();
				oneOf(controller.content).add(controller.pocViewNumericB);
				// oneOf(controller.pocViewGraphical).render();
				oneOf(controller.content).add(controller.pocViewGraphical);
			}
		});
		controller.call(new Event<String, PocAction>(PocAction.SHOW_COMPLEX_2));

		assertTrue(controller.isInitialised());

	}

	@Test
	public void testCallSHOW_MASKER() {
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				// oneOf(controller.pocViewNumericWithMasker).render();
				oneOf(controller.content).clearAndAdd(controller.pocViewNumericWithMasker);
			}
		});
		controller.call(new Event<String, PocAction>(PocAction.SHOW_MASKER));

		assertTrue(controller.isInitialised());

	}

	@Test
	public void testCallSHOW_MASKABLE() {
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				// oneOf(controller.pocViewNumericWithMaskable).render();
				oneOf(controller.content).clearAndAdd(controller.pocViewNumericWithMaskable);
			}
		});
		controller.call(new Event<String, PocAction>(PocAction.SHOW_MASKABLE));

		assertTrue(controller.isInitialised());

	}

	@Test
	public void testCallDO_PLUS_A() {
		final int currentValue = 1;
		final Event<Integer, PocAction> event = new Event<Integer, PocAction>(PocAction.DO_PLUS_A, currentValue);
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				oneOf(controller.modelA).plus(currentValue, event);
			}
		});
		controller.call(event);
	}

	@Test
	public void testCallDO_MINUS_A() {
		final int currentValue = 2;
		final Event<Integer, PocAction> event = new Event<Integer, PocAction>(PocAction.DO_MINUS_A, currentValue);
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				oneOf(controller.modelA).minus(currentValue, event);
			}
		});
		controller.call(event);
	}

	@Test
	public void testCallDO_PLUS_B() {
		final int currentValue = 3;
		final Event<Integer, PocAction> event = new Event<Integer, PocAction>(PocAction.DO_PLUS_B, currentValue);
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				oneOf(controller.modelB).plus(currentValue, event);
			}
		});
		controller.call(event);
	}

	@Test
	public void testCallDO_MINUS_B() {
		final int currentValue = 4;
		final Event<Integer, PocAction> event = new Event<Integer, PocAction>(PocAction.DO_MINUS_B, currentValue);
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				oneOf(controller.modelB).minus(currentValue, event);
			}
		});
		controller.call(event);
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventSHOW_SIMPLE_1() {
		assertEquals(PocAction.SHOW_SIMPLE_1, controller.tryConvertBrowserEventToControllerEvent(
				new BrowserEvent("SHOW_SIMPLE_1")).getAction());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventSHOW_SIMPLE_1_camelCase() {
		assertEquals(PocAction.SHOW_SIMPLE_1, controller.tryConvertBrowserEventToControllerEvent(
				new BrowserEvent("show_simple_1")).getAction());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventSHOW_COMPLEX_2() {
		assertEquals(PocAction.SHOW_COMPLEX_2, controller.tryConvertBrowserEventToControllerEvent(
				new BrowserEvent("SHOW_COMPLEX_2")).getAction());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTryConvertBrowserEventToControllerEvent404() {
		assertNull(controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("404")));
	}

	public void testCallSHOW_URLPARAMS() throws Exception {

		final String modelAurlParamValue = "5";
		controller.getUrlParamsMap().put("modelA", modelAurlParamValue);

		final Event event = new Event<Void, PocAction>(PocAction.SHOW_URLPARAMS);
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				// oneOf(controller.pocViewNumeric).render();
				oneOf(controller.content).clearAndAdd(controller.pocViewNumeric);

				oneOf(controller.modelA).update(Integer.valueOf(modelAurlParamValue), event);
			}
		});
		controller.call(event);

		assertTrue(controller.isInitialised());

		mockery.assertIsSatisfied();
	}

	public void testControllersHierarchy() throws Exception {

		final Event event = new Event(ChildAction.DO_REINIT_ALL);

		mockery.checking(new Expectations() {
			{
				oneOf(childControllerMock).couldHandleUserEvent(event);
				will(returnValue(true));

				oneOf(childControllerMock).handleUserEvent(event);

			}
		});
		controller.call(event);

		assertFalse(controller.isInitialised());

		mockery.assertIsSatisfied();

	}

	enum MyEnum {
		UNKNOWN
	};

	public void testControllersHierarchyUnavailableAction() throws Exception {

		final Event event = new Event(MyEnum.UNKNOWN);

		mockery.checking(new Expectations() {
			{
				oneOf(childControllerMock).couldHandleUserEvent(event);
				will(returnValue(false));
			}
		});
		try {
			controller.call(event);
			fail();
		} catch (UnavailableActionException e) {
			assertFalse(controller.isInitialised());

			mockery.assertIsSatisfied();
		}

	}
}
