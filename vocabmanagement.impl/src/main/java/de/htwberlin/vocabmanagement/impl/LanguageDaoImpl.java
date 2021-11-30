package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Language;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LanguageDaoImpl implements LanguageDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveLanguage(Language language) {
        em.persist(language);
    }

    @Override
    public List<Language> getLanguageByLanguageName(String languageName) {
        TypedQuery<Language> q = em.createQuery("SELECT l FROM Language AS l WHERE l.LanguageName LIKE :pattern", Language.class);
        q.setParameter("pattern", languageName);
        List<Language> languageResult = q.getResultList();

        return languageResult;
    }
}
