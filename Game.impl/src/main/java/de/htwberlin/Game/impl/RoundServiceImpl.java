package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Round;
import de.htwberlin.game.inter.RoundService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Component
public class RoundServiceImpl implements RoundService {

    //calculates the Winner of the Round and gives back a Integer
    //0=tie 1= User1 wins 2= User2 wins
    @Override
    public void calculateRoundResults(Round round){
        int winningUser = 0;
        String answerPlayer1 = round.getAnswerPlayer1();
        String answerPlayer2 = round.getAnswerPlayer2();
        String rightAnswer = round.getRightAnswer();

        if(answerPlayer1.equals(rightAnswer)){
            if(answerPlayer2.equals(rightAnswer))
                winningUser = 0;
            else winningUser= 1;
        }else{
            if(answerPlayer2.equals(rightAnswer)) winningUser = 2;
        }

        round.setWinningUser(winningUser);
    }

    @Override
    public Round createRound(int roundId, ArrayList vocabSet){
        Round round = new Round(roundId, vocabSet);

        return round;
    }

    @Override
    public void initNextQuestion(Round round){

    }

    @Override
    public ArrayList<String> mixAnswers(Round round){
        ArrayList<String> vocabSet = round.getVocabSet();

        ArrayList<String> answers = new ArrayList<String>(Arrays.asList(
                vocabSet.get(1), vocabSet.get(2), vocabSet.get(3), vocabSet.get(4)));

        vocabSet.remove(1);
        vocabSet.remove(1);
        vocabSet.remove(1);
        vocabSet.remove(1);

        Random rand = new Random();
        for(int f = 0; f < 4 ; f++){
            int rndInt = rand.nextInt(answers.size());
            vocabSet.add(answers.get(rndInt));
            answers.remove(rndInt);
        }
        return vocabSet;
    }
}
