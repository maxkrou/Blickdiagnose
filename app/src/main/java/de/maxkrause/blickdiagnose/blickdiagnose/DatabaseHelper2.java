package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "blickdiagnose_db_4";

    //Table Names
    private static final String TABLE_MAIN = "blickdiagnose_names";

    //Column names
    private static final String KEY_ID ="id";

    private static final String MAIN_IMAGE_PATH = "image_path";

    private static final String DIA_NAME_EN = "diagnosis_name_en";
    private static final String DIA_NAME_DE = "diagnosis_name_de";

    private static final String CATS_EN = "cats_en";
    private static final String CATS_DE = "cats_de";

    private static final String FACTS_EN = "facts_en";
    private static final String FACTS_DE = "facts_de";

    private static final String CITATION_EN = "cit_en";
    private static final String CITATION_DE = "cit_de";


    //Table Create Statements
    //MAIN Table
    private static final String CREATE_TABLE_MAIN = "CREATE TABLE " +TABLE_MAIN
            +"("
            +KEY_ID+" INTEGER PRIMARY KEY,"
            +MAIN_IMAGE_PATH+" TEXT,"
            +DIA_NAME_EN+" TEXT,"
            +DIA_NAME_DE+" TEXT,"
            +CATS_EN+" TEXT,"
            +CATS_DE+" TEXT,"
            +FACTS_EN+" TEXT,"
            +FACTS_DE+" TEXT,"
            +CITATION_EN+" TEXT,"
            +CITATION_DE+" TEXT"
            +")";

    public DatabaseHelper2(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MAIN);
        onCreate(db);
    }


    public void createDiagnosis(Database2DiagnosisEntry diagnosisEntry){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MAIN_IMAGE_PATH, diagnosisEntry.getImage_path());
        values.put(DIA_NAME_EN, diagnosisEntry.getDiagnosis_name_english());
        values.put(DIA_NAME_DE, diagnosisEntry.getDiagnosis_name_german());
        values.put(CATS_EN, diagnosisEntry.getCats_en());
        values.put(CATS_DE, diagnosisEntry.getCats_de());
        values.put(FACTS_EN, diagnosisEntry.getFacts_en());
        values.put(FACTS_DE, diagnosisEntry.getFacts_de());
        values.put(CITATION_DE, diagnosisEntry.getCitation_de());
        values.put(CITATION_EN, diagnosisEntry.getCitation_en());

        //insert row
        long diagnosis_id = db.insert(TABLE_MAIN, null, values);
    }

    public Database2DiagnosisEntry getDiagnosisEntry(long diagnosis_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_MAIN + " WHERE "+KEY_ID+ " = "+diagnosis_id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if(c!=null){
            c.moveToFirst();
        }

        Database2DiagnosisEntry diagnosisEntry = new Database2DiagnosisEntry();
        diagnosisEntry.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        diagnosisEntry.setImage_path(c.getString(c.getColumnIndex(MAIN_IMAGE_PATH)));
        diagnosisEntry.setDiagnosis_name_english(c.getString(c.getColumnIndex(DIA_NAME_EN)));
        diagnosisEntry.setDiagnosis_name_german(c.getString(c.getColumnIndex(DIA_NAME_DE)));
        diagnosisEntry.setCats_en(c.getString(c.getColumnIndex(CATS_EN)));
        diagnosisEntry.setCats_de(c.getString(c.getColumnIndex(CATS_DE)));
        diagnosisEntry.setFacts_en(c.getString(c.getColumnIndex(FACTS_EN)));
        diagnosisEntry.setFacts_de(c.getString(c.getColumnIndex(FACTS_DE)));
        diagnosisEntry.setCitation_en(c.getString(c.getColumnIndex(CITATION_EN)));
        diagnosisEntry.setCitation_de(c.getString(c.getColumnIndex(CITATION_DE)));

        return diagnosisEntry;

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

    public int getRowCountDB(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int)DatabaseUtils.longForQuery(db, "SELECT COUNT(*) FROM "+TABLE_MAIN, null);
    }


}
