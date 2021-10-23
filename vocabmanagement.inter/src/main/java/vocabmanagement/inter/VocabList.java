package vocabmanagement.inter;

import java.util.List;

public class VocabList {

    private int listID;
    private String first_language;
    private String sec_language;
    private String category;
    private List<vocabmanagement.inter.VocabItem> VocabList;

    public VocabList(int listID, String first_language, String sec_language, String category, List<vocabmanagement.inter.VocabItem> vocabList) {
        super();
        this.listID = listID;
        this.first_language = first_language;
        this.sec_language = sec_language;
        this.category = category;
        VocabList = vocabList;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<vocabmanagement.inter.VocabItem> getVocabList() {
        return VocabList;
    }

    public void setVocabList(List<vocabmanagement.inter.VocabItem> vocabList) {
        VocabList = vocabList;
    }

    public String getFirst_language() {
        return first_language;
    }

    public void setFirst_language(String first_language) {
        this.first_language = first_language;
    }

    public String getSec_language() {
        return sec_language;
    }

    public void setSec_language(String sec_language) {
        this.sec_language = sec_language;
    }
}
