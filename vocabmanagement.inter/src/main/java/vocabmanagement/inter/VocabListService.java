package vocabmanagement.inter;

public interface VocabListService {

    //Methode gibt eine List von Items für eine bestimmte ListenID zurück
    VocabList receiveVocabList(int VocabListId);

    //Methode fügt ein bestehendes Item einer List hinzu
    VocabList addItemToVocabSet(int VocabItemId, int VocabListID);
}
