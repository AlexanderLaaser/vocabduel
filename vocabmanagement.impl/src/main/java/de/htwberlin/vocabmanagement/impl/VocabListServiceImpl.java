package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class VocabListServiceImpl implements VocabListService{

    VocabListDao vocabListDao;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public VocabListServiceImpl(VocabListDao vocabListDao) {
        super();
        this.vocabListDao = vocabListDao;
    }

    @Transactional
    public VocabList createVocabList(List<VocabItem> VocabItemList, Language languageLeft, Language languageRight, Category category) {
        VocabList vocablist = new VocabList(VocabItemList,languageLeft,languageRight,category);
        vocabListDao.saveVocabList(vocablist);

        return vocablist;
    }

    @Transactional
    public VocabList getVocabListByID(long VocabListId){
        if(vocabListDao.getvocabListById(VocabListId) == null){
            VocabList vocabList = vocabListDao.getvocabListById(VocabListId);
            return vocabList;
        }else{
            return null;
        }
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
    @Transactional
    //ToDo Try Catch usw. schreiben
    //ToDo Was passiert mit den entsprechenden Vokabeln wenn wir eine VocabList löschen?
    public void deleteVocabListbyId(Long VocabListId) {
            VocabList vocabList = vocabListDao.getvocabListById(VocabListId);
            vocabListDao.deleteVocabList(vocabList);
    }

    @Override
    @Transactional
    public List<VocabList> getAllExistingVocabLists(){
        if(vocabListDao.getAllVocabLists() == null){
            List<VocabList> vocabList = vocabListDao.getAllVocabLists();
            System.out.println(vocabList);
            return vocabList;
        }else{
            return null;
        }
    }

    public List<VocabItem> getAllItemsInVocabList(Long listenId) {
        List<VocabItem> ListOfVocabItems = vocabListDao.getItemsInVocabList(listenId);

        return ListOfVocabItems;
    }


}
