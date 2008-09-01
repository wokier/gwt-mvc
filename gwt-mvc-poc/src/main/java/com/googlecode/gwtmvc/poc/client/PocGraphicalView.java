package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;

public class PocGraphicalView extends View {

	private Label bar;

	private ModelForView<Integer> modelA, modelB;
	
	public PocGraphicalView(Controller controller, PocModel modelA, PocModel modelB) {
		super("graphical", controller, modelA, modelB);
		this.modelA = modelA;
		this.modelB = modelB;
	}

	@Override
	public void init() {
		bar = new Label("");
		initWidget(bar);
	}

	@Override
	public void onModelChange(ModelForView model) {
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
