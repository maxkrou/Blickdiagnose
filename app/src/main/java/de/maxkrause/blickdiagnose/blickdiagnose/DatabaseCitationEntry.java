package de.maxkrause.blickdiagnose.blickdiagnose;

public class DatabaseCitationEntry {


    int id;
    String diagnosis_citation_english;
    String diagnosis_citation_german;


    public DatabaseCitationEntry(){

    }

    public DatabaseCitationEntry(String diagnosis_citation_english, String diagnosis_citation_german){
        this.diagnosis_citation_english=diagnosis_citation_english;
        this.diagnosis_citation_german=diagnosis_citation_german;
    }

    public DatabaseCitationEntry(int id, String diagnosis_citation_english, String diagnosis_citation_german){
        this.id=id;
        this.diagnosis_citation_english=diagnosis_citation_english;
        this.diagnosis_citation_german=diagnosis_citation_german;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDiagnosis_citation_english(String diagnosis_citation_english) {
        this.diagnosis_citation_english = diagnosis_citation_english;
    }

    public void setDiagnosis_citation_german(String diagnosis_citation_german) {
        this.diagnosis_citation_german = diagnosis_citation_german;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getDiagnosis_citation_english() {
        return diagnosis_citation_english;
    }

    public String getDiagnosis_citation_german() {
        return diagnosis_citation_german;
    }


}
