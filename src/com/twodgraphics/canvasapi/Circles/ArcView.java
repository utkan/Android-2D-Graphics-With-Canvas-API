package com.twodgraphics.canvasapi.circles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by utkan on 4.20.14.
 */
public class ArcView extends View {

    private int centerX;
    private int centerY;
    private float radius;
    private RectF rect;

    private Paint paint;

    public ArcView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        rect = new RectF();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2;
        centerY = h / 2;
        radius = Math.min(w, h) * 0.7f / 2;

        paint.setStrokeWidth(radius * 0.3f);

        rect.left = centerX - radius;
        rect.right = centerX + radius;
        rect.top = centerY - radius;
        rect.bottom = centerY + radius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.LTGRAY);
        canvas.drawOval(rect, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(0xff000099);
        canvas.drawArc(rect, 0, 90, false, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(0xff339933);
        canvas.drawArc(rect, 180, 90, true, paint);
    }
}
