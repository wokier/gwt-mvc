package com.googlecode.gwtmvc.poc.client.controller;

import org.jmock.Expectations;

import com.googlecode.gwtmvc.ControllerTestCase;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerForm.FormAction;
import com.googlecode.gwtmvc.poc.client.model.PocModel;

public class PocControllerFormTest extends ControllerTestCase {

	PocControllerForm controller;

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		controller = new PocControllerForm();
		
		controller.pocViewForm = mockView("pocForm");
		
		controller.formModel = mockModel(PocModel.class, "formModel");
		
		controller.content = mockDomPlacer("content");
	}
	
	public void testCallSHOW_FORM() throws Exception {

		mockery.checking(new Expectations() {
			{
				oneOf(controller.formModel).init();
				
//				oneOf(controller.pocViewForm).render();
				oneOf(controller.content).clearAndAdd(controller.pocViewForm);
			}
		});

		controller.call(new MvcEvent<Object>(FormAction.SHOW_FORM));

		assertTrue(controller.isInitialised());
	}

	public void testCallDO_ADDITION() throws Exception {

		final MvcEvent<Integer> event = new MvcEvent<Integer>(FormAction.DO_ADDITION,5);
		mockery.checking(new Expectations() {
			{
				oneOf(controller.formModel).init();
				
				oneOf(controller.formModel).update(5, event);
			}
		});

		controller.call(event);

		assertTrue(controller.isInitialised());
	}
	
}
