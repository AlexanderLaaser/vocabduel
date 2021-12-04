package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveCategory(Category category) {
        em.persist(category);
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        Category category = em.find(Category.class, categoryName);

        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        Category actualCategory = em.find(Category.class, id);

        return actualCategory;
    }

    @Override
    public void checkingCategoryName(String categoryName) {

    }
}
