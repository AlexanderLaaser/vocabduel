package de.htwberlin.vocabmanagement.inter;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class VocabItem {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long vocabItemID;

    private String leftlan;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @CollectionTable(name = "Translations", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "TranslationContent") // 3
    private List<String> rightlan;

    public VocabItem(String vocabName, List<String> translations) {
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
