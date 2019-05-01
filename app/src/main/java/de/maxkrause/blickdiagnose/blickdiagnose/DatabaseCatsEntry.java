package de.maxkrause.blickdiagnose.blickdiagnose;

public class DatabaseCatsEntry {

    int id;
    String diagnosis_cat_english;
    String diagnosis_cat_german;

    public DatabaseCatsEntry(){

    }

    public DatabaseCatsEntry(String diagnosis_cat_english, String diagnosis_cat_german){
        this.diagnosis_cat_english = diagnosis_cat_english;
        this.diagnosis_cat_german = diagnosis_cat_german;
    }

    public DatabaseCatsEntry(int id,String diagnosis_cat_english, String diagnosis_cat_german){
        this.id = id;
        this.diagnosis_cat_english = diagnosis_cat_english;
        this.diagnosis_cat_german = diagnosis_cat_german;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDiagnosis_cat_english(String diagnosis_cat_english) {
        this.diagnosis_cat_english = diagnosis_cat_english;
    }

    public void setDiagnosis_cat_german(String diagnosis_cat_german) {
        this.diagnosis_cat_german = diagnosis_cat_german;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getDiagnosis_cat_english() {
        return diagnosis_cat_english;
    }

    public String getDiagnosis_cat_german() {
        return diagnosis_cat_german;
    }
}
