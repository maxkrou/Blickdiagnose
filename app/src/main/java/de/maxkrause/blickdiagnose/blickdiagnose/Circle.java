package de.maxkrause.blickdiagnose.blickdiagnose;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Circle extends View {

    //Start of the circle animation. 270 is top, 90 is bottom.
    private static final int START_ANGLE_POINT = 270;

    private final Paint paint;
    private final RectF rect;

    private float angle;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        final int strokeWidth = 90;

        paint = new Paint();
        paint.setAntiAlias(true);

        //ring style circle
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        //Circle color
        paint.setColor(Color.RED);

        //size 400x400
        rect = new RectF(strokeWidth, strokeWidth, 400 + strokeWidth, 400 + strokeWidth);

        //Initial Angle (optional, it can be zero)
        angle = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}