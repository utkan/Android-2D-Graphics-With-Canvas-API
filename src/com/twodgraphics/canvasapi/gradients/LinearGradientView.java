package com.twodgraphics.canvasapi.gradients;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.21.14.
 */
public class LinearGradientView extends View {

    private int color1 = 0xff00FF00;
    private int color2 = 0xff005500;

    private int width, height;
    private LinearGradient gradient;
    private Paint paint;

    public LinearGradientView(Context context) {
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

        // gradient = new LinearGradient(0, 0, 0, height, color1, color2, Shader.TileMode.CLAMP);
        // Horizontal , left to right
        // gradient = new LinearGradient(0, 0, width, 0, color1, color2, Shader.TileMode.CLAMP);

        // Diagonal
        // gradient = new LinearGradient(0, 0, width, height, color1, color2, Shader.TileMode.CLAMP);

        // CLAMP Mode
        // gradient = new LinearGradient(0, 0, 0, height / 2, color1, color2, Shader.TileMode.CLAMP);

        // REPEAT Mode
        gradient = new LinearGradient(0, 0, 0, height / 3, color1, color2, Shader.TileMode.REPEAT);
        paint.setShader(gradient);
    }
}
