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
import java.util.Arrays;
import java.util.List;

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

    public User registerUser() {

        String userFirstName = gameUiView.askSomethingString("Wie lautet der Vorname des Spielers?");
        String userLastName = gameUiView.askSomethingString("Wie lautet der Nachname des Spielers?");
        String userUsername = gameUiView.askSomethingString("Wie lautet der Username des Spielers?");
        String userPassword = gameUiView.askSomethingString("Wie lautet das Passwort des Spielers?");

        User registeredUser = null;
        try {
            registeredUser = userService.createUser(userFirstName, userLastName, userUsername, userPassword);
            gameUiView.printMessage("Die User ID des neuen Spielers lautet: " + registeredUser.getUserID().toString());
        } catch (InvalidUserException e) {
            System.out.println("Der neue Spieler kann nicht angelegt werden. Bitte überprüfen Sie Ihre Eingaben.");
        } catch (javax.naming.InvalidNameException e) {
            System.out.println("Die Eingaben für den neuen Spieler sind fehlerhaft.");
        }
        return registeredUser;
    }

    @Override
    public void run() throws IOException, InvalidNameException, javax.naming.InvalidNameException, InvalidUserException {

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
                            if (!listOfVocabList.isEmpty()) {
                                for (int i = 0; i < listOfVocabList.size(); i++) {
                                    VocabList vocabList = listOfVocabList.get(i);
                                    System.out.println("ID: " + vocabList.getListID() + " - firstLanguage: " + vocabList.getFirstLanguage().getLanguageName() + " - secLanguage: " + vocabList.getSecLanguage().getLanguageName() + " - Category: " + vocabList.getCategory().getCategoryName());
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                        //Vokabeln für bestehende Liste anzeigen (Input: ID)
                    } else if (listAction == 2) {
                        Long listenIDShow = gameUiView.askSomethingLong("Welche Liste möchten sie anzeigen (Input = ListenID)?");

                        try {
                            List<VocabItem> listOfVocabitems = vocabListService.getAllItemsInVocabList(listenIDShow);

                            for (VocabItem vocabItem : listOfVocabitems) {
                                System.out.println("ItemId: " + vocabItem.getVocabItemID() + " - firstLanguage: " + vocabItem.getFirstLanguage() + " - secLanguage: " + vocabItem.getSecLanguage().toString());
                            }
                        } catch (InvalidListIdException invalidListIdException) {
                            System.out.println(invalidListIdException.getMessage());
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
                    } else if (listAction == 4) {
                        Long listenId = gameUiView.askSomethingLong("Zu welcher Liste möchten sie eine einzelne Vokabel hinzufügen? (Input = ListenID)?");
                        try {
                            vocabListService.getVocabListByID(listenId);
                            String leftlan = gameUiView.askSomethingString("Bitte geben sie die Übersetzung der Hauptsprache an");
                            String rightlan = gameUiView.askSomethingString("Bitte geben sie die Übersetzungen der Fremdsprache an (Bei mehreren getrennt durch ein Komma - X, Y)");
                            List<String> listOfRightLan = Arrays.asList(rightlan.split("\\s*,\\s*"));

                            VocabItem vocabItem = vocabItemService.createVocabItem(leftlan, listOfRightLan);
                            vocabListService.addItemToVocabList(vocabItem, listenId);

                        } catch (InvalidListIdException invalidListIdException) {
                            System.out.println(invalidListIdException.getMessage());
                        } catch (Exception e) {
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                        //Vokabelliste löschen
                    } else if (listAction == 5) {
                        Long deleteAction = gameUiView.askSomethingLong("Welche Liste möchten sie löschen (Input = ListenID)?");
                        try {
                            vocabListService.deleteVocabListById(deleteAction);
                        } catch (InvalidListIdException invalidUserException) {
                            System.out.println(invalidUserException.getMessage());
                        } catch (Exception e) {
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }

                        //App sofort beenden
                    } else if (listAction == 7) {
                        System.exit(0);
                    }
                }
            } else if (action == 2) {

                gameUiView.printMessage("Willkommen in der Userverwaltung:");

                while (listAction != 6) {
                    listAction = gameUiView.askForUserAction();

                    //1 = Alle User anzeigen
                    if (listAction == 1) {
                        try {
                            List<User> listOfAllUsers = userService.getAllExistingUser();
                            if (!listOfAllUsers.isEmpty()) {
                                for (int i = 0; i < listOfAllUsers.size(); i++) {
                                    User userList = listOfAllUsers.get(i);
                                    System.out.println("Vorname: " + userList.getFirstName() + " Nachname: " + userList.getLastName() + "\n" + "User ID: " + userList.getUserID() + " Spielername: " + userList.getUserName() + "\n" + "Gespielte Spiele: " + userList.getTotalGames() + " [Gewonnen: " + userList.getGamesWon() + " & Verloren: " + userList.getGamesLost() + "]" + "\n");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Systemadministrator!");
                        }
                    }

                    //2 = Ausgewählten User anzeigen (Input: User ID)
                    else if (listAction == 2) {

                        Long selectedUserUserId = gameUiView.askSomethingLong("Welcher User soll aufgerufen werden (Input: User ID)");

                        try {
                            User selectedUser = userService.getUserById(selectedUserUserId);
                            System.out.println("Vorname: " + selectedUser.getFirstName());
                            System.out.println("Nachname: " + selectedUser.getLastName());
                            System.out.println("Username: " + selectedUser.getUserName());
                            System.out.println("User ID: " + selectedUser.getUserID());
                        } catch (Exception e) {
                            System.out.println("Diese Auswahl ist nicht möglich.");
                        }

                        //3 = Neuen User anlegen
                    } else if (listAction == 3) {
                        registerUser();

                        //4 = Passwort eines bestehenden Users verändern (Input: User ID")
                    } else if (listAction == 4) {

                        Long toBeUpdatedUserUserId = gameUiView.askSomethingLong("Welcher User soll ein neues Passwort erhalten (Input: User ID)?");
                        String toBeUpdatedUserPassword = gameUiView.askSomethingString("Wie lautet das neue Passwort?");

                        try {
                            userService.changePassword(toBeUpdatedUserUserId, toBeUpdatedUserPassword);
                            System.out.println("Der Spieler mit der gewählten User ID " + toBeUpdatedUserUserId + " erhält das neue Passwort: " + userService.getUserById(toBeUpdatedUserUserId).getPassword());
                        } catch (Exception e) {
                            System.out.println("Eine Passwortänderung ist nicht möglich.");
                        }

                        //5 = Bestehenden User löschen (Input: User ID)
                    } else if (listAction == 5) {

                        Long toBeDeletedUserId = gameUiView.askSomethingLong("Welcher User soll gelöscht werden (Input: User ID)?");

                        try {
                            userService.removeUser(toBeDeletedUserId);
                            System.out.println("Spieler mit der User ID " + toBeDeletedUserId + " erfolgreich gelöscht.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Der Löschvorgang ist nicht möglich.");
                        }

                        //7 = App sofort beenden
                    } else if (listAction == 7) {
                        System.exit(0);
                    }
                }
            } else if (action == 3) {

                int neuerUserFrage = 1;
                while (neuerUserFrage == 1) {
                    neuerUserFrage = gameUiView.askSomethingInt("Möchtest du einen neuen User anlegen? (tippe 1)" + " \n" + "Wenn beide User bereits angelegt sind, tippe 2.");
                    if (neuerUserFrage == 1) {
                        registerUser();
                    } else neuerUserFrage = 0;
                }

                boolean differentUser = true;
                User gameOwner = null;
                User gameParnter = null;
                while (differentUser) {
                    Long User1Id = gameUiView.askSomethingLong("Gib uns die ID vom Game Host");
                    Long User2Id = gameUiView.askSomethingLong("Gib uns die ID vom Game Participant");

                    if (User1Id != User2Id) {
                        try {
                            gameOwner = userService.getUserById(User1Id);
                            gameParnter = userService.getUserById(User2Id);
                            String name = gameOwner.getUserName();
                            name = gameParnter.getUserName();
                            differentUser = false;

                        } catch (Exception e) {
                            gameUiView.printMessage("Mindestens einer der User ist nicht in der Datanbank. Bitte probiere es erneut.");
                            //gameUiView.printMessage(e.getMessage());
                            differentUser = true;
                        }

                    } else
                        gameUiView.printMessage("Sie haben leider zweimal die gleiche ID Eingegeben. Owner und Spielpartner müssen unterschiedliche User sein.");
                }

                //getUserbyID implem
                boolean vocablistExist = true;
                VocabList vocabList = null;
                while (vocablistExist) {
                    int vocablistId = gameUiView.askSomethingInt("Gib uns die ID der gewünschten VocabListe");
                    try {
                        vocabList = vocabListService.getVocabListByID(vocablistId);
                        Long id = vocabList.getListID();
                        vocablistExist = false;
                    } catch (Exception e) {
                        gameUiView.printMessage("Die Vokabelliste ist nicht in der Datenbank. Bitte gib eine andere ID ein.");
                        vocablistExist = true;
                    }
                }

                try {
                    gameUiView.printMessage("you creating a Game now.");
                    Game game = gameService.createGame(gameOwner, gameParnter, vocabList);
                    //Game created Rounds are implemented
                    List<Round> rounds = game.getRounds();

                    for(int i=0; i<3; i++){
                        gameUiView.printMessage("Round: " + (i+1));
                        Round round = rounds.get(i);
                        playRound(round);
                        gameService.updateGame(game);
                    }

                    int winningUser = gameService.calculateGameWinner(
                            game.getRounds().get(0).getWinningUser(),
                            game.getRounds().get(1).getWinningUser(),
                            game.getRounds().get(2).getWinningUser());

                    if (winningUser == 0) {
                        gameUiView.printMessage("Es ist ein Unentschieden zwischen den Spielern: " + game.getGamePartner().getUserName() + " und "+ game.getGameOwner().getUserName());
                    }
                    if (winningUser < 0) {
                        gameUiView.printMessage("Gewinner des Spiels ist Spieler 2: " + game.getGamePartner().getUserName());
                    }
                    if (winningUser > 0) {
                        gameUiView.printMessage("Gewinner des Spiels ist Spieler 1: " + game.getGameOwner().getUserName());
                    }

                    gameService.updateGame(game);

                } catch (InvalidUserException | InvalidListIdException e) {
                    e.printStackTrace();
                }
            } else if (action == 4) {
                System.exit(0);
            }
        }

    }

    private void playRound(Round round) {
        //mix all answers in vocabset
        List<String> vocabSet1 = round.getVocabSet1();
        List<String> vocabSet2 = round.getVocabSet2();
        List<String> vocabSet3 = round.getVocabSet3();

        vocabSet1 = roundService.mixAnswers(vocabSet1);
        vocabSet2 = roundService.mixAnswers(vocabSet2);
        vocabSet3 = roundService.mixAnswers(vocabSet3);

        //all Answers from Player1
        List<String> answers = new ArrayList<>();
        gameUiView.printMessage("Frage 1 Spieler 1");
        answers.add(askQuestion(round, vocabSet1));
        gameUiView.printMessage("Frage 2 Spieler 1");
        answers.add(askQuestion(round, vocabSet2));
        gameUiView.printMessage("Frage 3 Spieler 1");
        answers.add(askQuestion(round, vocabSet3));

        round.setAnswerPlayer1(answers);


        //Player 2 Round 1
        gameUiView.printMessage("Player 2, its your turn!");
        //all Answers from Player1
        List<String> answers2 = new ArrayList<>();

        gameUiView.printMessage("Frage 1 Spieler 2");
        answers2.add(askQuestion(round, vocabSet1));
        gameUiView.printMessage("Frage  Spieler 2");
        answers2.add(askQuestion(round, vocabSet2));
        gameUiView.printMessage("Frage 3 Spieler 2");
        answers2.add(askQuestion(round, vocabSet3));

        round.setAnswerPlayer2(answers2);

        roundService.calculateRoundResults(round);
        roundService.updateRound(round);

    }

    private String askQuestion(Round round, List<String> vocabSet) {
        gameUiView.printMessage(
                "Frage: " + vocabSet.get(0) + "\n" +
                        "1: " + vocabSet.get(1) + " \t 2: " + vocabSet.get(2) + "\n" +
                        "3: " + vocabSet.get(3) + " \t 4: " + vocabSet.get(4)
        );
        String answer = vocabSet.get(gameUiView.askSomethingInt(
                "Was ist die richtige Antwort? 1, 2, 3 oder 4?"));
        return answer;
    }

}
