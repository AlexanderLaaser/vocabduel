package de.htwberlin.vocabmanagement.inter;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(Long id){
        super("Could not find category with ID: " + id);
    }
}
