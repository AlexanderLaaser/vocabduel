package de.htwberlin.vocabmanagement.inter;

import java.util.List;

public class VocabItem {

    private Long vocabItemID;
    private String leftlan;
    private List<String> rightlan;

    public VocabItem(Long vocabItemID, String vocabName, List<String> translations) {
        this.vocabItemID = vocabItemID;
        this.leftlan = vocabName;
        this.rightlan = translations;
    }

    public Long getVocabItemID() {
        return vocabItemID;
    }

    public void setVocabItemID(Long vocabItemID) {
        this.vocabItemID = vocabItemID;
    }

    public String getFirstLanguage() {
        return leftlan;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.leftlan = firstLanguage;
    }

    public List<String> getSecLanguage() {
        return rightlan;
    }

    public void setSecLanguage(List<String> secLanguage) {
        this.rightlan = secLanguage;
    }
}
