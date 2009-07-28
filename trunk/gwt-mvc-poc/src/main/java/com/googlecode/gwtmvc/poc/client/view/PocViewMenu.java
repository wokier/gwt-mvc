package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
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
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.add(new Hyperlink("Intro",PocMenuAction.SHOW_INTRO.name()));
		verticalPanel.add(new Hyperlink("1 model - 1 view",PocAction.SHOW_SIMPLE_1.name()));
		verticalPanel.add(new Hyperlink("2 models - 3 views",PocAction.SHOW_COMPLEX_2.name()));
		verticalPanel.add(new Hyperlink("Masker",PocAction.SHOW_MASKER.name()));
		verticalPanel.add(new Hyperlink("Maskable",PocAction.SHOW_MASKABLE.name()));
		verticalPanel.add(new Hyperlink("404 Error (Unknown history token)","invalidToken"));
		verticalPanel.add(new Hyperlink("Form Validation",FormAction.SHOW_FORM.name()));
		verticalPanel.add(new Hyperlink("Url parameters",PocAction.SHOW_URLPARAMS.name() +"?modelA=5"));
		return verticalPanel;
	}
	
	@Override
	public void onModelChange(ModelForView model) {
		
	}

	@Override
	public void onRender() {
		Log.debug(toString()+" render");
	}
}

