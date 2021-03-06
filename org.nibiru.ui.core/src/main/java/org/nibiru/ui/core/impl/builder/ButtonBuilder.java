package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.ClickHandler;

import javax.annotation.Nullable;
import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class ButtonBuilder
        extends BaseBuilder<Button>
        implements
        FocusableBuilder<Button, ButtonBuilder>,
        HasClickHandlerBuilder<Button, ButtonBuilder>,
        HasEnabledBuilder<Button, ButtonBuilder>,
        ValueWidgetBuilder<Button, String, ButtonBuilder> {

    @Inject
    public ButtonBuilder(Button button) {
        super(button);
    }

    public Button build(@Nullable String text, ClickHandler clickHandler) {
        checkNotNull(clickHandler);
        return value(text).onClick(clickHandler).build();
    }
}
