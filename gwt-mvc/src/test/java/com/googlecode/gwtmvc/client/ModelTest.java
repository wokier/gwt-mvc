package com.googlecode.gwtmvc.client;

import org.junit.Test;

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

	@Test
	public void testUpdateT() {
		model.update("value");
		assertEquals("value", model.getValue());
		assertNull(model.getError());
	}

	@Test
	public void testUpdateTEvent() {
		model.update("value", new MvcEvent(Action.DO));
		assertEquals("value", model.getValue());
		assertNull(model.getError());
	}

	@Test
	public void testUpdateThrowable() {
		model.update(new IllegalArgumentException());
		assertNull(model.getValue());
		assertNotNull(model.getError());
	}

	@Test
	public void testUpdateThrowableEvent() {
		model.update(new IllegalArgumentException(), new MvcEvent(Action.DO));
		assertNull(model.getValue());
		assertNotNull(model.getError());
	}

	@Test
	public void testUpdateThrowableEventBooleanTrue() {
		model.update(new IllegalArgumentException(), new MvcEvent(Action.DO), true);
		assertNull(model.getValue());
		assertNotNull(model.getError());
	}

	@Test
	public void testUpdateThrowableEventBooleanFalse() {
		model.update(new IllegalArgumentException(), new MvcEvent(Action.DO), false);
		assertNotNull(model.getValue());
		assertNotNull(model.getError());
	}

	@Test
	public void testUpdateThrowableBooleanTrue() {
		model.update(new IllegalArgumentException(), true);
		assertNull("value", model.getValue());
		assertNotNull(model.getError());
	}

	@Test
	public void testUpdateThrowableBooleanFalse() {
		model.update(new IllegalArgumentException(), false);
		assertNotNull(model.getValue());
		assertNotNull(model.getError());
	}

}
