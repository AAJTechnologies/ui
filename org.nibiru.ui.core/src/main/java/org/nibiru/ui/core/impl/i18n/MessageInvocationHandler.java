package org.nibiru.ui.core.impl.i18n;

import com.google.common.annotations.GwtIncompatible;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

@GwtIncompatible("Reflection")
public class MessageInvocationHandler implements InvocationHandler {
	private final ResourceBundle resourceBundle;

	public MessageInvocationHandler(Class<?> proxyClass) {
		checkNotNull(proxyClass);
		resourceBundle = ResourceBundle.getBundle(proxyClass.getName());
	}

	@Override
	public Object invoke(@Nullable Object proxy, Method method,
			@Nullable Object[] args) throws Throwable {
		checkNotNull(method);
		String message = resourceBundle.getString(method.getName());
		MessageFormat messageFormat = new MessageFormat(message);
		return messageFormat.format(args);
	}
}
