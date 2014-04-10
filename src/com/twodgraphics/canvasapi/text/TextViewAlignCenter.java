package com.twodgraphics.canvasapi.text;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.11.14.
 */
public class TextViewAlignCenter extends View {

    private static final int FONT_SIZE = 100;

    private Paint paint;

    private int width;
    private int height;

    public TextViewAlignCenter(Context context) {
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

        center1(canvas, "Python", 100);
        center2(canvas, "Python", 300);
    }

    private  void center1(Canvas canvas, String str, int y) {

        int x = width / 2;

        float offset = (paint.ascent() + paint.descent()) / 2;
        canvas.drawText(str, x, y- offset, paint);

        float topY = y - FONT_SIZE / 2.0f;
        float bottomY = y + FONT_SIZE / 2.0f;

        paint.setColor(Color.RED);
        canvas.drawLine(0, y, width, y, paint);
        paint.setColor(Color.BLUE);
        canvas.drawLine(0, topY, width, topY, paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawLine(0, bottomY, width, bottomY, paint);
    }

    private void center2(Canvas canvas, String str, int y) {

        int x = width / 2;

        Rect bounds = new Rect();
        paint.getTextBounds(str, 0, str.length(), bounds);

        float offset = bounds.exactCenterY();
        canvas.drawText(str, x, y- offset, paint);

        float topY = y - FONT_SIZE / 2.0f;
        float bottomY = y + FONT_SIZE / 2.0f;

        paint.setColor(Color.RED);
        canvas.drawLine(0, y, width, y, paint);
        paint.setColor(Color.BLUE);
        canvas.drawLine(0, topY, width, topY, paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawLine(0, bottomY, width, bottomY, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;
    }
}
