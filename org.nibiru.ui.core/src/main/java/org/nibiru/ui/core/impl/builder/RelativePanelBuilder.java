package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.Rule;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class RelativePanelBuilder extends BaseContainerBuilder<RelativePanel, RelativePanelBuilder> {
    @Inject
    public RelativePanelBuilder(RelativePanel relativePanel) {
        super(relativePanel);
    }

    public RelativePanelBuilder addRule(Rule rule) {
        checkNotNull(rule);
        object.addRule(rule);
        return this;
    }

    public RuleBuilder prepare(Widget widget) {
        checkNotNull(widget);
        return new RuleBuilder(widget);
    }

    public class RuleBuilder {
        private final Widget target;

        private RuleBuilder(Widget target) {
            this.target = target;
        }

        public RuleBuilder above(int margin) {
            object.addAbove(target, null, margin);
            return this;
        }

        public RuleBuilder above(Widget source, int margin) {
            checkNotNull(source);
            object.addAbove(target, source, margin);
            return this;
        }

        public RuleBuilder alignBottom(int margin) {
            object.addAlignBottom(target, null, margin);
            return this;
        }

        public RuleBuilder alignBottom(Widget source, int margin) {
            checkNotNull(source);
            object.addAlignBottom(target, source, margin);
            return this;
        }

        public RuleBuilder alignLeft(int margin) {
            object.addAlignLeft(target, null, margin);
            return this;
        }

        public RuleBuilder alignLeft(Widget source, int margin) {
            checkNotNull(source);
            object.addAlignLeft(target, source, margin);
            return this;
        }

        public RuleBuilder alignRight(int margin) {
            object.addAlignRight(target, null, margin);
            return this;
        }

        public RuleBuilder alignRight(Widget source, int margin) {
            checkNotNull(source);
            object.addAlignRight(target, source, margin);
            return this;
        }

        public RuleBuilder alignTop(int margin) {
            object.addAlignTop(target, null, margin);
            return this;
        }

        public RuleBuilder alignTop(Widget source, int margin) {
            checkNotNull(source);
            object.addAlignTop(target, source, margin);
            return this;
        }

        public RuleBuilder below(int margin) {
            object.addBelow(target, null, margin);
            return this;
        }

        public RuleBuilder below(Widget source, int margin) {
            checkNotNull(source);
            object.addBelow(target, source, margin);
            return this;
        }

        public RuleBuilder centerHorizontally(int margin) {
            object.addCenterHorizontally(target, null, margin);
            return this;
        }

        public RuleBuilder centerHorizontally(Widget source, int margin) {
            checkNotNull(source);
            object.addCenterHorizontally(target, source, margin);
            return this;
        }

        public RuleBuilder centerVertically(int margin) {
            object.addCenterVertically(target, null, margin);
            return this;
        }

        public RuleBuilder centerVertically(Widget source, int margin) {
            checkNotNull(source);
            object.addCenterVertically(target, source, margin);
            return this;
        }

        public RuleBuilder matchBottomWithBottom(int margin) {
            object.addMatchBottomWithBottom(target, null, margin);
            return this;
        }

        public RuleBuilder matchBottomWithBottom(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchBottomWithBottom(target, source, margin);
            return this;
        }

        public RuleBuilder matchBottomWithTop(int margin) {
            object.addMatchBottomWithTop(target, null, margin);
            return this;
        }

        public RuleBuilder matchBottomWithTop(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchBottomWithTop(target, source, margin);
            return this;
        }

        public RuleBuilder matchHeight(int margin) {
            object.addMatchHeight(target, null, margin);
            return this;
        }

        public RuleBuilder matchHeight(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchHeight(target, source, margin);
            return this;
        }

        public RuleBuilder matchLeftWithLeft(int margin) {
            object.addMatchLeftWithLeft(target, null, margin);
            return this;
        }

        public RuleBuilder matchLeftWithLeft(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchLeftWithLeft(target, source, margin);
            return this;
        }

        public RuleBuilder matchLeftWithRight(int margin) {
            object.addMatchLeftWithRight(target, null, margin);
            return this;
        }

        public RuleBuilder matchLeftWithRight(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchLeftWithRight(target, source, margin);
            return this;
        }

        public RuleBuilder matchRightWithLeft(int margin) {
            object.addMatchRightWithLeft(target, null, margin);
            return this;
        }

        public RuleBuilder matchRightWithLeft(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchRightWithLeft(target, source, margin);
            return this;
        }

        public RuleBuilder matchRightWithRight(int margin) {
            object.addMatchRightWithRight(target, null, margin);
            return this;
        }

        public RuleBuilder matchRightWithRight(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchRightWithRight(target, source, margin);
            return this;
        }

        public RuleBuilder matchTopWithBottom(int margin) {
            object.addMatchTopWithBottom(target, null, margin);
            return this;
        }

        public RuleBuilder matchTopWithBottom(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchTopWithBottom(target, source, margin);
            return this;
        }

        public RuleBuilder matchTopWithTop(int margin) {
            object.addMatchTopWithTop(target, null, margin);
            return this;
        }

        public RuleBuilder matchTopWithTop(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchTopWithTop(target, source, margin);
            return this;
        }

        public RuleBuilder matchWidth(int margin) {
            object.addMatchWidth(target, null, margin);
            return this;
        }

        public RuleBuilder matchWidth(Widget source, int margin) {
            checkNotNull(source);
            object.addMatchWidth(target, source, margin);
            return this;
        }

        public RuleBuilder toLeftOf(int margin) {
            object.addToLeftOf(target, null, margin);
            return this;
        }

        public RuleBuilder toLeftOf(Widget source, int margin) {
            checkNotNull(source);
            object.addToLeftOf(target, source, margin);
            return this;
        }


        public RuleBuilder toRightOf(int margin) {
            object.addToRightOf(target, null, margin);
            return this;
        }

        public RuleBuilder toRightOf(Widget source, int margin) {
            checkNotNull(source);
            object.addToRightOf(target, source, margin);
            return this;
        }

        public RelativePanelBuilder add() {
            RelativePanelBuilder.this.add(target);
            return RelativePanelBuilder.this;
        }
    }
}
