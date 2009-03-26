package com.googlecode.gwtmvc.poc.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.view.PocViewIntro;
import com.googlecode.gwtmvc.poc.client.view.PocViewMenu;

public class PocControllerMenu extends Controller {

	public enum PocMenuAction {

		SHOW_INTRO;

	}
	IView pocViewMenu;
	IView pocViewIntro;

	public PocControllerMenu() {
		super(new PocController());
		

	}

	@Override
	public void init() {
		Log.debug("Root controller init");
		
		if (pocViewIntro == null) {
			pocViewIntro = new PocViewIntro(this);
			RootPanel.get("wait").setVisible(false);// remove loading...
			
			pocViewMenu = new PocViewMenu(this);
			RootPanel.get("menu").clear();
			RootPanel.get("menu").add((View)pocViewMenu);
		}
		pocViewMenu.render();
		
	}

	@Override
	public void showHomeView() {
		if (pocViewIntro instanceof View) {
			RootPanel.get("content").clear();
			RootPanel.get("content").add(new Label("Welcome..."));
		}
	}

	@Override
	public void handleEvent(Event event) {
		Log.debug("Menu controller handleEvent " + event);

		PocMenuAction action = (PocMenuAction) event.getAction();
		switch (action) {
		case SHOW_INTRO:
			renderView(pocViewIntro);
			break;
		default:
			break;
		}
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
	protected Enum[] getActionEnumValues() {
		return PocMenuAction.values();
	}

	@Override
	protected Event tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent) {
		PocMenuAction action = Enum.valueOf(PocMenuAction.class, browserEvent.getHistoryToken());
		return new Event<String, PocMenuAction>(action);
	}

}
