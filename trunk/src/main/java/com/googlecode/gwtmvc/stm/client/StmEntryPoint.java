package com.googlecode.gwtmvc.stm.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.googlecode.gwtmvc.stm.client.controller.NotModel;
import com.googlecode.gwtmvc.stm.client.controller.RegExpEvaluatingModel;
import com.googlecode.gwtmvc.stm.client.model.BString;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;
import com.googlecode.gwtmvc.stm.client.view.ButtonView;
import com.googlecode.gwtmvc.stm.client.view.LabelView;
import com.googlecode.gwtmvc.stm.client.view.TextBoxView;

public class StmEntryPoint implements EntryPoint, HistoryListener {
	private BString name = new BString();
	private BString age = new BString();
	private BString historyToken = new BString();

	public void onModuleLoad() {
		History.addHistoryListener(this);
		RootPanel rootPanel = RootPanel.get("content");

		DockPanel dockPanel = new DockPanel();
		dockPanel.add(new HTML("<h1>GWT MVC Demonstration</h1><hr>"),
				DockPanel.NORTH);
		dockPanel.setWidth("100%");
		rootPanel.add(dockPanel);

		DecoratorPanel decPanel = new DecoratorPanel();
		FlexTable layout = new FlexTable();
		layout.setCellSpacing(6);
		FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
		layout.setHTML(0, 0, "<b>Personal information</b>");
		cellFormatter.setColSpan(0, 0, 2);
		cellFormatter.setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_CENTER);

		// Add some standard form options
		layout.setHTML(1, 0, "Name:");
		layout.setWidget(1, 1, new TextBoxView(name));
		layout.setHTML(2, 0, "Age:");
		layout.setWidget(2, 1, new TextBoxView(age));
		LabelView textBoxView = new LabelView("!");
		layout.setWidget(2, 2, textBoxView);
		layout.setHTML(3, 0, "History token:");
		layout.setWidget(3, 1, new LabelView(historyToken));

		RegExpEvaluatingModel text = new RegExpEvaluatingModel(age, "\\d+");
		NotModel notModel = new NotModel(text);
		textBoxView.setVisible(notModel);
		rootPanel.add(notModel);
		VerticalPanel form = new VerticalPanel();
		form.add(layout);
		ButtonView w = new ButtonView();
		w.setEnabled(text);
		w.getWidget().setText("Submit");
		layout.setWidget(4, 1, w);
		decPanel.setWidget(form);
		dockPanel.add(decPanel, DockPanel.CENTER);
		VerticalPanel widget = new VerticalPanel();
		widget.add(new Hyperlink("Data binding", "binding"));
		widget.add(new Hyperlink("MVC principle", "mvc"));
		dockPanel.add(widget, DockPanel.WEST);

		historyToken.addModelListener(new Model.Listener<String>() {
			public void onChange(Event<String> event) {
				System.out.println("history changed:"
						+ event.getSource().getValue());
			}
		});
	}

	public void onHistoryChanged(String historyToken) {
		this.historyToken.setValue(historyToken);
	}
}
