package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.View;

public class PocController extends Controller {

	public enum PocAction {
		SHOW_SIMPLE_1, SHOW_COMPLEX_2, DO_PLUS_A, DO_MINUS_A, DO_REINIT_A, DO_PLUS_B, DO_MINUS_B, DO_REINIT_B
	}

	protected PocModel modelA, modelB;

	public PocController() {
		super();
	}

	@Override
	public void init() {
		modelA = new PocModel();
		modelB = new PocModel();

		addView(new PocViewNumeric(this, modelA));
		addView(new PocViewNumericB(this, modelB));
		addView(new PocViewGraphical(this, modelA, modelB));
	}

	@Override
	public void showHomeView() {

	}

	@Override
	public void handleEvent(Event event) {
		PocAction action = (PocAction) event.getAction();
		switch (action) {
		case SHOW_SIMPLE_1:
			IView nview = views.get(PocViewNumeric.KEY);
			nview.init();
			if (nview instanceof View) {
				RootPanel.get("content").clear();
			}
			renderView(nview);
			initModel(modelA);
			break;
		case SHOW_COMPLEX_2:
			IView nviewa = views.get(PocViewNumeric.KEY);
			nviewa.init();
			if (nviewa instanceof View) {
				RootPanel.get("content").clear();
			}
			renderView(nviewa);

			IView nviewb = views.get(PocViewNumericB.KEY);
			nviewb.init();
			renderView(nviewb);

			IView gview = views.get(PocViewGraphical.KEY);
			gview.init();
			renderView(gview);

			initModel(modelA);
			initModel(modelB);
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
			updateModel(modelA, 0);
			break;
		case DO_REINIT_B:
			updateModel(modelB, 0);
			break;
		}
	}

	@Override
	protected void renderView(IView view) {
		if (view instanceof View) {// Enable testing without GWT.create() error
			RootPanel.get("content").add((View) view);
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
