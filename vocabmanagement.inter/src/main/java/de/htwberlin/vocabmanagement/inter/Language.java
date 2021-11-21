package de.htwberlin.vocabmanagement.inter;

public class Language {

    private long languageID;
    private String LanguageName;

    public Language(long languageID, String languageName) {
        this.languageID = languageID;
        LanguageName = languageName;
    }

    public long getLanguageID() {
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
