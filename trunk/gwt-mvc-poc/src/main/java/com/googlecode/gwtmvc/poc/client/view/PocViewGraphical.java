package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.model.PocModelProxy;

public class PocViewGraphical extends View<Integer, Label> {

	public static final String ID = "graphical";

	ModelForView<Integer> modelA, modelB;

	public PocViewGraphical(Controller controller, PocModelProxy modelA, PocModelProxy modelB) {
		super(ID, controller, modelA, modelB);
		this.modelA = modelA;
		this.modelB = modelB;
	}

	@Override
	public Label createWidget() {
		Label bar = new Label(" ");
		bar.setHeight("20px");
		return bar;
	}

	public void onModelChange(ModelForView model) {
		ensureWidget();
		int value = (modelA.getValue() == null ? 0 : modelA.getValue()) + (modelB.getValue() == null ? 0 : modelB.getValue());
		if (value >= 0) {
			getCreatedWidget().setWidth(value * 10 + "px");
			DOM.setStyleAttribute(getCreatedWidget().getElement(), "background", "lightsteelblue");
		} else {
			getCreatedWidget().setWidth(value * -10 + "px");
			DOM.setStyleAttribute(getCreatedWidget().getElement(), "background", "red");
		}
	}

	@Override
	public void onRender() {
		Log.debug(toString()+" render");
	}

}
