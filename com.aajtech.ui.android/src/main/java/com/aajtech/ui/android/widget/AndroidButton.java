package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.Button;

import android.content.Context;

public class AndroidButton extends AndroidLabel implements Button {
	@Inject
	public AndroidButton(Context context, StyleResolver styleResolver) {
		this(new android.widget.Button(context), styleResolver);
	}

	public AndroidButton(android.widget.Button button, StyleResolver styleResolver) {
		super(button, styleResolver);
	}
}
