import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vocabmanagement.inter.InvalidNameException;
import vocabmanagement.inter.VocabItem;
import vocabmanagement.inter.VocabItemService;

import java.util.ArrayList;
import java.util.List;

public class VocabItemServiceTest {

    private VocabItemService vocService;
    private ArrayList<String> testLeftLan;
    private ArrayList<String> testRightLan;

    @Before
    public void setUp() {
        this.vocService = new VocabItemServiceImpl();
        this.testLeftLan = new ArrayList<String>();
        this.testRightLan = new ArrayList<String>();
    }

    /***
     * createVocabItem returns null at the moment
     * Therefore all test returning null
     */

    @Test
    public void testCreateVocabItemRaw() {
        testLeftLan.add("Test");
        testLeftLan.add("Examen");
        testRightLan.add("examen");

        VocabItem vocabItem = vocService.createVocabItem(testLeftLan, testRightLan);

        Assert.assertNotNull(vocabItem);
    }

    @Test(expected = InvalidNameException.class)
    public void testCreateVocabItemSpecialChars() throws InvalidNameException {
        testLeftLan.add("Test%&%/§$");
        testLeftLan.add("Examen");
        testRightLan.add("examen%&%/§$");

        VocabItem vocabItem = vocService.createVocabItem(testLeftLan, testRightLan);

    }

    @Test(expected = InvalidNameException.class)
    public void testCreateVocabItemSpecialNumber() throws InvalidNameException {
        testLeftLan.add("1");
        testLeftLan.add("2");
        testRightLan.add("3");

        VocabItem vocabItem = vocService.createVocabItem(testLeftLan, testRightLan);
    }






}
