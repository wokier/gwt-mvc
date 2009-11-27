package com.googlecode.gwtmvc.poc.client.controller;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.place.DivWrapperPlacer;
import com.googlecode.gwtmvc.client.place.DomPlacer;
import com.googlecode.gwtmvc.poc.client.view.PocViewIntro;
import com.googlecode.gwtmvc.poc.client.view.PocViewMenu;

public class PocControllerMenu extends Controller {

	public enum PocMenuAction {

		SHOW_INTRO;

	}

	IView pocViewMenu;
	IView pocViewIntro;

	DomPlacer menu;
	DomPlacer content;

	public PocControllerMenu() {
		super(PocMenuAction.values(), new PocController(), new PocControllerForm());
	}

	@Override
	public void init() {
		Log.debug("Root controller init");

		if (pocViewIntro == null) {
			pocViewIntro = new PocViewIntro(this);
			pocViewMenu = new PocViewMenu(this);

			content = new DivWrapperPlacer("content"){
				public void add(IView view) {
					Log.debug(toString() + " add "+ view);
					super.add(view);
				}
			};;
			menu = new DivWrapperPlacer("menu"){
				public void add(IView view) {
					Log.debug(toString() + " add "+ view);
					super.add(view);
				}
			};;
		}
		menu.clearAndAdd(pocViewMenu);
	}

	@Override
	public void showHomeView() {
		Log.debug("showHomeView");
		if(content instanceof DivWrapperPlacer){
			content.clear();
			((DivWrapperPlacer)content).getDivContainer().add(new Label("Welcome..."));
		}
	}

	@Override
	public void handleEvent(MvcEvent event) {
		Log.debug("Menu controller handleEvent " + event);

		PocMenuAction action = (PocMenuAction) event.getAction();
		switch (action) {
		case SHOW_INTRO:
			content.clearAndAdd(pocViewIntro);
			break;
		default:
			break;
		}
	}

	@Override
	@Deprecated
	protected void renderView(IView view) {
	}

	@Override
	protected MvcEvent tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent) {
		return super.tryConvertBrowserEventToControllerEvent(browserEvent);
	}
	
	public List<Controller> getChildren() {
		return children;
	}

}
