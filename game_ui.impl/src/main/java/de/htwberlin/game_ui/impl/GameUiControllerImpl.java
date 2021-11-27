package de.htwberlin.game_ui.impl;

import de.htwberlin.game_ui.inter.GameUiController;
import de.htwberlin.vocabmanagement.impl.CategoryServiceImpl;
import de.htwberlin.vocabmanagement.impl.LanguageServiceImpl;
import de.htwberlin.vocabmanagement.impl.VocabItemServiceImpl;
import de.htwberlin.vocabmanagement.impl.VocabListServiceImpl;
import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.Language;
import de.htwberlin.vocabmanagement.inter.VocabList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class GameUiControllerImpl implements GameUiController {

    private GameUiView gameUiView;
    private VocabListServiceImpl vocabListServiceimpl;
    private VocabItemServiceImpl vocabItemServiceImpl;
    private LanguageServiceImpl languageServiceImpl;
    private CategoryServiceImpl categoryServiceImpl;

    public GameUiControllerImpl() {
        super();
    }

    @Autowired
    public GameUiControllerImpl(GameUiView gameuiView, VocabListServiceImpl vocabListServiceimpl, VocabItemServiceImpl vocabItemServiceImpl, LanguageServiceImpl languageServiceImpl, CategoryServiceImpl categoryServiceImpl) {
        super();
        this.gameUiView = gameuiView;
        this.vocabListServiceimpl = vocabListServiceimpl;
        this.vocabItemServiceImpl = vocabItemServiceImpl;
        this.languageServiceImpl = languageServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    public void setGameView(GameUiView gameView) {
        this.gameUiView = gameView;
    }

    public void setVocabListServiceimpl(VocabListServiceImpl vocabListServiceimpl) {
        this.vocabListServiceimpl = vocabListServiceimpl;
    }

    public void setVocabItemServiceImpl(VocabItemServiceImpl vocabItemServiceImpl) {
        this.vocabItemServiceImpl = vocabItemServiceImpl;
    }

    public void setCategory(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    public void setGameView(LanguageServiceImpl languageServiceImpl) {
        this.languageServiceImpl = languageServiceImpl;
    }

    @Override
    public void run() throws IOException, InvalidNameException {

        //gameUiView.printMessage("Die Vocabmanagement Komponente wird gestartet:");
        //String action = gameUiView.askForListAction();

        //if(action == "eins"){
            //String languageLeft = gameUiView.askSomething("Welcher Hauptsprache soll die Liste angehören?");
            //Language languageleftObj = languageServiceImpl.createLanguage(languageLeft);

            //String languageRight = gameUiView.askSomething("Welcher Fremdsprache soll die Liste angehören?");
            //Language languagerightObj = languageServiceImpl.createLanguage(languageRight);

            String categoryName = gameUiView.askSomethingString("Welcher Kategorie soll die Liste angehören?");
            Category categoryObj = categoryServiceImpl.createCategory(categoryName);

            while(categoryObj == null){
                int CatAnswer = gameUiView.askSomethingInt("Diese Kategorie ist schon vorhanden. Möchtest du sie benutzen (1) oder eine neue erstellen (2)?");
                if(CatAnswer == 1){
                    categoryObj = categoryServiceImpl.getCategoryByCategoryName(categoryName);
                    System.out.println("ObjID nach DB:" + categoryObj.getCategoryID());
                }else{
                    String categoryName1 = gameUiView.askSomethingString("Welcher Kategorie soll die Liste angehören?");
                    categoryObj = categoryServiceImpl.createCategory(categoryName1);
                }
            }

            System.out.println("ObjID nach DB2:" + categoryObj.getCategoryID());

            //String pfad = gameUiView.askSomething("Von welchem Pfad soll die Liste eingelesen werden?");
            //Fehler mit Listenerstellung
            //List tempMap = vocabListServiceimpl.importVocabStringsFromTextFile(pfad);

            //VocabList vocabList = vocabListServiceimpl.createVocabList(tempMap,languageleftObj,languagerightObj,categoryObj);

            //System.out.print(tempMap);
            //System.out.println(vocabList.getItemlist());
            //System.out.println(vocabList.getCategory());
            //System.out.println(vocabList.getFirstLanguage());
            //System.out.println(vocabList.getSecLanguage());
        //}
    }
}
