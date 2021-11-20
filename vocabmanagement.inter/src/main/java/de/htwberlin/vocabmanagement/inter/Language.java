package de.htwberlin.vocabmanagement.inter;

public class Language {

    private int languageID;
    private String LanguageName;

    public Language(int languageID, String languageName) {
        this.languageID = languageID;
        LanguageName = languageName;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getLanguageName() {
        return LanguageName;
    }

    public void setLanguageName(String languageName) {
        LanguageName = languageName;
    }
}
