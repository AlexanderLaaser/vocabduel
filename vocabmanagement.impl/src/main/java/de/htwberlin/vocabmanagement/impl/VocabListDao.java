package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.InvalidListIdException;
import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabList;

import java.util.List;

public interface VocabListDao {

    void saveVocabList(VocabList vocabList);

    VocabList getvocabListById(Long vocabListId);

    void deleteVocabList(VocabList vocabList);

    List<VocabList> getAllVocabLists();

    List<VocabItem> getItemsInVocabList(Long listId);
 }
