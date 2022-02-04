package de.htwberlin.vocabmanagement.controller;

import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocabitem")
public class VocabItemController {

    private final VocabItemService vocabItemService;

    public VocabItemController(VocabItemService vocabItemService) {
        this.vocabItemService = vocabItemService;
    }

    /**
     * POST Request zum Ergänzen eines Vocabitems
     * @param leftlan - Übersetzung in der Hauptsprache
     * @param rightlan - Übersetzung in der Fremdsprache
     * @return VocabItem Obj
     */
    @PostMapping(value = "/add")
    public VocabItem createVocabItem(@RequestParam String leftlan, @RequestBody List<String> rightlan){
        return vocabItemService.createVocabItem(leftlan, rightlan);
    }

    /**
     * GET: Get VocabItem by Id
     * @param id - of VocabItem
     * @return VocabItem Obj
     */
    @GetMapping("/id/{id}")
    public VocabItem getVocabitemById(@PathVariable Long id){
        return vocabItemService.getVocabitemById(id);
    }
}
