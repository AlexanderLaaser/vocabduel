package de.htwberlin.vocabmanagement.inter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface VocabListService {

    /**
     * Methode gibt anhand einer Listen ID eine VocabList Objekt zurück
     * @param VocabListId - ID einer existierenden Vocabelliste
     * @return VocabList Objekt
     */
    VocabList getVocabListByID(long VocabListId) throws InvalidListIdException;

    /**
     * Methode fügt ein bestehendes Item einer List hinzu
     * @param vocabItem - ID eines VocabItem Objekts
     * @param listId - ID einer VocabListe
     */
    void addItemToVocabList(VocabItem vocabItem, Long listId) throws InvalidListIdException;

    /**
     * erstellt eine Vocabelliste aus mehreren Vocabitems
     * @param VocabItemList Liste von VocabItem Objekten
     */
    VocabList createVocabList(List<VocabItem> VocabItemList, Language languageLeft, Language languageRight, Category category);

    /**
     *
     * @param VocabListId - ID einer existierenden Vocabelliste
     * @return eine Category Objekt
     */
    Category getCategoryOfVocabList(int VocabListId);

    /**
     * @return - gibt eine Liste von VocabItem IDs zurück
     */
    List<VocabList> getAllExistingVocabLists();

    /**
     * Methode liest Übersetzungen aus Textfiles ein und erstellt pro Json item eine Vocabitem String
     */
    Map importVocabStringsFromTextFile(String filename) throws IOException;

    /**
     * Methode löscht eine bestehende VocabListe anhand der Listen ID
     * @param vocabListId
     */
    void deleteVocabListById(long vocabListId) throws InvalidListIdException;

    List<VocabItem> getAllItemsInVocabList(Long listenId) throws InvalidListIdException;

    Map<Integer, List<String>> createRandomVocabsets (Long listId) throws InvalidListIdException;

    void safeVocabList(VocabList vocabList);

}
