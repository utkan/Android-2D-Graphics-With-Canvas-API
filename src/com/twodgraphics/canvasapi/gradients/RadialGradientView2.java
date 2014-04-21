package com.twodgraphics.canvasapi.gradients;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.21.14.
 */
public class RadialGradientView2 extends View {

    private int color1 = 0xff00FF00;
    private int color2 = 0xff005500;

    private float centerX, centerY, radius;

    private RadialGradient gradient;
    private Paint paint;

    public RadialGradientView2(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2.0f;
        centerY = h / 2.0f;

        radius = Math.min(w, h) / 3.0f;

        gradient = new RadialGradient(
                centerX - radius * 0.3f,
                centerY - radius * 0.3f,
                radius * 1.3f,
                color1,
                color2,
                Shader.TileMode.CLAMP);
        paint.setShader(gradient);

        /*
        radius = Math.min(w, h) / 20.0f;
        gradient = new RadialGradient(centerX, centerY, radius, color1, color2, Shader.TileMode.REPEAT);
        paint.setShader(gradient);
        */
    }
}
