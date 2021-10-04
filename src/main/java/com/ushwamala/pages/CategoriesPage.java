package com.ushwamala.pages;

import java.util.ArrayList;
import java.util.List;

import com.ushwamala.entities.Category;
import com.ushwamala.services.CategoryService;
import com.ushwamala.services.ServiceRegistry;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CategoriesPage extends BaseEntitiesPage{
    public CategoriesPage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
            //Inject the CategoryService
            CategoryService categoryService = ServiceRegistry.get(CategoryService.class);
            //Get all the categories
            final List<Category> categoryList = new ArrayList<>(categoryService.listAll());
            //Create a ListView from the retrieved categories
            final ListView<Category> categories = new ListView<>("categories", categoryList) {
                //Implement the populateItem method
                @Override
                protected void populateItem(ListItem<Category> listItem) {
                    //display the name of the category using a label
                    listItem.add(new Label("name", listItem.getModelObject().getName()));
                    //create an attributeAppender "src" and give it a value of listItem.getModelObject().getImageUrl()
                    final AttributeAppender imgSrcAppender = new AttributeAppender(
                            "src", listItem.getModelObject().getImageUrl()
                    );
                    //add the imgSr to the listItem
                    listItem.add(new WebMarkupContainer("image").add(imgSrcAppender));
                }
            };
            add(categories);
    }
}
