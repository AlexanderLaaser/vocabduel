package de.htwberlin.vocabmanagement.inter;

public interface CategoryService {

    /**
     * Methode um eine Category zu erstellen
     * @param categoryName der Name der Category
     * @return gibt die Category zurück
     * @throws InvalidNameException Ausnahme bei falschem Namen
     */
    Category createCategory (String categoryName) throws InvalidNameException;

    /**
     * Methode um die Category nach Category Namen zu erhalten
     * @param categoryName der Name der Category
     * @return gibt die Category mit dem Namen zurück
     */
    Category getCategoryByCategoryName(String categoryName);

    /**
     *
     * Methode um die Category nach Category Id zu erhalten
     * @param catId Id der Category
     * @return gibt die Category mit der Id zurück
     */
    Category getCategoryById(Long catId);

    /**
     * Methode um die Category zu speichern
     * @param category übergibt eine Category
     */
    void storeCategory(Category category);
}

