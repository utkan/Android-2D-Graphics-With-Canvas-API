package com.twodgraphics.canvasapi.coordinatetransformation;

/**
 * Created by utkan on 4.23.14.
 */
public class Transform {

    private float moveX;
    private float moveY;

    private float scaleX;
    private float scaleY;

    public Transform() {
        setMove(0, 0);
        setScale(1, 1);
    }

    public void setMove(float x, float y) {
        moveX = x;
        moveY = y;
    }

    public void setScale(float x, float y) {
        scaleX = x;
        scaleY = y;
    }

    public float transformX(float x) {
        return moveX + scaleX * x;
    }

    public float transformY(float y) {
        return moveY + scaleY * y;
    }
}
