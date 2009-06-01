package com.googlecode.gwtmvc.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The controller acts as a coordinator. It responds to user gestures, call the
 * model and select the correct view to render.<br>
 * 
 * @see Model
 * @see View
 * 
 * USAGE: The controller knows its models and can call their methods. The
 * controller knows its view and can render them
 */
public abstract class Controller {

	private List<Controller> children = new ArrayList<Controller>();

	private boolean initialised;

	private Enum[] actionEnumValues;

	@Deprecated
	protected Map<String, IView> views = new HashMap<String, IView>();

	/**
	 * Empty Constructor
	 */
	public Controller() {
		super();
	}

	/**
	 * Constructor with action values
	 * 
	 * @param actionEnumValues
	 */
	public Controller(Enum[] actionEnumValues) {
		super();

	}

	/**
	 * Constructor with children
	 * 
	 * @param children
	 */
	public Controller(Controller... children) {
		super();
		for (Controller child : children) {
			addChild(child);
		}
	}

	/**
	 * Constructor with values and children
	 * 
	 * @param actionValues
	 * @param children
	 */
	public Controller(Enum[] actionEnumValues, Controller... children) {
		super();
		for (Controller child : children) {
			addChild(child);
		}
	}

	/**
	 * Initialise the controller This method is called at the first time the
	 * controller handle an event
	 */
	public abstract void init();

	/**
	 * Show the default page for this controller
	 */
	public abstract void showHomeView();

	/**
	 * Manages user gestures and browser events. User gesture must
	 * programatically be redirected to this method with corrects parameters.
	 * Browser events are automatically redirected to this method, without
	 * arguments. Auto-initalise the controller if necessary
	 * 
	 * @param event
	 */
	public void call(Event event) {
		if (!initialised) {
			this.init();
			initialised = true;
		}
		beginWait(event);
		handleEvent(event);
	}

	private void beginWait(Event event) {
		if (event.getMaskable() != null) {
			event.getMaskable().mask();
		}
	}

	/**
	 * Manages user gestures
	 * 
	 * @param event
	 */
	protected abstract void handleEvent(Event event);

	/**
	 * Adds a view managed by this controller
	 * 
	 * @param view
	 * @deprecated
	 */
	@Deprecated
	public void addView(IView view) {
		views.put(view.getKey(), view);
	}

	/**
	 * Place the view on the dom tree, and 'render' it
	 * 
	 * @see IView#render()
	 * 
	 * @param view
	 */
	protected abstract void renderView(IView view);

	/**
	 * call the update method on the model, as the method update can only be
	 * called by a controller.
	 * 
	 * @param <M>
	 *            model data type
	 * @param model
	 * @param value
	 */
	protected <M> void updateModel(Model<M> model, M value) {
		model.update(value);
	}

	/**
	 * call the update method on the model, as the method update can only be
	 * called by a controller.
	 * 
	 * @param <M>
	 *            model data type
	 * @param model
	 * @param value
	 * @param causeEvent
	 */
	protected <M> void updateModel(Model<M> model, M value, Event causeEvent) {
		model.update(value, causeEvent);
	}

	/**
	 * call the init method on the model, as the method init can only be called
	 * by a controller.
	 * 
	 * @param model
	 */
	protected void initModel(Model model) {
		model.init();
		model.initialised = true;
	}

	/**
	 * Removes this view from views managed by this controller
	 * 
	 * @param view
	 * @deprecated
	 */
	@Deprecated
	public void remove(IView view) {
		views.remove(view.getKey());
	}

	/**
	 * Add a child
	 * 
	 * @param child
	 * @deprecated pass children to the constructor instead
	 */
	@Deprecated
	protected void addChild(Controller child) {
		children.add(child);
	}

	/**
	 * The action enumeration available for this controller
	 * 
	 * @return the possible values od the enumeration
	 * @deprecated actions are passed via the constructor instead
	 */
	@Deprecated
	protected Enum[] getActionEnumValues() {
		return null;
	}

	/**
	 * Try to convert the event
	 * 
	 * @param browserEvent
	 * @return a new event if the controller could handle it, null otherwise
	 * @throws IllegalArgumentException
	 *             if the browser Event token dont match with any action. It is
	 *             the normal way to signal that this controller conldnt handle
	 *             this token
	 */
	protected abstract Event tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent)
			throws IllegalArgumentException;

	/**
	 * Manages history. use the controller itself or his childs to handle the
	 * browser event
	 * 
	 * @param browserEvent
	 * @return true if the historyToken match to an action on any controller
	 */
	protected boolean handleBrowserEvent(BrowserEvent browserEvent) {
		if (handleBrowserEventMyself(browserEvent))
			return true;
		return handleBrowserEventByChildren(browserEvent);
	}

	private boolean handleBrowserEventByChildren(BrowserEvent browserEvent) {
		for (Controller child : children) {
			try {
				Event event = child.tryConvertBrowserEventToControllerEvent(browserEvent);
				child.call(event);
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
			call(event);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}

	}

	/**
	 * Give wether the controller has been initialised or not
	 * 
	 * @return true if it had been initialised
	 */
	public boolean isInitialised() {
		return initialised;
	}

}
