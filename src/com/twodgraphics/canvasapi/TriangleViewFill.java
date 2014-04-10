package com.twodgraphics.canvasapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by utkan on 4.6.14.
 */
public class TriangleViewFill extends View{

    private Paint paint;
    private Path path;

    public TriangleViewFill(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        paint.setStrokeWidth(Math.min(w, h) * 0.1f);

        path = new Path();
        path.moveTo(w * 0.5f, h * 0.2f);
        path.lineTo(w * 0.8f, h * 0.8f);
        path.lineTo(w * 0.2f, h * 0.8f);

        path.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(255, 153, 0));

        canvas.drawPath(path, paint);

        // Stroke
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.rgb(204, 0, 0));

        canvas.drawPath(path, paint);
    }
}
