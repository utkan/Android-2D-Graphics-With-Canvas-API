package com.twodgraphics.canvasapi.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by utkan on 4.10.14.
 */
public class TextViewAlign extends View {

    private Paint paint;

    private int width;
    private int height;

    public TextViewAlign(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(90);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = width / 2;
        int y = 120;

        canvas.drawLine(x, 0, x, height, paint);

        Rect rect = new Rect();
        String str = "Left";
        paint.getTextBounds(str, 0, str.length(), rect);

        paint.setTextAlign(Paint.Align.LEFT);
        /*
            x - rect.left remove extra space adjust x
            x - offset : to center the text
            x - rect.right : to right align
         */
        float offset = (rect.left + rect.right) / 2.0f;
        canvas.drawText("Left", x, y, paint);
        // canvas.drawText("Left", x - rect.left, y, paint);
        // canvas.drawText("Left", x - offset, y, paint);
        // canvas.drawText("Left", x - rect.right, y, paint);

        y += 120;

        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Center", x, y, paint);

        y += 120;

        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("Right", x, y, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }
}
