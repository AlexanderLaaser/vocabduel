package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.VocabItem;

public interface VocabItemDao {

    void saveVocabItem(VocabItem vocabitem);

    VocabItem getvocabItemById(Long vocabitemId);
}
