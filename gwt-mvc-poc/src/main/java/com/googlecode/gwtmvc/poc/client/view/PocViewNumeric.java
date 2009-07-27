package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.Model;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.view.components.PocIntegerLabel;

public class PocViewNumeric extends View<Integer, VerticalPanel> {

	public static final String ID = "numericA";

	PocIntegerLabel component;

	public PocViewNumeric(Controller controller, Model model) {
		super(ID, controller, model);
	}

	@Override
	public VerticalPanel createWidget() {
		VerticalPanel panel = new VerticalPanel();
		panel.addStyleName("numeric");

		component = new PocIntegerLabel("labelA");
		panel.add(component);

		Button plusButton = new Button("+1");
		plusButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				plusAction();
			}
		});
		panel.add(plusButton);

		Button minusButton = new Button("-1");
		minusButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				minusAction();
			}
		});
		panel.add(minusButton);

		Button reinitButton = new Button("reset");
		reinitButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				reinitAction();
			}
		});
		panel.add(reinitButton);
		return panel;
	}

	protected void plusAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_PLUS_A, component.getValue()));
	}

	protected void minusAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_MINUS_A, component.getValue()));
	}

	protected void reinitAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_REINIT_A, 0));
	}

	@Override
	public void onModelChange(ModelForView model) {
		ensureWidget();
		component.setValue((Integer) model.getValue());
	}
	
	@Override
	public void render() {
		Log.debug(toString()+" render");
		super.render();
	}

}
