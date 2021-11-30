package de.htwberlin.game_ui.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game_ui.inter.GameUiController;
import de.htwberlin.usermanagement.inter.InvalidUserException;
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
    private VocabListService vocabListService;
    private VocabItemService vocabItemService;
    private LanguageService languageService;
    private CategoryService categoryService;
    private GameService gameService;

    public GameUiControllerImpl() {
        super();
    }

    @Autowired
    public GameUiControllerImpl(GameUiView gameuiView, VocabListService vocabListService, VocabItemService vocabItemService,
                                LanguageService languageService, CategoryService categoryService, GameService gameService) {
        super();
        this.gameUiView = gameuiView;
        this.vocabListService = vocabListService;
        this.vocabItemService = vocabItemService;
        this.languageService = languageService;
        this.categoryService = categoryService;
        this.gameService = gameService;
    }

    public void setGameView(GameUiView gameView) {
        this.gameUiView = gameView;
    }

    public void setVocabListServiceimpl(VocabListServiceImpl vocabListServiceimpl) {
        this.vocabListService = vocabListServiceimpl;
    }

    public void setVocabItemServiceImpl(VocabItemServiceImpl vocabItemServiceImpl) {
        this.vocabItemService = vocabItemServiceImpl;
    }

    public void setCategory(CategoryServiceImpl categoryServiceImpl) {
        this.categoryService = categoryServiceImpl;
    }

    public void setGameView(LanguageServiceImpl languageServiceImpl) {
        this.languageService = languageServiceImpl;
    }

    @Override
    public void run() throws IOException, InvalidNameException {
        //Todo Schleifen und ungültige Werte abfangen -> Eception Handling + Try/Catch

        int action = 0;
        gameUiView.printMessage("Die App wird gestartet:");

        while(action != 4){
            int listAction = 0;
            action = gameUiView.askForAction();

            if(action == 1){
                gameUiView.printMessage("Willkommen in der Vokabelverwaltung:");

                while(listAction != 7){
                    listAction = gameUiView.askForListAction();

                    //Alle Vokabellisten anzeigen
                    if(listAction == 1) {
                        try{
                            for (int i = 0; i < vocabListService.getAllExistingVocabLists().size(); i++) {
                                VocabList vocabList = vocabListService.getAllExistingVocabLists().get(i);
                                System.out.println("ID: " + vocabList.getListID() + " - firstLanguage: " + vocabList.getFirstLanguage().getLanguageName() + " - secLanguage: " + vocabList.getSecLanguage().getLanguageName());
                            }
                        }catch (Exception e){
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                    //Vokabeln für bestehende Liste anzeigen (Input: ID)
                    //ToDo Listenausgabe der secLanguage von [] in String Listen ändern
                    }else if(listAction == 2){
                        Long listenIDShow = gameUiView.askSomethingLong("Welche Liste möchten sie anzeigen (Input = ListenID)?");

                        try{
                            for (VocabItem vocabItem: vocabListService.getAllItemsInVocabList(listenIDShow)) {
                                System.out.println("ItemId: " + vocabItem.getVocabItemID() + " - firstLanguage: " + vocabItem.getFirstLanguage() + " - secLanguage: " + vocabItem.getSecLanguage().toString());
                            }
                        }catch (Exception e){
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                    //Vocabelliste erstellen
                    }else if(listAction == 3){

                        try{
                            String languageLeft = gameUiView.askSomethingString("Welcher Hauptsprache soll die Liste angehören?");
                            Language languageleftObj = languageService.createLanguage(languageLeft);

                            String languageRight = gameUiView.askSomethingString("Welcher Fremdsprache soll die Liste angehören?");
                            Language languagerightObj = languageService.createLanguage(languageRight);

                            String categoryName = gameUiView.askSomethingString("Welcher Kategorie soll die Liste angehören?");
                            Category categoryObj = categoryService.createCategory(categoryName);

                            String pfad = gameUiView.askSomethingString("Von welchem Pfad soll die Liste eingelesen werden?");
                            List VocabItemList = vocabItemService.createVocabItemOufOfMap(vocabListService.importVocabStringsFromTextFile(pfad));

                            VocabList vocabList = vocabListService.createVocabList(VocabItemList, languageleftObj, languagerightObj, categoryObj);

                        }catch (Exception e){
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                    //Vokabeln manuell zu bestehender Liste hinzufügen
                    //ToDo ausimplementieren
                    }else if(listAction == 4){
                        System.out.println("Noch nicht implementiert!");

                    //Textfiles zur bestehenden Vokabelliste hinzufügen
                    //ToDo ausimplementieren
                    }else if(listAction == 5){
                        System.out.println("Noch nicht implementiert!");

                    //Vokabelliste löschen
                    }else if(listAction == 6){
                        Long deleteAction = gameUiView.askSomethingLong("Welche Liste möchten sie löschen (Input = ListenID)?");
                        try{
                            //getbyId ausimplementieren, sodass eine Überprüfung durchgeführt werden kann
                            vocabListService.deleteVocabListbyId(deleteAction);
                        }catch (Exception e){
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                    //App sofort beenden
                    }else if(listAction == 8){
                        System.exit(0);
                    }
                }
            }else if(action ==2){
                System.out.println("Noch nicht implementiert!");
            }else if(action ==3){
                int User1Id = gameUiView.askSomethingInt("Gib uns die ID vom Game Host");
                int User2Id = gameUiView.askSomethingInt("Gib uns die ID vom Game Participant");
                int vocablistId = gameUiView.askSomethingInt("Gib uns die ID der gewünschten VocabListe");

                try {
                    gameUiView.printMessage("you creating a Game now.");
                    Game game = gameService.createGame(User1Id, User2Id, vocablistId);
                    gameUiView.printMessage("you created a Game now.");

                    gameUiView.printMessage(game.getGameOwner().toString());
                    gameUiView.printMessage(game.getRounds().getClass().toString());


                } catch (InvalidUserException e) {
                    e.printStackTrace();
                }

            }else if(action ==4){
                System.exit(0);
            }
        }
    }
}
