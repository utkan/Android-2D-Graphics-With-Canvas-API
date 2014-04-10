package com.twodgraphics.canvasapi.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by utkan on 4.11.14.
 */
public class TextViewShadow extends View {

    private Paint paint;

    private int width;
    private int height;

    public TextViewShadow(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setTextSize(100);
        paint.setTextAlign(Paint.Align.CENTER);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = width / 2;
        int y = 120;

        paint.setShadowLayer(10, 5, -5, Color.GRAY);
        canvas.drawText("Shadow", x, y, paint);

        y += 140;


        paint.setShadowLayer(16, 10, 10, Color.GRAY);
        canvas.drawText("Shadow", x, y, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;
    }
}
