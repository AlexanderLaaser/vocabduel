package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.InvalidListIdException;
import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VocabListDaoImpl implements VocabListDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveVocabList(VocabList vocabList) {
        em.persist(vocabList);
    }

    @Override
    public VocabList getvocabListById(Long vocabListId) {
        VocabList vocabList = em.find(VocabList.class, vocabListId);
        return vocabList;
    }

    @Override
    public void deleteVocabList(VocabList vocabList) {
        em.remove(vocabList);
        List<VocabItem> listofVocabItems = vocabList.getItemlist();
        for (VocabItem item : listofVocabItems){
            em.remove(item);
        }
    }

    public List<VocabList> getAllVocabLists(){
        TypedQuery<VocabList> vl = em.createQuery("SELECT vl FROM VocabList AS vl", VocabList.class);
        List<VocabList> VocabListResult = vl.getResultList();
        return VocabListResult;
    }

    @Override
    public List<VocabItem> getItemsInVocabList(Long ListId) {
        TypedQuery<VocabItem> vl = (TypedQuery<VocabItem>) em.createQuery("SELECT vl.itemlist FROM VocabList vl WHERE vl.listID like :listId");
        vl.setParameter("listId", ListId);
        List<VocabItem> items = vl.getResultList();

        return items;
    }
}
