package de.htwberlin.game_ui.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game.inter.Round;
import de.htwberlin.game.inter.RoundService;
import de.htwberlin.game_ui.inter.GameUiController;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import de.htwberlin.vocabmanagement.impl.CategoryServiceImpl;
import de.htwberlin.vocabmanagement.impl.LanguageServiceImpl;
import de.htwberlin.vocabmanagement.impl.VocabItemServiceImpl;
import de.htwberlin.vocabmanagement.impl.VocabListServiceImpl;
import de.htwberlin.vocabmanagement.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GameUiControllerImpl implements GameUiController {

    private GameUiView gameUiView;
    private VocabListService vocabListService;
    private VocabItemService vocabItemService;
    private LanguageService languageService;
    private CategoryService categoryService;
    private GameService gameService;
    private UserService userService;
    private RoundService roundService;

    public GameUiControllerImpl() {
        super();
    }


    @Autowired
    public GameUiControllerImpl(GameUiView gameuiView, VocabListService vocabListService, VocabItemService vocabItemService,
                                LanguageService languageService, CategoryService categoryService, GameService gameService,
                                UserService userService, RoundService roundService) {
        super();
        this.gameUiView = gameuiView;
        this.vocabListService = vocabListService;
        this.vocabItemService = vocabItemService;
        this.languageService = languageService;
        this.categoryService = categoryService;
        this.gameService = gameService;
        this.userService = userService;
        this.roundService = roundService;
    }


    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public void setRoundService(RoundService roundService) {
        this.roundService = roundService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
    public void run() throws IOException, InvalidNameException, javax.naming.InvalidNameException {
        //Todo Schleifen und ungültige Werte abfangen -> Eception Handling + Try/Catch

        int action = 0;
        gameUiView.printMessage("Die App wird gestartet:");

        while (action != 4) {
            int listAction = 0;
            action = gameUiView.askForAction();

            if (action == 1) {
                gameUiView.printMessage("Willkommen in der Vokabelverwaltung:");

                while (listAction != 7) {
                    listAction = gameUiView.askForListAction();

                    //Alle Vokabellisten anzeigen
                    if (listAction == 1) {
                        try {
                            List<VocabList> listOfVocabList = vocabListService.getAllExistingVocabLists();
                            if(!listOfVocabList.isEmpty()){
                                for (int i = 0; i < listOfVocabList.size(); i++) {
                                    VocabList vocabList = listOfVocabList.get(i);
                                    System.out.println("ID: " + vocabList.getListID() + " - firstLanguage: " + vocabList.getFirstLanguage().getLanguageName() + " - secLanguage: " + vocabList.getSecLanguage().getLanguageName());
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                    //Vokabeln für bestehende Liste anzeigen (Input: ID)
                    //ToDo Listenausgabe der secLanguage erreichen
                    } else if (listAction == 2) {
                        Long listenIDShow = gameUiView.askSomethingLong("Welche Liste möchten sie anzeigen (Input = ListenID)?");

                        try {
                            List<VocabItem> listOfVocabitems = vocabListService.getAllItemsInVocabList(listenIDShow);

                            for (VocabItem vocabItem : listOfVocabitems) {
                                System.out.println("ItemId: " + vocabItem.getVocabItemID() + " - firstLanguage: " + vocabItem.getFirstLanguage());//  + " - secLanguage: " + vocabItem.getSecLanguage().toArray().toString());
                            }
                        } catch (Exception e) {
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                        //Vocabelliste erstellen
                    } else if (listAction == 3) {

                        try {
                            String languageLeft = gameUiView.askSomethingString("Welcher Hauptsprache soll die Liste angehören?");
                            Language languageleftObj = languageService.createLanguage(languageLeft);

                            String languageRight = gameUiView.askSomethingString("Welcher Fremdsprache soll die Liste angehören?");
                            Language languagerightObj = languageService.createLanguage(languageRight);

                            String categoryName = gameUiView.askSomethingString("Welcher Kategorie soll die Liste angehören?");
                            Category categoryObj = categoryService.createCategory(categoryName);

                            String pfad = gameUiView.askSomethingString("Von welchem Pfad soll die Liste eingelesen werden?");
                            List VocabItemList = vocabItemService.createVocabItemOufOfMap(vocabListService.importVocabStringsFromTextFile(pfad));

                            VocabList vocabList = vocabListService.createVocabList(VocabItemList, languageleftObj, languagerightObj, categoryObj);

                        } catch (Exception e) {
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                        //Vokabeln manuell zu bestehender Liste hinzufügen
                        //ToDo ausimplementieren
                    } else if (listAction == 4) {
                        //System.out.println("Noch nicht implementiert!");
                        Long customAction = gameUiView.askSomethingLong("Für welche Liste möchten sie die CustomList erstellen? (Input = ListenID)?");
                        vocabListService.createQuestionList(customAction);

                        //Textfiles zur bestehenden Vokabelliste hinzufügen
                        //ToDo ausimplementieren
                    } else if (listAction == 5) {
                        System.out.println("Noch nicht implementiert!");

                        //Vokabelliste löschen
                    } else if (listAction == 6) {
                        Long deleteAction = gameUiView.askSomethingLong("Welche Liste möchten sie löschen (Input = ListenID)?");
                        //try {
                            vocabListService.deleteVocabListById(deleteAction);
                        //} catch (Exception e) {
                            //System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        //}

                        //App sofort beenden
                    } else if (listAction == 8) {
                        System.exit(0);
                    }
                }
            } else if (action == 2) {
                System.out.println("Noch nicht implementiert!");


            } else if (action == 3) {

                User test = userService.createUser("Peter", "Test","Supertester123", "qwer");
                User test2 = userService.createUser("Holger", "Test","Supertester123", "qwer");
                VocabList vocabtest = getVocabList(1L);

                Long User1Id = gameUiView.askSomethingLong("Gib uns die ID vom Game Host");
                Long User2Id = gameUiView.askSomethingLong("Gib uns die ID vom Game Participant");
                //getUserbyID implem

                int vocablistId = gameUiView.askSomethingInt("Gib uns die ID der gewünschten VocabListe");

                try {
                    gameUiView.printMessage("you creating a Game now.");
                    Game game = gameService.createGame(test, test2, vocabtest);
                    //Game created Rounds are implemented
                    List<Round> rounds = game.getRounds();

                    //Player 1 all Rounds
                    for (int i = 0; i < 3; i++) {
                        Round round = rounds.get(i);
                        //set the right answer for the round
                        round.setRightAnswer(round.getVocabSet().get(1));
                        //mix all answers in vocabset
                        List<String> vocabSet = roundService.mixAnswers(round);

                        gameUiView.printMessage(
                                "Frage: " + vocabSet.get(0) + "\n" +
                                "1: " + vocabSet.get(1) + " \t 2: " + vocabSet.get(2) + "\n" +
                                "3: " + vocabSet.get(3) + " \t 4: " + vocabSet.get(4)
                        );
                        String answer = vocabSet.get(gameUiView.askSomethingInt(
                                "Was ist die richtige Antwort? 1, 2, 3 oder 4?"));
                        round.setAnswerPlayer1(answer);
                    }

                    //Player 2 all Rounds
                    for (int i = 0; i < 3; i++) {
                        Round round = rounds.get(i);
                        List<String> vocabSet = round.getVocabSet();

                        gameUiView.printMessage(
                                "Frage: " + vocabSet.get(0) + "\n" +
                                        "1: " + vocabSet.get(1) + " \t 2: " + vocabSet.get(2) + "\n" +
                                        "3: " + vocabSet.get(3) + " \t 4: " + vocabSet.get(4)
                        );

                        round.setAnswerPlayer2(vocabSet.get(gameUiView.askSomethingInt(
                                "Was ist die richtige Antwort? 1, 2, 3 oder 4?")));

                        roundService.calculateRoundResults(round);

                    }

                    gameUiView.printMessage("Winner of the game is Player: " + gameService.calculateTotalWinner(game.getRounds().get(0).getWinningUser(), game.getRounds().get(1).getWinningUser(), game.getRounds().get(2).getWinningUser()));


                } catch (InvalidUserException e) {
                    e.printStackTrace();
                }

            } else if (action == 4) {
                System.exit(0);
            }
        }

    }
    public VocabList getVocabList(Long id){

//          if id null create Test bundle for Testing
//          delete later for getVocablist by ID

        //create Testlists for VocabItem
        List<String> testListVI, testListVI2, testListVI3, testListVI4;
        testListVI = testListVI2 = testListVI3 = testListVI4 = new ArrayList<>();
        testListVI.add("test-engl1");
        testListVI.add("different1");
        testListVI2.add("test-engl2");
        testListVI2.add("different2");
        testListVI2.add("moredifferent2");
        testListVI3.add("test-engl3");
        testListVI4.add("test-engl4");
        testListVI4.add("different4");

        //Test VocabItems for Itemlist with ID, vocabname and translationList
        VocabItem tVI1 = new VocabItem("Test1", testListVI);
        VocabItem tVI2 = new VocabItem("Test2", testListVI2);
        VocabItem tVI3 = new VocabItem("Test3", testListVI3);
        VocabItem tVI4 = new VocabItem("Test4", testListVI4);

        //create ItemList for Vocablist
        List<VocabItem> testItemList = new ArrayList<>();
        testItemList.add(tVI1);
        testItemList.add(tVI2);
        testItemList.add(tVI3);
        testItemList.add(tVI4);

        //create Vocablist
        Map<String,List<VocabItem>> testMap = new HashMap<String, List<VocabItem>>();
        testMap.put("Test", testItemList);

        VocabList testVocabList = new VocabList(testItemList, new Language("German"),
                new Language("English"), new Category("Test"));

        return testVocabList;

    };
}
