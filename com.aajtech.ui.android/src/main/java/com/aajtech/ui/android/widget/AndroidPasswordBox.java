package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.PasswordBox;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;

public class AndroidPasswordBox extends AndroidTextBox implements PasswordBox {
	@Inject
	public AndroidPasswordBox(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	@Override
	EditText buildControl(Context context, int styleResource) {
		EditText editText = super.buildControl(context, styleResource);
		
		editText.setHint("Password");
		editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		
		return editText;
	}
}
