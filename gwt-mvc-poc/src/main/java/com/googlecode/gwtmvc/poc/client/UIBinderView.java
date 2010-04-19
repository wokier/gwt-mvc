package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelProxy;
import com.googlecode.gwtmvc.client.View;
/**
 * UIBinder view
 *
 */
public abstract class UIBinderView extends View<Object, Widget> {

	/**
	 * Element wrapper
	 * 
	 */
	protected class ElementWrapper extends Widget {
		public ElementWrapper() {
			super();
		}

		public void wrap(DivElement elem) {
			super.setElement(elem);
		}
	}

	private UiBinder<DivElement, UIBinderView> binder;

	public UIBinderView(UiBinder<DivElement, ? extends UIBinderView> binder,
			String id, Controller controller, ModelProxy... models) {
		super(id, controller, models);
		this.binder = (UiBinder<DivElement, UIBinderView>) binder;
	}

	@Override
	public Widget createWidget() {
		ElementWrapper wrapper = new ElementWrapper();
		wrapper.wrap(binder.createAndBindUi(this));
		return wrapper;
	}
}
