package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class XAxisRendererRadarChart extends XAxisRenderer {
    private RadarChart mChart;

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, (Transformer) null);
        this.mChart = radarChart;
    }

    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
            PointF pointF = new PointF(0.5f, 0.0f);
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            float sliceAngle = this.mChart.getSliceAngle();
            float factor = this.mChart.getFactor();
            PointF centerOffsets = this.mChart.getCenterOffsets();
            int i10 = this.mXAxis.mAxisLabelModulus;
            for (int i11 = 0; i11 < this.mXAxis.getValues().size(); i11 += i10) {
                PointF position = Utils.getPosition(centerOffsets, (this.mChart.getYRange() * factor) + (((float) this.mXAxis.mLabelRotatedWidth) / 2.0f), ((((float) i11) * sliceAngle) + this.mChart.getRotationAngle()) % 360.0f);
                drawLabel(canvas, this.mXAxis.getValues().get(i11), i11, position.x, position.y - (((float) this.mXAxis.mLabelRotatedHeight) / 2.0f), pointF, labelRotationAngle);
            }
        }
    }

    public void renderLimitLines(Canvas canvas) {
    }
}
