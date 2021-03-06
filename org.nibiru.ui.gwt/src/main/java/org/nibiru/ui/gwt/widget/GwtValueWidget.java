package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.Widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ValueWidget;

abstract class GwtValueWidget<W extends Widget, V> extends GwtWidget<W> implements ValueWidget<V> {
	private Value<V> value;

	GwtValueWidget(W control) {
		super(control);
	}

	@Override
	public Value<V> getValue() {
		if (value == null) {
			value = buildValue();
		}
		return value;
	}

	abstract Value<V> buildValue();
}