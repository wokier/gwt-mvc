package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.ModelProxy;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerChild.ChildAction;
import com.googlecode.gwtmvc.poc.client.view.components.PocIntegerLabel;

public class PocViewNumericB extends View<Integer, VerticalPanel> {

	public static final String ID = "numericB";

	PocIntegerLabel component;

	public PocViewNumericB(Controller controller, ModelProxy model) {
		super(ID, controller, model);
	}

	@Override
	public VerticalPanel createWidget() {
		VerticalPanel panel = new VerticalPanel();
		panel.addStyleName("numeric");

		component = new PocIntegerLabel("labelB");
		panel.add(component);

		Button plusButton = new Button("+1",new ClickHandler() {
			public void onClick(ClickEvent event) {
				plusAction();
			}
		});
		panel.add(plusButton);

		Button minusButton = new Button("-1",new ClickHandler() {
			public void onClick(ClickEvent event) {
				minusAction();
			}
		});
		panel.add(minusButton);

		Button reinitButton = new Button("reset",new ClickHandler() {
			public void onClick(ClickEvent event) {
				reinitAction();
			}
		});
		panel.add(reinitButton);
		
		
		Button reinitAllButton = new Button("reset all",new ClickHandler() {
			public void onClick(ClickEvent event) {
				reinitAllAction();
			}
		});
		panel.add(reinitAllButton);
		return panel;
	}

	@Override
	public void onModelChange(ModelForView model) {
		ensureWidget();
		component.setValue((Integer) model.getValue());
	}
	
	protected void plusAction() {
		controller.call(new MvcEvent<Integer>(PocAction.DO_PLUS_B, component.getValue()));
	}
	
	protected void minusAction() {
		controller.call(new MvcEvent<Integer>(PocAction.DO_MINUS_B, component.getValue()));
	}
	
	protected void reinitAction() {
		controller.call(new MvcEvent<Integer>(PocAction.DO_REINIT_B, 0));
	}
	
	protected void reinitAllAction() {
		controller.call(new MvcEvent<Integer>(ChildAction.DO_REINIT_ALL,0));
	}
	
	@Override
	public void onRender() {
		Log.debug(toString()+" render");
	}
}
