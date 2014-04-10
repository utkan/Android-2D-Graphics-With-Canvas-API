package com.twodgraphics.canvasapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by utkan on 4.3.14.
 */
public class PathView extends View{

    private Paint paint;
    private Path path;

    public PathView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        paint.setStrokeWidth(Math.min(w, h) * 0.1f);

        path = new Path();
        path.moveTo(w * 0.2f, h * 0.2f);
        path.lineTo(w * 0.8f, h * 0.8f);

    }
}
