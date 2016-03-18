package com.aajtech.ui.android.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;

import javax.inject.Inject;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.ResourcesBasePath;
import com.google.common.base.Throwables;
import com.google.common.io.Closer;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class AndroidImage extends AndroidWidget<ImageView>implements Image {
	private final Value<String> value;

	@Inject
	public AndroidImage(Context context, @ResourcesBasePath String basePath) {
		this(new ImageView(context), basePath);
	}

	public AndroidImage(final ImageView view, final String basePath) {
		super(view);
		value = new BaseValue<String>() {
			private String imagePath;

			@Override
			public String get() {
				return imagePath;
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}

			@Override
			protected void setValue(String value) {
				imagePath = checkNotNull(value);
				Closer closer = Closer.create();
				try {
					try {
						view.setImageBitmap(BitmapFactory.decodeStream(
								closer.register(getClass().getClassLoader().getResourceAsStream(basePath + value))));
					} catch (Throwable e) { // must catch Throwable
						throw closer.rethrow(e);
					} finally {
						closer.close();
					}
				} catch (IOException e) {
					Throwables.propagate(e);
				}
			}
		};
	}

	@Override
	public Value<String> getValue() {
		return value;
	}
}