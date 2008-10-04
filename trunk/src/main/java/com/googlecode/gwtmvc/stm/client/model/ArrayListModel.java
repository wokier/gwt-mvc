package com.googlecode.gwtmvc.stm.client.model;

import java.util.ArrayList;
import java.util.List;

public class ArrayListModel<T> extends ModelAdapter<List<T>> {

	public ArrayListModel() {
		this(new ArrayList<T>());
	}

	public ArrayListModel(List<T> initValue) {
		super(initValue);
	}

}
