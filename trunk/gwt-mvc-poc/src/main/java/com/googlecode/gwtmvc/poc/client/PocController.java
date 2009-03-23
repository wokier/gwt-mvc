package com.googlecode.gwtmvc.poc.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.View;

public class PocController extends Controller {

	public enum PocAction {
		SHOW_SIMPLE_1, SHOW_COMPLEX_2, DO_PLUS_A, DO_MINUS_A, DO_REINIT_A, DO_PLUS_B, DO_MINUS_B, DO_REINIT_B, SHOW_MASKER, SHOW_MASKABLE
	}

	protected PocModel modelA, modelB;

	public PocController() {
		super();
	}

	@Override
	public void init() {
		modelA = new PocModel();
		modelB = new PocModel();

		new PocViewNumeric(this, modelA);
		new PocViewNumericB(this, modelB);
		new PocViewGraphical(this, modelA, modelB);
		
		new PocViewNumericWithMaskable(this, modelA);
		new PocViewNumericWithMasker(this, modelA);
	}

	@Override
	public void showHomeView() {

	}

	@Override
	public void handleEvent(Event event) {
		Log.debug("Controller handleEvent " + event);
		
		PocAction action = (PocAction) event.getAction();
		
		switch (action) {
		case SHOW_SIMPLE_1:
			IView nview = views.get(PocViewNumeric.KEY);
			if (nview instanceof View) {
				RootPanel.get("content").clear();
			}
			renderView(nview);
			initModel(modelA);
			break;
		case SHOW_COMPLEX_2:
			IView nviewa = views.get(PocViewNumeric.KEY);
			if (nviewa instanceof View) {
				RootPanel.get("content").clear();
			}
			renderView(nviewa);

			IView nviewb = views.get(PocViewNumericB.KEY);
			renderView(nviewb);

			IView gview = views.get(PocViewGraphical.KEY);
			renderView(gview);

			initModel(modelA);
			initModel(modelB);
			break;
		case SHOW_MASKABLE:
			IView viewMaskable = views.get(PocViewNumericWithMaskable.KEY);
			if (viewMaskable instanceof View) {
				RootPanel.get("content").clear();
			}
			renderView(viewMaskable);
			break;
		case SHOW_MASKER:
			IView viewMasker = views.get(PocViewNumericWithMasker.KEY);
			if (viewMasker instanceof View) {
				RootPanel.get("content").clear();
			}
			renderView(viewMasker);
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
		}
	}

	@Override
	protected void renderView(IView view) {
		Log.debug("Controller renderView "+view);
		if (view instanceof View) {// Enable testing without GWT.create() error
			RootPanel.get("content").add((View) view);
			((View)view).setVisible(true);
		}
	}

	@Override
	protected Enum[] getActionEnumValues() {
		return PocAction.values();
	}

	@Override
	protected Event tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent) {
		PocAction action = Enum.valueOf(PocAction.class, browserEvent.getHistoryToken());
		return new Event<String, PocAction>(action);
	}
}
