package com.googlecode.gwtmvc.poc.client;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.gwtmvc.ControllerTestCase;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;

public class PocControllerTest extends ControllerTestCase {

	PocController controller;
	
	IView numericViewAmock;
	IView numericViewBmock;
	IView graphicalViewmock;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		controller = new PocController();

		controller.modelA = mockery.mock(PocModel.class, "modelA");
		controller.modelB = mockery.mock(PocModel.class, "modelB");

		numericViewAmock = mockery.mock(IView.class, "numericAMockName");
		numericViewBmock = mockery.mock(IView.class, "numericBMockName");
		graphicalViewmock = mockery.mock(IView.class, "graphicalMockName");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testHandleUserEventSHOW_SIMPLE_1() {
		mockery.checking(new Expectations() {
			{
				one(numericViewAmock).getKey();
				will(returnValue(PocViewNumeric.KEY));
				
				one(controller.modelA).init();

			}
		});
		controller.addView(numericViewAmock);
		controller.handleEvent(new Event<String, PocAction>(PocAction.SHOW_SIMPLE_1));
	}
	
	@Test
	public void testHandleUserEventSHOW_COMPLEX_2() {
		mockery.checking(new Expectations() {
			{
				one(numericViewAmock).getKey();
				will(returnValue(PocViewNumeric.KEY));
				
				one(numericViewBmock).getKey();
				will(returnValue(PocViewNumericB.KEY));
				
				one(graphicalViewmock).getKey();
				will(returnValue(PocViewGraphical.KEY));
				
				one(controller.modelA).init();
				one(controller.modelB).init();

			}
		});
		controller.addView(numericViewAmock);
		controller.addView(numericViewBmock);
		controller.addView(graphicalViewmock);
		
		controller.handleEvent(new Event<String, PocAction>(PocAction.SHOW_COMPLEX_2));
	}
	
	@Test
	public void testHandleUserEventDO_PLUS_A() {
		final int currentValue = 1;
		final Event<Integer, PocAction> event = new Event<Integer, PocAction>(PocAction.DO_PLUS_A, currentValue);
		mockery.checking(new Expectations() {
			{
				one(controller.modelA).plus(currentValue, event);
			}
		});
		controller.handleEvent(event);
	}
	
	@Test
	public void testHandleUserEventDO_MINUS_A() {
		final int currentValue = 2;
		final Event<Integer, PocAction> event = new Event<Integer, PocAction>(PocAction.DO_MINUS_A, currentValue);
		mockery.checking(new Expectations() {
			{
				one(controller.modelA).minus(currentValue, event);
			}
		});
		controller.handleEvent(event);
	}
	
	@Test
	public void testHandleUserEventDO_PLUS_B() {
		final int currentValue = 3;
		final Event<Integer, PocAction> event = new Event<Integer, PocAction>(PocAction.DO_PLUS_B, currentValue);
		mockery.checking(new Expectations() {
			{
				one(controller.modelB).plus(currentValue, event);
			}
		});
		controller.handleEvent(event);
	}
	
	@Test
	public void testHandleUserEventDO_MINUS_B() {
		final int currentValue = 4;
		final Event<Integer, PocAction> event = new Event<Integer, PocAction>(PocAction.DO_MINUS_B, currentValue);
		mockery.checking(new Expectations() {
			{
				one(controller.modelB).minus(currentValue, event);
			}
		});
		controller.handleEvent(event);
	}
	

	@Test
	public void testTryConvertBrowserEventToControllerEventSHOW_SIMPLE_1() {
		controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("SHOW_SIMPLE_1"));
	}
	
	@Test
	public void testTryConvertBrowserEventToControllerEventSHOW_SIMPLE_1_case() {
		controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("show_simple_1"));
	}

	@Test
	public void testTryConvertBrowserEventToControllerEventSHOW_COMPLEX_2() {
		controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("SHOW_COMPLEX_2"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTryConvertBrowserEventToControllerEvent404() {
		try {
			controller.tryConvertBrowserEventToControllerEvent(new BrowserEvent("404"));
			fail();
		} catch (IllegalArgumentException e) {
			// success
		}
	}

}
