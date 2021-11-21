package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabItemService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VocabItemServiceImpl implements VocabItemService {

    @Override
    public VocabItem createVocabItem(String leftLan, List<String> rightLan) {
        VocabItem vocabItem = new VocabItem(1L,leftLan, rightLan);
        return vocabItem;
    }

    @Override
    public void addVocabName(List<String> leftLan, List<String> rightLan, int VocabItemID) {

    }

    @Override
    public VocabItem getVocabName(int VocabItem) {
        return null;
    }

}
