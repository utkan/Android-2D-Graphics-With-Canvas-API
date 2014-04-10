package com.twodgraphics.canvasapi.text;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.11.14.
 */
public class TextViewAlignTop extends View {

    private static final int FONT_SIZE = 100;

    private Paint paint;

    private int width;
    private int height;

    public TextViewAlignTop(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(FONT_SIZE);
        paint.setTypeface(Typeface.SERIF);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        top1(canvas, "Python", 100);
        top2(canvas, "Python", 300);
    }

    private void top1(Canvas canvas, String str, int y) {

        int x = width / 2;

        canvas.drawText(str, x, y - paint.ascent(), paint);

        canvas.drawLine(0, y, width, y, paint);
    }

    private void top2(Canvas canvas, String str, int y) {

        int x = width / 2;

        Rect bounds = new Rect();
        paint.getTextBounds(str, 0, str.length(), bounds);

        canvas.drawText(str, x, y - bounds.top, paint);

        canvas.drawLine(0, y, width, y, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;
    }
}
