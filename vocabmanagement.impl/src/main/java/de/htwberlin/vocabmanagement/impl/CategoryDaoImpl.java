package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.Language;
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
        TypedQuery<Category> CategoryResultList = em.createQuery("SELECT c FROM Category AS c WHERE categoryName LIKE :pattern", Category.class);
        CategoryResultList.setParameter("pattern", categoryName);
        if(!CategoryResultList.getResultList().isEmpty()){
            Category category = CategoryResultList.getResultList().get(0);
            return category;
        }else{
            return null;
        }
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
