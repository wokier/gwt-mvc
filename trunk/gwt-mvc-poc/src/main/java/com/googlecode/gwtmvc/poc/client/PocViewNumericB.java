package com.googlecode.gwtmvc.poc.client;

import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.Model;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;

public class PocViewNumericB extends PocViewNumeric {

	protected static final String KEY = "numericB";

	public PocViewNumericB(PocController controller, Model model) {
		super(KEY, controller, model);
	}
	
	protected void plusAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_PLUS_B, component.getValue(), new PocMasker()));
	}
	
	protected void minusAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_MINUS_B, component.getValue(), new PocMasker()));
	}
	
	protected void reinitAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_REINIT_B, 0, new PocMasker()));
	}
	
}
