package de.htwberlin.app.controller.vocabmanagement;

import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    /**
     * GET: Get Language by Name
     * @param name - of Category
     * @return Category obj
     */
    @GetMapping("/name/{name}")
    public Language searchLanguageByName(@PathVariable String name){
        return languageService.findLanguageByLanguageName(name);
    }

    /**
     * POST Request zum Ergänzen einer Sprache
     * @param languageName - Name der Sprache
     * @return Language obj
     * @throws InvalidNameException
     */
    @PostMapping(value = "/add")
    public Language newCategory(@RequestParam String languageName) throws InvalidNameException {
        return languageService.createLanguage(languageName);
    }
}
