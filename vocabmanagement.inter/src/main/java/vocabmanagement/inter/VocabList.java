package vocabmanagement.inter;

import java.util.List;

public class VocabList {

    private int listID;
    private Language firstLanguage;
    private Language secLanguage;
    private Category category;
    private List<VocabItem> VocabList;

    public VocabList(int listID, Language first_language, Language sec_language, Category category, List<VocabItem> vocabList) {
        this.listID = listID;
        this.firstLanguage = first_language;
        this.secLanguage = sec_language;
        this.category = category;
        VocabList = vocabList;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
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

    public List<VocabItem> getVocabList() {
        return VocabList;
    }

    public void setVocabList(List<VocabItem> vocabList) {
        VocabList = vocabList;
    }
}
