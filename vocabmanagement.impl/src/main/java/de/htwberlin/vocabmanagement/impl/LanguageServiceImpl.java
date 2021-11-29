package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.Language;
import de.htwberlin.vocabmanagement.inter.LanguageService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class LanguageServiceImpl implements LanguageService {

    private LanguageDaoImpl languageDao;

    @Override
    @Transactional
    public Language createLanguage(String languageName) throws InvalidNameException {
        checkingLanguageName(languageName);

        if(getLanguageByLanguageName(languageName) == null){
            Language tempLanguage = new Language(languageName);
            languageDao.saveLanguage(tempLanguage);
            return tempLanguage;
        }else{
            return getLanguageByLanguageName(languageName);
        }
    }

    @Override
    @Transactional
    public Language getLanguageByLanguageName(String languageName) {
        if(!languageDao.getLanguageByLanguageName(languageName).isEmpty()){
            Language language = languageDao.getLanguageByLanguageName(languageName).get(0);
            return language;
        }else{
            return null;
        }
    }

    private void checkingLanguageName(String LanguageName) throws InvalidNameException {
        //checking for empty inputs or spaces
        if ((LanguageName == null) || LanguageName.contains(" ") || LanguageName.equals("")){
            throw new InvalidNameException("Kategorie-Name darf nicht leer sein!");
        }else if (LanguageName.matches("[a-zA-Z_?]*") == false){
            throw new InvalidNameException("Name darf keine Sonderzeichen oder Nummern enthalten!");
        }
    }
}
