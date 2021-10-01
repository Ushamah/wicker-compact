package com.ushwamala.panels;

import com.ushwamala.enums.Tenant;
import com.ushwamala.links.PageLink;
import com.ushwamala.pages.ArticlesPage;
import com.ushwamala.pages.CategoriesPage;
import com.ushwamala.pages.TablesPage;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {

    private WebMarkupContainer navbar;

    public HeaderPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        navbar = new WebMarkupContainer("navbar");
        navbar.add(new PageLink("dashboard", getApplication().getHomePage()));
        navbar.add(new PageLink("categories", CategoriesPage.class));
        navbar.add(new PageLink("articles", ArticlesPage.class));
        navbar.add(new PageLink("tables", TablesPage.class));

        final Tenant tenant = Tenant.get();
        navbar.add(new ContextImage("brand", tenant.equals(Tenant.DEFAULT) ? "sg-logo.PNG" : "cafeone-logo.png"));
        navbar.add(new AttributeAppender("class", tenant.equals(Tenant.DEFAULT) ? " navbar-dark bg-dark" : " navbar-light bg-light"));
        add(navbar);
    }
}
