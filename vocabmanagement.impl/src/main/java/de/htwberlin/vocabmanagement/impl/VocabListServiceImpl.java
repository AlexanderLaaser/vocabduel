package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
@Service
public class VocabListServiceImpl implements VocabListService{

    VocabListDao vocabListDao;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public VocabListServiceImpl(VocabListDao vocabListDao, PlatformTransactionManager transactionManager) {
        super();
        this.vocabListDao = vocabListDao;
        this.transactionManager = transactionManager;
    }

    public VocabList createVocabList(List<VocabItem> VocabItemList, Language languageLeft, Language languageRight, Category category) {
        VocabList vocablist = new VocabList(VocabItemList,languageLeft,languageRight,category);
        TransactionStatus ts = transactionManager.getTransaction(null);
        vocabListDao.saveVocabList(vocablist);
        transactionManager.commit(ts);
        return vocablist;
    }

    public VocabList getVocabListByID(long VocabListId){
        TransactionStatus ts = transactionManager.getTransaction(null);
        VocabList vocabList = vocabListDao.getvocabListById(VocabListId);
        transactionManager.commit(ts);
        if(vocabList != null){
            return vocabList;
        }else{
            return null;
        }
    }

    @Override
    //ToDo Try Catch usw. schreiben
    //ToDo Was passiert mit den entsprechenden Vokabeln wenn wir eine VocabList löschen?
    public void deleteVocabListById(long vocabListId) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        VocabList vocabList = vocabListDao.getvocabListById(vocabListId);
        vocabListDao.deleteVocabList(vocabList);
        transactionManager.commit(ts);
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
    public List<VocabList> getAllExistingVocabLists(){
        TransactionStatus ts = transactionManager.getTransaction(null);
        List<VocabList> listofVocabLists = vocabListDao.getAllVocabLists();
        transactionManager.commit(ts);

        return listofVocabLists;
    }

    public List<VocabItem> getAllItemsInVocabList(Long listenId) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        List<VocabItem> ListOfVocabItems = vocabListDao.getItemsInVocabList(listenId);
        transactionManager.commit(ts);

        return ListOfVocabItems;
    }

    public void addItemToVocabSet(int VocabItemId, int VocabListId){
    }

    @Override
    public Category getCategoryOfVocabList(int VocabListId) {
        return null;
    }

    // Todo Muss noch schön gemacht werden -> Methdode extrahieren und Anzahl der "Runden" dynamisieren
    public List<String> createQuestionList(Long listenId){
        TransactionStatus ts = transactionManager.getTransaction(null);
        List<VocabItem> listOfVocabItems = getAllItemsInVocabList(listenId);
        System.out.println(listOfVocabItems);

        //Listen mit Anzahl der Vokalobjekte
        int listSize = listOfVocabItems.size();
        System.out.println(listSize);

        //Randomlist für Auswahl aus Vokabelobjekte
        ArrayList<Integer> counterOnelist = new ArrayList<Integer>();
        //Randomlist für Auswahl aus rechten Übersetzungen der Vokalobjekte
        ArrayList<Integer> counterTwolist = new ArrayList<Integer>();
        //Randomlist für Auswahl aus rechten Übersetzungen der Fakeobjekte
        ArrayList<Integer> counterThreelist = new ArrayList<Integer>();
        //Ausgabeliste
        ArrayList<String> listOfTranslations = new ArrayList<String>();

        for (int i=1; i<listSize; i++) {
            counterOnelist.add(i);
        }
        Collections.shuffle(counterOnelist);

        for (int i=0; i<3; i++) {

            listOfTranslations.add(listOfVocabItems.get(counterOnelist.get(i)).getFirstLanguage());

            List<String> listOfStringsRightLanItem = listOfVocabItems.get(counterOnelist.get(i)).getSecLanguage();
            int listOfStringsRightLanItemSize = listOfStringsRightLanItem.size();

            for (int o=1; o<listOfStringsRightLanItemSize; o++) {
                counterTwolist.add(o);
            }
            Collections.shuffle(counterTwolist);
            for (int r=0; r<1; r++) {
                listOfTranslations.add(listOfStringsRightLanItem.get(r));
            }

            for (int k=0; k<3; k++) {
                Random rand = new Random();
                int index = counterOnelist.get(rand.nextInt(counterOnelist.size()));
                if(index != i){
                    List<String> listOfStringsRightLanItemFake = listOfVocabItems.get(counterOnelist.get(index)).getSecLanguage();
                    int listOfStringsRightLanItemSizeFake = listOfStringsRightLanItemFake.size();

                    for (int o=1; o<listOfStringsRightLanItemSizeFake; o++) {
                        counterTwolist.add(o);
                    }
                    Collections.shuffle(counterTwolist);
                    for (int r=0; r<1; r++) {
                        listOfTranslations.add(listOfStringsRightLanItemFake.get(r));
                    }
                }
            }
        }
        return listOfTranslations;
    }
}
