import de.htwberlin.vocabmanagement.inter.VocabItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/***
 * Ausarbeitung erfolgt nach Implementierung der Datenquelle.
 * Im weiteren Verlauf des Projekts wird die Testklasse implementiert.
 */
class VocabListServiceTest {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAKBA");
    private EntityManager em = emf.createEntityManager();

    @Test
    void getVocabListByID() {
    }

    @Test
    void addItemToVocabSet() {
    }

    @Test
    void createVocabList() {
    }

    @Test
    void getCategoryOfVocabList() {
    }

    @Test
    public void getAllItemsInVocabList() {
        em.getTransaction().begin();
        TypedQuery<VocabItem> vl = em.createQuery("SELECT vl.itemlist FROM VocabList vl WHERE vl.listID=248", VocabItem.class);
        //vl.setParameter("listId", String.valueOf(vocabListId));
        List<VocabItem> VocabListResult = vl.getResultList();
        em.getTransaction().commit();

        for (int i = 0; i < VocabListResult.size(); i++) {
            VocabItem vocabitem = VocabListResult.get(i);
            System.out.println("ID: " + vocabitem.getVocabItemID());
        }
    }

    @Test
    void generateCustomVocabSet() {
    }
}