package com.twodgraphics.canvasapi;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.RadialGradient;
import android.os.Bundle;
import android.view.Window;
import com.twodgraphics.canvasapi.circles.CircularChart;
import com.twodgraphics.canvasapi.coordinatetransformation.ChartView;
import com.twodgraphics.canvasapi.gradients.LinearGradientView;
import com.twodgraphics.canvasapi.gradients.RadialGradientView;
import com.twodgraphics.canvasapi.gradients.RadialGradientView2;
import com.twodgraphics.canvasapi.gradients.SweepGradientView;
import com.twodgraphics.canvasapi.transformationmatrices.CTMView;
import com.twodgraphics.canvasapi.transformationmatrices.CTMViewFixed;
import com.twodgraphics.canvasapi.transformationmatrices.ChartViewMatrix;
import com.twodgraphics.canvasapi.transformationmatrices.TriangleViewMatrix;

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

        /*
        TextViewShadow textViewShadow = new TextViewShadow(this);
        setContentView(textViewShadow);
        */

        /*
        BarChartView barChartView = new BarChartView(this);
        setContentView(barChartView);
        */

        /*
        CircleView circleView = new CircleView(this);
        setContentView(circleView);
        */

        /*
        OvalView ovalView = new OvalView(this);
        setContentView(ovalView);
        */

        /*
        ArcView arcView = new ArcView(this);
        setContentView(arcView);
        */

        /*
        CircularChart circularChart = new CircularChart(this);
        setContentView(circularChart);
        */

        /*
        LinearGradientView linearGradientView = new LinearGradientView(this);
        setContentView(linearGradientView);
        */

        /*
        RadialGradientView radialGradientView = new RadialGradientView(this);
        setContentView(radialGradientView);
        */

        /*
        RadialGradientView2 radialGradientView2 = new RadialGradientView2(this);
        setContentView(radialGradientView2);
        */

        /*
        SweepGradientView sweepGradientView = new SweepGradientView(this);
        setContentView(sweepGradientView);
        */

        /*
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        com.twodgraphics.canvasapi.coordinatetransformation.
                TriangleView triangleView = new com.twodgraphics.canvasapi.coordinatetransformation.
                TriangleView(this);
        setContentView(triangleView);
        */

        /*
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        ChartView chartView = new ChartView(this);
        setContentView(chartView);
        */

        /*
        TriangleViewMatrix triangleViewMatrix = new TriangleViewMatrix(this);
        setContentView(triangleViewMatrix);
        */

        /*
        ChartViewMatrix chartViewMatrix = new ChartViewMatrix(this);
        setContentView(chartViewMatrix);
        */

        CTMViewFixed ctmView = new CTMViewFixed(this);
        setContentView(ctmView);
    }
}
