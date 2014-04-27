package com.twodgraphics.canvasapi.coordinatetransformation;

/**
 * Created by utkan on 4.25.14.
 */
public class ChartModel {
    private float prices[] = {
            1518.20f, 1525.20f, 1539.79f, 1541.46f, 1544.26f,
            1551.18f, 1556.22f, 1552.48f, 1554.52f, 1563.23f,
            1560.70f, 1552.10f, 1548.34f, 1558.71f, 1545.80f,
            1556.89f, 1551.69f, 1563.77f, 1562.85f, 1559.19f
    };

    private float minPrice = 1510;
    private float maxPrice = 1580;

    public ChartModel() {
    }

    public float getMinPrice() {
        return minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public int getNumberOfDays() {
        return prices.length;
    }

    public int getMinDay() {
        return 0;
    }

    public int getMaxDay() {
        return prices.length -1;
    }

    public float getPrice(int index) {
        return prices[index];
    }
}
