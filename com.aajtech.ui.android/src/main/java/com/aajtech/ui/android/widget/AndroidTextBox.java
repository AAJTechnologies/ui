package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.TextBox;

import android.content.Context;
import android.widget.EditText;

public class AndroidTextBox extends AndroidValueWidget<EditText, String> implements TextBox {
	@Inject
	public AndroidTextBox(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidTextBox(EditText editText, StyleResolver styleResolver) {
		super(editText, styleResolver);
	}

	@Override
	EditText buildControl(Context context, int styleResource) {
		return styleResource == 0 ? new EditText(context) : new EditText(context, null, styleResource);
	}

	@Override
	Value<String> buildValue() {
		return new TextBoxValue(control());
	}
}
