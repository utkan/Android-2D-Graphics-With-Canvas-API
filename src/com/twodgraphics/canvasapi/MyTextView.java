package com.twodgraphics.canvasapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by utkan on 4.10.14.
 */
public class MyTextView extends View {

    private Paint paint;

    public MyTextView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setTextSize(70);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = 20;
        int y = 90;

        paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText("Default", x, y, paint);

        y += 90;

        paint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText("Default Bold", x, y, paint);

        y += 90;

        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("Sans Serif", x, y, paint);

        y += 90;

        paint.setTypeface(Typeface.SERIF);
        canvas.drawText("Serif", x, y, paint);

        y += 90;

        paint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("Monospace", x, y, paint);

        y += 90;

        Typeface font = Typeface.create("serif", Typeface.BOLD);
        paint.setTypeface(font);
        canvas.drawText("Serif Bold", x, y, paint);

        y += 90;

        font = Typeface.create("serif", Typeface.ITALIC);
        paint.setTypeface(font);
        canvas.drawText("Serif Italic", x, y, paint);
    }
}
