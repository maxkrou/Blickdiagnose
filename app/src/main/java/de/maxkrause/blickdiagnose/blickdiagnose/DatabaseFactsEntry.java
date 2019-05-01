package de.maxkrause.blickdiagnose.blickdiagnose;

public class DatabaseFactsEntry {

    int id;
    String diagnosis_fact_english;
    String diagnosis_fact_german;


    public DatabaseFactsEntry(){

    }

    public DatabaseFactsEntry(String diagnosis_fact_english, String diagnosis_fact_german){
        this.diagnosis_fact_english=diagnosis_fact_english;
        this.diagnosis_fact_german=diagnosis_fact_german;
    }

    public DatabaseFactsEntry(int id, String diagnosis_fact_english, String diagnosis_fact_german){
        this.id=id;
        this.diagnosis_fact_english=diagnosis_fact_english;
        this.diagnosis_fact_german=diagnosis_fact_german;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDiagnosis_fact_english(String diagnosis_fact_english) {
        this.diagnosis_fact_english = diagnosis_fact_english;
    }

    public void setDiagnosis_fact_german(String diagnosis_fact_german) {
        this.diagnosis_fact_german = diagnosis_fact_german;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getDiagnosis_fact_english() {
        return diagnosis_fact_english;
    }

    public String getDiagnosis_fact_german() {
        return diagnosis_fact_german;
    }

}
