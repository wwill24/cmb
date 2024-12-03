package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import net.bytebuddy.jar.asm.Opcodes;

public class RadarChartRenderer extends LineRadarRenderer {
    protected RadarChart mChart;
    protected Paint mWebPaint;

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = radarChart;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, Opcodes.NEW, 115));
        Paint paint2 = new Paint(1);
        this.mWebPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    public void drawData(Canvas canvas) {
        RadarData radarData = (RadarData) this.mChart.getData();
        int i10 = 0;
        for (IRadarDataSet iRadarDataSet : radarData.getDataSets()) {
            if (iRadarDataSet.getEntryCount() > i10) {
                i10 = iRadarDataSet.getEntryCount();
            }
        }
        for (IRadarDataSet iRadarDataSet2 : radarData.getDataSets()) {
            if (iRadarDataSet2.isVisible() && iRadarDataSet2.getEntryCount() > 0) {
                drawDataSet(canvas, iRadarDataSet2, i10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IRadarDataSet iRadarDataSet, int i10) {
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        Path path = new Path();
        boolean z10 = false;
        for (int i11 = 0; i11 < iRadarDataSet.getEntryCount(); i11++) {
            this.mRenderPaint.setColor(iRadarDataSet.getColor(i11));
            PointF position = Utils.getPosition(centerOffsets, (iRadarDataSet.getEntryForIndex(i11).getVal() - this.mChart.getYChartMin()) * factor * phaseY, (((float) i11) * sliceAngle * phaseX) + this.mChart.getRotationAngle());
            if (!Float.isNaN(position.x)) {
                if (!z10) {
                    path.moveTo(position.x, position.y);
                    z10 = true;
                } else {
                    path.lineTo(position.x, position.y);
                }
            }
        }
        if (iRadarDataSet.getEntryCount() >= i10) {
            path.close();
        } else {
            path.lineTo(centerOffsets.x, centerOffsets.y);
            path.close();
        }
        if (iRadarDataSet.isDrawFilledEnabled()) {
            Drawable fillDrawable = iRadarDataSet.getFillDrawable();
            if (fillDrawable != null) {
                drawFilledPath(canvas, path, fillDrawable);
            } else {
                drawFilledPath(canvas, path, iRadarDataSet.getFillColor(), iRadarDataSet.getFillAlpha());
            }
        }
        this.mRenderPaint.setStrokeWidth(iRadarDataSet.getLineWidth());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (!iRadarDataSet.isDrawFilledEnabled() || iRadarDataSet.getFillAlpha() < 255) {
            canvas.drawPath(path, this.mRenderPaint);
        }
    }

    public void drawExtras(Canvas canvas) {
        drawWeb(canvas);
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        int xIndex;
        Entry entryForXIndex;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        for (int i10 = 0; i10 < highlightArr.length; i10++) {
            IRadarDataSet iRadarDataSet = (IRadarDataSet) ((RadarData) this.mChart.getData()).getDataSetByIndex(highlightArr[i10].getDataSetIndex());
            if (iRadarDataSet != null && iRadarDataSet.isHighlightEnabled() && (entryForXIndex = iRadarDataSet.getEntryForXIndex(xIndex)) != null && entryForXIndex.getXIndex() == (xIndex = highlightArr[i10].getXIndex())) {
                int entryIndex = iRadarDataSet.getEntryIndex(entryForXIndex);
                float val = entryForXIndex.getVal() - this.mChart.getYChartMin();
                if (!Float.isNaN(val)) {
                    PointF position = Utils.getPosition(centerOffsets, val * factor * phaseY, (((float) entryIndex) * sliceAngle * phaseX) + this.mChart.getRotationAngle());
                    drawHighlightLines(canvas, new float[]{position.x, position.y}, iRadarDataSet);
                }
            }
        }
    }

    public void drawValues(Canvas canvas) {
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        float convertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i10 = 0;
        while (i10 < ((RadarData) this.mChart.getData()).getDataSetCount()) {
            IRadarDataSet iRadarDataSet = (IRadarDataSet) ((RadarData) this.mChart.getData()).getDataSetByIndex(i10);
            if (iRadarDataSet.isDrawValuesEnabled() && iRadarDataSet.getEntryCount() != 0) {
                applyValueTextStyle(iRadarDataSet);
                int i11 = 0;
                while (i11 < iRadarDataSet.getEntryCount()) {
                    Entry entryForIndex = iRadarDataSet.getEntryForIndex(i11);
                    PointF position = Utils.getPosition(centerOffsets, (entryForIndex.getVal() - this.mChart.getYChartMin()) * factor * phaseY, (((float) i11) * sliceAngle * phaseX) + this.mChart.getRotationAngle());
                    ValueFormatter valueFormatter = iRadarDataSet.getValueFormatter();
                    float val = entryForIndex.getVal();
                    float f10 = position.x;
                    float f11 = position.y - convertDpToPixel;
                    int valueTextColor = iRadarDataSet.getValueTextColor(i11);
                    int i12 = i11;
                    IRadarDataSet iRadarDataSet2 = iRadarDataSet;
                    drawValue(canvas, valueFormatter, val, entryForIndex, i10, f10, f11, valueTextColor);
                    i11 = i12 + 1;
                    i10 = i10;
                    iRadarDataSet = iRadarDataSet2;
                }
            }
            i10++;
        }
    }

    /* access modifiers changed from: protected */
    public void drawWeb(Canvas canvas) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        float rotationAngle = this.mChart.getRotationAngle();
        PointF centerOffsets = this.mChart.getCenterOffsets();
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidth());
        this.mWebPaint.setColor(this.mChart.getWebColor());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int skipWebLineCount = this.mChart.getSkipWebLineCount() + 1;
        for (int i10 = 0; i10 < ((RadarData) this.mChart.getData()).getXValCount(); i10 += skipWebLineCount) {
            PointF position = Utils.getPosition(centerOffsets, this.mChart.getYRange() * factor, (((float) i10) * sliceAngle) + rotationAngle);
            canvas.drawLine(centerOffsets.x, centerOffsets.y, position.x, position.y, this.mWebPaint);
        }
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidthInner());
        this.mWebPaint.setColor(this.mChart.getWebColorInner());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int i11 = this.mChart.getYAxis().mEntryCount;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = 0;
            while (i13 < ((RadarData) this.mChart.getData()).getXValCount()) {
                float yChartMin = (this.mChart.getYAxis().mEntries[i12] - this.mChart.getYChartMin()) * factor;
                PointF position2 = Utils.getPosition(centerOffsets, yChartMin, (((float) i13) * sliceAngle) + rotationAngle);
                i13++;
                PointF position3 = Utils.getPosition(centerOffsets, yChartMin, (((float) i13) * sliceAngle) + rotationAngle);
                canvas.drawLine(position2.x, position2.y, position3.x, position3.y, this.mWebPaint);
            }
        }
    }

    public Paint getWebPaint() {
        return this.mWebPaint;
    }

    public void initBuffers() {
    }
}
