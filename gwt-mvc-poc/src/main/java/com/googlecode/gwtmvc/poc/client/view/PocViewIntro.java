package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;

public class PocViewIntro extends View<Object, HTML> {

	public static final String ID = "INTRO";

	public PocViewIntro(Controller controller) {
		super(ID, controller);
	}

	@Override
	public HTML createWidget() {
		return new HTML("Welcome to the GWT MVC POC.<br />GWT-MVC project's aim is to create a layer on top Google Web Toolkit's widget library capable of implementing RIAs in easier and more conceptually guided way based on Model-View-Controller design pattern.<br />MVC can be decomposed into observer design pattern in case of relation between Model and View. The view observes (listens to) the model for changes and updates itself according to changes. View does not directly change model state but use the controllers.");
	}
	
	@Override
	public void onModelChange(ModelForView model) {

	}

	@Override
	public void onRender() {
		Log.debug(toString()+" render");
	}
}
