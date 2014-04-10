package com.twodgraphics.canvasapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by utkan on 4.3.14.
 */
public class LineView extends View {

    private Paint paint;
    private int width;
    private int height;

    public LineView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);

        paint.setStrokeCap(Paint.Cap.ROUND);
        // paint.setStrokeCap(Paint.Cap.BUTT);
        // paint.setStrokeCap(Paint.Cap.SQUARE);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvas.drawLine(width * 0.2f, height * 0.2f,
                        width * 0.8f, height * 0.8f, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;
        paint.setStrokeWidth(Math.min(w, h) * 0.1f);
    }
}
