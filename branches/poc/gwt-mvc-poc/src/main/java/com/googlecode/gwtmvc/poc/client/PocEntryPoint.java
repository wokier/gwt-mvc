package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.core.client.EntryPoint;

public class PocEntryPoint implements EntryPoint {

	public PocEntryPoint() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onModuleLoad() {
		new PocMenuController().init();
	}

}
