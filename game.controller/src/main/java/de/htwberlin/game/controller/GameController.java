package de.htwberlin.game.controller;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.vocabmanagement.inter.InvalidListIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @PostMapping(value ="/add/{gameOwnerId}/{gamePartnerId}/{vocabListId}")
    public void createGame(@PathVariable("gameOwnerId") int gameOwnerId, @PathVariable("gamePartnerId") int gamePartnerId, @PathVariable("vocabListId") int vocabListId) throws InvalidListIdException {
//        Long gameOwnerId2 = Long.valueOf(gameOwnerId);
//        Long gamePartnerId2 = Long.valueOf(gamePartnerId);
//        Long vocabListId2 = Long.valueOf(vocabListId);
        gameService.createGameController(gameOwnerId, gamePartnerId, vocabListId);
    }


    @PutMapping(value = "/update")
    public void updateGame(@RequestParam Game game){
        gameService.updateGame(game);
    }

    @GetMapping("/id/{id}")
    public Game getGameById(@PathVariable int id){
        return gameService.getGameById(id);
    }



}
