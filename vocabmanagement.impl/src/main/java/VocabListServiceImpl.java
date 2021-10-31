import vocabmanagement.inter.Category;
import vocabmanagement.inter.VocabItem;
import vocabmanagement.inter.VocabList;
import vocabmanagement.inter.VocabListService;

import java.util.LinkedHashMap;
import java.util.List;

public class VocabListServiceImpl implements VocabListService{

    /**
    @param vocabItems - Liste von VocabItems
    @return List<VocabItem> - VocabList Objekt
     */
    @Override
    public void createVocabList(List<VocabItem> vocabItems) {
    }

    /**
    @param VocabListId - ID einer Vocabelliste
    @return List<VocabItem> - Liste von VocabItems
     */
    public VocabList getVocabListByID(int VocabListId){
        return null;
    }

    /**
    @param VocabListId - ID einer Vocabelliste
    @param VocabItemId - ID eines Vocabelitems
     */
    public void addItemToVocabSet(int VocabItemId, int VocabListId){
    }

    /**
    @param VocabListId - ID einer Vocabelliste
    @return String of Category
     */
    @Override
    public Category getCategoryOfVocabList(int VocabListId) {
        return null;
    }

    /**
    Methode würde eine List von, zu dieser VocabList, gehörenden VocabItemIDs zurückgeben
     */
    @Override
    public List<Integer> getAllItemsInVocabList() {
        return null;
    }

    /**
    Methode würde ein zufällige Auswahl aus, in der VocabList, vorhandenen Items und ihren Bedeutungen erstellen und als Liste von Strings zurückgeben
     */
    @Override
    public LinkedHashMap<String, List<String>> generateCustomVocabSet(int anzahlRunden) {
        return null;
    }
}
