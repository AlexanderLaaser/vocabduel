package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Language;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class LanguageDaoImpl implements LanguageDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveLanguage(Language language) {
        em.persist(language);
    }

    @Override
    public Language getLanguageByName(String languageName) {
        TypedQuery<Language> LanguageResultList = em.createQuery("SELECT l FROM Language AS l WHERE l.LanguageName LIKE :pattern", Language.class);
        LanguageResultList.setParameter("pattern", languageName);
        if(!LanguageResultList.getResultList().isEmpty()){
            Language language = LanguageResultList.getResultList().get(0);
            return language;
        }else{
            return null;
        }
    }

    @Override
    public Language getLanguageById(Long languageId) {
        Language language = em.find(Language.class, languageId);

        return language;
    }


}
