package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class VocabListServiceImpl implements VocabListService {

    VocabListDao vocabListDao;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public VocabListServiceImpl(VocabListDao vocabListDao, PlatformTransactionManager transactionManager) {
        super();
        this.vocabListDao = vocabListDao;
        this.transactionManager = transactionManager;
    }

    public VocabList createVocabList(List<VocabItem> VocabItemList, Language languageLeft, Language languageRight, Category category) {
        VocabList vocablist = new VocabList(VocabItemList, languageLeft, languageRight, category);
        TransactionStatus ts = transactionManager.getTransaction(null);
        vocabListDao.saveVocabList(vocablist);
        transactionManager.commit(ts);
        return vocablist;
    }

    public VocabList getVocabListByID(long VocabListId) throws InvalidListIdException {
        TransactionStatus ts = transactionManager.getTransaction(null);
        VocabList vocabList = vocabListDao.getvocabListById(VocabListId);
        transactionManager.commit(ts);
        if (vocabList != null) {
            return vocabList;
        }else{
            throw new InvalidListIdException("Achtung: die angegebene ID ist nicht vergeben!");
        }
    }

    @Override
    public void addItemToVocabList(VocabItem vocabItem, Long listId) throws InvalidListIdException {
        TransactionStatus ts = transactionManager.getTransaction(null);
        VocabList vocabList = vocabListDao.getvocabListById(listId);
        vocabList.getItemlist().add(vocabItem);
        vocabListDao.saveVocabList(vocabList);
        transactionManager.commit(ts);
    }

    @Override
    public void deleteVocabListById(long vocabListId) throws InvalidListIdException{
        TransactionStatus ts = transactionManager.getTransaction(null);
        VocabList vocabList = vocabListDao.getvocabListById(vocabListId);

        if(vocabList != null){
            vocabListDao.deleteVocabList(vocabList);
            transactionManager.commit(ts);
        }else{
            throw new InvalidListIdException("Achtung: die angegebene ID ist nicht vergeben!");
        }

    }

    @Override
    public HashMap importVocabStringsFromTextFile(String filename) throws IOException {

        String filePath = filename;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        reader.readLine();
        String line = null;

        while ((line = reader.readLine()) != null) {
            List ValueList = new ArrayList();
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                key = key.replace("{", "");
                key = key.replace("}", "");
                key = key.replace(" ", "");
                String value = parts[1];
                value = value.replace("{", "");
                value = value.replace("}", "");
                value = value.replace("/", "\\");

                String[] listOfValues = value.split(",");
                for (String ele : listOfValues) {
                    ValueList.add(ele);
                }

                String[] listOfKeys = key.split(",");
                for (String ele : listOfKeys) {
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
    public List<VocabList> getAllExistingVocabLists() {
        TransactionStatus ts = transactionManager.getTransaction(null);
        List<VocabList> listofVocabLists = vocabListDao.getAllVocabLists();
        transactionManager.commit(ts);

        return listofVocabLists;
    }

    public List<VocabItem> getAllItemsInVocabList(Long listenId) throws InvalidListIdException {
        TransactionStatus ts = transactionManager.getTransaction(null);
        List<VocabItem> ListOfVocabItems = vocabListDao.getItemsInVocabList(listenId);
        transactionManager.commit(ts);

        if(ListOfVocabItems.isEmpty()){
            throw new InvalidListIdException("Achtung: die angegebene ID ist nicht vergeben!");
        }

        return ListOfVocabItems;
    }

    @Override
    public Category getCategoryOfVocabList(int VocabListId) {
        return null;
    }

    @Override
    public Map<Integer, List<String>> createRandomVocabsets(Long listenId) throws InvalidListIdException {
        List<VocabItem> listOfVocabItems = getAllItemsInVocabList(listenId);
        System.out.println(listOfVocabItems);

        List<String> vocabSet1 = new ArrayList<>();;
        List<String> vocabSet2 = new ArrayList<>();
        List<String> vocabSet3 = new ArrayList<>();;

        List<VocabItem> finalVocabSets = new ArrayList<>();

        for (int j = 0; j < 3; j++) {
            //Anzahl verbleibender VokabelSets
            int possibleVocabSets = listOfVocabItems.size();
            int randomItem = getRandomNumber(0,possibleVocabSets);
            finalVocabSets.add(listOfVocabItems.get(randomItem));
            listOfVocabItems.remove(randomItem);
        }
        //jetzt haben wir für jede Runde ein VocabSet in der Liste
        // und haben diese aus der Liste der anderen Vocabitems gelöscht,damit antworten nicht ausversehen richtig sind

        List<String> questions = new ArrayList<String>();
        for(int i = 0; i<3;i++){
            String question = finalVocabSets.get(i).getFirstLanguage();
            questions.add(question);
        }

        vocabSet1.add(questions.get(0));
        vocabSet2.add(questions.get(1));
        vocabSet3.add(questions.get(2));
        //alle Fragen hinzugefügt

        List<String> rightAnswers = new ArrayList<String>();
        for(int i = 0; i < 3; i++){
            List<String> tempAnswers = finalVocabSets.get(i).getSecLanguage();
            int randomAnswer = getRandomNumber(0, tempAnswers.size());
            String answer = tempAnswers.get(randomAnswer);
            rightAnswers.add(answer);
        }
        //alle richtigen Antworten abgelget

        vocabSet1.add(rightAnswers.get(0));
        vocabSet2.add(rightAnswers.get(1));
        vocabSet3.add(rightAnswers.get(2));
        //Alle Antworten hinzugefügt

        List<String> allPossibleWrongTranslations = new ArrayList<>();
        for (int m = 0; m < listOfVocabItems.size(); m++){
            VocabItem temp = listOfVocabItems.get(m);
            List<String> tempTranslations = temp.getSecLanguage();
            for (int n = 0; n<tempTranslations.size(); n++){
                allPossibleWrongTranslations.add(tempTranslations.get(n));
            }
        }

        for(int t = 0; t<3; t++){
            int randomInt = getRandomNumber(0, allPossibleWrongTranslations.size());
            vocabSet1.add(allPossibleWrongTranslations.get(randomInt));
        }
        for(int t = 0; t<3; t++){
            int randomInt = getRandomNumber(0, allPossibleWrongTranslations.size());
            vocabSet2.add(allPossibleWrongTranslations.get(randomInt));
        }
        for(int t = 0; t<3; t++){
            int randomInt = getRandomNumber(0, allPossibleWrongTranslations.size());
            vocabSet3.add(allPossibleWrongTranslations.get(randomInt));
        }
        //alle falschen Übersetzungen in einer Liste

        Map<Integer, List<String>> vocabSetsForRounds = new HashMap<>();
        vocabSetsForRounds.put(0,vocabSet1);
        vocabSetsForRounds.put(1,vocabSet2);
        vocabSetsForRounds.put(2,vocabSet3);

        return vocabSetsForRounds;
    }

    @Override
    public void safeVocabList(VocabList vocabList) {
        TransactionStatus ts = transactionManager.getTransaction(null);
        vocabListDao.saveVocabList(vocabList);
        transactionManager.commit(ts);
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        int temp =random.nextInt(max - min) + min;
        return temp;

    }
}
