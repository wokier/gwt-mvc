package com.googlecode.gwtmvc.poc.client.view;

import java.util.Date;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.controller.PocController;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.model.PocModelProxy;

public class PocViewException extends View<String,VerticalPanel> {

	private Label label;

	public PocViewException(PocController controller, PocModelProxy model) {
		super("PocExceptionView",controller,model);
	}
	
	@Override
	public VerticalPanel createWidget() {
		VerticalPanel verticalPanel = new VerticalPanel();
		Button checkedExceptionButton = new Button("Do something wrong that throw Checked Exception", new ClickHandler(){
			public void onClick(ClickEvent event) {
				controller.call(new MvcEvent<String>(PocAction.DO_CHECKED_EXCEPTION));
			}
		});
		verticalPanel.add(checkedExceptionButton);
		Button uncheckedExceptionButton = new Button("Do something wrong that throw Unchecked Exception", new ClickHandler(){
			public void onClick(ClickEvent event) {
				controller.call(new MvcEvent<String>(PocAction.DO_UNCHECKED_EXCEPTION));
			}
		});
		verticalPanel.add(uncheckedExceptionButton);
		Button uncaughtExceptionButton = new Button("Throw Uncaught Exception", new ClickHandler(){
			public void onClick(ClickEvent event) {
				throw new RuntimeException("Uncaught Exception at "+new Date());
			}
		});
		verticalPanel.add(uncaughtExceptionButton);
		label = new Label("...");
		label.addStyleName("error");
		verticalPanel.add(label);
		return verticalPanel;
	}

	@Override
	public void onRender() {
		Log.debug("onRender");

	}

	@Override
	public void onModelChange(ModelForView model) {
		Log.error("onModelChange", model.getError());
		if(model.getError() != null){
			label.setText(model.getError().getMessage());
		}
	}
	
}
