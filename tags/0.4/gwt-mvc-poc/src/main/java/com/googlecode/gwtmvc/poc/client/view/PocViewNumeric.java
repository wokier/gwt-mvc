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
import com.googlecode.gwtmvc.poc.client.view.components.PocIntegerLabel;

public class PocViewNumeric extends View<Integer, VerticalPanel> {

	public static final String ID = "numericA";

	PocIntegerLabel component;

	public PocViewNumeric(Controller controller, ModelProxy model) {
		super(ID, controller, model);
	}

	@Override
	public VerticalPanel createWidget() {
		VerticalPanel panel = new VerticalPanel();
		panel.addStyleName("numeric");

		component = new PocIntegerLabel("labelA");
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
		return panel;
	}

	protected void plusAction() {
		controller.call(new MvcEvent<Integer>(PocAction.DO_PLUS_A, component.getValue()));
	}

	protected void minusAction() {
		controller.call(new MvcEvent<Integer>(PocAction.DO_MINUS_A, component.getValue()));
	}

	protected void reinitAction() {
		controller.call(new MvcEvent<Integer>(PocAction.DO_REINIT_A, 0));
	}

	@Override
	public void onModelChange(ModelForView model) {
		ensureWidget();
		component.setValue((Integer) model.getValue());
	}
	
	@Override
	public void onRender() {
		Log.debug(toString()+" render");
	}
}
