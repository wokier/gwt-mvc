package com.googlecode.gwtmvc.stm.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.googlecode.gwtmvc.stm.client.controller.NotModel;
import com.googlecode.gwtmvc.stm.client.controller.RegExpEvaluatingModel;
import com.googlecode.gwtmvc.stm.client.model.BBoolean;
import com.googlecode.gwtmvc.stm.client.model.BString;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;
import com.googlecode.gwtmvc.stm.client.view.ButtonView;
import com.googlecode.gwtmvc.stm.client.view.LabelView;
import com.googlecode.gwtmvc.stm.client.view.TextBoxView;

public class StmEntryPoint implements EntryPoint {
	private BString name = new BString();
	private BString age = new BString();
	private BBoolean enabled = new BBoolean();

	private static class MyDialog extends DialogBox {

		public MyDialog() {
			setText("My First Dialog");
			Button ok = new Button("OK");
			ok.addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					MyDialog.this.hide();
				}
			});
			setWidget(ok);
			center();
		}
	}

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get("content");
		VerticalPanel verticalPanel = new VerticalPanel();
		DecoratorPanel decPanel = new DecoratorPanel();

		FlexTable layout = new FlexTable();
		layout.setCellSpacing(6);
		FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
		layout.setHTML(0, 0, "title");
		cellFormatter.setColSpan(0, 0, 2);
		cellFormatter.setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_CENTER);

		// Add some standard form options
		layout.setHTML(1, 0, "Person Name");
		layout.setWidget(1, 1, new TextBoxView(name));
		layout.setHTML(2, 0, "Age");
		layout.setWidget(2, 1, new TextBoxView(age));
		LabelView textBoxView = new LabelView("!");
		layout.setWidget(2, 2, textBoxView);

		RegExpEvaluatingModel text = new RegExpEvaluatingModel(age, "\\d+");
		NotModel notModel = new NotModel(text);
		textBoxView.setVisible(notModel);
		rootPanel.add(notModel);
		rootPanel.add(decPanel);
		VerticalPanel form = new VerticalPanel();
		form.add(layout);
		ButtonView w = new ButtonView();
		w.setEnabled(text);
		w.getWidget().setText("Submit");
		layout.setWidget(3, 1, w);
		decPanel.setWidget(form);
		rootPanel.add(verticalPanel);
		enabled.addModelListener(new Model.Listener<Boolean>() {
			public void onChange(Event<Boolean> event) {
				if (event.getSource().getValue().equals(Boolean.TRUE)) {
					new MyDialog().show();
				}
			}
		});
	}
}
