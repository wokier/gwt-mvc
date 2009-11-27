package com.googlecode.gwtmvc.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.googlecode.gwtmvc.client.exception.UnavailableActionException;
import com.googlecode.gwtmvc.client.place.DomPlacer;

/**
 * The controller acts as a coordinator. It responds to user gestures, call the
 * model and select the correct view to render.<br>
 * 
 * USAGE: The controller knows its models and can call their methods. The
 * controller knows its view and can render them.<br>
 * To render the view, the controller could place them and render them himself, or use a DomPlacer. <br>
 * Create an inner Enum class of the possible actions, and pass its values in
 * the constructor to enable the event Handling.
 * 
 * @see Model
 * @see View
 * @see DomPlacer
 */
public abstract class Controller {

	private Controller parent;
	protected List<Controller> children = new ArrayList<Controller>();

	private boolean initialised;

	private List<Enum> actionEnumValues = new ArrayList<Enum>();

	protected Map<String, String> urlParamsMap = new HashMap<String, String>();

	/**
	 * Constructor with action values, for a controller without children
	 * 
	 * @param actionEnumValues
	 */
	public Controller(Enum[] actionEnumValues) {
		super();
		this.actionEnumValues = Arrays.asList(actionEnumValues);
	}

	/**
	 * Constructor with children, for a controller that does not handle any event, but forward all to its children
	 * 
	 * @param children
	 */
	public Controller(Controller... children) {
		super();
		addChildren(children);
	}

	/**
	 * Constructor with values and children
	 * 
	 * @param actionValues
	 * @param children
	 */
	public Controller(Enum[] actionEnumValues, Controller... children) {
		this(actionEnumValues);
		addChildren(children);
	}
	
	private void addChildren(Controller... children) {
		this.children = Arrays.asList(children);
		for (Controller child : children) {
			child.parent = this;
		}
	}

	/**
	 * Initialise the controller. This method is called at the first time the
	 * controller handle an event. <br>Use doInitIfNecessary if you want the controller to be initialised in other cases.
	 */
	protected abstract void init();

	/**
	 * Show the default page for this controller.<br>
	 * This could be the application Home Page, for the rootController,
	 * or an intermedaite 'home' page for other controllers.
	 */
	public abstract void showHomeView();

	/**
	 * Manages user gestures and browser events. User gesture must
	 * programatically be redirected to this method with corrects parameters.
	 * Browser events are automatically redirected to this method, without
	 * arguments. Auto-initalise the controller if necessary.
	 * 
	 * @param event
	 */
	public void call(MvcEvent event) {
		if (couldHandleUserEvent(event)) {
			handleUserEvent(event);
		} else {
			boolean eventHandledByChild = handleUserActionByChildren(event);
			if(!eventHandledByChild){
				throw new UnavailableActionException("You have tried to use an action anavailable at this level of the controller's tree :"+this+" with this event :"+event);
			}
		}
	}

	private boolean handleUserActionByChildren(MvcEvent event) {
		for (Controller child : children) {
			if (child.couldHandleUserEvent(event)) {
				child.handleUserEvent(event);
				return true;
			}
		}
		return false;
	}

	protected boolean couldHandleUserEvent(MvcEvent event) {
		return actionEnumValues.contains(event.getAction());
	}

	protected void handleUserEvent(MvcEvent event) {
		doInitIfNecessary();
		beginWait(event);
		handleEvent(event);
	}

	/**
	 * Allow the controller to be initialised only once. The initialisation is
	 * done at the first call of this controller.
	 */
	protected void doInitIfNecessary() {
		if (!initialised) {
			init();
			initialised = true;
		}
	}

	private void beginWait(MvcEvent event) {
		if (event.getMaskable() != null) {
			event.getMaskable().mask();
		}
	}

	/**
	 * Manages user gestures.<br>
	 * This method should not be called directly, Use call instead, to allow the
	 * controller to be initialised and to allow the maskable system.<br>
	 * Implements this method by 'switching' the different events available for this controller.
	 * 
	 * @param event
	 */
	protected abstract void handleEvent(MvcEvent event);

