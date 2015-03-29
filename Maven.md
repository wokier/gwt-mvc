Add maven2 gwt-mvc dependency

## Repository ##
gwt-mvc has its own repository.
http://gwt-mvc.googlecode.com/svn/repository

## Declare gwt-mvc dependency ##

Change your pom.xml as follow

Add the gwt-mvc repository in the repositories part
```
<repository>
	<id>gwt-mvc</id>
	<name>GWT MVC repository at googlecode</name>
	<url>http://gwt-mvc.googlecode.com/svn/repository</url>
</repository>
```

Add the gwt-mvc dependency in the dependencies part
```
<dependency>
	<groupId>com.googlecode.gwt-mvc</groupId>
	<artifactId>gwt-mvc</artifactId>
	<version>0.4</version>
</dependency>
```

Note 1: The groupId has changed between version 0.3 and 0.4 from gwt-mvc to com.googlecode.gwt-mvc

Note 2: There is no more differents verision of gwt-mvc depending on your gwt version.
gwt-mvc now cover all version since gwt 1.5
(LazyPanel is now simply copied in the library)

## Declare gwt-mvc module ##
Just follow the [Installation Guide](http://code.google.com/p/gwt-mvc/wiki/Installation)

## Mavenise your gwt project ##
I recommend this project to help you
http://code.google.com/p/gwt-maven/

The demo will be converted to it.
(The old version totsp was used before)