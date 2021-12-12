package de.htwberlin.vocabmanagement.impl;
import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.CategoryService;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

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
    public Category createCategory(String categoryName) throws InvalidNameException {
        checkingCategoryName(categoryName);

        if(getCategoryByCategoryName(categoryName) == null){
            Category tempCat = new Category(categoryName);
            storeCategory(tempCat);
            return tempCat;
        }else{
            return getCategoryByCategoryName(categoryName);
        }
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        Category category = categoryDao.getCategoryByCategoryName(categoryName);
        transactionManager.commit(ts);

        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        Category category = categoryDao.getCategoryById(id);
        transactionManager.commit(ts);

        return category;
    }

    @Override
    public void storeCategory(Category category) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        categoryDao.saveCategory(category);
        transactionManager.commit(ts);

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
