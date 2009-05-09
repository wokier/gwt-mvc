package com.googlecode.gwtmvc.poc.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.model.PocModel;
import com.googlecode.gwtmvc.poc.client.view.PocViewForm;

public class PocControllerForm extends Controller {

	public enum FormAction {
		SHOW_FORM, DO_ADDITION
	}

	protected IView<Integer> pocViewForm;

	protected PocModel formModel;

	public PocControllerForm() {
		super(FormAction.values());
		formModel = new PocModel();
	}

	@Override
	protected Enum[] getActionEnumValues() {
		return FormAction.values();
	}

	@Override
	protected void handleEvent(Event event) {
		Log.debug("Controller handleEvent " + event);
		FormAction action = (FormAction) event.getAction();
		switch (action) {
		case SHOW_FORM:
			renderView(pocViewForm);
			if (pocViewForm instanceof PocViewForm) {
				((PocViewForm) pocViewForm).initForm(formModel.getValue());
			}
			break;
		case DO_ADDITION:
			formModel.update((Integer) event.getValue(), event);
		}
	}

	@Override
	public void init() {
		Log.debug("Form Controller init");
		if (pocViewForm == null) {
			pocViewForm = new PocViewForm(this, formModel);
		}
		initModel(formModel);
	}

	@Override
	protected void renderView(IView view) {
		if (view instanceof View) {
			RootPanel.get("content").clear();
			RootPanel.get("content").add((View) view);
		}
		view.render();
	}

	@Override
	public void showHomeView() {

	}

	@Override
	protected Event tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent)
			throws IllegalArgumentException {
		return new Event<Object, FormAction>(FormAction.valueOf(browserEvent.getHistoryToken()));
	}

}
