package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.Language;
import de.htwberlin.vocabmanagement.inter.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

@Service
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
        checkingLanguageName(languageName);

        if(findLanguageByLanguageName(languageName) == null){
            Language tempLanguage = new Language(languageName);
            storeLanguage(tempLanguage);

            return tempLanguage;
        }else{
            return findLanguageByLanguageName(languageName);
        }
    }

    @Override
    public Language findLanguageByLanguageName(String languageName) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        Language language = languageDao.getLanguageByName(languageName);
        transactionManager.commit(ts);

        return language;
    }

    public void storeLanguage(Language language){
        TransactionStatus ts = transactionManager.getTransaction(null);
        languageDao.saveLanguage(language);
        transactionManager.commit(ts);
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
