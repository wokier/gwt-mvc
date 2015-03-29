## Introduction ##

GWT use history tokens to manage browser history.
It allows to identify a client state, and bookmark a page.

http://code.google.com/webtoolkit/doc/latest/DevGuideCodingBasicsHistory.html

http://google-web-toolkit.googlecode.com/svn/javadoc/2.0/com/google/gwt/user/client/History.html

http://google-web-toolkit.googlecode.com/svn/javadoc/2.0/com/google/gwt/event/logical/shared/ValueChangeHandler.html

http://google-web-toolkit.googlecode.com/svn/javadoc/2.0/com/google/gwt/user/client/ui/Hyperlink.html

## gwt-mvc ##

gwt-mvc had reused JSP conventions for the token.
Le token is composed like this: #ACTION?param1=value1&param2=value2

### Create an URL ###

You can use your browser or a bookmark to reach a known page.
and you can define links with MvcHyperlink.

http://gwt-mvc.googlecode.com/svn/site/0.4/apidocs/com/googlecode/gwtmvc/client/widget/MvcHyperlink.html
```
verticalPanel.add(new MvcHyperlink("Url parameters (value=5)",PocAction.SHOW_URLPARAMS , new MvcHyperlinkEntry("modelA","5")));
```

### Use the token ###

The params are available with the method getUrlParam in each controller.
```
content.clearAndAdd(pocViewNumeric);
Integer modelAParamValue = Integer.valueOf(getUrlParam("modelA"));
updateModel(modelA, modelAParamValue, event);
```
Exemple

http://gwt-mvc.googlecode.com/svn/trunk/gwt-mvc-poc/demo/0.4/com.googlecode.gwtmvc.poc.GwtMvcPoc/GwtMvcPoc.html#SHOW_URLPARAMS?modelA=5