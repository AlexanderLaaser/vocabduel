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
    private List<String> vocabSet1;
    @ElementCollection
    private List<String> vocabSet2;
    @ElementCollection
    private List<String> vocabSet3;

    private int winningUser;

    @ElementCollection
    private List<String> rightAnswer;
    @ElementCollection
    private List<String> answerPlayer1;
    @ElementCollection
    private List<String> answerPlayer2;

    public Round(List vocabSet1, List vocabSet2, List vocabSet3) {
        this.vocabSet1 = vocabSet1;
        this.vocabSet2 = vocabSet2;
        this.vocabSet3 = vocabSet3;
    }

    public Round() {

    }

    public int getRoundID() {
        return roundID;
    }


    public int getWinningUser() {
        return winningUser;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public void setWinningUser(int winningUser) {
        this.winningUser = winningUser;
    }


    public List<String> getVocabSet1() {
        return vocabSet1;
    }

    public void setVocabSet1(List<String> vocabSet1) {
        this.vocabSet1 = vocabSet1;
    }

    public List<String> getVocabSet2() {
        return vocabSet2;
    }

    public void setVocabSet2(List<String> vocabSet2) {
        this.vocabSet2 = vocabSet2;
    }

    public List<String> getVocabSet3() {
        return vocabSet3;
    }

    public void setVocabSet3(List<String> vocabSet3) {
        this.vocabSet3 = vocabSet3;
    }

    public List<String> getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(List<String> rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<String> getAnswerPlayer1() {
        return answerPlayer1;
    }

    public void setAnswerPlayer1(List<String> answertPlayer1) {
        this.answerPlayer1 = answertPlayer1;
    }

    public List<String> getAnswerPlayer2() {
        return answerPlayer2;
    }

    public void setAnswerPlayer2(List<String> answertPlayer2) {
        this.answerPlayer2 = answertPlayer2;
    }
}
