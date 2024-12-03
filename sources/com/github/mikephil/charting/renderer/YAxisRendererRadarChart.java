package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart mChart;

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, (Transformer) null);
        this.mChart = radarChart;
    }

    public void computeAxis(float f10, float f11) {
        computeAxisValues(f10, f11);
    }

    /* access modifiers changed from: protected */
    public void computeAxisValues(float f10, float f11) {
        double d10;
        float f12 = f10;
        float f13 = f11;
        int labelCount = this.mYAxis.getLabelCount();
        double abs = (double) Math.abs(f13 - f12);
        if (labelCount == 0 || abs <= 0.0d) {
            YAxis yAxis = this.mYAxis;
            yAxis.mEntries = new float[0];
            yAxis.mEntryCount = 0;
            return;
        }
        double roundToNextSignificant = (double) Utils.roundToNextSignificant(abs / ((double) labelCount));
        double pow = Math.pow(10.0d, (double) ((int) Math.log10(roundToNextSignificant)));
        if (((int) (roundToNextSignificant / pow)) > 5) {
            roundToNextSignificant = Math.floor(pow * 10.0d);
        }
        if (this.mYAxis.isForceLabelsEnabled()) {
            float f14 = ((float) abs) / ((float) (labelCount - 1));
            YAxis yAxis2 = this.mYAxis;
            yAxis2.mEntryCount = labelCount;
            if (yAxis2.mEntries.length < labelCount) {
                yAxis2.mEntries = new float[labelCount];
            }
            float f15 = f12;
            for (int i10 = 0; i10 < labelCount; i10++) {
                this.mYAxis.mEntries[i10] = f15;
                f15 += f14;
            }
        } else if (this.mYAxis.isShowOnlyMinMaxEnabled()) {
            YAxis yAxis3 = this.mYAxis;
            yAxis3.mEntryCount = 2;
            float[] fArr = new float[2];
            yAxis3.mEntries = fArr;
            fArr[0] = f12;
            fArr[1] = f13;
        } else {
            double d11 = ((double) f12) / roundToNextSignificant;
            if (d11 < 0.0d) {
                d10 = Math.floor(d11);
            } else {
                d10 = Math.ceil(d11);
            }
            double d12 = d10 * roundToNextSignificant;
            if (d12 == 0.0d) {
                d12 = 0.0d;
            }
            double nextUp = Utils.nextUp(Math.floor(((double) f13) / roundToNextSignificant) * roundToNextSignificant);
            int i11 = 0;
            for (double d13 = d12; d13 <= nextUp; d13 += roundToNextSignificant) {
                i11++;
            }
            if (Float.isNaN(this.mYAxis.getAxisMaxValue())) {
                i11++;
            }
            YAxis yAxis4 = this.mYAxis;
            yAxis4.mEntryCount = i11;
            if (yAxis4.mEntries.length < i11) {
                yAxis4.mEntries = new float[i11];
            }
            for (int i12 = 0; i12 < i11; i12++) {
                this.mYAxis.mEntries[i12] = (float) d12;
                d12 += roundToNextSignificant;
            }
        }
        if (roundToNextSignificant < 1.0d) {
            this.mYAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
        } else {
            this.mYAxis.mDecimals = 0;
        }
        YAxis yAxis5 = this.mYAxis;
        float[] fArr2 = yAxis5.mEntries;
        float f16 = fArr2[0];
        if (f16 < f12) {
            yAxis5.mAxisMinimum = f16;
        }
        float f17 = fArr2[yAxis5.mEntryCount - 1];
        yAxis5.mAxisMaximum = f17;
        yAxis5.mAxisRange = Math.abs(f17 - yAxis5.mAxisMinimum);
    }

    public void renderAxisLabels(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            PointF centerOffsets = this.mChart.getCenterOffsets();
            float factor = this.mChart.getFactor();
            int i10 = this.mYAxis.mEntryCount;
            int i11 = 0;
            while (i11 < i10) {
                if (i11 != i10 - 1 || this.mYAxis.isDrawTopYLabelEntryEnabled()) {
                    YAxis yAxis = this.mYAxis;
                    PointF position = Utils.getPosition(centerOffsets, (yAxis.mEntries[i11] - yAxis.mAxisMinimum) * factor, this.mChart.getRotationAngle());
                    canvas.drawText(this.mYAxis.getFormattedLabel(i11), position.x + 10.0f, position.y, this.mAxisLabelPaint);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines != null) {
            float sliceAngle = this.mChart.getSliceAngle();
            float factor = this.mChart.getFactor();
            PointF centerOffsets = this.mChart.getCenterOffsets();
            for (int i10 = 0; i10 < limitLines.size(); i10++) {
                LimitLine limitLine = limitLines.get(i10);
                if (limitLine.isEnabled()) {
                    this.mLimitLinePaint.setColor(limitLine.getLineColor());
                    this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                    this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                    float limit = (limitLine.getLimit() - this.mChart.getYChartMin()) * factor;
                    Path path = new Path();
                    for (int i11 = 0; i11 < ((RadarData) this.mChart.getData()).getXValCount(); i11++) {
                        PointF position = Utils.getPosition(centerOffsets, limit, (((float) i11) * sliceAngle) + this.mChart.getRotationAngle());
                        if (i11 == 0) {
                            path.moveTo(position.x, position.y);
                        } else {
                            path.lineTo(position.x, position.y);
                        }
                    }
                    path.close();
                    canvas.drawPath(path, this.mLimitLinePaint);
                }
            }
        }
    }
}
