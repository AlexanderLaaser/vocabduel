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
    public Round calculateRoundResults(Round round){

        List<String> answerPlayer1 = round.getAnswerPlayer1();
        List<String> answerPlayer2 = round.getAnswerPlayer2();
        List<String> rightAnswer = round.getRightAnswer();
        List<Integer> roundWinnerTotal = new ArrayList<>();


        for(int i = 0; i<3; i++){
            int winningUser = 0;
            if(answerPlayer1.get(i).equals(rightAnswer.get(i))){
                if(answerPlayer2.get(i).equals(rightAnswer.get(i)))
                    winningUser = 0;
                else winningUser= 1;
            }else{
                if(answerPlayer2.get(i).equals(rightAnswer.get(i))) winningUser = 2;
            }
            roundWinnerTotal.add(winningUser);
        }

        int finalRoundWinner = 0;
        finalRoundWinner = finalRoundWinner + addEndWinner(roundWinnerTotal.get(0));
        finalRoundWinner = finalRoundWinner + addEndWinner(roundWinnerTotal.get(1));
        finalRoundWinner = finalRoundWinner + addEndWinner(roundWinnerTotal.get(2));

        int winner = 0;
        if (finalRoundWinner == 0) {
            winner = 0;
        }
        if (finalRoundWinner < 0) {
            winner = 2;
        }
        if (finalRoundWinner > 0) {
            winner = 1;
        }

        round.setWinningUser(winner);
        return round;
    }

    public int addEndWinner(int winningUser){
        int winning = 0;
        if(winningUser == 2) winning = -1;
        if(winningUser == 1) winning = 1;
        return winning;
    }


    public Round saveRound(Round round){
        TransactionStatus ts = transactionManager.getTransaction(null);
        roundDao.saveRound(round);
        transactionManager.commit(ts);
        return round;
    }
    public Round updateRound(Round round){
        TransactionStatus ts = transactionManager.getTransaction(null);
        roundDao.updateRound(round);
        transactionManager.commit(ts);
        return round;
    }

    @Override
    public List<String> mixAnswers(List<String> vocabSet){

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

    @Override
    public Round getRoundById(int roundId){
        TransactionStatus ts = transactionManager.getTransaction(null);
        Round round = roundDao.getRoundById(roundId);
        transactionManager.commit(ts);

        return round;
    }

}
