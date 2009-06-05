package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.Element;

/**
 * Allow to externally mask an element. A masker will generally mask the entire
 * application and block any user action
 */
public abstract class Masker implements Maskable {

	protected Element elementToMask;

	/**
	 * Build a masker for the entire application. I allows to use a global wait
	 * screen.
	 */
	public Masker() {
		super();
	}

	/**
	 * Build a masker for the element
	 * 
	 * @param elementToMask
	 */
	public Masker(Element elementToMask) {
		super();
		this.elementToMask = elementToMask;
	}

	/**
	 * Give the element to mask
	 * 
	 * @return
	 */
	public Element getElementToMask() {
		return elementToMask;
	}

}
