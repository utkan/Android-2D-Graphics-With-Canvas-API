package com.twodgraphics.canvasapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.twodgraphics.canvasapi.text.*;

/**
 * Created by utkan on 3.29.14.
 */
public class GraphicsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        MyView view = new MyView(this);

        setContentView(view);
        */

        /*
        LineView lineView = new LineView(this);
        setContentView(lineView);
        */

        /*
        PathView pathView = new PathView(this);
        setContentView(pathView);
        */

        /*
        TriangleView triangleView = new TriangleView(this);
        setContentView(triangleView);
        */

        /*
        TriangleViewFill triangleViewFill = new TriangleViewFill(this);
        setContentView(triangleViewFill);
        */

        /*
        DashedLineView dashedLineView = new DashedLineView(this);
        setContentView(dashedLineView);
        */

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        /*
        MyTextView myTextView = new MyTextView(this);
        this.setContentView(myTextView);
        */

        /*
        CustomFontView customFontView = new CustomFontView(this);
        setContentView(customFontView);
        */

        /*
        TextViewAlign textViewAlign = new TextViewAlign(this);
        setContentView(textViewAlign);
        */

        /*
        TextViewBaseline textViewBaseline = new TextViewBaseline(this);
        setContentView(textViewBaseline);
        */

        /*
        TextViewAlignCenter textViewAlignCenter = new TextViewAlignCenter(this);
        setContentView(textViewAlignCenter);
        */

        /*
        TextViewAlignTop textViewAlignTop = new TextViewAlignTop(this);
        setContentView(textViewAlignTop);
        */

        TextViewShadow textViewShadow = new TextViewShadow(this);
        setContentView(textViewShadow);
    }
}
