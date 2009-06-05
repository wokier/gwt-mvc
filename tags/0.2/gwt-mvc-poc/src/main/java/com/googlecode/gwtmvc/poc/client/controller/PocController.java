package com.googlecode.gwtmvc.poc.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.model.PocModel;
import com.googlecode.gwtmvc.poc.client.view.PocViewGraphical;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumeric;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumericB;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumericWithMaskable;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumericWithMasker;

public class PocController extends Controller {

	public enum PocAction {
		SHOW_SIMPLE_1, SHOW_COMPLEX_2, SHOW_MASKER, SHOW_MASKABLE, DO_PLUS_A, DO_MINUS_A, DO_REINIT_A, DO_PLUS_B, DO_MINUS_B, DO_REINIT_B
	}

	protected IView<Integer> pocViewNumeric;
	protected IView<Integer> pocViewNumericB;
	protected IView<Integer> pocViewGraphical;
	protected IView<Integer> pocViewNumericWithMaskable;
	protected IView<Integer> pocViewNumericWithMasker;

	protected PocModel modelA, modelB;

	public PocController() {
		super(PocAction.values());
		modelA = new PocModel();
		modelB = new PocModel();
	}

	@Override
	public void init() {
		Log.debug("Controller init");
		
		if (pocViewNumeric == null)
			pocViewNumeric = new PocViewNumeric(this, modelA);
		if (pocViewNumericB == null)
			pocViewNumericB = new PocViewNumericB(this, modelB);
		if (pocViewGraphical == null)
			pocViewGraphical = new PocViewGraphical(this, modelA, modelB);

		if (pocViewNumericWithMaskable == null)
			pocViewNumericWithMaskable = new PocViewNumericWithMaskable(this, modelA);
		if (pocViewNumericWithMasker == null)
			pocViewNumericWithMasker = new PocViewNumericWithMasker(this, modelB);

		initModel(modelA);
		initModel(modelB);
	}

	@Override
	public void showHomeView() {

	}

	@Override
	protected void handleEvent(Event event) {
		Log.debug("Controller handleEvent " + event);

		PocAction action = (PocAction) event.getAction();

		switch (action) {
		case SHOW_SIMPLE_1:
			clearContent(pocViewNumeric instanceof View);
			renderView(pocViewNumeric);
			break;
		case SHOW_COMPLEX_2:
			clearContent(pocViewNumeric instanceof View);
			renderView(pocViewNumeric);
			renderView(pocViewNumericB);
			renderView(pocViewGraphical);
			break;
		case SHOW_MASKER:
			clearContent(pocViewNumericWithMasker instanceof View);
			renderView(pocViewNumericWithMasker);
			break;
		case SHOW_MASKABLE:
			clearContent(pocViewNumericWithMaskable instanceof View);
			renderView(pocViewNumericWithMaskable);
			break;
		case DO_PLUS_A:
			modelA.plus((Integer) event.getValue(), event);
			break;
		case DO_PLUS_B:
			modelB.plus((Integer) event.getValue(), event);
			break;
		case DO_MINUS_A:
			modelA.minus((Integer) event.getValue(), event);
			break;
		case DO_MINUS_B:
			modelB.minus((Integer) event.getValue(), event);
			break;
		case DO_REINIT_A:
			updateModel(modelA, 0, event);
			break;
		case DO_REINIT_B:
			updateModel(modelB, 0, event);
			break;
		default:
			Log.debug("Unknown action");
		}
	}

	private void clearContent(boolean isTestMode) {
		if (isTestMode) {
			RootPanel.get("content").clear();
		}
	}

	@Override
	protected void renderView(IView view) {
		Log.debug("Controller renderView " + view);
		if (view instanceof View) {// Enable testing without GWT.create() error
			RootPanel.get("loading").setVisible(false);
			RootPanel.get("content").add((View) view);
		}
		view.render();
	}
	
	@Override
	protected Event tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent) {
		return super.tryConvertBrowserEventToControllerEvent(browserEvent);
	}

}
