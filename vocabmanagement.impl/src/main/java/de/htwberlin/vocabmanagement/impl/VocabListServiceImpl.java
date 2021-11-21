package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VocabListServiceImpl implements VocabListService{

    //private VocabItemServiceImpl vocabItemServiceImpl;

    public VocabList createVocabList(Map VocabItemList, Language languageLeft, Language languageRight, Category category) {

        VocabList vocablist = new VocabList(1L,languageLeft,languageRight,category,VocabItemList);
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
    public List<String> getAllItemsInVocabList(VocabList vocabList) {

        Map map = (Map) vocabList;

        for (Object key : map.keySet())
        {
            // Erstellt pro Map ein Item Objekt
            //vocabItemServiceImpl.createVocabItem(key,map.get(key));
            //System.out.println(key + " : " + map.get(key));
        }

        return null;
    }

    @Override
    public Map importVocabStringsFromTextFile(String filename) throws IOException {

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

        for (String key : map.keySet())
        {
            // Erstellt pro Map ein Item Objekt
            //vocabItemServiceImpl.createVocabItem(key,map.get(key));
            //System.out.println(key + " : " + map.get(key));
        }
        reader.close();

        return map;
    }

    @Override
    public void deleteVocabList(int VocabListId) {

    }
}
