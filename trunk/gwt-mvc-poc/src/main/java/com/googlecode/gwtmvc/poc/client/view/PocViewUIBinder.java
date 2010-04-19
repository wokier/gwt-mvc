package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.ModelProxy;
import com.googlecode.gwtmvc.poc.client.UIBinderView;

public class PocViewUIBinder extends UIBinderView {

	interface IPocViewUIBinder extends UiBinder<DivElement, PocViewUIBinder> {

	}

	private static IPocViewUIBinder binder = GWT.create(IPocViewUIBinder.class);

	ModelProxy model;
	
	@UiField
	SpanElement uiBinderSpan;

	public PocViewUIBinder(Controller controller, ModelProxy model) {
		super(binder, "UIBinder", controller, model);
		this.model = model;
	}

	public void onRender() {
		Log.debug("PocViewUiBinder render");
		uiBinderSpan.setInnerText(model.getValue()!=null?model.getValue().toString(): "Undefined");
	}

	public void onModelChange(ModelForView model) {
		Log.debug("PocViewUiBinder onModelChange");
		uiBinderSpan.setInnerText(model.getValue()== null ? "NULL" : model.getValue().toString());
	}
	
}
