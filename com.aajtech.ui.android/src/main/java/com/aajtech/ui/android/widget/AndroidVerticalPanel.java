package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.VerticalPanel;

import android.content.Context;
import android.widget.LinearLayout;

public class AndroidVerticalPanel extends LinearLayoutContainer implements VerticalPanel {
	@Inject
	public AndroidVerticalPanel(Context context, StyleResolver styleResolver) {
		this(new LinearLayout(context), styleResolver);
	}

	public AndroidVerticalPanel(LinearLayout linearLayout, StyleResolver styleResolver) {
		super(linearLayout, styleResolver, LinearLayout.VERTICAL);
	}
}
