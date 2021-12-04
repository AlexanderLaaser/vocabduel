package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Language;


public interface LanguageDao {

    void saveLanguage(Language language);

    Language getLanguageByName(String languageName);

    Language getLanguageById(Long languageId);
}
