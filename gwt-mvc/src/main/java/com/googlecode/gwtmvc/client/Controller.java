package com.googlecode.gwtmvc.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The controller responds to user gestures, and select the correct view.<br>
 * 
 * USAGE: The controller knows its models and can call their methods.
 */
public abstract class Controller {

	protected Map<String, View> views = new HashMap<String, View>();

	private List<Controller> childs = new ArrayList<Controller>();

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
	public abstract void handleUserEvent(Event event);

	/**
	 * Adds a view managed by this controller
	 * 
	 * @param view
	 */
	protected void addView(View view) {
		views.put(view.getKey(), view);
	}

	/**
	 * call the update method on the model, as the method update can only be
	 * called by a controller.
	 * 
	 * @param model
	 * @param value
	 */
	protected void updateModel(Model model, Object value) {
		model.update(value);
	}

	/**
	 * call the init method on the model, as the method init can only be called
	 * by a controller.
	 * 
	 * @param model
	 */
	protected void initModel(Model model) {
		model.init();
	}

	/**
	 * Removes this view from views managed by this controller
	 * 
	 * @param view
	 */
	public void remove(View view) {
		views.remove(view.getKey());
	}

	/**
	 * Add a child
	 * 
	 * @param child
	 */
	protected void addChild(Controller child) {
		childs.add(child);
	}

	/**
	 * The action enumeration available for this controller
	 * 
	 * @return
	 */
	protected abstract Enum[] getActionEnumValues();

	/**
	 * Try to convert the event
	 * 
	 * @param browserEvent
	 * @return a new event if the controller coul handle it, null otherwise
	 * @throws IllegalArgumentException
	 *             if the browser Event token dont match with any action
	 */
	protected abstract Event tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent)
			throws IllegalArgumentException;

	/**
	 * Manages history. use the controller itself or his childs to handle the
	 * browser event
	 * 
	 * @param browserEvent
	 */
	public void handleBrowserEvent(BrowserEvent browserEvent) {
		if (!handleBrowserEventMyself(browserEvent)) {
			if (!handleBrowserEventByChilds(browserEvent)) {
				throw404Error();
			}
		}
	}

	private boolean handleBrowserEventByChilds(BrowserEvent browserEvent) {
		for (Controller child : childs) {
			try {
				Event event = child.tryConvertBrowserEventToControllerEvent(browserEvent);
				child.handleUserEvent(event);
				return true;
			} catch (IllegalArgumentException e) {
				// next
			}
		}
		return false;
	}

	private boolean handleBrowserEventMyself(BrowserEvent browserEvent) {
		try {
			Event event = tryConvertBrowserEventToControllerEvent(browserEvent);
			handleUserEvent(event);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}

	}
	
	private void throw404Error() {
		// TODO : redirect to NotFound page in gwt
		throw new RuntimeException("404");
	}
}
