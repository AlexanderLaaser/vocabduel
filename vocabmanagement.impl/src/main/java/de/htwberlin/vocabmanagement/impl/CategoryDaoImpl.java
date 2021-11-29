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
    public List<Category> getCategoryByCategoryName(String categoryName) {
        TypedQuery<Category> q = em.createQuery("SELECT c FROM Category AS c WHERE c.categoryName LIKE :pattern", Category.class);
        q.setParameter("pattern", categoryName);
        List<Category> CatResult = q.getResultList();

        return CatResult;
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
