package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;

public class PocViewGraphical extends View<Integer> {

	protected static final String KEY = "graphical";

	Label bar;

	ModelForView<Integer> modelA, modelB;

	boolean inited;

	public PocViewGraphical(Controller controller, PocModel modelA, PocModel modelB) {
		super(KEY, controller, modelA, modelB);
		this.modelA = modelA;
		this.modelB = modelB;
	}

	@Override
	public void init() {
		if (!inited) {
			inited = true;

			bar = new Label(" ");
			bar.setHeight("20px");
			initWidget(bar);// call only once
		}
	}

	public void onModelChange(ModelForView model) {
		if (inited) {
			int value = modelA.getValue() + (modelB.getValue() == null ? 0 : modelB.getValue());
			if (value >= 0) {
				bar.setWidth(value * 10 + "px");
				DOM.setStyleAttribute(bar.getElement(), "background", "lightsteelblue");
			} else {
				bar.setWidth(value * -10 + "px");
				DOM.setStyleAttribute(bar.getElement(), "background", "red");
			}
		}
	}
	


}
