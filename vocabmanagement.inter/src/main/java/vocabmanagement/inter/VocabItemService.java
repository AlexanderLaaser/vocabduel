package vocabmanagement.inter;

import java.util.List;

public interface VocabItemService {

    /**
     * Erstellt ein VocabItem Objekt
     * @param leftLan - Liste von Bedeutungen
     * @param rightLan - Liste von übersetzten Bedeutungen
     * @return VocabItem Objekt
     */
    VocabItem createVocabItem(List<String> leftLan, List<String> rightLan);

    /**
     * Methode fügt dem VocabItem Listen von Bedeutungen für die linken und rechten Listen eines bestehenden Objekts hinzu
     * @param leftLan - linke Liste
     * @param rightLan - rechte Liste
     * @param VocabItemID - ID eines bestehenden VocabItems
     * @return
     */
    void addVocabName(List<String> leftLan, List<String> rightLan, int VocabItemID);

    /**
     * Methode gibt einen VocabName(erste Übersetzung) aus der Liste der ersten Übersetzungen pro Item zurück
     * @param VocabItemId - IDWS eins VocabItems
     * @return VocabItem Objekt
     */
    VocabItem getVocabName (int VocabItemId);
}
