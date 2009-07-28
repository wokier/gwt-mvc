package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.mask.StyleMasker;

public class PocStyleMasker extends StyleMasker {
	
	private static final String MASKER_STYLE_NAME = "masker";
	public static final String MASK_STYLE_NAME = "mask";
	
	private static PocStyleMasker instance;
	
	public static PocStyleMasker getInstance() {
		if(instance == null){
			instance = new PocStyleMasker();
		}
		return instance;
	}
	
	
	private PocStyleMasker() {
		super(RootPanel.get(),MASKER_STYLE_NAME);
	}
	
}
