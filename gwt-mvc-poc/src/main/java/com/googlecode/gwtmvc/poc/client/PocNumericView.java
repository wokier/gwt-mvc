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

public class PocNumericView extends View {

	VerticalPanel panel;
	PocComponent component;
	Button plusButton, minusButton,  reinitButton;

	public PocNumericView(String key, PocController controller, ModelForView model) {
		super(key, controller, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtmvc.client.View#init()
	 */
	public void init() {
		panel = new VerticalPanel();
		DOM.setStyleAttribute(panel.getElement(), "border", "solid thin green");
		initWidget(panel);

		component = new PocComponent();
		panel.add(component);

		plusButton = new Button("+1");
		plusButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				plusAction();
			}
		});
		panel.add(plusButton);
		
		minusButton = new Button("-1");
		minusButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				minusAction();
			}
		});
		panel.add(minusButton);

		reinitButton = new Button("reinit");
		reinitButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				reinitAction();
			}
		});
		panel.add(reinitButton);
	}

	private void plusAction() {
		controller.onUserGesture(new Event<Integer, PocAction>(this, PocAction.PLUS, component.getValue()));
	}
	
	private void minusAction() {
		controller.onUserGesture(new Event<Integer, PocAction>(this, PocAction.MINUS, component.getValue()));
	}
	
	private void reinitAction() {
		controller.onUserGesture(new Event<Integer, PocAction>(this, PocAction.REINIT, 0));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtmvc.client.View#onModelChange(com.googlecode.gwtmvc.client.Model)
	 */
	public void onModelChange(ModelForView model) {
		component.setValue((Integer) model.getValue());
	}

}
