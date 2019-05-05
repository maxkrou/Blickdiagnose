package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class DiagnoseActivity extends AppCompatActivity {

    ImageView imageViewDiagnosisImage;
    Button buttonShowAnswer;
    Button buttonCorrectAnswer;
    Button buttonWrongAnswer;
    TextView textViewDiagnosisFacts;
    TextView textViewWhatIsTheAnswer;
    TextView textViewAnswer;
    ScrollView scrollViewDiagnosisFacts;
    Toolbar toolbar;


    DatabaseDiagnosisEntry dia;
    ArrayList<DatabaseDiagnosisEntry> dias = new ArrayList<DatabaseDiagnosisEntry>();
    ArrayList<DatabaseFactsEntry> facts = new ArrayList<DatabaseFactsEntry>();

    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.cont);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);

        dias.add(databaseHelper.getDiagnosisEntry(1));
        facts.addAll(databaseHelper.getAllFactsByDiagnosis(1));


        // Attaching the layout to the toolbar object
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.tool_bar);
        // Setting toolbar as the ActionBar with setSupportActionBar() call
        setSupportActionBar(toolbar);






        imageViewDiagnosisImage = (ImageView)findViewById(R.id.image_view_diagnosis);
        buttonShowAnswer = (Button)findViewById(R.id.button_show_answer);
        buttonCorrectAnswer = (Button)findViewById(R.id.button_correct_answer);
        buttonWrongAnswer = (Button)findViewById(R.id.button_incorrect_answer);
        textViewDiagnosisFacts = (TextView)findViewById(R.id.textView_facts);
        textViewWhatIsTheAnswer = (TextView)findViewById(R.id.textView_what_is_the_diagnosis);
        textViewAnswer = (TextView)findViewById(R.id.textView_Answer);
        scrollViewDiagnosisFacts = (ScrollView)findViewById(R.id.scrollview_diagnosis_facts);


        //initialize GUI
        buttonShowAnswer.setVisibility(View.VISIBLE);
        textViewWhatIsTheAnswer.setVisibility(View.VISIBLE);
        imageViewDiagnosisImage.setVisibility(View.VISIBLE);
        buttonCorrectAnswer.setVisibility(View.GONE);
        buttonWrongAnswer.setVisibility(View.GONE);
        scrollViewDiagnosisFacts.setVisibility(View.GONE);
        textViewAnswer.setVisibility(View.GONE);




        Context context = imageViewDiagnosisImage.getContext();
        int id = context.getResources().getIdentifier(dias.get(0).getImage_path(), "drawable", context.getPackageName());
        imageViewDiagnosisImage.setImageResource(id);
        textViewDiagnosisFacts.setText(facts.get(0).getDiagnosis_fact_english());



        //add Listeners

        buttonShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonShowAnswer.setVisibility(View.GONE);
                buttonCorrectAnswer.setVisibility(View.VISIBLE);
                buttonWrongAnswer.setVisibility(View.VISIBLE);
                scrollViewDiagnosisFacts.setVisibility(View.VISIBLE);
                textViewAnswer.setVisibility(View.VISIBLE);
                textViewAnswer.setText(dias.get(0).getDiagnosis_name_english());
                textViewDiagnosisFacts.setText("");


                ArrayList<DatabaseFactsEntry> allfacts = new ArrayList<DatabaseFactsEntry>();
                allfacts.addAll(databaseHelper.getAllFactsByDiagnosis(1));
                for(DatabaseFactsEntry fact:allfacts){

                    textViewDiagnosisFacts.setText(textViewDiagnosisFacts.getText()+"♦ "+fact.getDiagnosis_fact_english()+"\n\n");
                }


            }
        });

        buttonCorrectAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonShowAnswer.setVisibility(View.VISIBLE);
                buttonCorrectAnswer.setVisibility(View.GONE);
                buttonWrongAnswer.setVisibility(View.GONE);
                scrollViewDiagnosisFacts.setVisibility(View.GONE);
                textViewAnswer.setVisibility(View.GONE);

            }
        });

        buttonWrongAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonShowAnswer.setVisibility(View.VISIBLE);
                buttonCorrectAnswer.setVisibility(View.GONE);
                buttonWrongAnswer.setVisibility(View.GONE);
                scrollViewDiagnosisFacts.setVisibility(View.GONE);
                textViewAnswer.setVisibility(View.GONE);


            }
        });


        



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }


}
