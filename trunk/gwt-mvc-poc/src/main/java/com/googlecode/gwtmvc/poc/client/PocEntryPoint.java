package com.googlecode.gwtmvc.poc.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.MvcEntryPoint;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerRoot;


public class PocEntryPoint extends MvcEntryPoint {

	public PocEntryPoint() {
		super(new PocControllerRoot());
	}
	
	@Override
	protected void hideLoadingIndicator() {
		RootPanel.get("loading").setVisible(false);
		Log.getDivLogger().moveTo(10, 420);
	}
	
	public void onUncaughtException(Throwable e) {
		Log.error("Uncaught Exeption",e);
		RootPanel.get("error").clear();
		Label globalErrorLabel = new Label(e.getMessage());
		globalErrorLabel.addStyleName("error");
		RootPanel.get("error").add(globalErrorLabel);
	}
	
	@Override
	protected void showPeripherals() {
		
	}
}
