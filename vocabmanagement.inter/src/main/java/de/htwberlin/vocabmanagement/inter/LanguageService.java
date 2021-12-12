package de.htwberlin.vocabmanagement.inter;

public interface LanguageService {

    /**
     * Methode erstellt eine Sprache
     * @param LanguageName - Name der Sprache
     * @return ein Sprachen-Objekt
     */
    Language createLanguage(String LanguageName) throws InvalidNameException;


    /**
     * Methode findet die Sprache
     * @param LanguageName Name der Sprache
     * @return gibt die Sprache zurück
     */
    Language findLanguageByLanguageName(String LanguageName);

    /**
     * Methode um die Sprache zu speichern
     * @param language übergibt eine Sprache
     */
    void storeLanguage(Language language);
}
