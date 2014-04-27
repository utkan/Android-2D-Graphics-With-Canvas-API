package com.twodgraphics.canvasapi.coordinatetransformation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by utkan on 4.25.14.
 */
public class ChartView extends View {

    private Transformv2 transform;
    private ChartModel chartModel;

    private Paint paint;
    private Path path;

    public ChartView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        transform = new Transformv2();
        chartModel = new ChartModel();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Init transform
        transform.setMoveBeforeScale(0, -chartModel.getMinPrice());

        float scaleX = (float)w / (chartModel.getMaxDay() - chartModel.getMinDay());
        float scaleY = (float)h / (chartModel.getMaxPrice() - chartModel.getMinPrice());

        transform.setScale(scaleX, -scaleY);

        transform.setMoveAfterScale(0, h);

        // create path
        path = new Path();

        float x = transform.transformX(0);
        float y = transform.transformY(chartModel.getPrice(0));

        path.moveTo(x, y);

        for (int i = 1; i < chartModel.getNumberOfDays(); i++) {
            x = transform.transformX(i);
            y = transform.transformY(chartModel.getPrice(i));

            path.lineTo(x, y);
        }
    }
}
