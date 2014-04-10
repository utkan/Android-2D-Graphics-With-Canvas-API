package com.twodgraphics.canvasapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.View;

/**
 * Created by utkan on 4.6.14.
 */
public class TriangleView extends View {

    private Paint paint;
    private Path path;

    public TriangleView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        // paint.setStrokeJoin(Paint.Join.MITER);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        paint.setStrokeWidth(Math.min(w, h) * 0.1f);

        path = new Path();
        path.moveTo(w * 0.5f, h * 0.2f);
        path.lineTo(w * 0.8f, h * 0.8f);
        path.lineTo(w * 0.2f, h * 0.8f);

        Log.i(this.getClass().getSimpleName(), (w * 0.5f) + ", " + (h * 0.2f));
        Log.i(this.getClass().getSimpleName(), (w * 0.8f) + ", " + (h * 0.8f));
        Log.i(this.getClass().getSimpleName(), (w * 0.2f) + ", " + (h * 0.8f));

        path.lineTo(w * 0.5f, h * 0.2f);
        //path.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }
}
