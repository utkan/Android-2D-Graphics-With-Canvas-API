package com.twodgraphics.canvasapi.Circles;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.20.14.
 */
public class CircularChart extends View {

    private float value;
    private String label;

    private int centerX;
    private int centerY;
    private float radius;
    private float textX;
    private float textY;

    private RectF arcOval;
    private Rect textBounds;

    private Paint paint;
    private Paint txtPaint;

    private int color1 = Color.LTGRAY;
    private int color2 = 0xff333377;

    public CircularChart(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);

        txtPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        txtPaint.setColor(color2);
        txtPaint.setTypeface(Typeface.DEFAULT_BOLD);

        arcOval = new RectF();
        textBounds = new Rect();

        // Set value
        value = 0.65f;
        label = String.format("%.0f%%", value * 100);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2;
        centerY = h / 2;

        radius = Math.min(w, h) * 0.7f / 2;

        txtPaint.setTextSize(radius * 0.6f);

        txtPaint.getTextBounds(label, 0, label.length(), textBounds);
        textX = centerX - (textBounds.left + textBounds.right) * 0.5f;
        textY = centerY - (textBounds.top + textBounds.bottom) * 0.5f;

        arcOval.left = centerX - radius;
        arcOval.right = centerX + radius;
        arcOval.top = centerY - radius;
        arcOval.bottom = centerY + radius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth( radius * 0.05f );
        paint.setColor(color1);
        canvas.drawCircle(centerX, centerY, radius, paint);

        paint.setColor(color2);
        paint.setStrokeWidth(radius * 0.4f);
        canvas.drawArc(arcOval, -90, value * 360, false, paint);

        canvas.drawText(label, textX, textY, txtPaint);
    }
}
