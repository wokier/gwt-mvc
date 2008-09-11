package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.View;

public class PocController extends Controller {

	public enum PocAction {
		SHOW_SIMPLE_1, SHOW_COMPLEX_2, DO_PLUS_A, DO_MINUS_A, DO_REINIT_A, DO_PLUS_B, DO_MINUS_B, DO_REINIT_B
	}

	private PocModel modelA, modelB;

	public PocController() {
		super();

		modelA = new PocModel();
		modelB = new PocModel();

		addView(new PocViewNumeric("numericA", this, modelA));
		addView(new PocViewNumericB("numericB", this, modelB));
		addView(new PocViewGraphical(this, modelA, modelB));

	}

	@Override
	public void init() {

	}

	@Override
	public void handleUserEvent(Event event) {

		PocAction action = (PocAction) event.getAction();
		switch (action) {
		case SHOW_SIMPLE_1:
			View nview = views.get("numericA");
			nview.init();
			RootPanel.get("content").clear();
			RootPanel.get("content").add(nview);

			initModel(modelA);
			break;
		case SHOW_COMPLEX_2:
			RootPanel.get("content").clear();

			View nviewa = views.get("numericA");
			nviewa.init();
			addView(nviewa);
			RootPanel.get("content").add(nviewa);

			View nviewb = views.get("numericB");
			nviewb.init();
			addView(nviewb);
			RootPanel.get("content").add(nviewb);

			View gview = views.get("graphical");
			gview.init();
			addView(gview);
			RootPanel.get("content").add(gview);

			initModel(modelA);
			initModel(modelB);
			break;
		case DO_PLUS_A:
			modelA.plus((Integer) event.getValue());
			break;
		case DO_PLUS_B:
			modelB.plus((Integer) event.getValue());
			break;
		case DO_MINUS_A:
			modelA.minus((Integer) event.getValue());
			break;
		case DO_MINUS_B:
			modelB.minus((Integer) event.getValue());
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
	protected Enum[] getActionEnumValues() {
		return PocAction.values();
	}

	@Override
	protected Event tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent) {
		try {
			PocAction action = Enum.valueOf(PocAction.class, browserEvent.getHistoryToken());
			return new Event<String, PocAction>(action);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

}
