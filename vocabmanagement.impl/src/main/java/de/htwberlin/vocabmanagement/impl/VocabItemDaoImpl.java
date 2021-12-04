package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.VocabItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
