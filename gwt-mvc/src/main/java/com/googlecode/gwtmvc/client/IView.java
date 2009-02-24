package com.googlecode.gwtmvc.client;
/**
 * The view is the graphical part of the application get datas from model use
 * controler to action on the system.
 * 
 * This interface dont use any GWT class, but View did.
 * @param <D> type
 */
public interface IView<D> extends IModelListener<D> {

	/**
	 * Enable to initialise the view elsewhere than in the constructor. It could
	 * be used to REinitialise the view.
	 * @deprecated replaced by lazyPanel in View
	 */
	public abstract void init();


	/**
	 * @return key of this view
	 */
	public abstract String getKey();

}