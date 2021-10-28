package vocabmanagement.inter;

import vocabmanagement.inter.InvalidNameException;

public interface CategoryService {

    Category createCategory (String categoryName) throws InvalidNameException;

    Category checkingForDuplicates(String categoryName);
}
