package com.twodgraphics.canvasapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by utkan on 3.29.14.
 */
public class MyView extends View {

    private int width;
    private int height;

    private Paint paint;

    private String str;
    float textSize;
    float x, y;

    public MyView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;

        textSize = Math.min(width, height) * 0.12f;
        paint.setTextSize(textSize);

        x = width * 0.5f;
        y = height * 0.5f;

        str = "w=" + width + ", h=" + height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        canvas.drawText(str, x, y, paint);

        canvas.drawLine(10, 10, 100, 100, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);

        Path path = new Path();
        path.moveTo(10, 10);
        path.lineTo(120, 100);
        path.close();
        canvas.drawPath(path, paint);
    }
}
