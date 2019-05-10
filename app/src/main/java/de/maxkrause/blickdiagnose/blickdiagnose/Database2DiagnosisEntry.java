package de.maxkrause.blickdiagnose.blickdiagnose;

public class Database2DiagnosisEntry {

    int id;
    String image_path;
    String diagnosis_name_english;
    String diagnosis_name_german;
    String cats_en;
    String cats_de;
    String facts_en;
    String facts_de;
    String citation_en;
    String citation_de;
    String[] facts_splitted_en;
    String[] facts_splitted_de;
    String[] cats_splitted_en;
    String[] cats_splitted_de;

    public Database2DiagnosisEntry(){

    }

    public Database2DiagnosisEntry(String image_path, String diagnosis_name_english, String diagnosis_name_german, String cats_en, String cats_de, String facts_en, String facts_de, String citation_en, String citation_de){
        this.image_path=image_path;
        this.diagnosis_name_english=diagnosis_name_english;
        this.diagnosis_name_german=diagnosis_name_german;
        this.cats_en=cats_en;
        this.cats_de=cats_de;
        this.facts_en=facts_en;
        this.facts_de=facts_de;
        this.citation_en=citation_en;
        this.citation_de=citation_de;
    }

    public Database2DiagnosisEntry(int id, String image_path, String diagnosis_name_english, String diagnosis_name_german, String cats_en, String cats_de, String facts_en, String facts_de, String citation_en, String citation_de){
        this.id=id;
        this.image_path=image_path;
        this.diagnosis_name_english=diagnosis_name_english;
        this.diagnosis_name_german=diagnosis_name_german;
        this.cats_en=cats_en;
        this.cats_de=cats_de;
        this.facts_en=facts_en;
        this.facts_de=facts_de;
        this.citation_en=citation_en;
        this.citation_de=citation_de;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public void setDiagnosis_name_english(String diagnosis_name_english) {
        this.diagnosis_name_english = diagnosis_name_english;
    }

    public void setDiagnosis_name_german(String diagnosis_name_german) {
        this.diagnosis_name_german = diagnosis_name_german;
    }

    public void setCats_en(String cats_en){
        this.cats_en=cats_en;
    }

    public void setCats_de(String cats_de){
        this.cats_de=cats_de;
    }

    public void setFacts_en(String facts_en){
        this.facts_en=facts_en;
    }

    public void setFacts_de(String facts_de) {
        this.facts_de = facts_de;
    }

    public void setCitation_en(String citation_en) {
        this.citation_en = citation_en;
    }

    public void setCitation_de(String citation_de) {
        this.citation_de = citation_de;
    }

    public String getDiagnosis_name_german() {
        return diagnosis_name_german;
    }

    public String getDiagnosis_name_english() {
        return diagnosis_name_english;
    }

    public int getId() {
        return id;
    }

    public String getImage_path() {
        return image_path;
    }

    public String getCats_en() {
        return cats_en;
    }

    public String getCats_de() {
        return cats_de;
    }

    public String getFacts_en() {
        return facts_en;
    }

    public String getFacts_de() {
        return facts_de;
    }

    public String getCitation_en() {
        return citation_en;
    }

    public String getCitation_de() {
        return citation_de;
    }

    public String[] getFacts_splitted_en(){
        facts_splitted_en = facts_en.split("§");

        return facts_splitted_en;
    }

    public String[] getFacts_splitted_de(){
        facts_splitted_de = facts_de.split("§");

        return facts_splitted_de;
    }
}
