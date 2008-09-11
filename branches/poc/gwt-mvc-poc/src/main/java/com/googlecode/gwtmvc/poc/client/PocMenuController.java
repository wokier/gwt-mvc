package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.View;

public class PocMenuController extends Controller {

	public enum PocMenuAction {

		INTRO;

	}

	@Override
	public void init() {
		RootPanel.get("wait").setVisible(false);// remove loading...

		View menu = new PocMenu(this);
		menu.init();
		RootPanel.get("menu").add(menu);

		RootPanel.get("content").add(new Label("Welcome..."));

		addChild(new PocController());
	}

	@Override
	public void handleUserEvent(Event event) {

		PocMenuAction action = (PocMenuAction) event.getAction();
		switch (action) {
		case INTRO:
			RootPanel.get("content").clear();
			RootPanel.get("content").add(new PocIntro());
			break;
		default:
			break;
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
