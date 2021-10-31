package vocabmanagement.inter;

import vocabmanagement.inter.InvalidNameException;

public interface CategoryService {

    /**
     * Erstellt Category
     * @param categoryName
     * @return
     * @throws InvalidNameException
     */
    Category createCategory (String categoryName) throws InvalidNameException;

    /**
     *
     * @param categoryName
     * @return
     */
    Category checkingForDuplicates(String categoryName);
}
