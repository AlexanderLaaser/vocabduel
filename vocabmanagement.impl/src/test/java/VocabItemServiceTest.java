import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import de.htwberlin.vocabmanagement.impl.VocabItemServiceImpl;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabItemService;

import java.util.ArrayList;

public class VocabItemServiceTest {

    private VocabItemService vocService;
    private String testLeftLan;
    private ArrayList<String> testRightLan;

    @Before
    public void setUp() {
        this.vocService = new VocabItemServiceImpl();
        this.testRightLan = new ArrayList<String>();
    }

    /***
     * createVocabItem returns null at the moment
     * Therefore all test returning null
     */

    @Test
    public void testCreateVocabItemRaw() {
        testLeftLan = "test";
        testRightLan.add("examen");

        VocabItem vocabItem = vocService.createVocabItem(testLeftLan, testRightLan);

        Assert.assertNotNull(vocabItem);
    }

    @Test
    public void testCreateVocabItemSpecialChars() throws InvalidNameException {
        testLeftLan = "Test%&%/§$";
        testRightLan.add("examen%&%/§$");

        VocabItem vocabItem = vocService.createVocabItem(testLeftLan, testRightLan);

    }

    @Test
    public void testCreateVocabItemSpecialNumber() throws InvalidNameException {
        testLeftLan = "1";
        testRightLan.add("3");

        VocabItem vocabItem = vocService.createVocabItem(testLeftLan, testRightLan);
    }
}
