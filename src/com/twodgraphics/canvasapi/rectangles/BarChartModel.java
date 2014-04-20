package com.twodgraphics.canvasapi.rectangles;

/**
 * Created by utkan on 4.20.14.
 */
public class BarChartModel {

    private String labels[] = { "2010", "2011", "2012" };
    private float values[] = { 6335, 4236, 7654 };
    private float maxValue;

    public BarChartModel() {
        // Calculate the max value
        maxValue = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }
    }

    public int size() {
        return values.length;
    }

    public String getLabel(int index) {
        return labels[index];
    }

    public float getValue(int index) {
        return values[index];
    }

    public float maxValue() {
        return maxValue;
    }
}
