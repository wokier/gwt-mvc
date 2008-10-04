package com.googlecode.gwtmvc.stm.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.googlecode.gwtmvc.stm.client.model.ArrayListModel;
import com.googlecode.gwtmvc.stm.client.model.BString;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.view.Graph3DView;
import com.googlecode.gwtmvc.stm.client.view.TextBoxView;

public class StmEntryPoint implements EntryPoint, HistoryListener {
	private BString red = new BString("1");
	private BString green = new BString("2");
	private BString blue = new BString("3");
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
		layout.setHTML(0, 0, "<b>RGB compounds</b>");
		cellFormatter.setColSpan(0, 0, 2);
		cellFormatter.setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_CENTER);

		// Add some standard form options
		layout.setHTML(1, 0, "Red:");
		layout.setWidget(1, 1, new TextBoxView(red));
		layout.setHTML(2, 0, "Green:");
		layout.setWidget(2, 1, new TextBoxView(green));
		layout.setHTML(3, 0, "Blue:");
		layout.setWidget(3, 1, new TextBoxView(blue));
		decPanel.setWidget(layout);
		Panel centerPanel = new HorizontalPanel();
		centerPanel.add(decPanel);
		dockPanel.add(centerPanel, DockPanel.CENTER);

		final ArrayListModel<Integer> model = new ArrayListModel<Integer>(
				Arrays.asList(new Integer[] { 10, 20, 30 }));
		Model.Listener<String> inputListener = new Model.Listener<String>() {
			public void onChange(Model.Event<String> event) {
				try {
					List<Integer> asList = Arrays.asList(new Integer[] {
							Integer.valueOf(red.getValue().trim()),
							Integer.valueOf(green.getValue().trim()),
							Integer.valueOf(blue.getValue().trim()) });
					model.setValue(asList);
				} catch (NumberFormatException e) {
					// ignore
				}
			}
		};
		red.addModelListener(inputListener);
		green.addModelListener(inputListener);
		blue.addModelListener(inputListener);

		centerPanel.add(new Graph3DView(model));
		VerticalPanel widget = new VerticalPanel();
		widget.add(new Hyperlink("Data binding", "binding"));
		widget.add(new Hyperlink("MVC principle", "mvc"));
		dockPanel.add(widget, DockPanel.WEST);

		historyToken.addModelListener(new Model.Listener<String>() {
			public void onChange(Model.Event<String> event) {
				System.out.println("history changed:"
						+ event.getSource().getValue());
			}
		});
	}

	public void onHistoryChanged(String historyToken) {
		this.historyToken.setValue(historyToken);
	}
}
