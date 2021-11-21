package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.CategoryService;

import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {
    
    @Override
    public Category createCategory(String categoryName) throws InvalidNameException {
        checkingCategoryName(categoryName);
        
        return new Category(1L,categoryName);
    }

    @Override
    public Category checkingForDuplicates(String categoryName) {
        return null;
    }

    private void checkingCategoryName(String categoryName) throws InvalidNameException {
        //checking for empty inputs or spaces
        if ((categoryName == null) || categoryName.contains(" ") || categoryName.equals("")){
            throw new InvalidNameException("Kategorie-Name darf nicht leer sein!");
        }else if (categoryName.matches("[a-zA-Z_?]*") == false){
                throw new InvalidNameException("Name darf keine Sonderzeichen oder Nummern enthalten!");
        }

        //checking if category is already existing
        //checkingForDuplicates();
    }
}
