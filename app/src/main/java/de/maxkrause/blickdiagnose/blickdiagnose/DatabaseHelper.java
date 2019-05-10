package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "blickdiagnose_db_3";

    //Table Names
    private static final String TABLE_MAIN = "blickdiagnose_names";
    private static final String TABLE_CATS = "diagnosis_cats";
    private static final String TABLE_FACTS = "diagnosis_facts";
    private static final String TABLE_CITATION = "diagnosis_citation";
    private static final String TABLE_LINK_MAIN_CATS = "linking_diagnosisandcats";
    private static final String TABLE_LINK_MAIN_FACTS = "linking_diagnosisandfacts";
    private static final String TABLE_LINK_MAIN_CITATION = "linking_diagnosisandcitation";


    //Common column names
    private static final String KEY_ID ="id";

    //MAIN Table - column names
    private static final String MAIN_IMAGE_PATH = "image_path";
    private static final String MAIN_DIA_NAME_EN = "diagnosis_name_en";
    private static final String MAIN_DIA_NAME_DE = "diagnosis_name_de";

    //CATS Table - column names
    private static final String CATS_CAT_EN = "diagnosis_cat_en";
    private static final String CATS_CAT_DE = "diagnosis_cat_de";

    //MAIN_CATS_LINKING_TABLE
    private static final String LINK_DIA_ID = "dia_id";
    private static final String LINK_CAT_ID = "cat_id";

    //FACTS Table - column names
    private static final String FACT_ID = "fact_id";
    private static final String FACTS_FACT_EN = "diagnosis_fact_en";
    private static final String FACTS_FACT_DE = "diagnosis_fact_de";

    //MAIN_FACTS_LINKING_TABLE
    private static final String LINK_DIA_ID_2 = "dia_id";
    private static final String LINK_FACT_ID = "fact_id";

    //CITATION Table - column names
    private static final String CITATION_ENGLISH = "diagnosis_cit_en";
    private static final String CITATION_GERMAN = "diagnosis_cit_de";

    //MAIN_CITATION_LINKING_TABLE
    private static final String LINK_CIT_ID = "cit_id";
    private static final String LINK_DIA_ID_3 = "dia_id";

    //Table Create Statements
    //MAIN Table
    private static final String CREATE_TABLE_MAIN = "CREATE TABLE " +TABLE_MAIN
            +"("
            +KEY_ID+" INTEGER PRIMARY KEY,"
            +MAIN_IMAGE_PATH+" TEXT,"
            +MAIN_DIA_NAME_EN+" TEXT,"
            +MAIN_DIA_NAME_DE+" TEXT"
            +")";


    //CATS Table
    private static final String CREATE_TABLE_CATS = "CREATE TABLE " +TABLE_CATS
            +"("
            +KEY_ID+" INTEGER PRIMARY KEY,"
            +CATS_CAT_EN+" TEXT,"
            +CATS_CAT_DE+" TEXT"
            +")";

    //MAIN_CATS Linking Table
    private static final String CREATE_LINKING_TABLE_MAIN_CATS = "CREATE TABLE " +TABLE_LINK_MAIN_CATS
            +"("
            +KEY_ID+" INTEGER PRIMARY KEY,"
            +LINK_DIA_ID+" INTEGER,"
            +LINK_CAT_ID+" INTEGER"
            +")";

    //FACTS Table
    private static final String CREATE_TABLE_FACTS = "CREATE TABLE " +TABLE_FACTS
            +"("
            +KEY_ID+" INTEGER PRIMARY KEY,"
            +FACTS_FACT_EN+" TEXT,"
            +FACTS_FACT_DE+" TEXT"
            +")";

    //MAIN_FACTS Linking Table
    private static final String CREATE_LINKING_TABLE_MAIN_FACTS = "CREATE TABLE " +TABLE_LINK_MAIN_FACTS
            +"("
            +KEY_ID+" INTEGER PRIMARY KEY,"
            +LINK_DIA_ID_2+" INTEGER,"
            +LINK_FACT_ID+" INTEGER"
            +")";


    //CITATION Table
    private static final String CREATE_TABLE_CITATION = "CREATE TABLE " +TABLE_CITATION
            +"("
            +KEY_ID+" INTEGER PRIMARY KEY,"
            +CITATION_ENGLISH+" TEXT,"
            +CITATION_GERMAN+" TEXT"
            +")";

    //CITATION and Diagnosis Linking Table
    private static final String CREATE_LINKING_TABLE_MAIN_CITATION = "CREATE TABLE " +TABLE_LINK_MAIN_CITATION
            +"("
            +KEY_ID+" INTEGER PRIMARY KEY,"
            +LINK_DIA_ID_3+" INTEGER,"
            +LINK_CIT_ID+" INTEGER"
            +")";



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_MAIN);
        db.execSQL(CREATE_LINKING_TABLE_MAIN_CATS);
        db.execSQL(CREATE_TABLE_CATS);
        db.execSQL(CREATE_TABLE_FACTS);
        db.execSQL(CREATE_LINKING_TABLE_MAIN_FACTS);
        db.execSQL(CREATE_TABLE_CITATION);
        db.execSQL(CREATE_LINKING_TABLE_MAIN_CITATION);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop older tables on upgrade
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MAIN);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CATS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FACTS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LINK_MAIN_CATS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LINK_MAIN_FACTS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CITATION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LINK_MAIN_CITATION);


        //create new tables
        onCreate(db);
    }


    /*
     * Creating a new diagnosis
     */

    public long createDiagnosis(DatabaseDiagnosisEntry diagnosisEntry, long[] diagnosis_cats, long[] diagnosis_facts){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MAIN_IMAGE_PATH, diagnosisEntry.getImage_path());
        values.put(MAIN_DIA_NAME_EN, diagnosisEntry.getDiagnosis_name_english());
        values.put(MAIN_DIA_NAME_DE, diagnosisEntry.getDiagnosis_name_german());

        //insert row
        long diagnosis_id = db.insert(TABLE_MAIN, null, values);

        //assigning categories to diagnosis

        for(long diagnosis_cat: diagnosis_cats) {
            createDiagnosisCat(diagnosis_id, diagnosis_cat);
        }

        for(long diagnosis_fact: diagnosis_facts){
            createDiagnosisFact(diagnosis_id, diagnosis_fact);
        }


      return diagnosis_id;
    }

    public DatabaseDiagnosisEntry getDiagnosisEntry(long diagnosis_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_MAIN + " WHERE "+KEY_ID+ " = "+diagnosis_id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if(c!=null){
            c.moveToFirst();
        }

        DatabaseDiagnosisEntry diagnosisEntry = new DatabaseDiagnosisEntry();
        diagnosisEntry.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        diagnosisEntry.setImage_path(c.getString(c.getColumnIndex(MAIN_IMAGE_PATH)));
        diagnosisEntry.setDiagnosis_name_english(c.getString(c.getColumnIndex(MAIN_DIA_NAME_EN)));
        diagnosisEntry.setDiagnosis_name_german(c.getString(c.getColumnIndex(MAIN_DIA_NAME_DE)));

        return diagnosisEntry;

    }

    public long createCategory(DatabaseCatsEntry cat){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CATS_CAT_EN, cat.getDiagnosis_cat_english());
        values.put(CATS_CAT_DE, cat.getDiagnosis_cat_german());

        long cat_id = db.insert(TABLE_CATS, null, values);

        return cat_id;
    }

    public long createDiagnosisCat(long diagnosis_id, long diagnosis_cat){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LINK_DIA_ID, diagnosis_id);
        values.put(LINK_CAT_ID, diagnosis_cat);

        long id = db.insert(TABLE_LINK_MAIN_CATS, null, values);

        return id;
    }

    public long createFact(DatabaseFactsEntry fact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FACTS_FACT_EN, fact.getDiagnosis_fact_english());
        values.put(FACTS_FACT_DE, fact.getDiagnosis_fact_german());

        long fact_id = db.insert(TABLE_FACTS, null, values);

        return fact_id;
    }

    public long createDiagnosisFact(long diagnosis_id, long diagnosis_fact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LINK_DIA_ID_2, diagnosis_id);
        values.put(LINK_FACT_ID, diagnosis_fact);

        long id = db.insert(TABLE_LINK_MAIN_FACTS, null, values);

        return id;
    }

    public long createCitation(DatabaseCitationEntry cit){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CITATION_ENGLISH, cit.getDiagnosis_citation_english());
        values.put(CITATION_GERMAN, cit.getDiagnosis_citation_german());

        long cit_id = db.insert(TABLE_CITATION, null, values);

        return cit_id;
    }


    public List<DatabaseFactsEntry> getAllFactsByDiagnosis(long diagnosis_id) {
        List<DatabaseFactsEntry> facts = new ArrayList<DatabaseFactsEntry>();

        String selectQuery = "SELECT * FROM "
                + TABLE_MAIN
                + " INNER JOIN " + TABLE_LINK_MAIN_FACTS
                + " ON " + TABLE_MAIN + ".id = " + TABLE_LINK_MAIN_FACTS + ".dia_id"
                + " INNER JOIN " + TABLE_FACTS
                + " ON " + TABLE_LINK_MAIN_FACTS + ".fact_id = " + TABLE_FACTS + ".id"
                + " AND " + TABLE_LINK_MAIN_FACTS + ".dia_id = " + diagnosis_id
                + ";";
        Log.e(LOG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        //looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                DatabaseFactsEntry fact = new DatabaseFactsEntry();
                fact.setId(c.getInt(c.getColumnIndex(FACT_ID)));
                fact.setDiagnosis_fact_english(c.getString(c.getColumnIndex(FACTS_FACT_EN)));
                fact.setDiagnosis_fact_german(c.getString(c.getColumnIndex(FACTS_FACT_DE)));

                //adding to dias list
                facts.add(fact);
            }
            while (c.moveToNext());
        }
        return facts;
    }


    public List<DatabaseDiagnosisEntry> getDiagnosisById(long diagnosis_id){

        List<DatabaseDiagnosisEntry> dias = new ArrayList<DatabaseDiagnosisEntry>();

        String selectQuery = "SELECT * FROM "
                + TABLE_MAIN
                + " INNER JOIN " + TABLE_LINK_MAIN_FACTS
                + " ON " + TABLE_MAIN + ".id = " + TABLE_LINK_MAIN_FACTS + ".dia_id"
                + " INNER JOIN " + TABLE_FACTS
                + " ON " + TABLE_LINK_MAIN_FACTS + ".fact_id = " + TABLE_FACTS + ".id"
                + " AND " + TABLE_LINK_MAIN_FACTS + ".dia_id = " + diagnosis_id
                + ";";

        Log.e(LOG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        //looping through all rows and adding to list
        if(c.moveToFirst()){
            do{
                DatabaseDiagnosisEntry dia = new DatabaseDiagnosisEntry();
                dia.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                dia.setImage_path(c.getString(c.getColumnIndex(MAIN_IMAGE_PATH)));
                dia.setDiagnosis_name_english(c.getString(c.getColumnIndex(MAIN_DIA_NAME_EN)));
                dia.setDiagnosis_name_german(c.getString(c.getColumnIndex(MAIN_DIA_NAME_DE)));

                //adding to dias list
                dias.add(dia);
            }
            while(c.moveToNext());

        }

        return dias;
    }




    public void dropDatabase(Context context){
        try {
            context.deleteDatabase(DATABASE_NAME);
        }catch (NullPointerException e){

        }
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }


/*

    /////////////-------------------------------------------
    public boolean addData (int table,int column, String item){
        long result = 1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //Table blickdiagnose_db
        if (table == 1) {
            if(column == 1){
                contentValues.put(COL1, item);
            }
            else if(column == 2){
                contentValues.put(COL2, item);
            }
            else if(column == 3){
                contentValues.put(COL3, item);
            }
            else if(column == 4){
                contentValues.put(COL4, item);
            }
            result = db.insert(TABLE_NAME, null, contentValues);
        }
        //Table blickdiagnose_cats
        else if(table == 2){
            if(column == 1){
                contentValues.put(COL1, item);
            }
            else if(column == 2){
                contentValues.put(COL_CAT_2, item);
            }
            else if(column == 3){
                contentValues.put(COL_CAT_3, item);
            }

            result = db.insert(TABLE_NAME2, null, contentValues);
        }
        //Table blickdiagnose_facts
        else if(table == 3){
            //db.insert(TABLE_NAME3, null, contentValues);
        }





      //  Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

      //  long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

*/

/*
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }


    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Updates the name field
     * @param newName
     * @param id
     * @param oldName
     */


/*
    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    /**
     * Delete from database
     * @param id
     * @param name
     */

/*
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }
*/


}
