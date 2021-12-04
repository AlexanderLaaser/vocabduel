package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.VocabItem;
import java.util.List;

public interface VocabItemDao {

    void saveVocabItem(VocabItem vocabitem);

    VocabItem getvocabItemById(Long vocabitemId);
}
