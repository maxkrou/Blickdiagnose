package de.maxkrause.blickdiagnose.blickdiagnose;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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

    ArrayList<DatabaseDiagnosisEntry> dias = new ArrayList<>();
    ArrayList<Database2DiagnosisEntry> dias2 = new ArrayList<>();
    ArrayList<DatabaseFactsEntry> facts = new ArrayList<>();

    Locale currentLocale;
    Locale enLocale;
    Locale deLocale;

    int counter = 0;

    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.cont);
    DatabaseHelper2 databaseHelper2 = new DatabaseHelper2(MainActivity.cont);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);

        counter = 0;
        currentLocale = getResources().getConfiguration().locale;
        enLocale = Locale.ENGLISH;
        deLocale = Locale.GERMAN;
        final boolean isLanguageEnglish = currentLocale.getLanguage().equals(enLocale.getLanguage());
        final boolean isLanguageGerman = currentLocale.getLanguage().equals(deLocale.getLanguage());


        ArrayList<Integer> rndNumbers = new ArrayList<>(getUniqueRandomNumbers());

        for(int num:rndNumbers){
            dias2.add(databaseHelper2.getDiagnosisEntry(num));
        }



        dias.add(databaseHelper.getDiagnosisEntry(1));

        // Attaching the layout to the toolbar object
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.tool_bar);
        // Setting toolbar as the ActionBar with setSupportActionBar() call
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imageViewDiagnosisImage = findViewById(R.id.image_view_diagnosis);
        buttonShowAnswer = findViewById(R.id.button_show_answer);
        buttonCorrectAnswer = findViewById(R.id.button_correct_answer);
        buttonWrongAnswer = findViewById(R.id.button_incorrect_answer);
        textViewDiagnosisFacts = findViewById(R.id.textView_facts);
        textViewWhatIsTheAnswer = findViewById(R.id.textView_what_is_the_diagnosis);
        textViewAnswer = findViewById(R.id.textView_Answer);
        scrollViewDiagnosisFacts = findViewById(R.id.scrollview_diagnosis_facts);

        //initialize GUI
        buttonShowAnswer.setVisibility(View.VISIBLE);
        textViewWhatIsTheAnswer.setVisibility(View.VISIBLE);
        imageViewDiagnosisImage.setVisibility(View.VISIBLE);
        buttonCorrectAnswer.setVisibility(View.GONE);
        buttonWrongAnswer.setVisibility(View.GONE);
        scrollViewDiagnosisFacts.setVisibility(View.GONE);
        textViewAnswer.setVisibility(View.GONE);

        Context context = imageViewDiagnosisImage.getContext();
        int id = context.getResources().getIdentifier(dias2.get(counter).getImage_path(), "drawable", context.getPackageName());
        imageViewDiagnosisImage.setImageResource(id);
        //textViewDiagnosisFacts.setText(facts.get(0).getDiagnosis_fact_english());

        //add Listeners
        buttonShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonShowAnswer.setVisibility(View.GONE);
                buttonCorrectAnswer.setVisibility(View.VISIBLE);
                buttonWrongAnswer.setVisibility(View.VISIBLE);
                scrollViewDiagnosisFacts.setVisibility(View.VISIBLE);
                textViewAnswer.setVisibility(View.VISIBLE);
                if(isLanguageEnglish) {
                    textViewAnswer.setText(dias2.get(counter).getDiagnosis_name_english());
                }else if(isLanguageGerman){
                    textViewAnswer.setText(dias2.get(counter).getDiagnosis_name_german());
                }
                textViewDiagnosisFacts.setText("");


                String[] facts = {""};
                if(isLanguageEnglish) {
                    facts = dias2.get(counter).getFacts_splitted_en();
                }else if(isLanguageGerman){
                    facts = dias2.get(counter).getFacts_splitted_de();
                }
                for (String fact : facts) {
                    String facts_text_temp = textViewDiagnosisFacts.getText() + "♦ " + fact + "\n\n";
                    textViewDiagnosisFacts.setText(facts_text_temp);
                }
            }
        });

        buttonCorrectAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                buttonShowAnswer.setVisibility(View.VISIBLE);
                buttonCorrectAnswer.setVisibility(View.GONE);
                buttonWrongAnswer.setVisibility(View.GONE);
                scrollViewDiagnosisFacts.setVisibility(View.GONE);
                textViewAnswer.setVisibility(View.GONE);

                Context context = imageViewDiagnosisImage.getContext();
                int id = context.getResources().getIdentifier(dias2.get(counter).getImage_path(), "drawable", context.getPackageName());
                imageViewDiagnosisImage.setImageResource(id);
            }
        });

        buttonWrongAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                buttonShowAnswer.setVisibility(View.VISIBLE);
                buttonCorrectAnswer.setVisibility(View.GONE);
                buttonWrongAnswer.setVisibility(View.GONE);
                scrollViewDiagnosisFacts.setVisibility(View.GONE);
                textViewAnswer.setVisibility(View.GONE);

                Context context = imageViewDiagnosisImage.getContext();
                int id = context.getResources().getIdentifier(dias2.get(counter).getImage_path(), "drawable", context.getPackageName());
                imageViewDiagnosisImage.setImageResource(id);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.citation_info:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                LinearLayout layout = new LinearLayout(this);
                LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setLayoutParams(parms);

                layout.setGravity(Gravity.CLIP_VERTICAL);
                layout.setPadding(10, 2, 10, 2);

                TextView tv = new TextView(this);
                tv.setText(R.string.author_of_this_file);
                tv.setPadding(40, 40, 40, 40);
                tv.setGravity(Gravity.CENTER);
                TextView tv1 = new TextView(this);
                tv1.setText(Html.fromHtml(dias2.get(counter).getCitation_en()));
                tv1.setMovementMethod(LinkMovementMethod.getInstance());

                LinearLayout.LayoutParams tv1Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                tv1Params.bottomMargin = 5;
                tv1Params.leftMargin = 20;
                tv1Params.rightMargin = 20;
                tv1Params.bottomMargin = 10;
                layout.addView(tv1, tv1Params);

                alertDialogBuilder.setView(layout);
                alertDialogBuilder.setTitle("Title");
                alertDialogBuilder.setCustomTitle(tv);
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();

                try {
                    alertDialog.show();
                } catch (Exception e) {
                    // WindowManager$BadTokenException will be caught and the app would
                    // not display the 'Force Close' message
                    e.printStackTrace();
                }

                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    public ArrayList<Integer> getUniqueRandomNumbers() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 6; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);

        return list;

    }
}





