package com.googlecode.gwtmvc.poc.client.view;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerForm.FormAction;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerMenu.PocMenuAction;

public class PocViewMenu extends View<Object,VerticalPanel> {

	public PocViewMenu(Controller controller){
		super("menu", controller);
	}
	
	@Override
	public VerticalPanel createWidget() {
		VerticalPanel pan = new VerticalPanel();
		pan.add(new Hyperlink("Intro",PocMenuAction.SHOW_INTRO.name()));
		pan.add(new Hyperlink("1 model - 1 view",PocAction.SHOW_SIMPLE_1.name()));
		pan.add(new Hyperlink("2 models - 3 views",PocAction.SHOW_COMPLEX_2.name()));
		pan.add(new Hyperlink("Masker",PocAction.SHOW_MASKER.name()));
		pan.add(new Hyperlink("Maskable",PocAction.SHOW_MASKABLE.name()));
		pan.add(new Hyperlink("404 Error (Unknown history token)","invalidToken"));
		pan.add(new Hyperlink("Form Validation",FormAction.SHOW_FORM.name()));
		return pan;
	}
	
	@Override
	public void onModelChange(ModelForView model) {
		
	}
}

