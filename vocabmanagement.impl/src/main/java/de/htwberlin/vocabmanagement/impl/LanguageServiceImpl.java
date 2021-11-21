package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Language;
import de.htwberlin.vocabmanagement.inter.LanguageService;
import org.springframework.stereotype.Component;

@Component
public class LanguageServiceImpl implements LanguageService {

    @Override
    public Language createLanguage(String LanguageName) {
        Language language = new Language(1L,LanguageName);
        return language;
    }
}
