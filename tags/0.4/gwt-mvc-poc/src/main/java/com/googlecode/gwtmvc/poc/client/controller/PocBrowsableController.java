package com.googlecode.gwtmvc.poc.client.controller;

import java.util.List;

import com.googlecode.gwtmvc.client.Controller;

public abstract class PocBrowsableController extends Controller {
	
	public PocBrowsableController(Controller... children) {
		super(children);
	}

	public PocBrowsableController(Enum[] actionEnumValues, Controller... children) {
		super(actionEnumValues, children);
	}

	public PocBrowsableController(Enum[] actionEnumValues) {
		super(actionEnumValues);
	}

	@Override
	public List<Enum> getActionEnumValues() {
		return super.getActionEnumValues();
	}
	
	@Override
	public List<Controller> getChildren() {
		return super.getChildren();
	}
	
}
