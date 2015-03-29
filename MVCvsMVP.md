# MVC vs MVP #

It exists particular variation of MVC called MVP (Model View Presenter), and since GWT 1.6 a general approach of implementation called "Event Bus".

This page explain how it works, based on gwt 2.0 Contacts sample.
[MVP architecture](http://code.google.com/webtoolkit/doc/latest/tutorial/mvp-architecture.html)

You could also read :

[GWT Best Practices](http://code.google.com/intl/fr-FR/events/io/sessions/GoogleWebToolkitBestPractices.html)

[onGwt MVP links](http://www.ongwt.com/post/2009/08/16/GWT-MVP-(Model-View-Presenter)-Link-directory)

## MVC ##
![http://gwt-mvc.googlecode.com/svn/wiki/mvc.png](http://gwt-mvc.googlecode.com/svn/wiki/mvc.png)

The View use the controller and listen to some models.
The Controller acts on the model , place and render the views.
The Model calls the server, wait for the asynchronous callback, and notify the views.

http://code.google.com/p/gwt-mvc/wiki/UML

## MVP ##
![http://gwt-mvc.googlecode.com/svn/wiki/mvp.png](http://gwt-mvc.googlecode.com/svn/wiki/mvp.png)

The View use the controller.
The Controller use the model and wait for the callback, then place, render the views and give datas from the model to the views.
The Model calls the server, wait for the asynchronous callback, and notify the controller.

With MVP, the controller, here called presenter, pushed the
datas of the model to the view, instead of (in mvc), that the view
read the model as it renders.
gwt-mvc does not fit to MVP because the model changes are directly
listen by the view, without passing throught the controller/presenter.

## gwt-mvc ##
The problem we are facing with MVC for GWT, is that we (java
developers) are trying to give an answer to a well-known problem, that
we have already faced before with technologies such as struts or
springMVC, and now stripes.
But now, we are not in server-mode only, we are in a client-mode with
asynchronous calls.
So the answer cant be the same. This problem is common to all RIA technologies.
Each of them give its own answer.

I was interested in PureMVC
http://trac.puremvc.org/PureMVC_Java_MultiCore , because it offers a
generic solution, that could be applied to any language/technology.
But the promise was to big, and a was disappointed, because it does
not fit to gwt. too much generic...

## Conclusion ##

gwt-mvc tries to offer a guide for the developer, that really fit to
gwt (EntryPoint, historyTokens, ...), and that allows to develop in
TDD.

Plus gwt-mvc is really a framework, not an approach or an exemple.