import vocabmanagement.inter.Category;
import vocabmanagement.inter.CategoryService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vocabmanagement.inter.InvalidNameException;

public class CategoryServiceTest {

    //Parameterized Test?

    private CategoryService catService;

    @Before
    public void setUp() {
        this.catService = new CategoryServiceImpl();
    }

    @Test
    public void testCreateCategoryRaw() throws InvalidNameException {
        //Arrage
        String testCatName = "Auto";
        //Act
        Category category = catService.createCategory(testCatName);
        //Assert
        Assert.assertNotNull(category);
    }

    @Test(expected = InvalidNameException.class)
    public void testCreateCategorySpecialChar() throws InvalidNameException {
        //Arrage
        String testCatName = "Auto&Bahn%&%/§$";
        //Act
        catService.createCategory(testCatName);
        //Assert
        //Exception expected
    }

    @Test(expected = InvalidNameException.class)
    public void testCreateCategoryNumber() throws InvalidNameException {
        //Arrage
        String testCatName = "2";
        //Act
        catService.createCategory(testCatName);
    }

    //Test zum Checken ob eine Kategorie bereits existiert




}
