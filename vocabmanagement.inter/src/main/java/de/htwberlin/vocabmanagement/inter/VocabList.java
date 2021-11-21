package de.htwberlin.vocabmanagement.inter;

import java.util.List;
import java.util.Map;

public class VocabList {

    private long listID;
    private Language firstLanguage;
    private Language secLanguage;
    private Category category;
    private Map<String, List<VocabItem>> itemlist;

    public VocabList(long listID, Language first_language, Language sec_language, Category category, Map<String,List<VocabItem>> itemlist) {
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

    public void setVocabList(Map<String, List<VocabItem>> itemlist) {
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

    public Map<String, List<VocabItem>> getItemlist() {
        return itemlist;
    }

    public void setVocabList(List<VocabItem> vocabList) {
        vocabList = vocabList;
    }

    public VocabList getVocabListByID(int vocablistId) {
        return null;
    }
}
