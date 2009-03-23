package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.PocControllerMenu.PocMenuAction;

public class PocViewMenu extends View<Object,VerticalPanel> {

	PocViewMenu(Controller controller){
		super("menu", controller);
	}
	
	@Override
	public VerticalPanel createWidget() {
		VerticalPanel pan = new VerticalPanel();
		pan.add(new Hyperlink("Introduction",PocMenuAction.SHOW_INTRO.name()));
		pan.add(new Hyperlink("Simple Example #1",PocAction.SHOW_SIMPLE_1.name()));
		pan.add(new Hyperlink("More Complex Example #2",PocAction.SHOW_COMPLEX_2.name()));
		pan.add(new Hyperlink("Masker",PocAction.SHOW_MASKER.name()));
		pan.add(new Hyperlink("Maskable",PocAction.SHOW_MASKABLE.name()));
		pan.add(new Hyperlink("404 Error (Unknown history token)","invalidToken"));
		return pan;
	}
	
	@Override
	public void onModelChange(ModelForView model) {
		
	}
}

