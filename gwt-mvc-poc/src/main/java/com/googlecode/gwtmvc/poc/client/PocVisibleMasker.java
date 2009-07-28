package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.mask.VisibleMasker;

public class PocVisibleMasker extends VisibleMasker {
	
	private static PocVisibleMasker instance;
	
	public static PocVisibleMasker getInstance() {
		if(instance == null){
			instance = new PocVisibleMasker();
		}
		return instance;
	}
	
	
	private PocVisibleMasker() {
		super(RootPanel.get("loading"));
	}
	
}
