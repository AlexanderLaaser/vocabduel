package de.htwberlin.usermanagement.inter;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userID")
    private Long userID;

    @Column(
            name = "firstName",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "lastName",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "userName",
            nullable = false,
            unique = true
    )
    private String userName;

    @Column(
            name = "password",
            nullable = false)
    private String password;

    @Column(name = "totalGames")
    private int totalGames;

    @Column(name = "gamesWon")
    private int gamesWon;

    @Column(name = "gamesLost")
    private int gamesLost;

    public User(long userID, String firstName, String lastName, String userName, String password) {
        super();
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

}

