package de.maxkrause.blickdiagnose.blickdiagnose;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button button_quick_start;
    Button button_settings;
    Button button_statistics;

    public static Context cont;

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);
        loadDiagnoseMeObjects();

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle(getResources().getString(R.string.app_name));

        cont = this;
        final Context context = this;
        DatabaseCreator dc_creator = new DatabaseCreator(context);
        //mDatabaseHelper = new DatabaseHelper(this);

        //-----------------------------------------------------------------

        button_quick_start = (Button)findViewById(R.id.button_quick_start);
        button_settings = (Button)findViewById(R.id.button_settings);
        button_statistics = (Button)findViewById(R.id.button_statistics);

        //-----------------------------------------------------------------

        button_quick_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiagnoseActivity.class);


                startActivity(intent);
            }
        });


        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });

        button_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, DatabaseGUI.class);
                //startActivity(intent);
               // mDatabaseHelper.addData(1,"test123");



            }
        });

    }

    private void loadDiagnoseMeObjects() {
        ArrayList<DiagnoseMeObject> diagnose_me_objects = new ArrayList<DiagnoseMeObject>();




    }


    private void showChangeLanguageDialog(){
        final String[] langs = {"English", "German"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(langs, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    setLocale("en");
                    recreate();
                }
                if(which==1) {
                    setLocale("de");
                    recreate();
                }
                dialog.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String _loc) {
        Locale loc = new Locale(_loc);
        Locale.setDefault(loc);
        Configuration config = new Configuration();
        config.locale = loc;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", _loc);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }


}
