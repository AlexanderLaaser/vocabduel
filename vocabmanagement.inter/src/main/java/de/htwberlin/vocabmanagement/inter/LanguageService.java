package de.htwberlin.vocabmanagement.inter;

public interface LanguageService {

    /**
     * Methode erstellt eine Sprache
     * @param LanguageName - Name der Sprache
     * @return ein Sprachen-Objekt
     */
    Language createLanguage(String LanguageName) throws InvalidNameException;

    Language findLanguageByLanguageName(String LanguageName);

    void storeLanguage(Language language);
}
