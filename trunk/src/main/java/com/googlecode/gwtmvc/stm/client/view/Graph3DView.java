package com.googlecode.gwtmvc.stm.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

public class Graph3DView extends Composite implements
		Model.Listener<List<Integer>> {

	private final Model<List<Integer>> model;
	private final Image image;

	public Graph3DView(Model<List<Integer>> model) {
		this.model = model;
		image = new Image();
		initWidget(image);
		setWidth("300px");
	}

	public void onChange(Event<List<Integer>> event) {
		List<Integer> value = event.getSource().getValue();
		StringBuffer series = new StringBuffer();
		for (int i = 0; i < value.size(); i++) {
			series.append(value.get(i));
			if (i != value.size() - 1)
				series.append(",");
		}
		image.setUrl("http://chart.apis.google.com/chart?cht=p3&chd=t:"
				+ series + "&chs=300x125");
	}

	@Override
	protected void onUnload() {
		this.model.removeModelListener(this);
	}

	@Override
	protected void onLoad() {
		this.model.addModelListener(this);
	}

}
