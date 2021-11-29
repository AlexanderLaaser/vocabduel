package de.htwberlin.vocabmanagement.inter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long languageID;

    @Column(name = "languagename")
    private String LanguageName;

    public Language(String languageName) {
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
