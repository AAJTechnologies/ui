package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.ClickHandler;
import com.aajtech.ui.core.api.Color;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextBox;

public class UiBuilder implements UiCreator {
	private final Provider<LabelBuilder> labelBuilderProvider;
	private final Provider<TextBoxBuilder> textBoxBuilderProvider;
	private final Provider<PasswordBoxBuilder> passwordBoxBuilderProvider;
	private final Provider<VerticalPanelBuilder> verticalPanelBuilderProvider;
	private final Provider<HorizontalPanelBuilder> horizontalPanelBuilderProvider;
	private final Provider<GridPanelBuilder> gridPanelBuilderProvider;
	private final Provider<FormBuilder> formBuilderProvider;
	private final Provider<ButtonBuilder> buttonBuilderProvider;
	private final Provider<ListWidget> listWidgetProvider;
	private final Provider<ImageBuilder> imageBuilderProvider;
	private final Provider<StyleBuilder> styleProvider;

	@Inject
	public UiBuilder(Provider<LabelBuilder> labelBuilderProvider,
			Provider<TextBoxBuilder> textBoxBuilderProvider,
			Provider<PasswordBoxBuilder> passwordBoxBuilderProvider,
			Provider<VerticalPanelBuilder> verticalPanelBuilderProvider,
			Provider<HorizontalPanelBuilder> horizontalPanelBuilderProvider,
			Provider<GridPanelBuilder> gridPanelBuilderProvider,
			Provider<FormBuilder> formBuilderProvider,
			Provider<ButtonBuilder> buttonBuilderProvider,
			Provider<ListWidget> listWidgetProvider,
			Provider<ImageBuilder> imageBuilderProvider,
			Provider<StyleBuilder> styleProvider) {
		this.labelBuilderProvider = checkNotNull(labelBuilderProvider);
		this.textBoxBuilderProvider = checkNotNull(textBoxBuilderProvider);
		this.passwordBoxBuilderProvider = checkNotNull(passwordBoxBuilderProvider);
		this.verticalPanelBuilderProvider = checkNotNull(verticalPanelBuilderProvider);
		this.horizontalPanelBuilderProvider = checkNotNull(horizontalPanelBuilderProvider);
		this.gridPanelBuilderProvider = checkNotNull(gridPanelBuilderProvider);
		this.formBuilderProvider = checkNotNull(formBuilderProvider);
		this.buttonBuilderProvider = checkNotNull(buttonBuilderProvider);
		this.listWidgetProvider = checkNotNull(listWidgetProvider);
		this.imageBuilderProvider = checkNotNull(imageBuilderProvider);
		this.styleProvider = checkNotNull(styleProvider);
	}

	@Override
	public LabelBuilder label() {
		return labelBuilderProvider.get();
	}

	@Override
	public Label label(String text) {
		return label().text(text).build();
	}

	@Override
	public TextBoxBuilder textBox() {
		return textBoxBuilderProvider.get();
	}

	@Override
	public TextBox textBox(String text) {
		return textBox().text(text).build();
	}

	@Override
	public PasswordBoxBuilder passwordBox() {
		return passwordBoxBuilderProvider.get();
	}

	@Override
	public PasswordBox passwordBox(String text) {
		return passwordBox().text(text).build();
	}
	
	@Override
	public VerticalPanelBuilder verticalPanel() {
		return verticalPanelBuilderProvider.get();
	}

	@Override
	public HorizontalPanelBuilder horizontalPanel() {
		return horizontalPanelBuilderProvider.get();
	}

	@Override
	public GridPanelBuilder gridPanel() {
		return gridPanelBuilderProvider.get();
	}

	@Override
	public FormBuilder form() {
		return formBuilderProvider.get();
	}

	@Override
	public ButtonBuilder button() {
		return buttonBuilderProvider.get();
	}

	@Override
	public Button button(String text, ClickHandler clickHandler) {
		return button().text(text).onClick(clickHandler).build();
	}

	@Override
	public ListWidget list() {
		return listWidgetProvider.get();
	}

	@Override
	public ImageBuilder image() {
		return imageBuilderProvider.get();
	}

	@Override
	public Image image(String path) {
		return image().path(path).build();
	}

	@Override
	public StyleBuilder style() {
		return styleProvider.get();
	}

	@Override
	public Color color(int red, int green, int blue) {
		return new Color(red, green, blue);
	}

	@Override
	public Color color(int red, int green, int blue, int alpha) {
		return new Color(red, green, blue, alpha);
	}
}
