package com.googlecode.gwtmvc.poc.client.view.components;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.TextBox;
import com.googlecode.gwtmvc.client.Maskable;
import com.googlecode.gwtmvc.client.form.FormValidationElement;
import com.googlecode.gwtmvc.poc.client.PocMasker;

public class PocIntegerTextBox extends TextBox implements FormValidationElement, Maskable {
	
	private static final String ERROR_STYLENAME = "error";

	public PocIntegerTextBox() {
		super();
	}
	
	public PocIntegerTextBox(String id) {
		this();
		getElement().setId(id);
	}
	
	
	public Integer getIntegerValue(){
		return Integer.parseInt(getText());
	}
	
	public void setValue(Integer integer){
		setText(String.valueOf(integer));
	}
	
	public boolean validate() {
		try{
			getIntegerValue();
			removeStyleName(ERROR_STYLENAME);
			Log.debug("TextBox validation OK");
			return true;
		}catch (NumberFormatException e) {
			addStyleName(ERROR_STYLENAME);
			Log.debug("TextBox validation KO");
			return false;
		}
	}
	
	public void mask() {
		Log.debug("maskable mask");
		addStyleName(PocMasker.MASK_STYLE_NAME);
	}
	
	public void unmask() {
		Log.debug("maskable unmask");
		removeStyleName(PocMasker.MASK_STYLE_NAME);
	}	
}
