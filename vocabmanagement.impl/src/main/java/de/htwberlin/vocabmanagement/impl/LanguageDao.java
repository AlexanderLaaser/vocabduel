package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.Language;

import java.util.List;

public interface LanguageDao {

    void saveLanguage(Language language);

    List<Language> getLanguageByLanguageName(String languageName);
}
