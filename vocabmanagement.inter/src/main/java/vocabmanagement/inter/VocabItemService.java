package vocabmanagement.inter;

import java.util.List;

public interface VocabItemService {

    //Methode erstellt ein VocabItem
    VocabItem createVocabitem(List<String> leftLan, List<String> rightLan);

    //Methode fügt dem VocabItem eine Übersetzung für die VocabName oder der Übersetzung hinzu
    VocabItem addVocabName(String Translation, List<String> Lan, int VocabItemID);

    //Methode gibt einen VocabName(erste Übersetzung) aus der Liste der ersten Übersetzungen pro Item zurück
    VocabItem getVocabName (int VocabItem);

}
