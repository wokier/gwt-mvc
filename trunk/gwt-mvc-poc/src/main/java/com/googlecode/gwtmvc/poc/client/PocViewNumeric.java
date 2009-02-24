package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.Model;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;
import com.googlecode.gwtmvc.poc.client.components.PocIntegerLabel;

public class PocViewNumeric extends View<Integer, VerticalPanel> {

	protected static final String KEY = "numericA";

	PocIntegerLabel component;

	public PocViewNumeric(PocController controller, Model model) {
		super(KEY, controller, model);
	}

	public PocViewNumeric(String key, PocController controller, Model model) {
		super(key, controller, model);
	}

	@Override
	public VerticalPanel createWidget() {
		VerticalPanel panel = new VerticalPanel();
		DOM.setStyleAttribute(panel.getElement(), "border", "solid thin green");

		component = new PocIntegerLabel();
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
		RootPanel.get("wait").setVisible(false);
		component.setValue((Integer) model.getValue());
	}

}
