package com.aajtech.ui.vaadin.widget;

import com.aajtech.ui.core.api.HorizontalPanel;
import com.vaadin.ui.HorizontalLayout;

public class VaadinHorizontalPanel extends VaadinContainer<HorizontalLayout>implements HorizontalPanel {
	public VaadinHorizontalPanel() {
		super(new HorizontalLayout());
	}
}