package com.googlecode.gwtmvc.poc.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.place.DivWrapperPlacer;
import com.googlecode.gwtmvc.client.place.DomPlacer;
import com.googlecode.gwtmvc.poc.client.view.PocViewHierarchy;
import com.googlecode.gwtmvc.poc.client.view.PocViewIntro;
import com.googlecode.gwtmvc.poc.client.view.PocViewMenu;

public class PocControllerRoot extends PocBrowsableController {

    public enum PocRootAction {

	SHOW_INTRO, SHOW_HIERARCHY;

    }

    IView pocViewMenu;
    IView pocViewIntro;
    IView pocViewHierarchy;

    DomPlacer menu;
    DomPlacer content;

    public PocControllerRoot() {
	super(PocRootAction.values(), new PocController(), new PocControllerForm());
    }

    @Override
    public void init() {
	Log.debug("Root controller init");

	if (pocViewIntro == null) {
	    pocViewIntro = new PocViewIntro(this);
	    pocViewMenu = new PocViewMenu(this);
	    pocViewHierarchy = new PocViewHierarchy(this);

	    content = new DivWrapperPlacer("content") {
		public void add(IView view) {
		    Log.debug(toString() + " add " + view);
		    super.add(view);
		}
	    };
	    ;
	    menu = new DivWrapperPlacer("menu") {
		public void add(IView view) {
		    Log.debug(toString() + " add " + view);
		    super.add(view);
		}
	    };
	    ;
	}
	menu.clearAndAdd(pocViewMenu);
    }

    @Override
    public void showHomeView() {
	Log.debug("showHomeView");
	if (content instanceof DivWrapperPlacer) {
	    content.clear();
	    ((DivWrapperPlacer) content).getDivContainer().add(new Label("Welcome Home"));
	}
    }

    @Override
    public void handleEvent(MvcEvent event) {
	Log.debug("Menu controller handleEvent " + event);

	PocRootAction action = (PocRootAction) event.getAction();
	switch (action) {
	case SHOW_INTRO:
	    content.clearAndAdd(pocViewIntro);
	    break;
	case SHOW_HIERARCHY:
	    content.clearAndAdd(pocViewHierarchy);
	    break;
	default:
	    throw new RuntimeException("Unknown action");
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

}
