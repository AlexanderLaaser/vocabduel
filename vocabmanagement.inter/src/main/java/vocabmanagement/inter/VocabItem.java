package vocabmanagement.inter;

import java.util.List;

public class VocabItem {

    private String vocabName;
    private List<String> translations;

    public VocabItem(String vocabName, List<String> translations) {
        super();
        this.vocabName = vocabName;
        this.translations = translations;
    }

    public String getVocabName() {
        return vocabName;
    }

    public void setVocabName(String vocabName) {
        this.vocabName = vocabName;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }
}
