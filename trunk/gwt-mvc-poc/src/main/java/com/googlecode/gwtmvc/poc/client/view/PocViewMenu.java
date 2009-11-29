package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.client.widget.MvcHyperlink;
import com.googlecode.gwtmvc.client.widget.MvcHyperlinkEntry;
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
		verticalPanel.add(new MvcHyperlink("Intro",PocMenuAction.SHOW_INTRO));
		verticalPanel.add(new MvcHyperlink("1 model - 1 view",PocAction.SHOW_SIMPLE));
		verticalPanel.add(new MvcHyperlink("2 models - 3 views",PocAction.SHOW_COMPLEX));
		verticalPanel.add(new MvcHyperlink("Maskable A",PocAction.SHOW_MASKABLE));
		verticalPanel.add(new MvcHyperlink("Maskable B (StyleMasker)",PocAction.SHOW_STYLE_MASKER));
		verticalPanel.add(new MvcHyperlink("Maskable C (VisibleMasker)",PocAction.SHOW_VISIBLE_MASKER));
		verticalPanel.add(new Hyperlink("404 Error (Unknown history token)","invalidToken"));
		verticalPanel.add(new MvcHyperlink("Form Validation",FormAction.SHOW_FORM));
		verticalPanel.add(new MvcHyperlink("Url parameters (value=5)",PocAction.SHOW_URLPARAMS , new MvcHyperlinkEntry("modelA","5")));
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

