package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        Circle circle_green = (Circle) findViewById(R.id.circle_green);
        Circle circle_red = (Circle) findViewById(R.id.circle_red);


        Intent intent = getIntent();

        int correctAnswers = intent.getIntExtra("correctAnswers", 0);
        int maxAnswers = intent.getIntExtra("maxAnswers", 0);



        int angle_green = (360/maxAnswers)*correctAnswers;
        int angle_red = 360-angle_green;

        int result_percentage = (correctAnswers*100)/(maxAnswers);


        circle_green.setResult(result_percentage);
        circle_red.setResult(result_percentage);

        circle_red.setStartAnglePoint(270+angle_green);
        circle_red.setColorRed();


        CircleAngleAnimation animation_green = new CircleAngleAnimation(circle_green, angle_green);
        animation_green.setDuration(1500);
        circle_green.startAnimation(animation_green);

        CircleAngleAnimation animation_red = new CircleAngleAnimation(circle_red, angle_red);
        animation_red.setDuration(1500);
        circle_red.startAnimation(animation_red);



        TextView textview = findViewById(R.id.textView);
        textview.setText("correct answers: "+ correctAnswers + " max. Answers: "+ maxAnswers + " Result percentage: "+result_percentage);






    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(this,MainActivity.class));
        this.finish();
    }
}
