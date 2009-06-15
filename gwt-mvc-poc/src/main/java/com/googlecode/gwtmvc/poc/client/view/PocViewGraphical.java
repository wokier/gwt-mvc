package com.googlecode.gwtmvc.poc.client.view;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.model.PocModel;

public class PocViewGraphical extends View<Integer, Label> {

	public static final String ID = "graphical";

	Label bar;

	ModelForView<Integer> modelA, modelB;

	public PocViewGraphical(Controller controller, PocModel modelA, PocModel modelB) {
		super(ID, controller, modelA, modelB);
		this.modelA = modelA;
		this.modelB = modelB;
	}

	@Override
	public Label createWidget() {
		bar = new Label(" ");
		bar.setHeight("20px");
		return bar;
	}

	public void onModelChange(ModelForView model) {
		ensureWidget();
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