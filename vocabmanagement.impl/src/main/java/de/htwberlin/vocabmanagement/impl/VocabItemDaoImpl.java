package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.VocabItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class VocabItemDaoImpl implements VocabItemDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveVocabItem(VocabItem vocabitem) {
        em.persist(vocabitem);
    }

    @Override
    public VocabItem getvocabItemById(Long vocabitemId) {
        VocabItem vocabItem = em.find(VocabItem.class, vocabitemId);

        return vocabItem;
    }

    @Override
    public VocabItem getvocabItemByName(String vocabName) {
        TypedQuery<VocabItem> vocabItemResultList = em.createQuery("SELECT v FROM VocabItem AS v WHERE leftlan LIKE :pattern", VocabItem.class);
        vocabItemResultList.setParameter("pattern", vocabName);
        if(!vocabItemResultList.getResultList().isEmpty()){
            VocabItem vocabItem = vocabItemResultList.getResultList().get(0);
            return vocabItem;
        }else{
            return null;
        }
    }
}
