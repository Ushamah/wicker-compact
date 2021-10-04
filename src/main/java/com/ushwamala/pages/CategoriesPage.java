package com.ushwamala.pages;

import java.util.ArrayList;
import java.util.List;

import com.ushwamala.entities.Category;
import com.ushwamala.services.CategoryService;
import com.ushwamala.services.ServiceRegistry;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CategoriesPage extends BaseEntitiesPage {
    public CategoriesPage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        //Inject the CategoryService
        CategoryService categoryService = ServiceRegistry.get(CategoryService.class);
        //Get all the categoriesDataView
        final List<Category> categoryList = new ArrayList<>(categoryService.listAll());
        //create a data provider
        final IDataProvider<Category> categoryDataProvider = new ListDataProvider<>(categoryList);
        //Create a ListView from the retrieved categoriesDataView
        final DataView<Category> categoriesDataView = new DataView<Category>("categories", categoryDataProvider) {
            //Implement the populateItem method
            protected void populateItem(Item<Category> item) {
                //display the name of the category using a label
                item.add(new Label("name", item.getModelObject().getName()));
                //create an attributeAppender "src" and give it a value of item.getModelObject().getImageUrl()
                final AttributeAppender imgSrcAppender = new AttributeAppender(
                        "src", item.getModelObject().getImageUrl()
                );
                //add the imgSr to the item
                item.add(new WebMarkupContainer("image").add(imgSrcAppender));
            }
        };
        //set the number of categoriesDataView per page
        categoriesDataView.setItemsPerPage(3);
        //add a paging navigator
        final PagingNavigation pagingNavigation = new PagingNavigation("navigator", categoriesDataView);
        add(categoriesDataView);
        add(pagingNavigation);
    }
}
