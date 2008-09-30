package com.googlecode.gwtmvc.stm.client.model;

/**
 * BString contains {@link String} as a content.
 * 
 * @author Igor Mihalik
 * @see Model
 * 
 */
public class BString extends ModelAdapter<String> {
	public BString() {
		super("");
	}

	public BString(String value) {
		super(value);
	}

}
