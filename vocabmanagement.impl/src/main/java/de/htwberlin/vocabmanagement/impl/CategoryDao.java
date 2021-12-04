package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;

import java.util.List;

public interface CategoryDao {

    //ToDo Java Doc
    void saveCategory(Category category);

    Category getCategoryByCategoryName(String categoryName);

    Category getCategoryById(Long id);

    void checkingCategoryName(String categoryName);
}
