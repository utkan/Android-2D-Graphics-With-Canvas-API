package com.twodgraphics.canvasapi.gradients;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.22.14.
 */
public class SweepGradientView extends View{

    private int color1 = 0xff00FF00;
    private int color2 = 0xff005500;

    private SweepGradient gradient;
    private Paint paint;

    private float centerX;
    private float centerY;
    private float radius;

    public SweepGradientView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2.0f;
        centerY = h / 2.0f;
        radius = Math.min(w, h) * 0.7f / 2.0f;

        gradient = new SweepGradient(centerX, centerY, color1, color2);

        Matrix matrix = new Matrix();
        matrix.postTranslate(-centerX, -centerY);
        matrix.postRotate(-45);
        matrix.postTranslate(centerX, centerY);
        gradient.setLocalMatrix(matrix);

        paint.setShader(gradient);
        paint.setStrokeWidth(radius / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(centerX, centerY, radius, paint);
    }
}
