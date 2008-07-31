package com.googlecode.gwtmvc.stm.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.stm.client.model.impl.StringModel;
import com.googlecode.gwtmvc.stm.client.view.impl.StringView;

public class StmEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get("content");
		VerticalPanel verticalPanel = new VerticalPanel();

		TextBox tb1 = new TextBox();
		TextBox tb2 = new TextBox();
		TextBox tb3 = new TextBox();
		verticalPanel.add(tb1);
		verticalPanel.add(tb2);
		verticalPanel.add(tb3);
		rootPanel.add(verticalPanel);

		// this is where MVC is created
		final StringModel model = new StringModel();
		new StringView(tb1, model);
		new StringView(tb2, model);
		new StringView(tb3, model);

		// dummy controller which updates model with current time
		new Timer() {
			@Override
			public void run() {
				String format = DateTimeFormat.getMediumTimeFormat().format(
						new Date());
				model.setValue(format);
			}
		}.scheduleRepeating(1000);
	}
}
