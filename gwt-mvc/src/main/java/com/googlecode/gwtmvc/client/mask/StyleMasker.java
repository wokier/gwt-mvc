package com.googlecode.gwtmvc.client.mask;

import com.google.gwt.user.client.ui.UIObject;
import com.googlecode.gwtmvc.client.Maskable;

/**
 * Allow to externally mask an element. <br>
 * A masker will generally mask the entire application and block any user action
 */
public class StyleMasker implements Maskable {

	private UIObject uiobjectToStyle;
	private String style;

	/**
	 * Build a masker for the element
	 * 
	 * @param uiobjectToStyleMask
	 * @param style
	 */
	public StyleMasker(UIObject uiobjectToStyleMask, String style) {
		super();
		this.uiobjectToStyle = uiobjectToStyleMask;
		this.style = style;
	}

	public void mask() {
		uiobjectToStyle.addStyleName(style);
	}

	public void unmask() {
		uiobjectToStyle.removeStyleName(style);
	}

}
