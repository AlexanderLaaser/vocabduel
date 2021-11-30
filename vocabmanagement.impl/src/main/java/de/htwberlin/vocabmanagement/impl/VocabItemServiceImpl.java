package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabItemService;
import de.htwberlin.vocabmanagement.inter.VocabList;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VocabItemServiceImpl implements VocabItemService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();

    @Override
    public VocabItem createVocabItem(String leftLan, List<String> rightLan) {
        VocabItem vocabItem = new VocabItem(leftLan, rightLan);

        em.getTransaction().begin();
        em.persist(vocabItem);
        em.getTransaction().commit();

        return vocabItem;
    }

    public List<VocabItem> createVocabItemOufOfMap(Map<String, List<String>> map){
        List<VocabItem> VocabItemList = new ArrayList<VocabItem>();

        for (String key : map.keySet())
        {
            VocabItem vocabItem = createVocabItem(key,map.get(key));
            VocabItemList.add(vocabItem);
        }

        return VocabItemList;
    }

    @Override
    public void addVocabName(List<String> leftLan, List<String> rightLan, int VocabItemID) {

    }

    @Override
    public VocabItem getVocabName(int VocabItem) {
        return null;
    }

}
