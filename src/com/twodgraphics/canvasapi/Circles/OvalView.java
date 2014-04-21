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
public class OvalView extends View {

    private Paint paint;
    private float padding;
    private RectF rect;

    public OvalView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);

        rect = new RectF();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        padding = Math.max(w, h) * 0.1f;

        rect.left = padding;
        rect.right = w - padding;
        rect.top = padding;
        rect.bottom = h - padding;



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth(padding);
        paint.setColor(Color.RED);

        canvas.drawOval(rect, paint);


        paint.setStrokeWidth(padding / 12);;
        paint.setColor(0xff000077);

        canvas.drawRect(rect, paint);
    }
}
