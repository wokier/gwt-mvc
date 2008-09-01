package com.googlecode.gwtmvc.client;

import java.util.HashMap;
import java.util.Map;

/**
 * The controller responds to user gestures, and select the correct view.<br>
 * 
 * USAGE: The controller knows its models and can call their methods.
 */
public abstract class Controller {

	protected Map<String, View> views = new HashMap<String, View>();

	/**
	 * Empty Constructor
	 */
	public Controller() {
	}

	/**
	 * Initialise the controller by rendering the initial view
	 * 
	 */
	public abstract void init();

	/**
	 * Manages user gestures
	 * 
	 * @param event
	 */
	public abstract void onUserGesture(Event event);

	/**
	 * Adds a view managed by this controller
	 * 
	 * @param view
	 */
	protected void add(View view) {
		views.put(view.getKey(), view);
	}

	protected void updateModel(Model model, Object value) {
		model.update(value);
	}
	
	protected void initModel(Model model) {
		model.init();
	}

	// /**
	// * Removes this view from views managed by this controller
	// *
	// * @param view
	// */
	// public void remove(View view) {
	// views.remove(view.getKey());
	// }
}
