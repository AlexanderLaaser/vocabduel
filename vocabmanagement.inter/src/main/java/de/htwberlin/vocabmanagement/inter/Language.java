package de.htwberlin.vocabmanagement.inter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language {

    @Id
    @GeneratedValue
    private long languageID;
    private String LanguageName;

    public Language(long languageID, String languageName) {
        this.languageID = languageID;
        LanguageName = languageName;
    }

    public Language() {

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
