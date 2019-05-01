package de.maxkrause.blickdiagnose.blickdiagnose;

public class DatabaseDiagnosisEntry {

    int id;
    String image_path;
    String diagnosis_name_english;
    String diagnosis_name_german;

    // constructors
    public DatabaseDiagnosisEntry() {
    }

    public DatabaseDiagnosisEntry(String image_path, String diagnosis_name_english, String diagnosis_name_german) {
        this.image_path = image_path;
        this.diagnosis_name_english = diagnosis_name_english;
        this.diagnosis_name_german = diagnosis_name_german;
    }

    public DatabaseDiagnosisEntry(int id, String image_path, String diagnosis_name_english, String diagnosis_name_german) {
        this.id = id;
        this.image_path = image_path;
        this.diagnosis_name_english = diagnosis_name_english;
        this.diagnosis_name_german = diagnosis_name_german;
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

    //Getters
    public int getId() {
        return id;
    }

    public String getImage_path() {
        return image_path;
    }

    public String getDiagnosis_name_english() {
        return diagnosis_name_english;
    }

    public String getDiagnosis_name_german() {
        return diagnosis_name_german;
    }
}
