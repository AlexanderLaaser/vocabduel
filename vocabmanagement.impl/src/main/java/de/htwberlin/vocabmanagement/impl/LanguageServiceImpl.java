package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.Language;
import de.htwberlin.vocabmanagement.inter.LanguageService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class LanguageServiceImpl implements LanguageService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();

    @Override
    public Language createLanguage(String languageName) throws InvalidNameException {
        checkingLanguageName(languageName);

        if(getLanguageByLanguageName(languageName) == null){
            Language tempLanguage = new Language(languageName);
            em.getTransaction().begin();
            em.persist(tempLanguage);
            em.getTransaction().commit();
            return tempLanguage;
        }else{
            return getLanguageByLanguageName(languageName);
        }
    }

    public Language getLanguageByLanguageName(String LanguageName) {
        em.getTransaction().begin();
        TypedQuery<Language> q = em.createQuery("SELECT l FROM Language AS l WHERE l.LanguageName LIKE :pattern", Language.class);
        q.setParameter("pattern", LanguageName);
        List<Language> LanguageResult = q.getResultList();
        em.getTransaction().commit();
        if(!LanguageResult.isEmpty()){
            Language language = LanguageResult.get(0);
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
