# gwt-mvc 0.4 #

Follow this steps:
  * Have a look at the [Demo](http://gwt-mvc.googlecode.com/svn/trunk/gwt-mvc-poc/demo/0.2/com.googlecode.gwtmvc.poc.GwtMvcPoc/GwtMvcPoc.html)
  * Download the library
  * Add it to the project classpath (You can use [Maven](http://code.google.com/p/gwt-mvc/wiki/Maven) to do it)
  * Add the module to your '.gwt.xml' module file
  * Have a look at the Demo Source
  * Join the [group](http://groups.google.com/group/gwt-mvc) to ask your questions
  * Enjoy

## Add the module ##

Exemple (from the demo):
```
<module>
	<!-- Inherit the core Web Toolkit stuff. -->
	<inherits name='com.google.gwt.user.User' />

	<!-- GWT MVC -->
	<inherits name="com.googlecode.gwtmvc.GwtMvc" />

	<entry-point class="com.googlecode.gwtmvc.poc.client.PocEntryPoint" />

	<servlet path="/PocPlusRPC" class="com.googlecode.gwtmvc.poc.server.PocPlusRPCImpl"  />
	<servlet path="/PocMinusRPC" class="com.googlecode.gwtmvc.poc.server.PocMinusRPCImpl"  />
</module>
```

As in any gwt module:
The client part of the module will be available in your gwt client code.
The server part of the module will be available in your server code (Here is just for controller testing).

## Use the API ##
Here is some code exemple from the demo.

### Write an entryPoint ###
```
public class PocEntryPoint extends MvcEntryPoint {

	public PocEntryPoint() {
		super(new PocControllerMenu());
	}

        @Override
	protected void hideLoadingIndicator() {
		RootPanel.get("loading").setVisible(false);
	}

	public void onUncaughtException(Throwable e) {
		Window.alert(e.getMessage());
	}
	
	@Override
	protected void showPeripherals() {
		RootPanel.get("menu").add(new MyMenu());
	}
	
}
```

### Write a view ###
A view is a specific widget or container(here is a VerticalPanle) that listen one or many models.
```
public class PocViewNumeric extends View<Integer, VerticalPanel> {

	public static final String ID = "numericA";

	PocIntegerLabel component;

	public PocViewNumeric(PocController controller, Model model) {
		super(ID, controller, model);
	}

	@Override
	public VerticalPanel createWidget() {
		VerticalPanel panel = new VerticalPanel();
		
		component = new PocIntegerLabel("labelA");
		panel.add(component);

		Button plusButton = new Button("+1",new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.call(new MvcEvent<Integer>(PocAction.DO_PLUS_A, component.getValue()));
			}
		});
		panel.add(plusButton);

		return panel;
	}

	@Override
	public void onModelChange(ModelForView model) {
		ensureWidget();
		component.setValue((Integer) model.getValue());
	}

}
```

### Test a controller ###
ControllerTestCase uses JMock to assert the controller behavior.
```
public class PocControllerTest extends ControllerTestCase {

	PocController controller;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		controller = new PocController();

		controller.modelA = mockModel(PocModel.class,"modelAMock");

		controller.pocViewNumeric = mockView("pocViewNumericMock");

                controller.content = mockDomPlacer("content");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCallSHOW_SIMPLE_1() {
		mockery.checking(new Expectations() {
			{
				oneOf(controller.modelA).init();

                                oneOf(controller.contentDomPlacer). clearAndAdd(controller.pocViewNumeric);
			}
		});
		controller.call(new MvcEvent<String>(PocAction.SHOW_SIMPLE_1), component);

		assertTrue(controller.isInitialised());

		mockery.assertIsSatisfied();
	}

}

```

### Write a controller ###
The main point is to create an inner enum class which will describe the controller possible actions
```
public class PocController extends Controller {

	public enum PocAction {
		SHOW_SIMPLE_1
	}

	protected IView<Integer> pocViewNumeric;
	
	protected PocModel modelA;

        protected contentDomPlacer;


	public PocController() {
		super(PocAction.values());
		modelA = new PocModel();
	}

	@Override
	public void init() {
		
		if (pocViewNumeric == null)
			pocViewNumeric = new PocViewNumeric(this, modelA);
		
		initModel(modelA);

                contentDomPlacer = new DivWrapperPlacer("content");
	}

	@Override
	public void showHomeView() {
		
	}

	@Override
	protected void handleEvent(Event event) {

		PocAction action = (PocAction) event.getAction();

		switch (action) {
		case SHOW_SIMPLE_1:
			renderView(pocViewNumeric);
			break;
		default:
			Window.alert("Unknown action");
		}
	}

	@Override
	protected void renderView(IView view) {
                contentDomPlacer.clearAndAdd(view);
	}

}
```


### Write a model ###
The main point is that you will write your OWN methods in a model.
The model represents the client application state throught its value and the possible actions on it or the server throught its methods.public class PocModel extends Model<Integer> {

	protected static final int INITIAL_VALUE_10 = 10;

	private boolean useServerRPCCall = false;
	
	public PocModel() {
		super();
	}

	@Override
	public void init() {//public visibility for test
		update(INITIAL_VALUE_10);
	}
	
	public void plus(Integer integer,final Event causeEvent) {
		AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				Window.alert("plus failed : " + caught);
			}

			public void onSuccess(Integer result) {
				update(result, causeEvent);
			}
		};
		PocPlusRPC.Factory.getInstance(useServerRPCCall).plus(integer, callback);
	}

}```