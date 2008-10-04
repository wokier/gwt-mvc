package com.googlecode.gwtmvc.stm.client.controller;

import java.util.HashSet;
import java.util.Set;

import com.googlecode.gwtmvc.stm.client.model.BBoolean;
import com.googlecode.gwtmvc.stm.client.model.Disposable;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.Model.Listener;

/**
 * In logic and/or mathematics, logical conjunction or "and" is a two-place
 * logical operation that results in a value of true if both of its operands are
 * true, otherwise a value of false.
 * 
 * @author Igor Mihalik
 * 
 */
public class ConjunctionValidator implements Listener<Boolean>, Model<Boolean>,
		Disposable {

	private Set<BBoolean> vals;
	private final BBoolean result;

	public ConjunctionValidator(BBoolean... booleanModels) {
		this(new BBoolean(), booleanModels);
		subscribe();
	}

	public ConjunctionValidator(BBoolean result, BBoolean... booleanModels) {
		this.result = result;
		vals = new HashSet<BBoolean>();
		if (booleanModels != null)
			for (BBoolean validator : booleanModels)
				vals.add(validator);
	}

	private void subscribe() {
		for (BBoolean val : vals)
			val.addModelListener(this);
		updateResult();
	}

	public void dispose() {
		for (BBoolean val : vals)
			val.removeModelListener(this);
	}

	public void onChange(Event<Boolean> event) {
		updateResult();
	}

	private void updateResult() {
		boolean res = true;
		for (BBoolean val : vals)
			if (val.getValue())
				res = false;
		result.setValue(res);
	}

	public BBoolean getValid() {
		return result;
	}

	public void addModelListener(Listener<Boolean> listener) {
		result.addModelListener(listener);

	}

	public Boolean getValue() {
		return result.getValue();
	}

	public void removeModelListener(Listener<Boolean> listener) {
		result.removeModelListener(listener);
	}

	public void setValue(Boolean value) {
		// TODO Auto-generated method stub

	}
}
