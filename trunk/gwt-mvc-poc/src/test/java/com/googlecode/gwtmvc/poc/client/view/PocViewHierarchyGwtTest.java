package com.googlecode.gwtmvc.poc.client.view;

import com.google.gwt.user.client.ui.Tree;
import com.googlecode.gwtmvc.poc.client.PocGWTTestCase;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerRoot;

public class PocViewHierarchyGwtTest extends PocGWTTestCase {

	public void testEnsureWidget() {
		PocViewHierarchy pocViewHierarchy = new PocViewHierarchy(new PocControllerRoot());
		pocViewHierarchy.ensureWidget();
		Tree tree = (Tree)pocViewHierarchy.getWidget();
		//PocControllerRoot
		assertEquals(1, tree.getItemCount());
		assertEquals(1+2+2, tree.getItem(0).getChildCount());
		//-PocController (showHomeView + 2 SHOW actions + 2 children)
		assertEquals(1+7+1, tree.getItem(0).getChild(3).getChildCount());
		//--PocControllerChild
		assertEquals(1+0+0, tree.getItem(0).getChild(3).getChild(8).getChildCount());
		//-PocControllerForm
		assertEquals(1+2+0, tree.getItem(0).getChild(4).getChildCount());
		
	}

}
