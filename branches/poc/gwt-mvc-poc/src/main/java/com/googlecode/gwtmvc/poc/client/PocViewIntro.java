package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;

public class PocViewIntro extends View {
	
	public static final String KEY = "INTRO";
	
	public PocViewIntro(Controller controller) {
		super(KEY,controller);
	}
	
	@Override
	public void init() {
		initWidget(new Label("Welcome to the GWT MVC POC."));
	}

	@Override
	public void onModelChange(ModelForView model) {
		
	}
	
}
