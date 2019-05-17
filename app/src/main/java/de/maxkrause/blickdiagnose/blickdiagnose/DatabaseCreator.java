package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.Context;

public class DatabaseCreator {

    DatabaseHelper db;
    DatabaseHelper2 db2;

    public DatabaseCreator(Context context){


        db2 = new DatabaseHelper2(context);
        db2.dropDatabase(context);


        Database2DiagnosisEntry diag_2 = new Database2DiagnosisEntry();
        diag_2.setImage_path("hufeisenniere_ct_axial");
        diag_2.setCats_en("Nephrology");
        diag_2.setCats_de("Nephrologie");
        diag_2.setDiagnosis_name_english("Horseshoe kidney");
        diag_2.setDiagnosis_name_german("Hufeisenniere");
        diag_2.setFacts_en("Genetic diseases like Edwards Syndrome, Turner Syndrome and Down Syndrome can predispose patients to developing a horseshoe kidney.§Incidence of 1:500 within normal population.§Treatment focusses on treating the sequelae.");
        diag_2.setFacts_de("Genetische Erkrankungen wie das Edwars-, Turner-, und Down-Syndrom prädisponieren Patienten für die Entwicklung einer Hufeisenniere.§Die Inzidenz in der Normalbevölkerung beträgt 1:500.§Es erfolgt in der Regel eine symptomatische Therapie.");
        diag_2.setCitation_en("Hellerhoff [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Hufeisenniere_CT_axial.jpg\">via Wikimedia Commons</a>");
        diag_2.setCitation_de("Hellerhoff [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Hufeisenniere_CT_axial.jpg\">via Wikimedia Commons</a>");

        db2.createDiagnosis(diag_2);



        Database2DiagnosisEntry diag_3 = new Database2DiagnosisEntry();
        diag_3.setImage_path("erythema_nodosum_legs");
        diag_3.setCats_en("Infektiologie");
        diag_3.setCats_de("Infectiology");
        diag_3.setDiagnosis_name_english("Erythema nodosum");
        diag_3.setDiagnosis_name_german("Erythema nodosum");
        diag_3.setFacts_en("Acute inflammation of the fat cells under the skin.§Occurs on both sides of the lower legs, knees and ankles and is very painful.§Type 3 allergic reaction associated with a wide variety of conditions, including sarcoidosis, Löfgren's syndrome, infections (Tuberculosis, Streptococcal infection), inflammatory bowel diseases and Behçet's disease.");
        diag_3.setFacts_de("Akute Entzündung der Subkutis.§Tritt beidseitig an den Unterschenkeln, am Knie und den Sprunggelenken auf und ist sehr schmerzhaft.§Allergische Reaktion Typ 3, die im Zusammenhang mit Sarkoidose, Löfgren-Syndrom, Infektionen (Tuberkulose, Streptokokken), entzündlichen Darmerkrankungen und Morbus Behçet steht.");
        diag_3.setCitation_en("James Heilman, MD [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:ENlegs.JPG\">via Wikimedia Commons</a>");
        diag_3.setCitation_de("James Heilman, MD [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:ENlegs.JPG\">via Wikimedia Commons</a>");

        db2.createDiagnosis(diag_3);



        Database2DiagnosisEntry diag_4 = new Database2DiagnosisEntry();
        diag_4.setImage_path("baby_with_fas");
        diag_4.setCats_en("Pediatrics");
        diag_4.setCats_de("Pädiatrie");
        diag_4.setDiagnosis_name_english("Fetal alcohol syndrome");
        diag_4.setDiagnosis_name_german("Fetales Alkoholsyndrom");
        diag_4.setFacts_en("The unborn child suffers the same alcohol level as the mother via the umbilical cord.§Alcohol consumption by the pregnant woman damages the cognitive and physical-organic development of the unborn child.§The criteria that must be fully met for an FAS diagnosis are growth deficiency, central nervous system damage and dysmorphic facial features.");
        diag_4.setFacts_de("Das Ungeborene erleidet über die Nabelschnur den selben Alkoholpegel wie die Mutter.§Alkoholkonsum der schwangeren Frau schädigt die kognitive und körperlich-organische Entwicklung des Ungeborenen.§Das Vollbild des FAS besteht aus Wachstumsstörungen, Störungen des Zentralnervensystems und Gesichtsveränderungen.");
        diag_4.setCitation_en("Teresa Kellerman [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Photo_of_baby_with_FAS-2.jpg\">via Wikimedia Commons</a>");
        diag_4.setCitation_de("Teresa Kellerman [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Photo_of_baby_with_FAS-2.jpg\">via Wikimedia Commons</a>");

        db2.createDiagnosis(diag_4);

        Database2DiagnosisEntry diag_5 = new Database2DiagnosisEntry();
        diag_5.setImage_path("aortic_dissection_ct");
        diag_5.setCats_en("Vascular surgery");
        diag_5.setCats_de("Gefäßchirurgie");
        diag_5.setDiagnosis_name_english("Aortic dissection");
        diag_5.setDiagnosis_name_german("Aortendissektion");
        diag_5.setFacts_en("Most frequently caused by tearing of the intima of the aorta with subsequent bleeding between the wall layers.§Causes sudden severe pain and is acutely life-threatening.§Occurs most frequently in the area of the aorta ascendens.§A dissection of Stanford type A is treated with surgery, a dissection of type B is initially treated purely with medication, as the 30-day mortality rate is thus lower.");
        diag_5.setFacts_de("Am häufigsten verursacht durch Einriss der Intima der Aorta mit anschließender Einblutung zwischen die Wandschichten.§Verursacht plötzliche stärkste stechende Schmerzen und ist akut lebensbedrohlich.§Tritt am häufigsten im Bereich der Aorta ascendens auf.§Eine Dissektion vom Stanford Typ A wird operiert, eine Dissektion vom Typ B zunächst rein medikamentös behandelt, da die 30-Tage-Sterblichkeit so geringer ist.");
        diag_5.setCitation_en("James Heilman, MD [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:DissectionCT.png\">via Wikimedia Commons</a>");
        diag_5.setCitation_de("James Heilman, MD [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:DissectionCT.png\">via Wikimedia Commons</a>");

        db2.createDiagnosis(diag_5);

        Database2DiagnosisEntry diag_6 = new Database2DiagnosisEntry();
        diag_6.setImage_path("chickenpox_adult_back");
        diag_6.setCats_en("Infectiology");
        diag_6.setCats_de("Infektiologie");
        diag_6.setDiagnosis_name_english("Chickenpox");
        diag_6.setDiagnosis_name_german("Windpocken");
        diag_6.setFacts_en("The chickenpox pathogen is the varicella zoster virus.§After an infection, the virus remains in the nucleuplasma of the nerve cells of the spinal ganglia for the rest of the life.§The viruses are transmitted either by the contents of the varicella vesicles or by inhalation of expiratory droplets. However, the latter form of transmission is only possible up to one day before the outbreak of the exanthema.§Complications include pneumonia, meningoencephalitis, hepatitis and bacterial superinfection by staphylococci.");
        diag_6.setFacts_de("Der Erreger der Windpocken ist das Varizella-Zoster-Virus§Nach einer Infektion vergleibt das Virus lebenslang im Nukleuplasma der Nervenzellen der Spinalganglien§Die Viren werden entweder über den Inhalt der Varizellenbläschen oder über Einatmen von Expirationströpfchen übertragen. Letztere Übertragungsform ist allerdings nur bis einen Tag vor Ausbruch des Exanthems möglich.§Zu den Komplikationen gehören Pneumonie, Meningoenzephalitis, Hepatitis und bakterielle Superinfektion durch Staphylokokken.");
        diag_6.setCitation_en("F malan [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Chickenpox_Adult_back.jpg\">via Wikimedia Commons</a>");
        diag_6.setCitation_de("F malan [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Chickenpox_Adult_back.jpg\">via Wikimedia Commons</a>");

        db2.createDiagnosis(diag_6);


        Database2DiagnosisEntry diag_7 = new Database2DiagnosisEntry();
        diag_7.setDiagnosis_name_english("Auer rods");
        diag_7.setDiagnosis_name_german("Auerstäbchen");
        diag_7.setImage_path("myeloblast_with_auer_rods");
        diag_7.setCats_en("Hematology");
        diag_7.setCats_de("Hämatologie");
        diag_7.setFacts_en("Rod-shaped granules found in about 30% of all acute myeloid leukemias (AML).§Auer rods are sign of a maturation disorder of the cell.§Cells with bundled Auer rods are called Faggot cells. They occur in AML-M3 (promyelocytic leukemia).");
        diag_7.setFacts_de("Stäbchenförmige Granula, die man in ca. 30% aller akuten myeloischen Leukämien (AML) findet.§Auerstäbchen sind Zeichen einer Reifungsstörung der Zelle.§Zellen mit gebündelten Auerstäbchen nennt man Faggot-Zellen. Sie treten bei der AML-M3 (Promyelozytenleukämie) auf.");
        diag_7.setCitation_en("Paulo Henrique Orlandi Mourao [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Myeloblast_with_Auer_rod_smear_2010-01-27.JPG\">via Wikimedia Commons</a>");
        diag_7.setCitation_de("Paulo Henrique Orlandi Mourao [<a href=\"https://creativecommons.org/licenses/by-sa/3.0\">CC BY-SA 3.0</a>], <a href=\"https://commons.wikimedia.org/wiki/File:Myeloblast_with_Auer_rod_smear_2010-01-27.JPG\">via Wikimedia Commons</a>");

        db2.createDiagnosis(diag_7);













/*
        db = new DatabaseHelper(context);
        db.dropDatabase(context);
        DatabaseCatsEntry cat_1 = new DatabaseCatsEntry("Nephrology", "Nephrologie");
        DatabaseCatsEntry cat_2 = new DatabaseCatsEntry("Cardiology", "Kardiologie");
        DatabaseCatsEntry cat_3 = new DatabaseCatsEntry("Rheumatology", "Rheumatologie");
        DatabaseDiagnosisEntry diag_1 = new DatabaseDiagnosisEntry("hufeisenniere_ct_axial", "Horseshoe kidney", "Hufeisenniere");
        DatabaseFactsEntry fact_1_1 = new DatabaseFactsEntry("Genetic diseases like Edwards Syndrome, Turner Syndrome and Down Syndrome can predispose patients to developing a horseshoe kidney.", "Genetische Erkrankungen wie das Edwars-, Turner-, und Down-Syndrom prädisponieren Patienten für die Entwicklung einer Hufeisenniere.");
        DatabaseFactsEntry fact_1_2 = new DatabaseFactsEntry("Incidence of 1:500 within normal population.", "Die Inzidenz in der Normalbevölkerung beträgt 1:500.");
        DatabaseFactsEntry fact_1_3 = new DatabaseFactsEntry("Treatment focusses on treating the sequelae.", "Es erfolgt in der Regel eine symptomatische Therapie.");
        db.createCategory(cat_1);
        db.createCategory(cat_2);
        db.createCategory(cat_3);
        db.createFact(fact_1_1);
        db.createFact(fact_1_2);
        db.createFact(fact_1_3);
        long[] arr1_1 = {1};
        long[] arr1_2 = {1,2,3};
        db.createDiagnosis(diag_1, arr1_1, arr1_2);
        db.closeDB();




Database2DiagnosisEntry diag_5 = new Database2DiagnosisEntry();
        diag_5.setImage_path();
        diag_5.setCats_en();
        diag_5.setCats_de();
        diag_5.setDiagnosis_name_english();
        diag_5.setDiagnosis_name_german();
        diag_5.setFacts_en();
        diag_5.setFacts_de();
        diag_5.setCitation_en();
        diag_5.setCitation_de();
*/



    }

}
