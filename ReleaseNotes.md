## v0.4 ##
2010-01-08

## New Features ##

  * Form validation with messages on each field
  * Create a MVCHyperlink widget
  * Fix of [Issue 8](http://code.google.com/p/gwt-mvc/issues/detail?id=8&can=1)

## Demo ##

  * Form validation with messages on each field
  * Exception Handling
  * Hierachical MVC


## v0.3 ##
2009-08-24

## New Features ##

  * Add normalized url arguments
  * Enable decorator/layout pattern to structure multi-view screens [Post in Group](http://groups.google.com/group/gwt-mvc/browse_thread/thread/bba0671fb490bdb7): DomPlacer
  * Hierachical controller (for all Events, not only browser events)
  * Simple Exception Handling [Post in Group](http://groups.google.com/group/gwt-mvc/browse_thread/thread/a826a8b6b5a458fa)
  * Distinction between StyleMasker and VisibleMasker

There is only one version for all gwt versions from gwt-1.5 to gwt-1.7
The lazyPanel class is just copied into gwt-mvc library.

## v0.2.1-gwt1.6 ##
2009-06-09

Just commented this line in GwtMvc.gwt.xml, as there is no dependency to incubator for gwt1.6 :

`<!-- <inherits name='com.google.gwt.widgetideas.BasicWidget' />-->`

# v0.2 #
2009-06-08

## Features ##

  * Add 'standard' 404 page when historyToken is unknown, in the MvcEntryPoint
  * Manage simple form validation, with a Form and a FormValidationBuilder
  * Base the view on a LazyPanel instead of Composite
  * The action Enum in a controller is just passed in the constructor, avoiding getActionEnumValues and tryConvertBrowserEventToControllerEvent boring methods.

We choosed to have 2 release, for different gwt version, mainly because the LazyPanel class has been moved from gwt-incubator project to gwt (regular) project, with a change of package. That is the only change between this 2 releases of the same gwt-mvc version.

## Demo ##

  * gwt-log project allows us to show what appens
  * Masker and maskable system was on project since 0.0.1 but not on the demo.
  * Simple Form Validation
  * 404 token exemple

## v0.0.1 for GWT 1.5.3 ##

## Features ##

The main advantages we would like to expose are:
  * The controllers are testables.
  * A controler defines its action by an enum.
  * We recommand to call the action with a prefix but it is not required.
    * SHOW_to render one or more views
    * DO_ to call an action on the model, eventually a RPC call
    * GET_to (re)load a model, eventually with a RPC call
    * OPEN_ to open a new popup or window
  * The model updates the views listening him in respect of the asynchronous call.
  * As a view is only a composite (container), it could be a unique componant, or multiple componant(a form for example)

## Demo ##

In the early start, we'd like to show a real example of how this could work.
So we have two projects: gwt-mvc and gwt-mvc-poc (Proof Of Concept).