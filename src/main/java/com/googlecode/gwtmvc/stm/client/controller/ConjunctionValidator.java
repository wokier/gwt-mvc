package com.googlecode.gwtmvc.stm.client.controller;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.gwtmvc.stm.client.model.BooleanModel;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;
import com.googlecode.gwtmvc.stm.client.model.Model.Listener;

/**
 * In logic and/or mathematics, logical conjunction or "and" is a two-place
 * logical operation that results in a value of true if both of its operands are
 * true, otherwise a value of false.
 * 
 * @author Igor Mihalik
 * 
 */
public class ConjunctionValidator extends SimplePanel implements
		Listener<Boolean>, Validator {

	private Set<BooleanModel> vals;
	private final BooleanModel result;

	public ConjunctionValidator(BooleanModel... booleanModels) {
		this(new BooleanModel(), booleanModels);
	}

	public ConjunctionValidator(BooleanModel result,
			BooleanModel... booleanModels) {
		this.result = result;
		vals = new HashSet<BooleanModel>();
		if (booleanModels != null)
			for (BooleanModel validator : booleanModels)
				vals.add(validator);
	}

	@Override
	protected void onLoad() {
		for (BooleanModel val : vals)
			val.addModelListener(this);
		updateResult();
	}

	@Override
	protected void onUnload() {
		for (BooleanModel val : vals) {
			val.removeModelListener(this);
		}
	}

	public void onChange(Event<Boolean> event) {
		updateResult();
	}

	private void updateResult() {
		boolean res = true;
		for (BooleanModel val : vals)
			if (val.getValue())
				res = false;
		result.setValue(res);
	}

	public BooleanModel getValid() {
		return result;
	}
}
