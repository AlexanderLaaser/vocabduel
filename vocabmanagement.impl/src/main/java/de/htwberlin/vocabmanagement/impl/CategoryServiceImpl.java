package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.CategoryService;

import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();
    
    @Override
    public Category createCategory(String categoryName) throws InvalidNameException {

        if(getCategoryByCategoryName(categoryName) == null){
            Category tempCat = new Category(categoryName);

            em.getTransaction().begin();
            em.persist(tempCat);
            em.getTransaction().commit();

            return tempCat;
        }else{
            return null;
        }
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {

        em.getTransaction().begin();
        TypedQuery<Category> q = em.createQuery("SELECT c FROM Category AS c WHERE c.categoryName LIKE :pattern", Category.class);
        q.setParameter("pattern", categoryName);
        List<Category> CatResult = q.getResultList();
        em.getTransaction().commit();
        if(!CatResult.isEmpty()){
            Category category = CatResult.get(0);
            return category;
        }else{
            return null;
        }
    }

    public Category getCategoryById(Long id) throws InvalidNameException {

        em.getTransaction().begin();
        Category actualCategory = em.find(Category.class, id);
        em.getTransaction().commit();

        System.out.println(actualCategory.getCategoryID());
        return actualCategory;
    }

    private void checkingCategoryName(String categoryName) throws InvalidNameException {
        //checking for empty inputs or spaces
        if ((categoryName == null) || categoryName.contains(" ") || categoryName.equals("")){
            throw new InvalidNameException("Kategorie-Name darf nicht leer sein!");
        }else if (categoryName.matches("[a-zA-Z_?]*") == false){
                throw new InvalidNameException("Name darf keine Sonderzeichen oder Nummern enthalten!");
        }
    }
}
