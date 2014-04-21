package com.twodgraphics.canvasapi.gradients;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.21.14.
 */
public class RadialGradientView extends View {

    private int color1 = 0xff00FF00;
    private int color2 = 0xff005500;

    private int width, height;
    private RadialGradient gradient;
    private Paint paint;

    public RadialGradientView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, width, height, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;

        float centerX = width / 2.0f;
        float centerY = height / 2.0f;
        float radius = Math.min(width, height) / 2.0f;

        gradient = new RadialGradient(centerX, centerY, radius, color1, color2, Shader.TileMode.CLAMP);
        paint.setShader(gradient);
    }
}
