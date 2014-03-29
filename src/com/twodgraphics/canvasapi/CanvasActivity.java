package com.twodgraphics.canvasapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class CanvasActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        MyView myView = new MyView(this);

        LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        addContentView(myView, lllp);
    }
}