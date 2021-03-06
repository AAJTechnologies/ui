package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ValueWidget;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class GwtHasValueWidget<W extends Widget & HasValue<V>, V>
        extends GwtValueWidget<W, V>
        implements ValueWidget<V> {
    private final Type<V> type;

    GwtHasValueWidget(W control, Type<V> type) {
        super(control);
        this.type = checkNotNull(type);
    }

    @Override
    Value<V> buildValue() {
        return new HasValueAdapter<V>(control, type);
    }
}
