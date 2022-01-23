package de.htwberlin.app.controller.vocabmanagement;

import de.htwberlin.vocabmanagement.impl.VocabItemDaoImpl;
import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocablist")
public class VocabListController {

    private final VocabListService vocabListService;

    public VocabListController(VocabListService vocabListService) {
        this.vocabListService = vocabListService;
    }

    /**
     * POST: Create a new VocabList
     * @param vocabItemList
     * @param languageLeft
     * @param languageRight
     * @param category
     * @return
     */
    @PostMapping("/add")
    public VocabList newVocabList(@RequestBody List<VocabItem> vocabItemList,
                                  @RequestBody Language languageLeft,
                                  @RequestBody Language languageRight,
                                  @RequestBody Category category){

        return vocabListService.createVocabList(vocabItemList, languageLeft, languageRight, category);

    }

    /**
     * GET: Returns a VocabList by Id
     * @param id
     * @return
     * @throws InvalidListIdException
     */
    @GetMapping("/listid/{id}")
    public VocabList searchVocabListById(@PathVariable Long id) throws InvalidListIdException {
        return vocabListService.getVocabListByID(id);
    }

    /**
     * GET: Returns a List of VocabLists
     * @return
     * @throws InvalidListIdException
     */
    @GetMapping("/vocablists")
    public List<VocabList> searchAllVocabLists() throws InvalidListIdException {
        return vocabListService.getAllExistingVocabLists();
    }

    /**
     * GET: Returns a List of VocabItems per List
     * @return
     * @throws InvalidListIdException
     */
    @GetMapping("/vocabitems/listid/{id}")
    public List<VocabItem> searchAllVocabItemsInVocabList(@PathVariable Long id) throws InvalidListIdException {
        return vocabListService.getAllItemsInVocabList(id);
    }

    /**
     * POST: Adds a VocabItem to an existing List
     * @param vocabitem
     * @param id
     */
    @PutMapping("/addItem/{id}")
    public void addItemToVocabLst(@RequestBody VocabItem vocabitem, @PathVariable Long id) throws InvalidListIdException {
        vocabListService.addItemToVocabList(vocabitem, id);
    }

    /**
     * Deletes a VocabList by Id
     * TODO: Abhängigkeit zum Game -> VocabListe löschen ja/nein?
     * @param id
     * @throws InvalidListIdException
     */
    @DeleteMapping("/deleteList/{id}")
    public void deleteVocabListById(@PathVariable Long id) throws InvalidListIdException {
        vocabListService.deleteVocabListById(id);
    }
}
