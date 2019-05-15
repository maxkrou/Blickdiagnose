package de.maxkrause.blickdiagnose.blickdiagnose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ShowResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);


        Circle circle = (Circle) findViewById(R.id.circle);

        CircleAngleAnimation animation = new CircleAngleAnimation(circle, 360);
        animation.setDuration(1500);
        circle.startAnimation(animation);


    }
}
