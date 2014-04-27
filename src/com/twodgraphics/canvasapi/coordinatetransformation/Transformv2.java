package com.twodgraphics.canvasapi.coordinatetransformation;

/**
 * Created by utkan on 4.25.14.
 */
public class Transformv2 {

    private float moveBeforeScaleX;
    private float moveBeforeScaleY;

    private float moveAfterScaleX;
    private float moveAfterScaleY;

    private float scaleX;
    private float scaleY;

    public Transformv2() {
        setMoveBeforeScale(0, 0);
        setMoveAfterScale(0, 0);
        setScale(1, 1);
    }

    public void setMoveBeforeScale(float x, float y) {
        moveBeforeScaleX = x;
        moveBeforeScaleY = y;
    }

    public void setMoveAfterScale (float x, float y) {
        moveAfterScaleX = x;
        moveAfterScaleY = y;
    }

    public void setScale(float x, float y) {
        scaleX = x;
        scaleY = y;
    }

    public float transformX(float x) {
        return moveAfterScaleX + scaleX * (moveBeforeScaleX + x);
    }

    public float transformY(float y) {
        return moveAfterScaleY + scaleY * (moveBeforeScaleY + y);
    }
}
