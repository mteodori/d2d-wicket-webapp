package com.mycompany;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class BasePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public BasePage() {
        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
    }

    public BasePage(final PageParameters parameters) {
        this();
    }

}
