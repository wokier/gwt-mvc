package com.googlecode.gwtmvc.stm.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.stm.client.controller.Validator;
import com.googlecode.gwtmvc.stm.client.model.BooleanModel;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.StringModel;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;
import com.googlecode.gwtmvc.stm.client.view.CheckBoxView;
import com.googlecode.gwtmvc.stm.client.view.RadioButtonView;
import com.googlecode.gwtmvc.stm.client.view.TextAreaView;
import com.googlecode.gwtmvc.stm.client.view.TextBoxView;

public class StmEntryPoint implements EntryPoint {
	private StringModel text = new StringModel();
	private BooleanModel enabled = new BooleanModel();
	private BooleanModel valid = new BooleanModel(true);

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

		TextBoxView textBoxView = new TextBoxView(text);
		textBoxView.setEnabled(valid);

		TextBoxView tb2 = new TextBoxView(text);
		tb2.setVisible(valid);

		verticalPanel.add(textBoxView);
		verticalPanel.add(tb2);
		verticalPanel.add(new TextAreaView(text));
		verticalPanel.add(new CheckBoxView(enabled));
		verticalPanel.add(new CheckBoxView(enabled));
		verticalPanel.add(new RadioButtonView(enabled, new RadioButton("")));

		Validator validator = new Validator(valid, text, "\\d{1,4}");
		rootPanel.add(validator);
		HorizontalSplitPanel splitPannel = new HorizontalSplitPanel();
		rootPanel.add(splitPannel);
		splitPannel.setRightWidget(verticalPanel);
		splitPannel.setLeftWidget(new TextBoxView(text));
		splitPannel.setSplitPosition("200px");
		enabled.addModelListener(new Model.Listener<Boolean>() {
			public void onChange(Event<Boolean> event) {
				if (event.getSource().getValue().equals(Boolean.TRUE)) {
					new MyDialog().show();
				}
			}
		});
	}
}
