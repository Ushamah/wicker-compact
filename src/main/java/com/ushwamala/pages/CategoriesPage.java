package com.ushwamala.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ushwamala.entities.Category;
import com.ushwamala.services.CategoryService;
import com.ushwamala.services.ServiceRegistry;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CategoriesPage extends BaseEntitiesPage {
    private final DataView<Category> categoriesDataView;

    public CategoriesPage(PageParameters parameters) {
        super(parameters);
        //Inject the CategoryService
        CategoryService categoryService = ServiceRegistry.get(CategoryService.class);
        //Get all the categoriesDataView
        final Collection<Category> tenantCategories = categoryService.listAll();
        final List<Category> categoryList = new ArrayList<>(tenantCategories);
        //create a data provider
        final IDataProvider<Category> categoryDataProvider = new ListDataProvider<>(categoryList);
        categoriesDataView = new DataView<>("categories", categoryDataProvider) {
            //Implement the populateItem method
            protected void populateItem(Item<Category> item) {
                //display the name of the category using a label
                final Category category = item.getModelObject();
                item.add(new Label("name", LambdaModel.of(category::getName)));
                //create an attributeAppender "src" and give it a value of item.getModelObject().getImageUrl()
                final AttributeAppender imgSrcAppender = new AttributeAppender(
                        "src", LambdaModel.of(category::getImageUrl)
                );
                //add the imgSr to the item
                item.add(new WebMarkupContainer("image").add(imgSrcAppender));
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        //set the number of categoriesDataView per page
        categoriesDataView.setItemsPerPage(3);
        add(categoriesDataView);

    }

    @Override
    protected IPageable getPageable() {
        return categoriesDataView;
    }
}
