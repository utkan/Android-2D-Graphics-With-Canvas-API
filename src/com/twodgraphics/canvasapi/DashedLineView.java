package com.twodgraphics.canvasapi;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.6.14.
 */
public class DashedLineView extends View {

    private Paint paint;
    private Path path;

    public DashedLineView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        path = new Path();
        path.moveTo(50, 100);
        path.lineTo(w - 50, 100);

        // DashPathEffect effect = new DashPathEffect(new float[] {90, 30}, 0);
        // DashPathEffect effect = new DashPathEffect(new float[] {90, 30}, 60);

        paint.setStrokeCap(Paint.Cap.ROUND);
        DashPathEffect effect = new DashPathEffect(new float[] {1, 60}, 0);

        paint.setPathEffect(effect);
    }
}
