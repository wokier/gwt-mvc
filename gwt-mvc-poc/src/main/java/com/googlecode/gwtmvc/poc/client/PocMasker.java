package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.mask.StyleMasker;

public class PocMasker extends StyleMasker {
	
	private static final String MASKER_STYLE_NAME = "masker";
	public static final String MASK_STYLE_NAME = "mask";
	
	private static PocMasker instance;
	
	public static PocMasker getInstance() {
		if(instance == null){
			instance = new PocMasker();
		}
		return instance;
	}
	
	
	private PocMasker() {
		super(RootPanel.get(),MASKER_STYLE_NAME);
	}
	
}
