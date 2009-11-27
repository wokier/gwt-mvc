package com.googlecode.gwtmvc.poc.client.controller;

import java.util.Arrays;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.poc.client.model.PocModel;

public class PocControllerChild extends Controller {

	public enum ChildAction{DO_REINIT_ALL}
	
	List<PocModel> models;
	
	public PocControllerChild(PocModel... models) {
		super(ChildAction.values());
		this.models = Arrays.asList(models); 
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void showHomeView() {
		
	}
	
	@Override
	protected void handleEvent(MvcEvent event) {
		Log.debug("Child Controller handleEvent "+event);
		ChildAction action = (ChildAction)event.getAction();
		switch (action) {
		case DO_REINIT_ALL:
			for (PocModel model : models) {
				model.update((Integer)event.getValue(),event);
			}
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void renderView(IView view) {
		
	}
	
	@Override
	public boolean couldHandleUserEvent(MvcEvent event) {
		return super.couldHandleUserEvent(event);
	}
	
	@Override
	public void doInitIfNecessary() {
		super.doInitIfNecessary();
	}
	
	@Override
	public void handleUserEvent(MvcEvent event) {
		super.handleUserEvent(event);
	}
	
	
}
