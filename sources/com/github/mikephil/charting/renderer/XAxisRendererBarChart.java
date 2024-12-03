package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class XAxisRendererBarChart extends XAxisRenderer {
    protected BarChart mChart;

    public XAxisRendererBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer, BarChart barChart) {
        super(viewPortHandler, xAxis, transformer);
        this.mChart = barChart;
    }

    /* access modifiers changed from: protected */
    public void drawLabels(Canvas canvas, float f10, PointF pointF) {
        float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
        float[] fArr = {0.0f, 0.0f};
        BarData barData = (BarData) this.mChart.getData();
        int dataSetCount = barData.getDataSetCount();
        for (int i10 = this.mMinX; i10 <= this.mMaxX; i10 += this.mXAxis.mAxisLabelModulus) {
            float groupSpace = ((float) (i10 * dataSetCount)) + (((float) i10) * barData.getGroupSpace()) + (barData.getGroupSpace() / 2.0f);
            fArr[0] = groupSpace;
            if (dataSetCount > 1) {
                fArr[0] = groupSpace + ((((float) dataSetCount) - 1.0f) / 2.0f);
            }
            this.mTrans.pointValuesToPixel(fArr);
            if (this.mViewPortHandler.isInBoundsX(fArr[0]) && i10 >= 0 && i10 < this.mXAxis.getValues().size()) {
                String str = this.mXAxis.getValues().get(i10);
                if (this.mXAxis.isAvoidFirstLastClippingEnabled()) {
                    if (i10 == this.mXAxis.getValues().size() - 1) {
                        float calcTextWidth = ((float) Utils.calcTextWidth(this.mAxisLabelPaint, str)) / 2.0f;
                        if (fArr[0] + calcTextWidth > this.mViewPortHandler.contentRight()) {
                            fArr[0] = this.mViewPortHandler.contentRight() - calcTextWidth;
                        }
                    } else if (i10 == 0) {
                        float calcTextWidth2 = ((float) Utils.calcTextWidth(this.mAxisLabelPaint, str)) / 2.0f;
                        if (fArr[0] - calcTextWidth2 < this.mViewPortHandler.contentLeft()) {
                            fArr[0] = this.mViewPortHandler.contentLeft() + calcTextWidth2;
                        }
                    }
                }
                drawLabel(canvas, str, i10, fArr[0], f10, pointF, labelRotationAngle);
            }
        }
    }

    public void renderGridLines(Canvas canvas) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            float[] fArr = {0.0f, 0.0f};
            this.mGridPaint.setColor(this.mXAxis.getGridColor());
            this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
            BarData barData = (BarData) this.mChart.getData();
            int dataSetCount = barData.getDataSetCount();
            int i10 = this.mMinX;
            while (i10 < this.mMaxX) {
                fArr[0] = (((float) (i10 * dataSetCount)) + (((float) i10) * barData.getGroupSpace())) - 0.5f;
                this.mTrans.pointValuesToPixel(fArr);
                if (this.mViewPortHandler.isInBoundsX(fArr[0])) {
                    canvas.drawLine(fArr[0], this.mViewPortHandler.offsetTop(), fArr[0], this.mViewPortHandler.contentBottom(), this.mGridPaint);
                }
                i10 += this.mXAxis.mAxisLabelModulus;
            }
        }
    }
}