	/**
	 * Place the view on the dom tree, and 'render' it.
	 * You could use a Dom Placer for that.
	 * 
	 * @see IView#render()
	 * @see DomPlacer
	 * 
	 * @param view
	 */
	protected abstract void renderView(IView view);

	/**
	 * Call the update method on the model, as the method update can only be
	 * called by a controller, or the model itself.
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
	 * Call the update method on the model, as the method update can only be
	 * called by a controller. Add the causeEvent allows to use the Maskable.
	 * 
	 * @param <M>
	 *            model data type
	 * @param model
	 * @param value
	 * @param causeEvent
	 */
	protected <M> void updateModel(Model<M> model, M value, MvcEvent causeEvent) {
		model.update(value, causeEvent);
	}

	/**
	 * Call the init method on the model, as the method init can only be called
	 * by a controller.
	 * 
	 * @param model
	 */
	protected void initModel(Model model) {
		model.init();
		model.initialised = true;
	}

	/**
	 * Try to convert the event
	 * 
	 * @param browserEvent
	 * @return a new event if the controller could handle it, null if the
	 *         browser Event token dont match with any action.
	 */
	protected MvcEvent tryConvertBrowserEventToControllerEvent(BrowserEvent browserEvent) {
		Enum actionEnumValue = actionEnumValueOf(browserEvent.getAction());
		if (actionEnumValue == null) {
			return null;
		}
		urlParamsMap = browserEvent.getParams();
		return new MvcEvent(actionEnumValue);
	}

	private Enum actionEnumValueOf(String action) {
		for (Enum actionEnumValue : actionEnumValues) {
			if (actionEnumValue.name().equals(action)) {
				return actionEnumValue;
			}
		}
		return null;
	}

	/**
	 * Manages history. use the controller itself or his childs to handle the
	 * browser event. You should not call this method directly.
	 * 
	 * @param browserEvent
	 * @return true if the historyToken match to an action on any controller
	 */
	protected boolean handleBrowserEvent(BrowserEvent browserEvent) {
		if (handleBrowserEventMyself(browserEvent)){
			return true;
		}
		return handleBrowserEventByChildren(browserEvent);
	}

	private boolean handleBrowserEventByChildren(BrowserEvent browserEvent) {
		for (Controller child : children) {
			MvcEvent event = child.tryConvertBrowserEventToControllerEvent(browserEvent);
			if (event != null) {
				child.call(event);
				return true;
			}
		}
		return false;
	}

	private boolean handleBrowserEventMyself(BrowserEvent browserEvent) {
		MvcEvent event = tryConvertBrowserEventToControllerEvent(browserEvent);
		if (event != null) {
			call(event);
			return true;
		}
		return false;
	}

	/**
	 * Give wether the controller has been initialised or not
	 * 
	 * @return true if it had been initialised
	 */
	public boolean isInitialised() {
		return initialised;
	}

	/**
	 * Give the url params used when the controller has been called by a browser
	 * event.
	 * 
	 * @see BrowserEvent
	 * @return
	 */
	protected Map<String, String> getUrlParamsMap() {
		return urlParamsMap;
	}

	/**
	 * Give a specific param used when the controller has been called by a
	 * browser event.
	 * 
	 * @see BrowserEvent
	 * @param param
	 *            paramName (before the '=' character)
	 * @return
	 */
	public String getUrlParam(String param) {
		return urlParamsMap.get(param);
	}
	
	/**
	 * Give an acces to the root controller of this controllers tree
	 * @return
	 */
	public Controller getRootController() {
		Controller rootController = this;
		while (rootController.parent != null){
			rootController = rootController.parent;
		}
		return rootController;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (actionEnumValues !=null ? "actions :"+actionEnumValues :"") + (!children.isEmpty() ? " (children :"+ children+")":"");
	}

}
