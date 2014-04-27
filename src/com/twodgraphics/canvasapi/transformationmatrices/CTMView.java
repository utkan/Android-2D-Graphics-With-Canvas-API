package com.twodgraphics.canvasapi.transformationmatrices;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by utkan on 4.27.14.
 */
public class CTMView extends View {

    private int minX = 0;
    private int maxX = 19;
    private int minY = 1510;
    private int maxY = 1580;

    private Paint paint;
    private RectF rect;

    private int deviceHeight;
    private int deviceWidth;

    public CTMView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);

        rect = new RectF(5, 1520, 14, 1570);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        deviceWidth = w;
        deviceHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Transform 3
        canvas.translate(0, deviceHeight);

        // Transform 2
        float scaleX = (float)deviceWidth / (maxX - minX);
        float scaleY = (float)deviceHeight / (maxY - minY);
        canvas.scale(scaleX, -scaleY);

        // Transform 1
        canvas.translate(0, -minY);

        // draw
        canvas.drawRect(rect, paint);
    }
}
