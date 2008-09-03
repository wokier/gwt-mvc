package com.googlecode.gwtmvc.poc.client;

import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;

public class PocViewNumericB extends PocViewNumeric {

	public PocViewNumericB(String key, PocController controller, ModelForView model) {
		super(key, controller, model);
	}
	
	protected void plusAction() {
		controller.handleUserGesture(new Event<Integer, PocAction>(PocAction.DO_PLUS_A, component.getValue()));
	}
	
	protected void minusAction() {
		controller.handleUserGesture(new Event<Integer, PocAction>(PocAction.DO_MINUS_A, component.getValue()));
	}
	
	protected void reinitAction() {
		controller.handleUserGesture(new Event<Integer, PocAction>(PocAction.DO_REINIT_A, 0));
	}
	
}
