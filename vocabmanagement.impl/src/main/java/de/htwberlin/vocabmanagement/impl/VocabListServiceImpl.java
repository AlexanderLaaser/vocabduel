package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabList;
import de.htwberlin.vocabmanagement.inter.VocabListService;

import java.util.List;

public class VocabListServiceImpl implements VocabListService{

    @Override
    public void createVocabList(List<VocabItem> vocabItems) {
    }

    public VocabList getVocabListByID(int VocabListId){
        return null;
    }

    public void addItemToVocabSet(int VocabItemId, int VocabListId){
    }

    @Override
    public Category getCategoryOfVocabList(int VocabListId) {
        return null;
    }

    @Override
    public List<Integer> getAllItemsInVocabList(int VocabListId) {
        return null;
    }

    @Override
    public void importVocabStringsFromTextFile() {

    }

    @Override
    public void deleteVocabList(int VocabListId) {

    }
}
