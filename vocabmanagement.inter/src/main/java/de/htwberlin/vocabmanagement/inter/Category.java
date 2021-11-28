package de.htwberlin.vocabmanagement.inter;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long categoryID;

    @Column(name = "categoryName")
    private String categoryName;

    public Category(Long categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public Category() {

    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
