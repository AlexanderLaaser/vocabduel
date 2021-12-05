package de.htwberlin.game.inter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Round")
public class Round {

    @Id
    @GeneratedValue
    @Column(name = "roundId")
    private int roundID;

    @ElementCollection
    private List<String> vocabSet;

    private int roundNumber;
    private int winningUser;
    private String rightAnswer;


    private String answerPlayer1;
    private String answerPlayer2;

    public Round(List vocabSet) {
        this.vocabSet = vocabSet;
    }

    public Round() {

    }

    public int getRoundID() {
        return roundID;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getWinningUser() {
        return winningUser;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setWinningUser(int winningUser) {
        this.winningUser = winningUser;
    }

    public List<String> getVocabSet() {
        return vocabSet;
    }

    public void setVocabSet(ArrayList vocabSet) {
        this.vocabSet = vocabSet;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getAnswerPlayer1() {
        return answerPlayer1;
    }

    public void setAnswerPlayer1(String answertPlayer1) {
        this.answerPlayer1 = answertPlayer1;
    }

    public String getAnswerPlayer2() {
        return answerPlayer2;
    }

    public void setAnswerPlayer2(String answertPlayer2) {
        this.answerPlayer2 = answertPlayer2;
    }
}
