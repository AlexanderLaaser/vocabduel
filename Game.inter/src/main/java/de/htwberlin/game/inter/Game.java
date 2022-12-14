package de.htwberlin.game.inter;

import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.vocabmanagement.inter.VocabList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @GeneratedValue
    @Column(name = "gameId")
    private int gameID;

    @OneToOne
    private User gameOwner;

    @OneToOne
    private User gamePartner;

    @OneToOne
    private VocabList vocablist;

//    @OneToOne
//    @Column(name = "Game Statistic")
//    private GameStatistic gameStatistic;

//    @OneToOne
//    @JoinColumn(name = "Category")
//    private Category gameCategory;


    @OneToMany
    private List<Round> rounds = new ArrayList<>();

    public Game(User gameOwner, User gamePartner, VocabList vocablist) {
        this.gameOwner = gameOwner;
        this.gamePartner = gamePartner;
        this.vocablist = vocablist;
    }

    public Game() {

    }

    //    public GameStatistic getGameStatistic() {
//        return gameStatistic;
//    }
//
//    public void setGameStatistic(GameStatistic gameStatistic) {
//        this.gameStatistic = gameStatistic;
//    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public User getGameOwner() {
        return gameOwner;
    }

    public void setGameOwner(User gameOwner) {
        this.gameOwner = gameOwner;
    }

    public User getGamePartner() {
        return gamePartner;
    }

    public void setGamePartner(User gamePartner) {
        this.gamePartner = gamePartner;
    }

    public VocabList getVocablist() {
        return vocablist;
    }

    public void setVocablist(VocabList vocablist) {
        this.vocablist = vocablist;
    }

//    public Category getGameCategory() {
//        return gameCategory;
//    }

//    public void setGameCategory(Category gameCategory) {
//        this.gameCategory = gameCategory;
//    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }

}
