package com.twodgraphics.canvasapi.Circles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by utkan on 4.20.14.
 */
public class CircleView extends View{

    private int centerX;
    private int centerY;
    private float radius;

    private Paint paint;

    public CircleView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xff000099);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2;
        centerY = h / 2;
        radius = Math.min(w, h) * 0.7f / 2;
        paint.setStrokeWidth(radius * 0.3f);
    }
}
