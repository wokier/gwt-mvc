package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.View;

public class PocController extends Controller {

	public enum PocAction {

		PLUS, MINUS, REINIT
	}

	private PocModel modelA, modelB;

	public PocController() {
		super();
		modelA = new PocModel();
		modelB = new PocModel();
		add(new PocNumericView("numericA", this, modelA));
		add(new PocNumericView("numericB", this, modelB));
		
		add(new PocGraphicalView(this, modelA, modelB));
	}

	@Override
	public void init() {
		View nviewa = views.get("numericA");
		nviewa.init();
		RootPanel.get().add(nviewa);

		View nviewb = views.get("numericB");
		nviewb.init();
		RootPanel.get().add(nviewb);

		View gview = views.get("graphical");
		gview.init();
		RootPanel.get().add(gview);

		initModel(modelA);
		initModel(modelB);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtmvc.client.Controller#onUserGesture(com.googlecode.gwtmvc.client.Event)
	 */
	public void onUserGesture(Event event) {

		PocAction action = (PocAction) event.getAction();
		switch (action) {
		case PLUS:
			if (event.getSender().getKey().equals("numericA")) {
				modelA.plus((Integer) event.getValue());
			} else {
				modelB.plus((Integer) event.getValue());
			}
			break;
		case MINUS:
			if (event.getSender().getKey().equals("numericA")) {
				modelA.minus((Integer) event.getValue());
			} else {
				modelB.minus((Integer) event.getValue());
			}
			break;
		case REINIT:
			if (event.getSender().getKey().equals("numericA")) {
				updateModel(modelA, 0);
			} else {
				updateModel(modelB, 0);
			}
			break;
		}
	}

}
