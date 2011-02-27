package com.googlecode.gwtmvc.poc.client.view.widgetbinder;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.ModelProxy;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.binder.UIBinderView;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;

public class PocViewUIBinder extends UIBinderView {

    interface IPocViewUIBinder extends UiBinder<HTMLPanel, PocViewUIBinder> {

    }

    private static IPocViewUIBinder binder = GWT.create(IPocViewUIBinder.class);

    ModelProxy model;

    @UiField
    SpanElement uiBinderSpan;

    @UiField
    Button myButton;

    public PocViewUIBinder(Controller controller, ModelProxy model) {
	super(binder, "UIBinder", controller, model);
	this.model = model;
    }

    public void onRender() {
	Log.debug("PocViewUiBinder render");
	uiBinderSpan.setInnerText(model.getValue() != null ? model.getValue().toString() : "Undefined");
    }

    public void onModelChange(ModelForView model) {
	Log.debug("PocViewUiBinder onModelChange");
	uiBinderSpan.setInnerText(model.getValue() == null ? "NULL" : model.getValue().toString());
    }

    @UiHandler("myButton")
    void handleClick(ClickEvent e) {
	controller.call(new MvcEvent(PocAction.DO_PLUS_A, model.getValue()));
    }

}
