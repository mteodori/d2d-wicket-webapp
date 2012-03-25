package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class MyPage extends WebPage {
	private static final long serialVersionUID = 1L;

    public MyPage() {
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
    }
}
