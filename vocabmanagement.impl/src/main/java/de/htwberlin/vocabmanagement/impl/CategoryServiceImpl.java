package de.htwberlin.vocabmanagement.impl;
import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.CategoryService;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import javax.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao, PlatformTransactionManager transactionManager) {
        super();
        this.categoryDao = categoryDao;
        this.transactionManager = transactionManager;
    }
    
    @Override
    @Transactional
    public Category createCategory(String categoryName) throws InvalidNameException {
        TransactionStatus ts = transactionManager.getTransaction(null);
        checkingCategoryName(categoryName);

        if(getCategoryByCategoryName(categoryName) == null){
            Category tempCat = new Category(categoryName);
            categoryDao.saveCategory(tempCat);
            transactionManager.commit(ts);
            return tempCat;
        }else{
            return getCategoryByCategoryName(categoryName);
        }
    }

    @Override
    @Transactional
    public Category getCategoryByCategoryName(String categoryName) {
        if(categoryDao.getCategoryByCategoryName(categoryName) == null){
            Category category = categoryDao.getCategoryByCategoryName(categoryName);
            return category;
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public Category getCategoryById(Long id) throws InvalidNameException {
        Category category = categoryDao.getCategoryById(id);

        return category;
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
