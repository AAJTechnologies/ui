package org.nibiru.ui.gwt.widget;

import com.google.common.collect.Lists;
import com.google.gwt.canvas.dom.client.Context2d;

import org.nibiru.ui.core.api.Canvas;
import org.nibiru.ui.core.api.style.Color;

import java.util.List;

import javax.inject.Inject;

public class GwtCanvas
        extends GwtWidget<com.google.gwt.canvas.client.Canvas>
        implements Canvas {

    private final Context2d context2d;
    private final List<Runnable> operations;

    @Inject
    public GwtCanvas() {
        this(com.google.gwt.canvas.client.Canvas.createIfSupported());
    }

    public GwtCanvas(com.google.gwt.canvas.client.Canvas canvas) {
        super(canvas);
        context2d = control.getContext2d();
        operations = Lists.newArrayList();
    }

    @Override
    public Canvas arc(int x,
                      int y,
                      int radius,
                      double startAngle,
                      double endAngle) {
        addOperation(() -> context2d.arc(x, y, radius, startAngle, endAngle));
        return this;
    }

    @Override
    public Canvas beginPath() {
        addOperation(context2d::beginPath);
        return this;
    }

    @Override
    public Canvas closePath() {
        addOperation(context2d::closePath);
        return this;
    }

    @Override
    public Canvas clear() {
        addOperation(() -> context2d.clearRect(0,
                0,
                control.getOffsetWidth(),
                control.getOffsetHeight()));
        return this;
    }

    @Override
    public Canvas fill() {
        addOperation(context2d::fill);
        return this;
    }

    @Override
    public Canvas lineTo(int x,
                         int y) {
        addOperation(() -> context2d.lineTo(x, y));
        return this;
    }

    @Override
    public Canvas moveTo(int x,
                         int y) {
        addOperation(() -> context2d.moveTo(x, y));
        return this;
    }

    @Override
    public Canvas rect(int x,
                       int y,
                       int width,
                       int height) {
        addOperation(() -> context2d.rect(x, y, width, height));
        return this;
    }

    @Override
    public Canvas setFillStyle(Color color) {
        addOperation(() -> context2d.setFillStyle(color.asCss()));
        return this;
    }

    @Override
    public Canvas setLineWidth(int width) {
        addOperation(() -> context2d.setLineWidth(width));
        return this;
    }

    @Override
    public Canvas setStrokeStyle(Color color) {
        addOperation(() -> context2d.setStrokeStyle(color.asCss()));
        return this;
    }

    @Override
    public Canvas stroke() {
        addOperation(context2d::stroke);
        return this;
    }

    @Override
    public void setNativeSize(int measuredWidth, int measuredHeight) {
        super.setNativeSize(measuredWidth, measuredHeight);
        control.setCoordinateSpaceWidth(measuredWidth);
        control.setCoordinateSpaceHeight(measuredHeight);
    }

    @Override
    public void onLayout() {
        super.onLayout();
        operations.forEach(Runnable::run);
    }

    private void addOperation(Runnable operation) {
        operations.add(operation);
    }
}