package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;

public class PocViewIntro extends View<Object, Label> {

	public static final String KEY = "INTRO";

	private boolean inited;

	public PocViewIntro(Controller controller) {
		super(KEY, controller);
	}

	@Override
	public Label createWidget() {
		return new Label("Welcome to the GWT MVC POC.");
	}
	
	@Override
	public void onModelChange(ModelForView model) {

	}

}
