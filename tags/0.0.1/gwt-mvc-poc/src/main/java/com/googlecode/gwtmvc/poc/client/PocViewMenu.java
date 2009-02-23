package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.PocControllerMenu.PocMenuAction;

public class PocViewMenu extends View {

	PocViewMenu(Controller controller){
		super("menu", controller);
	}
	
	@Override
	public void init() {
		VerticalPanel pan = new VerticalPanel();
		Hyperlink hIntro =new Hyperlink("Introduction",PocMenuAction.SHOW_INTRO.name());
		pan.add(hIntro);
		Hyperlink h1 = new Hyperlink("Simple Example #1",PocAction.SHOW_SIMPLE_1.name());
		pan.add(h1);
		Hyperlink h2 = new Hyperlink("More Complex Example #2",PocAction.SHOW_COMPLEX_2.name());
		pan.add(h2);
		initWidget(pan);	
	}

	@Override
	public void onModelChange(ModelForView model) {
		
	}
}
