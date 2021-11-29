package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VocabListServiceImpl implements VocabListService{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();

    public VocabList createVocabList(List<VocabItem> VocabItemList, Language languageLeft, Language languageRight, Category category) {
        VocabList vocablist = new VocabList(VocabItemList,languageLeft,languageRight,category);
        em.getTransaction().begin();
        em.persist(vocablist);
        em.getTransaction().commit();

        return vocablist;
    }

    public VocabList getVocabListByID(long VocabListId){
        return null;
    }

    public void addItemToVocabSet(int VocabItemId, int VocabListId){
    }

    @Override
    public Category getCategoryOfVocabList(int VocabListId) {
        return null;
    }

    @Override
    public HashMap importVocabStringsFromTextFile(String filename) throws IOException {

        String filePath = filename;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null)
        {
            List ValueList = new ArrayList();
            String[] parts = line.split(":", 2);
            if (parts.length >= 2)
            {
                String key = parts[0];
                key = key.replace("{","");
                key = key.replace("}","");
                key = key.replace(" ","");
                String value = parts[1];
                value = value.replace("{","");
                value = value.replace("}","");
                value = value.replace(" ","");

                String[] listOfValues = value.split(",");
                for (String ele:listOfValues) {
                    ValueList.add(ele);
                }

                String[] listOfKeys = key.split(",");
                for (String ele:listOfKeys) {
                    map.put(ele, ValueList);
                }
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
        reader.close();
        return map;
    }

    @Override
    public void deleteVocabListbyId(int VocabListId) {

    }

    public List<VocabList> getAllExistingVocabLists(){

        em.getTransaction().begin();
        TypedQuery<VocabList> vl = em.createQuery("SELECT vl FROM VocabList AS vl", VocabList.class);
        List<VocabList> VocabListResult = vl.getResultList();
        em.getTransaction().commit();
        return VocabListResult;
    }

    //Kann man auch in UI view machen
    public void prepareExistingListsForOutput(){

        for (int i = 0; i < getAllExistingVocabLists().size(); i++) {
            VocabList vocabList = getAllExistingVocabLists().get(i);
            System.out.println("ID: " + vocabList.getListID() + " firstLanguage: " + vocabList.getFirstLanguage() + "secLanguage:" + vocabList.getSecLanguage());
        }

    }

    public List<VocabItem> getAllItemsInVocabList(Long listenId) {
        em.getTransaction().begin();
        TypedQuery<VocabItem> vl = (TypedQuery<VocabItem>) em.createQuery("SELECT vl.itemlist FROM VocabList vl WHERE vl.listID like :listId");
        vl.setParameter("listId", listenId);
        List<VocabItem> items = vl.getResultList();
        em.getTransaction().commit();

        List<VocabItem> itemlist = new ArrayList<>();
        for (VocabItem vocabItem: items) {
            System.out.println(vocabItem.getVocabItemID());
        }
        return items;
    }


}
