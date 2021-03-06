package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.Style;

import javax.inject.Inject;

public class StyleBuilder
        extends BaseBuilder<Style>
        implements BaseStyleBuilder<Style, StyleBuilder> {
    @Inject
    public StyleBuilder() {
        super(new Style());
    }
}
