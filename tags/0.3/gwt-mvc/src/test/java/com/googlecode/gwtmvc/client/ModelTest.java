package com.googlecode.gwtmvc.client;

import junit.framework.TestCase;

public class ModelTest extends TestCase {

	private class StringModel extends Model<String> {
		public StringModel(String value) {
			super(value);
		}

		protected void init() {
		}
	}

	StringModel model = new StringModel("initialValue");

	private enum Action {
		DO
	}

	public void testUpdateT() {
		model.update("value");
		assertEquals("value", model.getValue());
		assertNull(model.getError());
	}

	public void testUpdateTEvent() {
		model.update("value", new Event(Action.DO));
		assertEquals("value", model.getValue());
		assertNull(model.getError());
	}

	public void testUpdateThrowable() {
		model.update(new IllegalArgumentException());
		assertNull(model.getValue());
		assertNotNull(model.getError());
	}

	public void testUpdateThrowableEvent() {
		model.update(new IllegalArgumentException(), new Event(Action.DO));
		assertNull(model.getValue());
		assertNotNull(model.getError());
	}

	public void testUpdateThrowableEventBooleanTrue() {
		model.update(new IllegalArgumentException(), new Event(Action.DO), true);
		assertNull(model.getValue());
		assertNotNull(model.getError());
	}

	public void testUpdateThrowableEventBooleanFalse() {
		model.update(new IllegalArgumentException(), new Event(Action.DO), false);
		assertNotNull(model.getValue());
		assertNotNull(model.getError());
	}

	public void testUpdateThrowableBooleanTrue() {
		model.update(new IllegalArgumentException(), true);
		assertNull("value", model.getValue());
		assertNotNull(model.getError());
	}

	public void testUpdateThrowableBooleanFalse() {
		model.update(new IllegalArgumentException(), false);
		assertNotNull(model.getValue());
		assertNotNull(model.getError());
	}

}
