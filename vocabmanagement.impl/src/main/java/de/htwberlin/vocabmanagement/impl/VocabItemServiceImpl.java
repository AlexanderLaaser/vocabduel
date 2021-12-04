package de.htwberlin.vocabmanagement.impl;

import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabItemService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class VocabItemServiceImpl implements VocabItemService {

    VocabItemDao vocabItemDao;
    private PlatformTransactionManager transactionManager;

    @Override
    @Transactional
    public VocabItem createVocabItem(String leftLan, List<String> rightLan) {
        VocabItem vocabItem = new VocabItem(leftLan, rightLan);

        vocabItemDao.saveVocabItem(vocabItem);
        return vocabItem;
    }

    public List<VocabItem> createVocabItemOufOfMap(Map<String, List<String>> map){
        List<VocabItem> VocabItemList = new ArrayList<VocabItem>();

        for (String key : map.keySet())
        {
            VocabItem vocabItem = createVocabItem(key,map.get(key));
            VocabItemList.add(vocabItem);
        }

        return VocabItemList;
    }

    @Override
    @Transactional
    public VocabItem getVocabitemById(Long vocabItemId){
        if(vocabItemDao.getvocabItemById(vocabItemId) == null){
            VocabItem vocabItem = vocabItemDao.getvocabItemById(vocabItemId);
            return vocabItem;
        }else{
            return null;
        }
    }

    @Override
    public void addVocabName(List<String> leftLan, List<String> rightLan, int VocabItemID) {

    }

    @Override
    public VocabItem getVocabName(int VocabItem) {
        return null;
    }

}
