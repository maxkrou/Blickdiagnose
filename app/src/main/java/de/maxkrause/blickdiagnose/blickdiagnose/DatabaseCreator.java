package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.Context;

public class DatabaseCreator {

    DatabaseHelper db;

    public DatabaseCreator(Context context){

        db = new DatabaseHelper(context);

        //db.closeDB();
        db.dropDatabase(context);

        DatabaseDiagnosisEntry diag_1 = new DatabaseDiagnosisEntry("hufeisenniere_ct_axial.jpg", "Horseshoe kidney", "Hufeisenniere");

        DatabaseCatsEntry cat_1 = new DatabaseCatsEntry("Nephrology", "Nephrologie");
        DatabaseCatsEntry cat_2 = new DatabaseCatsEntry("Cardiology", "Kardiologie");
        DatabaseCatsEntry cat_3 = new DatabaseCatsEntry("Rheumatology", "Rheumatologie");


        DatabaseFactsEntry fact_1_1 = new DatabaseFactsEntry("Genetic diseases like Edwards Syndrome, Turner Syndrome and Down Syndrome can predispose patients to developing a horseshoe kidney.", "Genetische Erkrankungen wie das Edwars-, Turner-, und Down-Syndrom prädisponieren Patienten für die Entwicklung einer Hufeisenniere.");
        DatabaseFactsEntry fact_1_2 = new DatabaseFactsEntry("Incidence of 1:500 within normal population.", "Die Inzidenz in der Normalbevölkerung beträgt 1:500.");
        DatabaseFactsEntry fact_1_3 = new DatabaseFactsEntry("Treatment focusses on treating the sequelae.", "Es erfolgt in der Regel eine symptomatische Therapie.");


        db.createCategory(cat_1);
        db.createCategory(cat_2);
        db.createCategory(cat_3);


        db.createFact(fact_1_1);
        db.createFact(fact_1_2);
        db.createFact(fact_1_3);


        //so kann man aktuell jeder diagnose nur eine einzige Kategorie zuordnen
        long[] arr1_1 = {1};
        long[] arr1_2 = {1,2,3};
        db.createDiagnosis(diag_1, arr1_1, arr1_2);




        db.closeDB();








    }

}
