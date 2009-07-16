package com.googlecode.gwtmvc.poc.client.view;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.Model;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.controller.PocController;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.view.components.PocIntegerLabel;

public class PocViewNumericB extends View<Integer, VerticalPanel> {

	public static final String ID = "numericB";

	PocIntegerLabel component;

	public PocViewNumericB(PocController controller, Model model) {
		super(ID, controller, model);
	}

	@Override
	public VerticalPanel createWidget() {
		VerticalPanel panel = new VerticalPanel();
		panel.addStyleName("numeric");

		component = new PocIntegerLabel("labelB");
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

		Button reinitButton = new Button("reinit");
		reinitButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				reinitAction();
			}
		});
		panel.add(reinitButton);
		return panel;
	}

	@Override
	public void onModelChange(ModelForView model) {
		ensureWidget();
		component.setValue((Integer) model.getValue());
	}
	
	protected void plusAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_PLUS_B, component.getValue()));
	}
	
	protected void minusAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_MINUS_B, component.getValue()));
	}
	
	protected void reinitAction() {
		controller.call(new Event<Integer, PocAction>(PocAction.DO_REINIT_B, 0));
	}
	
}