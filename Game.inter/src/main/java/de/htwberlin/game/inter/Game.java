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
    @JoinColumn(name = "`GameOwner`")
    private User GameOwner;

    @OneToOne
    @JoinColumn(name = "GameParnter")
    private User GamePartner;

    @OneToOne
    @JoinColumn(name = "Vocablist")
    private VocabList vocablist;

//    @OneToOne
//    @Column(name = "Game Statistic")
//    private GameStatistic gameStatistic;

//    @OneToOne
//    @JoinColumn(name = "Category")
//    private Category gameCategory;


    @OneToMany
    @JoinColumn(name="Round")
    private List<Round> rounds = new ArrayList<>();

    public Game(User gameOwner, User gamePartner, VocabList vocablist) {
        GameOwner = gameOwner;
        GamePartner = gamePartner;
        this.vocablist = vocablist;
        if (this.rounds == null) {
            this.rounds = new ArrayList<Round>();
        }

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
        return GameOwner;
    }

    public void setGameOwner(User gameOwner) {
        GameOwner = gameOwner;
    }

    public User getGamePartner() {
        return GamePartner;
    }

    public void setGamePartner(User gamePartner) {
        GamePartner = gamePartner;
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
