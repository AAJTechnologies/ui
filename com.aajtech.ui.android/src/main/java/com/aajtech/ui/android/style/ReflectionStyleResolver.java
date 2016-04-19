package com.aajtech.ui.android.style;

import static com.google.common.base.Preconditions.*;

import java.lang.reflect.Field;

import com.aajtech.ui.core.api.Widget;
import com.google.common.base.Throwables;

public class ReflectionStyleResolver implements StyleResolver {
	private final Class<?> sytleConstantClass;

	public ReflectionStyleResolver(Class<?> stleConstantClass) {
		this.sytleConstantClass = checkNotNull(stleConstantClass);
	}

	@Override
	public int resolveStyle(Enum<?> styleName) {
		checkNotNull(styleName);
		try {
			String fieldName = Widget.STYLE_NAME_PREFIX + styleName.name().toLowerCase();
			Field styleField = sytleConstantClass.getField(fieldName);
			checkNotNull(styleField, "No field %s found for class %s.", fieldName, sytleConstantClass);
			return styleField.getInt(null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw Throwables.propagate(e);
		}
	}
}