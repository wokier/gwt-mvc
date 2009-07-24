package com.googlecode.gwtmvc.poc.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.MvcEntryPoint;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerMenu;


public class PocEntryPoint extends MvcEntryPoint {

	public PocEntryPoint() {
		super(new PocControllerMenu());
	}
	
	@Override
	protected void hideLoadingIndicator() {
		RootPanel.get("loading").setVisible(false);
		Log.getDivLogger().moveTo(10, 400);
	}
	
}
