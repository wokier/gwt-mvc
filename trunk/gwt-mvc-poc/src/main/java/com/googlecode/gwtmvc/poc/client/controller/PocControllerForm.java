package com.googlecode.gwtmvc.poc.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.place.DivWrapperPlacer;
import com.googlecode.gwtmvc.client.place.DomPlacer;
import com.googlecode.gwtmvc.poc.client.model.PocModelProxy;
import com.googlecode.gwtmvc.poc.client.view.PocViewForm;
import com.googlecode.gwtmvc.poc.client.view.PocViewFormWithMessages;

public class PocControllerForm extends PocBrowsableController {

	public enum FormAction {
		SHOW_FORM, DO_ADDITION, SHOW_FORM_MESSAGES
	}

	protected IView<Integer> pocViewForm;
	protected IView<Integer> pocViewFormMessages;

	protected PocModelProxy formModel;

	protected DomPlacer content;

	public PocControllerForm() {
		super(FormAction.values());
		formModel = new PocModelProxy();
	}

	@Override
	public void init() {
		Log.debug("Form Controller init");
		if (pocViewForm == null) {
			pocViewForm = new PocViewForm(this, formModel);
		}
		if (pocViewFormMessages == null) {
			pocViewFormMessages = new PocViewFormWithMessages(this, formModel);
		}
		initModel(formModel);

		if (content == null) {
			content = new DivWrapperPlacer("content"){
				public void add(IView view) {
					Log.debug(toString() + " add "+ view);
					super.add(view);
				}
			};
		}
	}

	@Override
	protected void handleEvent(MvcEvent event) {
		Log.debug("Form Controller handleEvent " + event);
		FormAction action = (FormAction) event.getAction();
		switch (action) {
		case SHOW_FORM:
			content.clearAndAdd(pocViewForm);
			if (pocViewForm instanceof PocViewForm) {
				((PocViewForm) pocViewForm).initForm(formModel.getValue());
			}
			break;
		case SHOW_FORM_MESSAGES:
			content.clearAndAdd(pocViewFormMessages);
			if (pocViewFormMessages instanceof PocViewFormWithMessages) {
				((PocViewFormWithMessages) pocViewFormMessages).initForm(formModel.getValue());
			}
			break;
		case DO_ADDITION:
			formModel.update((Integer) event.getValue(), event);
		}
	}

	@Override
	@Deprecated
	protected void renderView(IView view) {
	}

	@Override
	public void showHomeView() {

	}

}
