package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.PocController.PocAction;

public class PocMenuController extends Controller {

	public enum PocMenuAction {

		INTRO, ACTION_1, ACTION_2;

	}

	Controller pocControllerChild ;
	
	@Override
	public void init() {
		RootPanel.get("wait").setVisible(false);//remove loading...
		
		View menu = new PocMenu(this);
		menu.init();
		RootPanel.get("menu").add(menu);
		
		RootPanel.get("content").add(new Label("Welcome..."));
		
		pocControllerChild = new PocController();
	}

	@Override
	public void handleUserGesture(Event event) {

		PocMenuAction action = (PocMenuAction) event.getAction();
		switch (action) {
		case INTRO:
			RootPanel.get("content").clear();
			RootPanel.get("content").add(new PocIntro());
			break;
		case ACTION_1:
			pocControllerChild.handleUserGesture(new Event<String, PocAction>(PocAction.SHOW_SIMPLE_1));
			break;
		case ACTION_2:
			pocControllerChild.handleUserGesture(new Event<String, PocAction>(PocAction.SHOW_COMPLEX_2));
			break;
		default:
			break;
		}
	}

}
