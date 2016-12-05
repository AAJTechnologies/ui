package org.nibiru.ui.android.widget;

import javax.inject.Inject;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.GridPanel;

import android.content.Context;
import android.widget.GridLayout;

public class AndroidGridPanel extends AndroidContainer<GridLayout> implements GridPanel {
	@Inject
	public AndroidGridPanel(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidGridPanel(GridLayout grid, StyleResolver styleResolver) {
		super(grid, styleResolver);
	}

	@Override
	public void setColumns(int columns) {
		control().setColumnCount(columns);
	}

	@Override
	GridLayout buildControl(Context context, int styleResource) {
		return styleResource == StyleResolver.NO_STYLE
				? new GridLayout(context)
				: new GridLayout(context, null, styleResource);
	}
}