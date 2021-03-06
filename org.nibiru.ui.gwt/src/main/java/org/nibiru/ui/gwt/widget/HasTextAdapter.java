package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.HasText;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class HasTextAdapter extends BaseValue<String> {
	private final HasText control;

	public HasTextAdapter(HasText control) {
		this.control = checkNotNull(control);
	}

	@Override
	@Nullable
	public String get() {
		return control.getText();
	}

	@Override
	protected void setValue(@Nullable String value) {
		control.setText(value);
	}

	@Override
	public Type<String> getType() {
		return JavaType.STRING;
	}
}
