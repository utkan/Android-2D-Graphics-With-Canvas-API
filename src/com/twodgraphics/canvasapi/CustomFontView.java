package com.twodgraphics.canvasapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by utkan on 4.10.14.
 */
public class CustomFontView extends View {

    private Paint paint;
    private Typeface font1, font2, font3;

    public CustomFontView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setTextSize(90);

        font1 = Typeface.createFromAsset(context.getAssets(), "EuphoriaScript-Regular.otf");
        font2 = Typeface.createFromAsset(context.getAssets(), "Pacifico.ttf");
        font3 = Typeface.createFromAsset(context.getAssets(), "Chantelli_Antiqua.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = 15;
        int y = 100;

        paint.setTypeface(font1);
        canvas.drawText("Euphoria Script", x, y, paint);

        y += 150;

        paint.setTypeface(font2);
        canvas.drawText("Pacifico", x, y, paint);

        y += 150;

        paint.setTypeface(font3);
        canvas.drawText("Chantelli", x, y, paint);

    }
}
