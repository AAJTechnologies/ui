package org.nibiru.ui.android.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.impl.BaseControlWidget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;

abstract class AndroidWidget<T extends View> extends BaseControlWidget<T> implements HasClickHandler {
	private final Context context;
	private final StyleResolver styleResolver;
	private Registration clickRegistration;
	private int styleResource;

	AndroidWidget(T control, StyleResolver styleResolver) {
		super(control);
		this.styleResolver = checkNotNull(styleResolver);
		context = null;
	}

	AndroidWidget(Context context, StyleResolver styleResolver) {
		super(null);
		this.context = checkNotNull(context);
		this.styleResolver = checkNotNull(styleResolver);
	}

	@Override
	protected int getNativeHeight() {
		control().measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		return pxToDp(control().getMeasuredHeight());
	}

	@Override
	protected int getNativeWidth() {
		control().measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		return pxToDp(control().getMeasuredWidth());
	}

	@Override
	public void setNativeSize(int measuredWidth, int measuredHeight) {
		LayoutParams params = getLayoutParams();
		params.width = dpToPx(measuredWidth);
		params.height = dpToPx(measuredHeight);
		control().setLayoutParams(params);
	}

	@Override
	public T asNative() {
		return control();
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		if (clickRegistration != null) {
			clickRegistration.remove();
		}
		control().setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clickHandler.onClick();
			}
		});
		clickRegistration = new Registration() {
			@Override
			public void remove() {
				control().setOnClickListener(null);
			}
		};
		return clickRegistration;
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		styleResource = styleResolver.resolveStyle(styleName);
	}

	T control() {
		if (control == null) {
			control = buildControl(styleResource == StyleResolver.NO_STYLE 
						? context
						: new ContextThemeWrapper(context, styleResource),
					styleResource);
		}
		return control;
	}

	abstract T buildControl(Context context, int styleResource);

	int dpToPx(int dp) {
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		return (int) ((dp * displayMetrics.density) + 0.5);
	}

	int pxToDp(int px) {
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		return (int) ((px / displayMetrics.density) + 0.5);
	}

	private LayoutParams getLayoutParams() {
		LayoutParams params = (LayoutParams) control().getLayoutParams();
		return params != null ? params : new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	}
}
