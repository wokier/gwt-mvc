package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;

public class PocMenu extends View {

	PocMenu(Controller controller){
		super("menu", controller);
	}
	
	@Override
	public void init() {
		VerticalPanel pan = new VerticalPanel();
		Hyperlink hIntro =new Hyperlink("Introduction","INTRO");
		pan.add(hIntro);
		Hyperlink h1 = new Hyperlink("Simple Example #1","SHOW_SIMPLE_1");
		pan.add(h1);
		Hyperlink h2 = new Hyperlink("More Complex Example #2","SHOW_COMPLEX_2");
		pan.add(h2);
		initWidget(pan);	
	}

	@Override
	public void onModelChange(ModelForView model) {
		
	}
}
