package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.Masker;

public class PocMasker extends Masker {
	
	public void mask() {
//		GWT.log("mask", null);
		RootPanel.get("wait").setVisible(true);
	}
	
	public void unmask() {
//		GWT.log("unmask", null);
		RootPanel.get("wait").setVisible(false);	
	}
	
	
}
