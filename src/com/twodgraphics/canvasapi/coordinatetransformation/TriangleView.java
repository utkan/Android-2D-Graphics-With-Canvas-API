package com.twodgraphics.canvasapi.coordinatetransformation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.View;

/**
 * Created by utkan on 4.23.14.
 */
public class TriangleView extends View {

    private Transform transform;
    private Path path;
    private Paint paint;

    public TriangleView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        transform = new Transform();

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(25);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Init transform

        // Landscape mode
        if (w > h) {
            transform.setScale(h, -h);
            // transform.setMove(0, h);

            // if you want to center triangle
            transform.setMove((w - h) / 2, h);
        } else {
            transform.setScale(w, -w);
            // transform.setMove(0, h);

            // if you want to center triangle
            transform.setMove(0, h - (h - w) / 2);
        }

        // convert coordinates
        float Ax = transform.transformX(0.2f);
        float Ay = transform.transformY(0.2f);


        float Bx = transform.transformX(0.8f);
        float By = transform.transformY(0.8f);

        float Cx = transform.transformX(0.8f);
        float Cy = transform.transformY(0.2f);

        Log.i(this.getClass().getSimpleName(), "Ax: " + Ax + ", Ay: " + Ay);
        Log.i(this.getClass().getSimpleName(), "Bx: " + Bx + ", By: " + By);
        Log.i(this.getClass().getSimpleName(), "Cx: " + Cx + ", Cy: " + Cy);
        // create path
        path = new Path();

        path.moveTo(Ax, Ay);
        path.lineTo(Bx, By);
        path.lineTo(Cx, Cy);

        path.close();
    }
}
