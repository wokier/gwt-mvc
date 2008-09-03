package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.PocMenuController.PocMenuAction;

public class PocMenu extends View {

	PocMenu(Controller controller){
		super("menu", controller);
	}
	
	@Override
	public void init() {
		VerticalPanel pan = new VerticalPanel();
		Hyperlink hIntro =new Hyperlink("Introduction","intro");
		hIntro.addClickListener(new ClickListener(){
			public void onClick(Widget sender) {
				controller.handleUserGesture(new Event<String, PocMenuAction>(PocMenuAction.INTRO));
			}
		});
		pan.add(hIntro);
		Hyperlink h1 = new Hyperlink("Simple Example #1","1");
		h1.addClickListener(new ClickListener(){
			public void onClick(Widget sender) {
				controller.handleUserGesture(new Event<String, PocMenuAction>(PocMenuAction.ACTION_1));
			}
		});
		pan.add(h1);
		Hyperlink h2 = new Hyperlink("More Complex Example #2","2");
		h2.addClickListener(new ClickListener(){
			public void onClick(Widget sender) {
				controller.handleUserGesture(new Event<String, PocMenuAction>(PocMenuAction.ACTION_2));
			}
		});
		pan.add(h2);
		initWidget(pan);	
	}

	@Override
	public void onModelChange(ModelForView model) {
		
	}
}
