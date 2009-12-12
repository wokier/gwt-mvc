package com.googlecode.gwtmvc.poc.client.view.components;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.ListBox;
import com.googlecode.gwtmvc.client.Maskable;
import com.googlecode.gwtmvc.client.form.FormValidationElement;
import com.googlecode.gwtmvc.poc.client.PocStyleMasker;

public class PocIntegerListBox extends ListBox implements FormValidationElement, Maskable {

	private static final String ERROR_STYLENAME = "error";
	
	private static int NULL_INDEX = -1;
	
	public PocIntegerListBox(Integer begin, Integer end) {
		super();
		for (int i = begin; i <= end; i++) {
			String value = String.valueOf(i);
			addItem("+ "+value,value);
		}
		clearSelection();
	}
	
	public PocIntegerListBox(String id, Integer begin, Integer end) {
		this(begin, end);
		getElement().setId(id);
	}

	public void clearSelection() {
		setSelectedIndex(NULL_INDEX);
	}

	
	public Integer getIntegerValue(){
		return Integer.parseInt(getValue(getSelectedIndex()));
	}
	
	public void setValue(Integer integer){
		for (int i = 0; i < getItemCount(); i++) {
			int value = Integer.parseInt(getValue(i));
			if(integer.equals(value)){
				setSelectedIndex(i);
			}
		}
	}
	
	public List<Integer> getValues() {
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < getItemCount(); i++) {
			values.add(Integer.parseInt(getValue(i)));
		}
		return values;
	}
	
	public boolean validate() {
		if( getSelectedIndex() != NULL_INDEX){
			removeStyleName(ERROR_STYLENAME);
			Log.debug("ListBox validation OK");
			return true;
		}
		addStyleName(ERROR_STYLENAME);
		Log.debug("ListBox validation KO");
		return false;
	}
	public String getErrorMessage() {
		return "You must select one";
	}

	public void mask() {
		Log.debug("maskable mask");
		addStyleName(PocStyleMasker.MASK_STYLE_NAME);
	}
	
	public void unmask() {
		Log.debug("maskable unmask");
		removeStyleName(PocStyleMasker.MASK_STYLE_NAME);
	}

}
