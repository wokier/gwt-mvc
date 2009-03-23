package com.googlecode.gwtmvc.poc.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.View;

public class PocControllerMenu extends Controller {

	public enum PocMenuAction {

		SHOW_INTRO;

	}

	@Override
	public void init() {
		Log.debug("Menu controller init");

		RootPanel.get("wait").setVisible(false);// remove loading...

		View menu = new PocViewMenu(this);
		RootPanel.get("menu").add(menu);
		menu.setVisible(true);
		
		addView(new PocViewIntro(this));
		
		addChild(new PocController());
	}

	@Override
	public void showHomeView() {
		RootPanel.get("content").clear();
		RootPanel.get("content").add(new Label("Welcome..."));
	}

	@Override
	public void handleEvent(Event event) {
		Log.debug("Menu controller handleEvent " + event);
		
		PocMenuAction action = (PocMenuAction) event.getAction();
		switch (action) {
		case SHOW_INTRO:
			IView view = views.get(PocViewIntro.KEY);
			renderView(view);
			break;
		default:
			break;
		}
	}

	@Override
	protected void renderView(IView view) {
		if(view instanceof View){
			RootPanel.get("content").clear();
			RootPanel.get("content").add((View)view);
			((View)view).setVisible(true);
		}
	}

	@Override
	protected Enum[] getActionEnumValues() {
		return PocMenuAction.values();
	}

	@Override
	protected Event tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent) {
		PocMenuAction action = Enum.valueOf(PocMenuAction.class, browserEvent.getHistoryToken());
		return new Event<String, PocMenuAction>(action);
	}

}
