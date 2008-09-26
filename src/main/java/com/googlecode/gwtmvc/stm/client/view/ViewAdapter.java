package com.googlecode.gwtmvc.stm.client.view;

import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.stm.client.model.BooleanModel;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

abstract class ViewAdapter<T, E extends Widget> extends Composite implements
		Model.Listener<T>, ChangeListener, ClickListener, KeyboardListener {
	protected Model<T> model = null;

	protected E widget = null;

	private BooleanModel enabled = new BooleanModel(Boolean.TRUE);
	private BooleanModel visible = new BooleanModel(Boolean.TRUE);

	private Model.Listener<Boolean> enabledListener = new Model.Listener<Boolean>() {
		public void onChange(Event<Boolean> event) {
			enable(event.getSource().getValue());
		}
	};

	private Model.Listener<Boolean> visibleListener = new Model.Listener<Boolean>() {
		public void onChange(Event<Boolean> event) {
			setVisible(event.getSource().getValue());
		}
	};

	public ViewAdapter(Model<T> model, E widget) {
		this.widget = widget;
		this.model = model;
		initWidget(widget);
		createControllerRole();
	}

	abstract protected void enable(Boolean value);

	abstract protected void createControllerRole();

	abstract protected void updateView(Event<T> event);

	abstract protected void updateModel();

	@Override
	protected void onLoad() {
		model.addModelListener(this);
		enabled.addModelListener(enabledListener);
	}

	@Override
	protected void onUnload() {
		model.removeModelListener(this);
		enabled.removeModelListener(enabledListener);
	}

	public void setValue(final Model<T> model) {
		this.model.removeModelListener(this);
		this.model = model;
		this.model.addModelListener(this);
	}

	public void setEnabled(BooleanModel enabled) {
		this.enabled.removeModelListener(enabledListener);
		this.enabled = enabled;
		this.enabled.addModelListener(enabledListener);
	}

	public void setVisible(BooleanModel visible) {
		this.visible.removeModelListener(visibleListener);
		this.visible = visible;
		this.visible.addModelListener(visibleListener);
	}

	public E getWidget() {
		return widget;
	}

	public void onChange(Event<T> event) {
		updateView(event);
	}

	public void onChange(Widget sender) {
		updateModel();
	}

	public void onClick(Widget sender) {
		updateModel();
	}

	public void onKeyDown(Widget sender, char keyCode, int modifiers) {
		updateModel();
	}

	public void onKeyPress(Widget sender, char keyCode, int modifiers) {
		updateModel();
	}

	public void onKeyUp(Widget sender, char keyCode, int modifiers) {
		updateModel();
	}
}
