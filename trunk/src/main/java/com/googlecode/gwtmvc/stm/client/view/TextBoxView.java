package com.googlecode.gwtmvc.stm.client.view;

import com.google.gwt.user.client.ui.TextBox;
import com.googlecode.gwtmvc.stm.client.model.BString;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

public class TextBoxView extends ViewAdapter<String, TextBox> {

    public TextBoxView(TextBox textBox) {
        super(new BString(textBox.getText()), textBox);
    }

    public TextBoxView() {
        this(new TextBox());
    }

    public TextBoxView(BString text) {
        super(text, new TextBox());
    }

    public TextBoxView(String string) {
        this(new BString(string));
    }

    protected void createControllerRole() {
        widget.addClickListener(this);
        widget.addKeyboardListener(this);
    }

    protected void updateModel() {
        model.setValue(widget.getText());
    }

    @Override
    protected void updateView(Event<String> event) {
        if (!model.getValue().equals(widget.getText()))
            widget.setText(model.getValue());
    }

    @Override
    protected void enable(Boolean value) {
        widget.setEnabled(value);
    }

}
