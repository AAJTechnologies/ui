package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;

public class ButtonBuilder extends BaseValueBuilder<Button, String> {
	@Inject
	public ButtonBuilder(Button button) {
		super(button);
	}

	public ButtonBuilder text(String text) {
		object.getValue().set(text);
		return this;
	}

	public ButtonBuilder onClick(ClickHandler clickHandler) {
		object.setClickHandler(clickHandler);
		return this;
	}
}
