package com.twodgraphics.canvasapi.rectangles;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by utkan on 4.20.14.
 */
public class BarChartView extends View {

    private Paint barPaint;
    private Paint titleTextPaint;
    private Paint labelTextPaint;

    float totalWidth;

    float barWidth;
    float barPading;

    float labelPading;

    float titleY;
    float labelY;
    float plotAreaBottomY;
    float plotAreaHeight;

    private BarChartModel model;
    private RectF bar;

    public BarChartView(Context context) {
        super(context);

        setBackgroundColor(Color.WHITE);

        barPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        barPaint.setColor(Color.BLUE);
        barPaint.setStyle(Paint.Style.FILL);

        titleTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        titleTextPaint.setColor(Color.BLACK);;
        titleTextPaint.setTextAlign(Paint.Align.CENTER);
        titleTextPaint.setTypeface(Typeface.DEFAULT_BOLD);

        labelTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        labelTextPaint.setColor(Color.BLACK);
        labelTextPaint.setTextAlign(Paint.Align.CENTER);

        model = new BarChartModel();

        bar = new RectF();
    }

    public float getBarLeftX(int barIndex) {
        return barPading * (barIndex + 1) + barWidth * barIndex;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // Title
        canvas.drawText("Annual Sales", totalWidth / 2, titleY, titleTextPaint);


        // Horizontal line below bars
        canvas.drawLine(0, plotAreaBottomY, totalWidth, plotAreaBottomY, labelTextPaint);


        // Bars
        int i = 0;
        for (i = 0; i < model.size(); i++) {

            // Bar coordinates
            float leftX = getBarLeftX(i);
            float rightX = leftX + barWidth;
            float topY = plotAreaBottomY - plotAreaHeight * model.getValue(i) / model.maxValue();

            // Bar
            bar.left = leftX;
            bar.right = rightX;
            bar.top = topY;
            bar.bottom = plotAreaBottomY;

            canvas.drawRect(bar, barPaint);

            // Label
            float labelX = (leftX + rightX) / 2;
            canvas.drawText(model.getLabel(i), labelX, labelY, labelTextPaint);

            // Value Text
            String valueText = String.format("%.0f", model.getValue(i));
            canvas.drawText(valueText, labelX, topY - labelPading, labelTextPaint);
        }

        // super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        totalWidth = w;

        float viewPading = h * 0.03f;
        float titlePading = h * 0.05f;
        labelPading = h * 0.01f;

        barPading = w * 0.01f;

        float titleTextSize = h * 0.07f;
        float labelTextSize = h * 0.04f;

        titleY = viewPading + titleTextSize;
        labelY = h - viewPading;

        float plotAreaTopY = viewPading + titleTextSize + titlePading + labelTextSize + labelPading;
        plotAreaBottomY = h - viewPading - labelTextSize - labelPading;
        plotAreaHeight = plotAreaBottomY - plotAreaTopY;

        // Bar width
        int numBars = model.size();
        barWidth = (totalWidth - (numBars + 1) * barPading) / numBars;

        // Font Sizes
        titleTextPaint.setTextSize(titleTextSize);
        labelTextPaint.setTextSize(labelTextSize);
    }
}
