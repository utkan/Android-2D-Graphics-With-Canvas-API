package com.twodgraphics.canvasapi.transformationmatrices;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.27.14.
 */
public class TriangleViewMatrix extends View {

    private Matrix matrix;
    private Path path;
    private Paint paint;

    public TriangleViewMatrix(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(25);

        matrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Init transformation matrix

        matrix.reset();

        if (w > h) {
            matrix.postScale(h, -h);
            matrix.postTranslate(0, h);
        } else {
            matrix.postScale(w, -w);
            matrix.postTranslate(0, h);
        }

        // Create path
        path = new Path();
        path.moveTo(0.2f, 0.2f);
        path.lineTo(0.8f, 0.8f);
        path.lineTo(0.8f, 0.2f);
        path.close();

        path.transform(matrix);
    }
}
