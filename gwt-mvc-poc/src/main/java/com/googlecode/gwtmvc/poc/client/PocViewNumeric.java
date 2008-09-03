package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;

public class PocViewNumeric extends View {

	PocIntegerLabel component;

	boolean inited;

	public PocViewNumeric(String key, PocController controller,
			ModelForView model) {
		super(key, controller, model);
		
	}

	@Override
	public void init() {

		if (!inited) {
			inited = true;
			
			VerticalPanel panel = new VerticalPanel();
			DOM.setStyleAttribute(panel.getElement(), "border", "solid thin green");
			initWidget(panel);// only call once
			
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
		}

	}

	protected void plusAction() {
		controller.handleUserGesture(new Event<Integer, PocAction>(
				PocAction.DO_PLUS_A, component.getValue()));
	}

	protected void minusAction() {
		controller.handleUserGesture(new Event<Integer, PocAction>(
				PocAction.DO_MINUS_A, component.getValue()));
	}

	protected void reinitAction() {
		controller.handleUserGesture(new Event<Integer, PocAction>(
				PocAction.DO_REINIT_A, 0));
	}

	@Override
	public void onModelChange(ModelForView model) {
		if (inited) {
			component.setValue((Integer) model.getValue());
		}
	}

}
