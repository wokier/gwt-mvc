## Best Practices 'auto' provided by gwt-mvc ##
  * LazyPanel : a view is only built when it became visible
  * Bookmarkability
  * Separation of concerns
  * Keep References : By having references on different views, a controller could place each of them multiple times, but only instanciate them once
  * Controller lazy init: The controller is only initialized at its first call


## Best Practices when using gwt-mvc ##
  * Display the maximum of elements in the initial html page
  * Notify each asynchronous call by using a maskable
  * Notify each form validation error with a visible sign and an error text
  * Use a controller hierarchy
  * Make a singleton for a shared model
  * Put ALL the design in CSS, just place the widget with GWT
  * Divide your css file into (at least) 3 files, 1 for html, 1 for gwt widgets, 1 for your widgets
  * Follow Usability best practices...