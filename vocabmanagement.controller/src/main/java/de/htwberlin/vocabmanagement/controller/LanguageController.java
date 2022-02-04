package de.htwberlin.vocabmanagement.controller;

import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.Language;
import de.htwberlin.vocabmanagement.inter.LanguageService;
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
    public Language findLanguageByLanguageName(@PathVariable String name){
        return languageService.findLanguageByLanguageName(name);
    }

    /**
     * POST Request zum Ergänzen einer Sprache
     * @param languageName - Name der Sprache
     * @return Language obj
     * @throws InvalidNameException
     */
    @PostMapping(value = "/add")
    public Language createLanguage(@RequestParam String languageName) throws InvalidNameException {
        return languageService.createLanguage(languageName);
    }
}
