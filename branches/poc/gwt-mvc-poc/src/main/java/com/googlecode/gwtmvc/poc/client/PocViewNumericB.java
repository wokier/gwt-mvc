package com.googlecode.gwtmvc.poc.client;

import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;

public class PocViewNumericB extends PocViewNumeric {

	protected static final String KEY = "numericB";

	public PocViewNumericB(PocController controller, ModelForView model) {
		super(KEY, controller, model);
	}
	
	protected void plusAction() {
		controller.handleUserEvent(new Event<Integer, PocAction>(PocAction.DO_PLUS_B, component.getValue()));
	}
	
	protected void minusAction() {
		controller.handleUserEvent(new Event<Integer, PocAction>(PocAction.DO_MINUS_B, component.getValue()));
	}
	
	protected void reinitAction() {
		controller.handleUserEvent(new Event<Integer, PocAction>(PocAction.DO_REINIT_B, 0));
	}
	
}
