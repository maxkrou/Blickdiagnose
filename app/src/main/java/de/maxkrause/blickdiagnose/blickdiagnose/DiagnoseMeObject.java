package de.maxkrause.blickdiagnose.blickdiagnose;

import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DiagnoseMeObject {

    String diagnosis_name;
    ImageView diagnosis_img;
    ArrayList<String> diagnosis_facts;
    ArrayList<String> diagnosis_cats;
    ArrayList<String> diagnosis_organs;


    public DiagnoseMeObject(){




    }

    public void setImage(ImageView img){
        diagnosis_img = img;
    }

    public ImageView getImage(){
        return diagnosis_img;
    }

    public void setDiagnosis_name(String name){
        diagnosis_name= name;
    }

    public String getDiagnosis_name(){
        return diagnosis_name;
    }

    public void setDiagnosisFacts(ArrayList<String> facts){
        diagnosis_facts = facts;
    }

    public ArrayList<String> getDiagnosis_facts(){
        return diagnosis_facts;
    }



}
