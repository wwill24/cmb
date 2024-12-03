package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ZoomJob extends ViewPortJob {
    protected YAxis.AxisDependency axisDependency;
    protected float scaleX;
    protected float scaleY;

    public ZoomJob(ViewPortHandler viewPortHandler, float f10, float f11, float f12, float f13, Transformer transformer, YAxis.AxisDependency axisDependency2, View view) {
        super(viewPortHandler, f12, f13, transformer, view);
        this.scaleX = f10;
        this.scaleY = f11;
        this.axisDependency = axisDependency2;
    }

    public void run() {
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoom(this.scaleX, this.scaleY), this.view, false);
        float deltaY = ((BarLineChartBase) this.view).getDeltaY(this.axisDependency) / this.mViewPortHandler.getScaleY();
        float size = ((float) ((BarLineChartBase) this.view).getXAxis().getValues().size()) / this.mViewPortHandler.getScaleX();
        float[] fArr = this.pts;
        fArr[0] = this.xValue - (size / 2.0f);
        fArr[1] = this.yValue + (deltaY / 2.0f);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.refresh(this.mViewPortHandler.translate(this.pts), this.view, false);
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
    }
}
