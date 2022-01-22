package de.htwberlin.vocabmanagement.controller;

import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.CategoryService;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * POST Request zum Ergänzen einer Kategorie
     * @param categoryName - Name der Kategorie
     * @return Category obj
     * @throws InvalidNameException
     */
    @PostMapping("/category")
    public Category newCategory(@RequestBody String categoryName) throws InvalidNameException {
        return categoryService.createCategory(categoryName);
    }

    /**
     * 1. Todo Exception "CategoryNotFoundException" als API Response übergeben
     * 2. Todo Exception "CategoryNotFoundAdvice" als HTTP Display anlegen -> https://spring.io/guides/tutorials/rest/
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public Category searchCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
