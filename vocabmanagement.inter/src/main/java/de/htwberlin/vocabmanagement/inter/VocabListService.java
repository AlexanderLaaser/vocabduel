package de.htwberlin.vocabmanagement.inter;

import java.util.List;

public interface VocabListService {

    /**
     * Methode gibt anhand einer Listen ID eine VocabList Objekt zurück
     * @param VocabListId - ID einer existierenden Vocabelliste
     * @return VocabList Objekt
     */
    VocabList getVocabListByID(int VocabListId);

    /**
     * Methode fügt ein bestehendes Item einer List hinzu
     * @param VocabItemId - ID eines VocabItem Objekts
     * @param VocabListID - ID einer VocabListe
     */
    void addItemToVocabSet(int VocabItemId, int VocabListID);

    /**
     * erstellt eine Vocabelliste aus mehreren Vocabitems
     * @param VocabItemList Liste von VocabItem Objekten
     */
    void createVocabList(List<VocabItem> VocabItemList);

    /**
     *
     * @param VocabListId - ID einer existierenden Vocabelliste
     * @return eine Category Objekt
     */
    Category getCategoryOfVocabList(int VocabListId);

    /**
     * @return - gibt eine Liste von VocabItem IDs zurück
     */
    List<Integer> getAllItemsInVocabList(int VocabListId);

    /**
     * Methode liest Übersetzungen aus Textfiles ein und erstellt pro Json item eine Vocabitem String
     */
    void importVocabStringsFromTextFile();

    /**
     * Methode löscht eine bestehende VocabListe anhand der Listen ID
     * @param VocabListId
     */
    void deleteVocabList(int VocabListId);

}
