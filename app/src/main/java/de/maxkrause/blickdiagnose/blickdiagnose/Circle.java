package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class Circle extends View {

    //Start of the circle animation. 270 is top, 90 is bottom.
    private int startAnglePoint = 270;

    private final Paint paint;
    private final RectF rect;
    private final Paint textPaint;

    private Context context;

    private int result_percentage;

    private float angle;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context=context;

        final int strokeWidth = 90;



        paint = new Paint();
        paint.setAntiAlias(true);

        //ring style circle
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        //Circle color
        paint.setColor(ContextCompat.getColor(context, R.color.colorAnswerButton));

        textPaint = new Paint();


        //size 400x400
        rect = new RectF(strokeWidth, strokeWidth, 400 + strokeWidth, 400 + strokeWidth);


        //Initial Angle (optional, it can be zero)
        angle = 0;
    }



    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        int height = canvas.getHeight() / 2;
        int width = canvas.getWidth() / 2;
        rect.set(width - 300, height - 300, width + 300, height + 300);
        canvas.drawArc(rect, startAnglePoint, angle, false, paint);



        textPaint.setARGB(200, 82, 147, 102);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(200);

        int xPos = (canvas.getWidth() / 2);
        int yPos = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)) ;
        //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.

        canvas.drawText(result_percentage+"%", xPos, yPos, textPaint);


    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setResult(int _result_percentage){
        result_percentage = _result_percentage;
    }

    public void setStartAnglePoint(int startAnglePoint){
        this.startAnglePoint=startAnglePoint;
    }

    public void setColorRed(){
        paint.setColor(ContextCompat.getColor(context, R.color.colorAccent));
    }
}