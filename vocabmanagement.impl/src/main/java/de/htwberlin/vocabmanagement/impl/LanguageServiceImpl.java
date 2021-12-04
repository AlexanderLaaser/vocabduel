package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.Language;
import de.htwberlin.vocabmanagement.inter.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import javax.transaction.Transactional;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

    private LanguageDao languageDao;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public LanguageServiceImpl(LanguageDao languageDao, PlatformTransactionManager transactionManager) {
        super();
        this.languageDao = languageDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public Language createLanguage(String languageName) throws InvalidNameException {
        TransactionStatus ts = transactionManager.getTransaction(null);
        checkingLanguageName(languageName);

        if(languageDao.getLanguageByName(languageName) == null){
            Language tempLanguage = new Language(languageName);
            languageDao.saveLanguage(tempLanguage);
            transactionManager.commit(ts);

            return tempLanguage;
        }else{
            return languageDao.getLanguageByName(languageName);
        }
      }

    public void storeLanguageInDB(Language language){
        TransactionStatus ts = transactionManager.getTransaction(null);
        languageDao.saveLanguage(language);
        transactionManager.commit(ts);
    }

    @Override
    public Language getLanguageByLanguageName(String languageName) {
        if(languageDao.getLanguageByName(languageName) == null){
            Language language = languageDao.getLanguageByName(languageName);
            return language;
        }else{
            return languageDao.getLanguageByName(languageName);
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
