package com.googlecode.gwtmvc.client.mask;

import com.google.gwt.user.client.ui.UIObject;
import com.googlecode.gwtmvc.client.Maskable;
/**
 * Allow to externally mask an element. <br>A masker will generally mask the entire
 * application and block any user action
 */
public class VisibleMasker implements Maskable {

	private UIObject uiobjectToDisplay;

	/**
	 * Build a masker for the element
	 * 
	 * @param uiobjectToDisplay
	 */
	public VisibleMasker(UIObject uiobjectToDisplay) {
		super();
		this.uiobjectToDisplay = uiobjectToDisplay;
	}

	public void mask() {
		uiobjectToDisplay.setVisible(true);
	}

	public void unmask() {
		uiobjectToDisplay.setVisible(false);
	}
}
