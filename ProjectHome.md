GWT MVC project's aim is to create a layer on top Google Web Toolkit's widget library capable of implementing RIAs in easier and more guided way based on a Model-View-Controller design pattern for the client part.

The MVC of gwt-mvc is a client-hierarchical-mvc

## Project Goals ##

### Easy to read controller ###
Different actions available on a controller are described with an enumeration.

### History Tokens ###
The user actions are managed as the browser actions, making the bookmarking easier.

### Test Driven Development ###
The controllers are testable with simple Test Case (not Gwt Test Case).

### Hierarchical MVC ###
The controller hierarchy allows to delegate a part of a controller responsibilities to its children.

### Loading notification ###
The notification of a long process or an asynchronous call is simplified by a 'maskable', that could be called at each MvcEvent

### Lazy Initialisation ###
Each component has a mechanism to differ the initilalisation from the constructor.

### Forms ###
gwt-mvc contains facilities to build and validate forms.


## Project Non-Goals ##
There's no goal to create or design new widgets.

&lt;wiki:gadget url="http://www.ohloh.net/p/20104/widgets/project\_partner\_badge.xml" height="53"  border="0" /&gt;