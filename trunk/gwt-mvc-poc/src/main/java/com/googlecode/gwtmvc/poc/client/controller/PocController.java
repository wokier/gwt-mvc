package com.googlecode.gwtmvc.poc.client.controller;

import java.util.Map;

import com.allen_sauer.gwt.log.client.Log;
import com.googlecode.gwtmvc.client.BrowserEvent;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.place.DivWrapperPlacer;
import com.googlecode.gwtmvc.client.place.DomPlacer;
import com.googlecode.gwtmvc.poc.client.model.PocModel;
import com.googlecode.gwtmvc.poc.client.view.PocViewGraphical;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumeric;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumericB;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumericWithMaskable;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumericWithStyleMasker;
import com.googlecode.gwtmvc.poc.client.view.PocViewNumericWithVisibleMasker;

public class PocController extends Controller {

	public enum PocAction {
		SHOW_SIMPLE, SHOW_COMPLEX, SHOW_MASKABLE, SHOW_STYLE_MASKER, SHOW_VISIBLE_MASKER, DO_PLUS_A, DO_MINUS_A, DO_REINIT_A, DO_PLUS_B, DO_MINUS_B, DO_REINIT_B, SHOW_URLPARAMS
	}

	protected IView<Integer> pocViewNumeric;
	protected IView<Integer> pocViewNumericB;
	protected IView<Integer> pocViewGraphical;
	protected IView<Integer> pocViewNumericWithMaskable;
	protected IView<Integer> pocViewNumericWithStyleMasker;
	protected IView<Integer> pocViewNumericWithVisibleMasker;

	protected PocModel modelA, modelB;

	protected DomPlacer content;

	public PocController() {
		this(new PocModel(), new PocModel());
	}
	
	protected PocController(Controller child) {
		super(PocAction.values(),child);
	}
	
	protected PocController(PocModel modelA, PocModel modelB) {
		this(new PocControllerChild(modelA, modelB));
		this.modelA = modelA;
		this.modelB = modelB;
	}
	

	@Override
	public void init() {
		Log.debug("Controller init");

		if (pocViewNumeric == null)
			pocViewNumeric = new PocViewNumeric(this, modelA);
		if (pocViewNumericB == null)
			pocViewNumericB = new PocViewNumericB(this, modelB);
		if (pocViewGraphical == null)
			pocViewGraphical = new PocViewGraphical(this, modelA, modelB);

		if (pocViewNumericWithMaskable == null)
			pocViewNumericWithMaskable = new PocViewNumericWithMaskable(this, modelA);
		if (pocViewNumericWithStyleMasker == null)
			pocViewNumericWithStyleMasker = new PocViewNumericWithStyleMasker(this, modelA);
		if (pocViewNumericWithVisibleMasker == null)
			pocViewNumericWithVisibleMasker = new PocViewNumericWithVisibleMasker(this, modelA);

		
		initModel(modelA);
		initModel(modelB);

		if (content == null) {
			content = new DivWrapperPlacer("content"){
				public void add(IView view) {
					Log.debug(toString() + " add "+ view);
					super.add(view);
				}
			};
		}
	}

	@Override
	public void showHomeView() {

	}

	@Override
	protected void handleEvent(MvcEvent event) {
		Log.debug("Controller handleEvent " + event);

		PocAction action = (PocAction) event.getAction();

		switch (action) {
		case SHOW_SIMPLE:
			content.clearAndAdd(pocViewNumeric);
			break;
		case SHOW_COMPLEX:
			content.clearAndAdd(pocViewNumeric);
			content.add(pocViewNumericB);
			content.add(pocViewGraphical);
			break;
		case SHOW_MASKABLE:
			content.clearAndAdd(pocViewNumericWithMaskable);
			break;
		case SHOW_STYLE_MASKER:
			content.clearAndAdd(pocViewNumericWithStyleMasker);
			break;
		case SHOW_VISIBLE_MASKER:
			content.clearAndAdd(pocViewNumericWithVisibleMasker);
			break;
		case DO_PLUS_A:
			modelA.plus((Integer) event.getValue(), event);
			break;
		case DO_PLUS_B:
			modelB.plus((Integer) event.getValue(), event);
			break;
		case DO_MINUS_A:
			modelA.minus((Integer) event.getValue(), event);
			break;
		case DO_MINUS_B:
			modelB.minus((Integer) event.getValue(), event);
			break;
		case DO_REINIT_A:
			modelA.reinit(event);
			break;
		case DO_REINIT_B:
			modelB.reinit(event);
			break;
		case SHOW_URLPARAMS:
			content.clearAndAdd(pocViewNumeric);
			Integer modelAParamValue = Integer.valueOf(getUrlParam("modelA"));
			updateModel(modelA, modelAParamValue, event);
			break;
		default:
			Log.debug("Unknown action");
		}
	}

	@Override
	@Deprecated
	protected void renderView(IView view) {

	}

	@Override
	protected MvcEvent tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent) {
		return super.tryConvertBrowserEventToControllerEvent(browserEvent);
	}

	@Override
	public Map<String, String> getUrlParamsMap() {
		return super.getUrlParamsMap();
	}

}
