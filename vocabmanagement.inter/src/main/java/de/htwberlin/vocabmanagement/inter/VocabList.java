package de.htwberlin.vocabmanagement.inter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "VocabList")
public class VocabList {

    @Id
    @GeneratedValue
    private long listID;

    @OneToOne
    @Column(name = "Language")
    private Language firstLanguage;

    @OneToOne
    @Column(name = "Language")
    private Language secLanguage;

    @OneToOne
    @Column(name = "Category")
    private Category category;

    @ManyToMany
    private List<VocabItem> itemlist;

    public VocabList(long listID, Language first_language, Language sec_language, Category category, List<VocabItem> itemlist) {
        this.listID = listID;
        this.firstLanguage = first_language;
        this.secLanguage = sec_language;
        this.category = category;
        this.itemlist = itemlist;
    }

    public VocabList(long listID, Language first_language, Language sec_language, Category category) {
        this.listID = listID;
        this.firstLanguage = first_language;
        this.secLanguage = sec_language;
        this.category = category;
    }

    public VocabList() {

    }

    public void setVocabList(List<VocabItem> itemlist) {
        this.itemlist = itemlist;
    }

    public long getListID() {
        return listID;
    }

    public void setListID(long listID) {
        this.listID = listID;
    }

    public Language getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(Language firstLanguage) {
        this.firstLanguage = firstLanguage;
    }

    public Language getSecLanguage() {
        return secLanguage;
    }

    public void setSecLanguage(Language secLanguage) {
        this.secLanguage = secLanguage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<VocabItem> getItemlist() {
        return itemlist;
    }

    public VocabList getVocabListByID(int vocablistId) {
        return null;
    }
}
