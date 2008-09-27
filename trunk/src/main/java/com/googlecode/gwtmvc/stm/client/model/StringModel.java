package com.googlecode.gwtmvc.stm.client.model;

/**
 * StringModel contains {@link String} as a content.
 * 
 * @author Igor Mihalik
 * @see Model
 * 
 */
public class StringModel extends ModelAdapter<String> {
	public StringModel() {
		super("");
	}

	public StringModel(String value) {
		super(value);
	}

}
