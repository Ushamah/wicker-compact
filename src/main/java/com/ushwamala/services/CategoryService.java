package com.ushwamala.services;

import com.ushwamala.entities.Category;

public class CategoryService extends BaseService<Category> {

    public CategoryService() {
        final Category coffee = new Category("Coffee", "https://images.freeimages.com/images/large-previews/5a3/raw-espresso-2-1177689.jpg");
        final Category tea = new Category("Tea", "https://images.freeimages.com/images/large-previews/ff1/tea-1327515.jpg");
        final Category drinks = new Category("Soft Drinks", "https://images.freeimages.com/images/large-previews/9c2/coca-cola-1189757.jpg");
        final Category beer = new Category("Beers", "https://images.freeimages.com/images/large-previews/dff/three-champion-1328253.jpg");
        final Category breakfast = new Category("Breakfast", "https://images.freeimages.com/images/large-previews/def/sandwich-4-1525938.jpg");
        final Category snacks = new Category("Snacks", "https://images.freeimages.com/images/large-previews/0a6/butter-biscuits-1329768.jpg");
        final Category burger = new Category("Burger", "https://images.freeimages.com/images/large-previews/dbe/burger-on-a-plate-1328009.jpg");

        save(coffee);
        save(tea);
        save(drinks);
        save(beer);
        save(breakfast);
        save(snacks);
        save(burger);
    }
}