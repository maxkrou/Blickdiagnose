package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class DiagnoseActivity extends AppCompatActivity {

    ImageView imageViewDiagnosisImage;
    Button buttonShowAnswer;
    Button buttonCorrectAnswer;
    Button buttonWrongAnswer;
    TextView textViewDiagnosisFacts;
    TextView textViewWhatIsTheAnswer;
    TextView textViewAnswer;
    ScrollView scrollViewDiagnosisFacts;

    DatabaseDiagnosisEntry dia;
    ArrayList<DatabaseDiagnosisEntry> dias = new ArrayList<DatabaseDiagnosisEntry>();
    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.cont);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose);

        dias.add(databaseHelper.getDiagnosisEntry(1));



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




        //imageViewDiagnosisImage.setImageBitmap(BitmapFactory.decodeFile("drawable/hufeisenniere_ct_axial.jpg"));


      /*  File sd = Environment.getExternalStorageDirectory();
        File image = new File(sd+filePath, imageName);
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap,parent.getWidth(),parent.getHeight(),true);
        imageView.setImageBitmap(bitmap);*/


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
}
