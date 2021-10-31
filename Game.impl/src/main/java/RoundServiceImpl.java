import game.inter.RoundService;
import vocabmanagement.inter.VocabListService;

public class RoundServiceImpl implements RoundService {

    private VocabListService vocabListService;

    @Override
    public void askForGuess(){

    }

    @Override
    public int calculateRoundResults(int winningUser){
        return winningUser;
    }
}
