package com.mycompany;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class ProductListPage extends BasePage {
    private static final long serialVersionUID = 1L;

    // page state
    private final List<Product> products = Arrays.asList(
            new Product("tomatos", "1.00"),
            new Product("carrots", "0.80"),
            new Product("strawberries", "1.80"));

    public ProductListPage() {
        super();

        add(new Label("name", new Model<String>("**Name**")));
        add(new Label("price", new Model<String>("**Price**")));

        @SuppressWarnings("serial")
        ListView<Product> lv = new ListView<Product>("product", products) {
            @Override
            protected void populateItem(ListItem<Product> item) {
                Product product = item.getModelObject();
                item.add(new Label("productName",
                         new Model<String>(product.getName())));
                item.add(new Label("productPrice",
                         new Model<String>(product.getPrice())));
            }
        };
        add(lv);
    }
}
