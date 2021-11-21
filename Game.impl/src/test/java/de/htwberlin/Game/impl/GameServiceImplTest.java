package de.htwberlin.Game.impl;

import de.htwberlin.game.inter.Game;
import de.htwberlin.game.inter.GameService;
import de.htwberlin.game.inter.RoundService;
import de.htwberlin.usermanagement.inter.InvalidUserException;
import de.htwberlin.usermanagement.inter.User;
import de.htwberlin.usermanagement.inter.UserService;
import de.htwberlin.vocabmanagement.inter.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GameServiceImplTest {

    @Spy
    @InjectMocks
    private GameService gameService = new GameServiceImpl();
    @InjectMocks
    private RoundService roundService = new RoundServiceImpl();

    @Mock
    private UserService userService;
    @Mock
    private VocabListService vocabservice;
    @Mock
    private Category mockcategory;
    @Mock
    private Language mocklanguage;
    @Mock
    private VocabList mocklist;
    @Mock
    private Game mockGame;

    @Before
    public void setUp(){
    }

    /**
     * Test erstellt ein Game mit künstlichen Daten aus User und VocabList
     * @throws InvalidUserException invalid User
     */
    @Test
    public void testCreateGame() throws InvalidUserException {
        int userId1 = 1;
        int userId2 = 2;
        int listId = 2;

        gameService.createGame(userId1, userId2, listId);

/*
        String listLeftLan = ("Hallo");
        List listRightLan = new ArrayList();
        listRightLan.add("Hello");
        List<VocabItem> vocabItems = new ArrayList<VocabItem>();
        VocabItem mockitem = new VocabItem(1L, listLeftLan, listRightLan);
        vocabItems.add(mockitem);

        User mockuser1 = new User(userId1,"Peter", "Test","Supertester123", "qwer");
        User mockuser2 = new User(userId2,"Peter", "Test","Supertester123", "qwer");

        VocabList mocklist = new VocabList(listId,mocklanguage, mocklanguage, mockcategory, vocabItems);

        Mockito.when(userService.getUserById(userId1)).thenReturn(mockuser1);
        Mockito.when(userService.getUserById(userId2)).thenReturn(mockuser2);
        Mockito.when(vocabservice.getVocabListByID(listId)).thenReturn(mocklist);

        Game gametestObj = gameService.createGame(userId1, userId2, listId);

        Assert.assertEquals(mockuser1.getUserID(), userId1);
        Assert.assertNotNull(mockuser2);
        Assert.assertNotNull(gametestObj);
        Assert.assertNotNull(gametestObj.getGameOwner());

 */
    }
}