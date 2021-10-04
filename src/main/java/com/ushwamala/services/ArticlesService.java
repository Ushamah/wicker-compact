package com.ushwamala.services;

import java.math.BigDecimal;

import com.ushwamala.entities.Article;

public class ArticlesService extends BaseService<Article>{
    public ArticlesService() {
        final CategoryService categoryService = ServiceRegistry.get(CategoryService.class);

        final Article cappuccino = new Article(categoryService.get(1L), "Cappuccino", "https://images.freeimages.com/images/large-previews/a79/cappuccino-1497220.jpg",
                new BigDecimal("3.20"), "Italian coffee speciality, which is made out of  Espresso und hot milk.");

        save(cappuccino);
    }
}
