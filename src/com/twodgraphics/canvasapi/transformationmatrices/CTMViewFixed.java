package com.twodgraphics.canvasapi.transformationmatrices;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.27.14.
 */
public class CTMViewFixed extends View {

    private int minX = 0;
    private int maxX = 19;
    private int minY = 1510;
    private int maxY = 1580;

    Matrix matrix;
    private Paint paint;
    private RectF rect;

    public CTMViewFixed(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);

        matrix = new Matrix();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        matrix.reset();

        // Transform 1
        matrix.postTranslate(0, -minY);

        // Transform 2
        float scaleX = (float)w / (maxX - minX);
        float scaleY = (float)h / (maxY - minY);
        matrix.postScale(scaleX, -scaleY);

        // Tansform 3
        matrix.postTranslate(0, h);

        // convert coordinates
        rect = new RectF(5, 1520, 14, 1570);
        matrix.mapRect(rect);

        // set line width
        paint.setStrokeWidth(h * 0.05f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(rect, paint);
    }
}
