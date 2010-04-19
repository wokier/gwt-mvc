package com.googlecode.gwtmvc.poc.client.controller;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.gwtmvc.ControllerTestCase;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.exception.UnavailableActionException;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerChild.ChildAction;
import com.googlecode.gwtmvc.poc.client.model.PocModelProxy;

public class PocControllerTest extends ControllerTestCase {

	PocController controller;
	PocControllerChild childControllerMock;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		childControllerMock = mockChildController(PocControllerChild.class);
		controller = new PocController(childControllerMock);

		controller.modelA = mockModel(PocModelProxy.class, "modelAMock");
		controller.modelB = mockModel(PocModelProxy.class, "modelBMock");

		controller.pocViewNumeric = mockView("pocViewNumericMock");
		controller.pocViewNumericB = mockView("pocViewNumericBMock");
		controller.pocViewGraphical = mockView("pocViewGraphicalMock");

		controller.pocViewNumericWithMaskable = mockView("pocViewNumericWithMaskableMock");
		controller.pocViewNumericWithStyleMasker = mockView("pocViewNumericWithStyleMaskerMock");
		controller.pocViewNumericWithVisibleMasker = mockView("pocViewNumericWithVisibleMaskerMock");

		controller.pocViewException =mockView("pocViewExceptionMock");
		
		controller.pocViewUIBinder = mockView("pocViewUIBinder");
		
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
		controller.call(new MvcEvent<String>(PocAction.SHOW_SIMPLE));

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
		controller.call(new MvcEvent<String>(PocAction.SHOW_COMPLEX));

		assertTrue(controller.isInitialised());

	}

	@Test
	public void testCallSHOW_STYLE_MASKER() {
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				oneOf(controller.content).clearAndAdd(controller.pocViewNumericWithStyleMasker);
			}
		});
		controller.call(new MvcEvent<String>(PocAction.SHOW_STYLE_MASKER));

		assertTrue(controller.isInitialised());

	}
	
	@Test
	public void testCallSHOW_VISIBLE_MASKER() {
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();
				oneOf(controller.modelB).init();

				oneOf(controller.content).clearAndAdd(controller.pocViewNumericWithVisibleMasker);
			}
		});
		controller.call(new MvcEvent<String>(PocAction.SHOW_VISIBLE_MASKER));

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
		controller.call(new MvcEvent<String>(PocAction.SHOW_MASKABLE));

		assertTrue(controller.isInitialised());

	}

	@Test
	public void testCallDO_PLUS_A() {
		final int currentValue = 1;
		final MvcEvent<Integer> event = new MvcEvent<Integer>(PocAction.DO_PLUS_A, currentValue);
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
		final MvcEvent<Integer> event = new MvcEvent<Integer>(PocAction.DO_MINUS_A, currentValue);
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
		final MvcEvent<Integer> event = new MvcEvent<Integer>(PocAction.DO_PLUS_B, currentValue);
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
		final MvcEvent<Integer> event = new MvcEvent<Integer>(PocAction.DO_MINUS_B, currentValue);
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
	public void testTryConvertBrowserEventToControllerEventSHOW_SIMPLE() {
		assertEquals(PocAction.SHOW_SIMPLE, controller.tryConvertBrowserEventToControllerEvent(
				new BrowserEvent("SHOW_SIMPLE")).getAction());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventSHOW_SIMPLE_camelCase() {
		assertEquals(PocAction.SHOW_SIMPLE, controller.tryConvertBrowserEventToControllerEvent(
				new BrowserEvent("show_simple")).getAction());
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventSHOW_COMPLEX() {
		assertEquals(PocAction.SHOW_COMPLEX, controller.tryConvertBrowserEventToControllerEvent(
				new BrowserEvent("SHOW_COMPLEX")).getAction());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTryConvertBrowserEventToControllerEvent404() {
		assertNull(controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("404")));
	}

	public void testCallSHOW_URLPARAMS() throws Exception {

		final String modelAurlParamValue = "5";
		controller.getUrlParamsMap().put("modelA", modelAurlParamValue);

		final MvcEvent event = new MvcEvent<Void>(PocAction.SHOW_URLPARAMS);
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

		final MvcEvent event = new MvcEvent(ChildAction.DO_REINIT_ALL);

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

		final MvcEvent event = new MvcEvent(MyEnum.UNKNOWN);

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
