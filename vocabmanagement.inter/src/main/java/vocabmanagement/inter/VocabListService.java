package vocabmanagement.inter;

import java.util.LinkedHashMap;
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
    List<Integer> getAllItemsInVocabList();

    /**
     * Methode erstellt eine LinkedHashmap von Übersetzungen aus mehreren Items die in diesem Spiel angezeigt werden
     * @param anzahlRunden - Anzahl zu spielender Runden. Im Regelfall 3
     * @return gibt eine LinkedHashmap zurück aus Key: Richtige Übersetzung Value; Array aus 3x falschen Übersetzung
     */
    LinkedHashMap<String, List<String>> generateCustomVocabSet(int anzahlRunden);

}
