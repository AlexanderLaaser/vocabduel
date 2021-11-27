import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import de.htwberlin.vocabmanagement.impl.VocabItemServiceImpl;
import de.htwberlin.vocabmanagement.inter.InvalidNameException;
import de.htwberlin.vocabmanagement.inter.VocabItem;
import de.htwberlin.vocabmanagement.inter.VocabItemService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class VocabItemServiceTest {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();

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

    public static String serialize(List<String> dataList){

        StringBuilder dataBuilder = new StringBuilder("[");
        dataList.forEach((data) -> {
            dataBuilder.append(data);
        });
        return dataBuilder.append("]").toString();
    }

    @Test
    public void testInsertVocabItemInDB(){

        long id = 30;

        //Arrange
        testRightLan.add("examen");
        VocabItem vocabItem = new VocabItem(id,"sprachelink",testRightLan);
        //Act
        em.getTransaction().begin();
        em.persist(vocabItem);
        em.getTransaction().commit();
        //Assert
    }




}
