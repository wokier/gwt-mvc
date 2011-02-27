package com.googlecode.gwtmvc.client.binder;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelProxy;
import com.googlecode.gwtmvc.client.View;

/**
 * UIBinder (widget) view<br>
 * The ui.xml must start with a g:HTMLPanel tag
 */
public abstract class UIBinderView extends View<Object, Widget> {

    private UiBinder<HTMLPanel, UIBinderView> binder;

    /**
     * Constructor
     * 
     * @param binder
     * @param id
     * @param controller
     * @param models
     */
    public UIBinderView(UiBinder<HTMLPanel, ? extends UIBinderView> binder, String id, Controller controller, ModelProxy... models) {
	super(id, controller, models);
	this.binder = (UiBinder<HTMLPanel, UIBinderView>) binder;
    }

    /**
     * @see com.googlecode.gwtmvc.client.View#createWidget()
     */
    @Override
    public Widget createWidget() {
	return binder.createAndBindUi(this);
    }
}
