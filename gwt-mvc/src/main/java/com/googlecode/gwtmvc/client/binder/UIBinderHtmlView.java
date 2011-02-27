package com.googlecode.gwtmvc.client.binder;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelProxy;
import com.googlecode.gwtmvc.client.View;

/**
 * UIBinder Html view<br>
 * The ui.xml must start with a div tag
 */
public abstract class UIBinderHtmlView extends View<Object, Widget> {

    /**
     * Element wrapper
     * 
     */
    private class ElementWrapper extends Widget {
	protected ElementWrapper() {
	    super();
	}

	public void wrap(DivElement elem) {
	    super.setElement(elem);
	}
    }

    private UiBinder<DivElement, UIBinderHtmlView> binder;

    /**
     * Constructor
     * 
     * @param binder
     * @param id
     * @param controller
     * @param models
     */
    public UIBinderHtmlView(UiBinder<DivElement, ? extends UIBinderHtmlView> binder, String id, Controller controller, ModelProxy... models) {
	super(id, controller, models);
	this.binder = (UiBinder<DivElement, UIBinderHtmlView>) binder;
    }

    /**
     * @see com.googlecode.gwtmvc.client.View#createWidget()
     */
    @Override
    public Widget createWidget() {
	ElementWrapper wrapper = new ElementWrapper();
	wrapper.wrap(binder.createAndBindUi(this));
	return wrapper;
    }
}
