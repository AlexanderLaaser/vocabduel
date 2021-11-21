package de.htwberlin.game_ui.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game_ui.inter.GameUiController;
import de.htwberlin.vocabmanagement.impl.CategoryServiceImpl;
import de.htwberlin.vocabmanagement.impl.LanguageServiceImpl;
import de.htwberlin.vocabmanagement.impl.VocabItemServiceImpl;
import de.htwberlin.vocabmanagement.impl.VocabListServiceImpl;
import de.htwberlin.vocabmanagement.inter.Category;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.Language;
import de.htwberlin.vocabmanagement.inter.VocabList;

import de.htwberlin.Game.impl.GameServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class GameUiControllerImpl implements GameUiController {

    private GameUiView gameUiView;
    private VocabListServiceImpl vocabListServiceimpl;
    private VocabItemServiceImpl vocabItemServiceImpl;
    private LanguageServiceImpl languageServiceImpl;
    private CategoryServiceImpl categoryServiceImpl;
    private GameServiceImpl gameServiceImpl;

    public GameUiControllerImpl() {
        super();
    }

    @Autowired
    public GameUiControllerImpl(GameUiView gameuiView, VocabListServiceImpl vocabListServiceimpl, VocabItemServiceImpl vocabItemServiceImpl, LanguageServiceImpl languageServiceImpl, CategoryServiceImpl categoryServiceImpl, GameServiceImpl gameServiceImpl) {
        super();
        this.gameUiView = gameuiView;
        this.vocabListServiceimpl = vocabListServiceimpl;
        this.vocabItemServiceImpl = vocabItemServiceImpl;
        this.languageServiceImpl = languageServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
        this.gameServiceImpl = gameServiceImpl;
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
        int component = gameUiView.askForInt("Was tun? 1 = Vocabmanagement Komponente starten  2 = Game Komponente starten");

        if (component == 1) {
            gameUiView.printMessage("Die Vocabmanagement Komponente wird gestartet:");
            String action = gameUiView.askForListAction();

            //if(action == "eins"){
            String languageLeft = gameUiView.askSomething("Welcher Hauptsprache soll die Liste angehören?");
            Language languageleftObj = languageServiceImpl.createLanguage(languageLeft);

            String languageRight = gameUiView.askSomething("Welcher Fremdsprache soll die Liste angehören?");
            Language languagerightObj = languageServiceImpl.createLanguage(languageRight);

            String category = gameUiView.askSomething("Welcher Kategorie soll die Liste angehören?");
            Category categoryObj = categoryServiceImpl.createCategory(category);

            String pfad = gameUiView.askSomething("Von welchem Pfad soll die Liste eingelesen werden?");
            Map tempMap = vocabListServiceimpl.importVocabStringsFromTextFile(pfad);

            VocabList vocabList = vocabListServiceimpl.createVocabList(tempMap,languageleftObj,languagerightObj,categoryObj);

            System.out.print(tempMap);
            System.out.println(vocabList.getItemlist());
            System.out.println(vocabList.getCategory());
            System.out.println(vocabList.getFirstLanguage());
            System.out.println(vocabList.getSecLanguage());
            //}
        }
        else if(component == 2){
            int User1Id = gameUiView.askForInt("Gib uns die ID vom Game Host");
            int User2Id = gameUiView.askForInt("Gib uns die ID vom Game Participant");
            int vocablistId = gameUiView.askForInt("Gib uns die ID der gewünschten VocabListe");

          //  Game game = GameServiceImpl.createGame(User1Id, User2Id,vocablistId);



        }

    }
}
