package com.twodgraphics.canvasapi;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by utkan on 3.29.14.
 */
public class GraphicsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView view = new MyView(this);

        setContentView(view);
    }
}
