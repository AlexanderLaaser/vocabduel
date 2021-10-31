import vocabmanagement.inter.Category;
import vocabmanagement.inter.CategoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vocabmanagement.inter.InvalidNameException;

public class CategoryServiceTest {

    private CategoryService catService;

    @Before
    public void setUp() {
        this.catService = new CategoryServiceImpl();
    }

    @Test
    public void testCreateCategoryRaw() throws InvalidNameException {
        String testCatName = "Auto";

        Category category = catService.createCategory(testCatName);

        Assert.assertNotNull(category);
    }

    @Test(expected = InvalidNameException.class)
    public void testCreateCategorySpecialChar() throws InvalidNameException {

        String testCatName = "Auto&Bahn%&%/§$";

        catService.createCategory(testCatName);

        //Exception expected
    }

    @Test(expected = InvalidNameException.class)
    public void testCreateCategoryNumber() throws InvalidNameException {

        String testCatName = "2";

        catService.createCategory(testCatName);
    }






}
