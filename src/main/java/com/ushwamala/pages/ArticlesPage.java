package com.ushwamala.pages;

import java.util.ArrayList;
import java.util.Collection;

import com.ushwamala.entities.Article;
import com.ushwamala.services.ArticlesService;
import com.ushwamala.services.ServiceRegistry;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ArticlesPage extends BaseEntitiesPage {

    private final DataView<Article> articles;

    public ArticlesPage(PageParameters parameters) {
        super(parameters);
        final ArticlesService articlesService = ServiceRegistry.get(ArticlesService.class);
       var tenantArticles = articlesService.listAll();
        IDataProvider<Article> dataProvider = new ListDataProvider<>(new ArrayList<>(tenantArticles));
        this.articles = new DataView<>("articles", dataProvider) {

            @Override
            protected void populateItem(Item<Article> item) {
                final Article article = item.getModelObject();
                item.setModel(new CompoundPropertyModel<>(article));
                item.add(new Label("name"));
                item.add(new Label("category.name"));
                item.add(new Label("description"));
                item.add(new Label("price"));
                item.add(new Label("validFrom"));
                item.add(new Label("validTo"));

                final AttributeAppender srcAppender = new AttributeAppender("src", item.getModelObject().getImageUrl());
                item.add(new WebMarkupContainer("image").add(srcAppender));
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(this.articles);
    }

    @Override
    protected IPageable getPageable() {
        return this.articles;
    }
}