package de.htwberlin.vocabmanagement.impl;
import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.CategoryService;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDaoImpl categoryDao;
    
    @Override
    @Transactional
    public Category createCategory(String categoryName) throws InvalidNameException {
        checkingCategoryName(categoryName);

        if(getCategoryByCategoryName(categoryName) == null){
            Category tempCat = new Category(categoryName);
            categoryDao.saveCategory(tempCat);
            return tempCat;
        }else{
            return getCategoryByCategoryName(categoryName);
        }
    }

    @Override
    @Transactional
    public Category getCategoryByCategoryName(String categoryName) {
        if(!categoryDao.getCategoryByCategoryName(categoryName).isEmpty()){
            Category category = categoryDao.getCategoryByCategoryName(categoryName).get(0);
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
