package com.twodgraphics.canvasapi.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by utkan on 4.10.14.
 */
public class TextViewBaseline extends View {

    private Paint paint;

    private int width;
    private int height;

    public TextViewBaseline(Context context) {

        super(context);
        setBackgroundColor(Color.WHITE);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(100);
        ;
        paint.setTypeface(Typeface.SERIF);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = width / 2;
        int y = 150;

        float ascent = paint.ascent();
        float descent = paint.descent();

        canvas.drawLine(0, y, width, y, paint);

        paint.setColor(Color.RED);
        canvas.drawLine(0, y + ascent, width, y + ascent, paint);

        paint.setColor(Color.GREEN);
        canvas.drawLine(0, y + descent, width, y + descent, paint);

        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Python", x, y, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }
}
