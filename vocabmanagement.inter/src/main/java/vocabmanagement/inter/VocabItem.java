package vocabmanagement.inter;

import java.util.List;

public class VocabItem {

    private Long vocabItemID;
    private List<String> firstLanguage;
    private List<String> secLanguage;
    private String Lernstatus;

    public VocabItem(Long vocabItemID, List<String> vocabName, List<String> translations) {
        this.vocabItemID = vocabItemID;
        this.firstLanguage = vocabName;
        this.secLanguage = translations;
    }

    public Long getVocabItemID() {
        return vocabItemID;
    }

    public void setVocabItemID(Long vocabItemID) {
        this.vocabItemID = vocabItemID;
    }

    public List<String> getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(List<String> firstLanguage) {
        this.firstLanguage = firstLanguage;
    }

    public List<String> getSecLanguage() {
        return secLanguage;
    }

    public void setSecLanguage(List<String> secLanguage) {
        this.secLanguage = secLanguage;
    }
}
