package com.aajtech.ui.core.impl.builder;

import java.util.List;

import com.aajtech.ui.core.api.ComboBox;

public class ComboBoxBuilder<T> extends BaseValueBuilder<ComboBox<T>, T, ComboBoxBuilder<T>> {
	public ComboBoxBuilder(ComboBox<T> control) {
		super(control);
	}

	public ComboBoxBuilder<T> items(List<T> items) {
		object.getItems().set(items);
		return getThis();
	}

}
