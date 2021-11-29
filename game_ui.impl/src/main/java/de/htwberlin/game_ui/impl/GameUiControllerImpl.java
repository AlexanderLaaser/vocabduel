package de.htwberlin.game_ui.impl;

import de.htwberlin.game_ui.inter.GameUiController;
import de.htwberlin.vocabmanagement.impl.CategoryServiceImpl;
import de.htwberlin.vocabmanagement.impl.LanguageServiceImpl;
import de.htwberlin.vocabmanagement.impl.VocabItemServiceImpl;
import de.htwberlin.vocabmanagement.impl.VocabListServiceImpl;
import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.util.List;

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

        gameUiView.printMessage("Die App wird gestartet:");
        int action = gameUiView.askForAction();

        if(action == 1){

            gameUiView.printMessage("Willkommen in der Vokabelverwaltung:");
            int listAction = gameUiView.askForListAction();

            //Alle Vokabellisten anzeigen
            if(listAction == 1) {
                vocabListServiceimpl.prepareExistingListsForOutput();

            //Vokabeln für bestehende Liste anzeigen (Input: ID)
            }else if(listAction == 2){
                Long listenIDShow = gameUiView.askSomethingLong("Welche Liste möchten sie anzeigen (Input = ListenID)?");
                vocabListServiceimpl.getAllItemsInVocabList(listenIDShow);

                //Vocabelliste erstellen
            }else if(listAction == 3){
                String languageLeft = gameUiView.askSomethingString("Welcher Hauptsprache soll die Liste angehören?");
                Language languageleftObj = languageServiceImpl.createLanguage(languageLeft);

                String languageRight = gameUiView.askSomethingString("Welcher Fremdsprache soll die Liste angehören?");
                Language languagerightObj = languageServiceImpl.createLanguage(languageRight);

                String categoryName = gameUiView.askSomethingString("Welcher Kategorie soll die Liste angehören?");
                Category categoryObj = categoryServiceImpl.createCategory(categoryName);

                String pfad = gameUiView.askSomethingString("Von welchem Pfad soll die Liste eingelesen werden?");
                List<VocabItem> VocabItemList = vocabItemServiceImpl.createVocabItemOufOfMap(vocabListServiceimpl.importVocabStringsFromTextFile(pfad));

                VocabList vocabList = vocabListServiceimpl.createVocabList(VocabItemList, languageleftObj, languagerightObj, categoryObj);

            //Vokabeln manuell zu bestehender Liste hinzufügen
            }else if(listAction == 4){
                System.out.println("Noch nicht implementiert!");

            //Textfiles zur bestehenden Vokabelliste hinzufügen
            }else if(listAction == 5){
                System.out.println("Noch nicht implementiert!");

            //Vokabelliste löschen
            }else if(listAction == 6){
                int deleteAction = gameUiView.askSomethingInt("Welche Liste möchten sie löschen (Input = ListenID)?");
                //getbyId ausimplementieren, sodass eine Überprüfung durchgeführt werden kann
                vocabListServiceimpl.deleteVocabListbyId(deleteAction);
            }
        }else if(action ==2){
        }
    }
}
