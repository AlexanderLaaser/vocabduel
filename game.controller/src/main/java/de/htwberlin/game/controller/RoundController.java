package de.htwberlin.game.controller;

import de.htwberlin.game.inter.Round;
import de.htwberlin.game.inter.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/round")
public class RoundController {
    private final RoundService roundService;

    @Autowired
    public RoundController(RoundService roundService){
        this.roundService = roundService;
    }

    @PostMapping(value = "/add")
    public Round updateRound(@RequestParam Round round){
       return roundService.saveRound(round);
    }

    @PutMapping(value = "/update")
    public Round saveRound(@RequestParam Round round){
        return roundService.updateRound(round);
    }

    @GetMapping("/id/{id}")
    public Round getRoundById(@PathVariable int id){
        return roundService.getRoundById(id);
    }

}
