package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.View;
import com.googlecode.gwtmvc.poc.client.controller.PocBrowsableController;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerRoot;

public class PocViewHierarchy extends View<Controller, Tree> {

	public PocViewHierarchy(PocControllerRoot controller) {
		super("hierarchical", controller);
	}

	@Override
	public Tree createWidget() {
		Tree controllerTree = new Tree();
		PocBrowsableController rootController = (PocBrowsableController)controller;
		TreeItem rootItem = controllerTree.addItem(rootController.toString());
		addActionsAndChildren(rootController, rootItem);
		return controllerTree;
	}

	private void addActionsAndChildren(PocBrowsableController currentController, TreeItem currentItem) {
		TreeItem showHomeViewItem = currentItem.addItem("showHomeView");
		for (Enum controllerAction : currentController.getActionEnumValues()) {
			if (controllerAction.name().startsWith("SHOW")) {
				currentItem.addItem(controllerAction.name());
			}
		}
		for (Controller child : currentController.getChildren()) {
			TreeItem newItem = currentItem.addItem(child.toString());
			addActionsAndChildren((PocBrowsableController)child, newItem);
		}
	}

	@Override
	public void onModelChange(ModelForView model) {

	}

	@Override
	public void onRender() {
		Log.debug(toString() + " render");

	}

}
