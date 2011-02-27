package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Callback that allows to automatically update the model.
 * 
 * @param <T>
 */
public class ModelAutoCallback<T> implements AsyncCallback<T> {

    private ModelProxy<T> modelProxy;
    private MvcEvent cause;

    /**
     * Builds a ModelAutoCallback
     * 
     * @param modelProxy
     */
    public ModelAutoCallback(ModelProxy<T> modelProxy) {
	this.modelProxy = modelProxy;
    }

    /**
     * Builds a ModelAutoCallback with an event
     * 
     * @param modelProxy
     * @param cause
     */
    public ModelAutoCallback(ModelProxy<T> modelProxy, MvcEvent cause) {
	this.modelProxy = modelProxy;
	this.cause = cause;
    }

    /**
     * @see AsyncCallback#onSuccess(Object)
     * @Override
     */
    public void onSuccess(T result) {
	if (cause == null) {
	    modelProxy.update(result);
	} else {
	    modelProxy.update(result, cause);
	}

    };

    /**
     * @see AsyncCallback#onFailure(Throwable)
     * @Override
     */
    public void onFailure(Throwable caught) {
	if (cause == null) {
	    modelProxy.update(caught);
	} else {
	    modelProxy.update(caught, cause);
	}
    }
}
