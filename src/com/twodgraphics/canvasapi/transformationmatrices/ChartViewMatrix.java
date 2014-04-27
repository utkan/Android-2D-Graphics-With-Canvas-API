package com.twodgraphics.canvasapi.transformationmatrices;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.27.14.
 */
public class ChartViewMatrix extends View {

    private Matrix matrix;
    private ChartModel chartModel;

    private Paint paint;
    private Path path;

    public ChartViewMatrix(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        matrix = new Matrix();
        chartModel = new ChartModel();
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

        matrix.postTranslate(0, -chartModel.getMinPrice());

        float scaleX = (float)w / (chartModel.getMaxDay() - chartModel.getMinDay());
        float scaleY = (float)h / (chartModel.getMaxPrice() - chartModel.getMinPrice());
        matrix.postScale(scaleX, -scaleY);

        matrix.postTranslate(0, h);

        // Create Path
        path = new Path();
        path.moveTo(0, chartModel.getPrice(0));

        for (int i = 1; i < chartModel.getNumberOfDays(); i++) {
            path.lineTo(i, chartModel.getPrice(i));
        }

        // Convert coordinates
        path.transform(matrix);
    }
}
