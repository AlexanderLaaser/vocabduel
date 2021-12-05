package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Round;
import de.htwberlin.game.inter.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RoundServiceImpl implements RoundService {

    private PlatformTransactionManager transactionManager;
    private RoundDao roundDao;

    @Autowired
    public RoundServiceImpl(PlatformTransactionManager transactionManager, RoundDao roundDao) {
        super();
        this.transactionManager = transactionManager;
        this.roundDao = roundDao;
    }

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

    public void saveRound(Round round){
        TransactionStatus ts = transactionManager.getTransaction(null);
        roundDao.saveRound(round);
        transactionManager.commit(ts);
    }
    public void updateRound(Round round){
        TransactionStatus ts = transactionManager.getTransaction(null);
        roundDao.updateRound(round);
        transactionManager.commit(ts);
    }

    @Override
    public Round createRound(ArrayList vocabSet){
        Round round = new Round(vocabSet);

        return round;
    }

    @Override
    public void initNextQuestion(Round round){

    }

    @Override
    public java.util.List<String> mixAnswers(Round round){
        List<String> vocabSet = round.getVocabSet();

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
