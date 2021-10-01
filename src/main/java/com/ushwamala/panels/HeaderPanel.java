package com.ushwamala.panels;

import com.ushwamala.pages.ArticlesPage;
import com.ushwamala.pages.CategoriesPage;
import com.ushwamala.pages.TablesPage;
import com.ushwamala.resources.LogoResourceReference;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {
    public HeaderPanel(String id) {
        super(id);
        add(new BookmarkablePageLink<Void>("dashboard", getApplication().getHomePage()));
        add(new BookmarkablePageLink<Void>("categories", CategoriesPage.class));
        add(new BookmarkablePageLink<Void>("articles", ArticlesPage.class));
        add(new BookmarkablePageLink<Void>("tables", TablesPage.class));

        add(new Image("brand", new LogoResourceReference()));

    }
}
