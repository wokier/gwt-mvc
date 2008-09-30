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
import com.googlecode.gwtmvc.stm.client.controller.StringValidator;
import com.googlecode.gwtmvc.stm.client.model.BooleanModel;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.StringModel;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;
import com.googlecode.gwtmvc.stm.client.view.TextBoxView;

public class StmEntryPoint implements EntryPoint {
    private StringModel name = new StringModel();
    private StringModel age = new StringModel();
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
        DecoratorPanel decPanel = new DecoratorPanel();

        FlexTable layout = new FlexTable();
        layout.setCellSpacing(6);
        FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
        layout.setHTML(0, 0, "title");
        cellFormatter.setColSpan(0, 0, 2);
        cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

        // Add some standard form options
        layout.setHTML(1, 0, "Person Name");
        layout.setWidget(1, 1, new TextBoxView(name));
        layout.setHTML(2, 0, "Age");
        layout.setWidget(2, 1, new TextBoxView(age));
        TextBoxView textBoxView = new TextBoxView("valid");
        textBoxView.setVisible(valid);
        layout.setWidget(2, 2, textBoxView);

        StringValidator validator = new StringValidator(valid, age, "\\d+");
        rootPanel.add(validator);
        rootPanel.add(decPanel);
        decPanel.setWidget(layout);
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
