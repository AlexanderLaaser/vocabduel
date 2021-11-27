package de.htwberlin.vocabmanagement.inter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "VocabItem")
public class VocabItem {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long vocabItemID;
    private String leftlan;
    @Transient
    @ElementCollection
    @CollectionTable(name = "rightlan", joinColumns = @JoinColumn(name = "id"))
    @OrderColumn
    private List<String> rightlan;

    public VocabItem(Long vocabItemID, String vocabName, List<String> translations) {
        this.vocabItemID = vocabItemID;
        this.leftlan = vocabName;
        this.rightlan = translations;
    }

    public VocabItem() {

    }

    public Long getVocabItemID() {
        return vocabItemID;
    }

    public void setVocabItemID(Long vocabItemID) {
        this.vocabItemID = vocabItemID;
    }

    public String getFirstLanguage() {
        return leftlan;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.leftlan = firstLanguage;
    }

    public List<String> getSecLanguage() {
        return rightlan;
    }

    public void setSecLanguage(List<String> secLanguage) {
        this.rightlan = secLanguage;
    }
}
