package com.googlecode.gwtmvc.poc.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.Masker;

public class PocMasker extends Masker {
	
	private static final String MASKER_STYLE_NAME = "masker";
	public static final String MASK_STYLE_NAME = "mask";
	
	public void mask() {
		Log.debug("masker mask");
//		RootPanel.get("loading").setVisible(true);
		RootPanel.get().addStyleName(MASKER_STYLE_NAME);
	}
	
	public void unmask() {
		Log.debug("masker unmask");
		RootPanel.get().removeStyleName(MASKER_STYLE_NAME);
//		RootPanel.get("loading").setVisible(false);
	}
	
	
}
