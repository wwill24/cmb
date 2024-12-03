package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BarChartRenderer extends DataRenderer {
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect = new RectF();
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = barDataProvider;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.mShadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i10 = 0; i10 < barData.getDataSetCount(); i10++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i10);
            if (iBarDataSet.isVisible() && iBarDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iBarDataSet, i10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i10) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        BarBuffer barBuffer = this.mBarBuffers[i10];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setBarSpace(iBarDataSet.getBarSpace());
        barBuffer.setDataSet(i10);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        int i11 = 0;
        if (iBarDataSet.getColors().size() > 1) {
            while (i11 < barBuffer.size()) {
                int i12 = i11 + 2;
                if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i12])) {
                    if (this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i11])) {
                        if (this.mChart.isDrawBarShadowEnabled()) {
                            canvas.drawRect(barBuffer.buffer[i11], this.mViewPortHandler.contentTop(), barBuffer.buffer[i12], this.mViewPortHandler.contentBottom(), this.mShadowPaint);
                        }
                        this.mRenderPaint.setColor(iBarDataSet.getColor(i11 / 4));
                        float[] fArr = barBuffer.buffer;
                        canvas.drawRect(fArr[i11], fArr[i11 + 1], fArr[i12], fArr[i11 + 3], this.mRenderPaint);
                    } else {
                        return;
                    }
                }
                i11 += 4;
            }
            return;
        }
        this.mRenderPaint.setColor(iBarDataSet.getColor());
        while (i11 < barBuffer.size()) {
            int i13 = i11 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i13])) {
                if (this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i11])) {
                    if (this.mChart.isDrawBarShadowEnabled()) {
                        canvas.drawRect(barBuffer.buffer[i11], this.mViewPortHandler.contentTop(), barBuffer.buffer[i13], this.mViewPortHandler.contentBottom(), this.mShadowPaint);
                    }
                    float[] fArr2 = barBuffer.buffer;
                    canvas.drawRect(fArr2[i11], fArr2[i11 + 1], fArr2[i13], fArr2[i11 + 3], this.mRenderPaint);
                } else {
                    return;
                }
            }
            i11 += 4;
        }
    }

    public void drawExtras(Canvas canvas) {
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        BarEntry barEntry;
        boolean z10;
        float f10;
        float f11;
        Canvas canvas2 = canvas;
        Highlight[] highlightArr2 = highlightArr;
        int dataSetCount = this.mChart.getBarData().getDataSetCount();
        for (Highlight highlight : highlightArr2) {
            int xIndex = highlight.getXIndex();
            int dataSetIndex = highlight.getDataSetIndex();
            IBarDataSet iBarDataSet = (IBarDataSet) this.mChart.getBarData().getDataSetByIndex(dataSetIndex);
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                float barSpace = iBarDataSet.getBarSpace() / 2.0f;
                Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                if (xIndex >= 0) {
                    float f12 = (float) xIndex;
                    if (f12 < (this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) / ((float) dataSetCount) && (barEntry = (BarEntry) iBarDataSet.getEntryForXIndex(xIndex)) != null && barEntry.getXIndex() == xIndex) {
                        float groupSpace = this.mChart.getBarData().getGroupSpace();
                        if (highlight.getStackIndex() < 0) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        float f13 = (groupSpace * f12) + ((float) ((xIndex * dataSetCount) + dataSetIndex)) + (groupSpace / 2.0f);
                        if (z10) {
                            f10 = highlight.getRange().from;
                            f11 = highlight.getRange().to;
                        } else {
                            f10 = barEntry.getVal();
                            f11 = 0.0f;
                        }
                        float f14 = f10;
                        prepareBarHighlight(f13, f14, f11, barSpace, transformer);
                        canvas2.drawRect(this.mBarRect, this.mHighlightPaint);
                        if (this.mChart.isDrawHighlightArrowEnabled()) {
                            this.mHighlightPaint.setAlpha(255);
                            float[] fArr = new float[9];
                            transformer.getPixelToValueMatrix().getValues(fArr);
                            float abs = Math.abs(fArr[4] / fArr[0]);
                            float barSpace2 = iBarDataSet.getBarSpace() / 2.0f;
                            float f15 = abs * barSpace2;
                            float phaseY = f14 * this.mAnimator.getPhaseY();
                            Path path = new Path();
                            float f16 = f13 + 0.4f;
                            float phaseY2 = phaseY + (this.mAnimator.getPhaseY() * 0.07f);
                            path.moveTo(f16, phaseY2);
                            float f17 = f16 + barSpace2;
                            path.lineTo(f17, phaseY2 - f15);
                            path.lineTo(f17, phaseY2 + f15);
                            transformer.pathValueToPixel(path);
                            canvas2.drawPath(path, this.mHighlightPaint);
                        }
                    }
                }
            }
        }
    }

    public void drawValues(Canvas canvas) {
        float f10;
        float f11;
        int i10;
        List list;
        Transformer transformer;
        float f12;
        float[] fArr;
        int i11;
        int i12;
        float[] fArr2;
        float f13;
        float f14;
        int i13;
        float[] fArr3;
        float f15;
        if (passesCheck()) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i14 = 0;
            while (i14 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i14);
                if (iBarDataSet.isDrawValuesEnabled() && iBarDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = (float) Utils.calcTextHeight(this.mValuePaint, "8");
                    if (isDrawValueAboveBarEnabled) {
                        f10 = -convertDpToPixel;
                    } else {
                        f10 = calcTextHeight + convertDpToPixel;
                    }
                    if (isDrawValueAboveBarEnabled) {
                        f11 = calcTextHeight + convertDpToPixel;
                    } else {
                        f11 = -convertDpToPixel;
                    }
                    if (isInverted) {
                        f10 = (-f10) - calcTextHeight;
                        f11 = (-f11) - calcTextHeight;
                    }
                    float f16 = f10;
                    float f17 = f11;
                    Transformer transformer2 = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    float[] transformedValues = getTransformedValues(transformer2, iBarDataSet, i14);
                    if (!iBarDataSet.isStacked()) {
                        int i15 = 0;
                        while (((float) i15) < ((float) transformedValues.length) * this.mAnimator.getPhaseX() && this.mViewPortHandler.isInBoundsRight(transformedValues[i15])) {
                            int i16 = i15 + 1;
                            if (!this.mViewPortHandler.isInBoundsY(transformedValues[i16]) || !this.mViewPortHandler.isInBoundsLeft(transformedValues[i15])) {
                                fArr3 = transformedValues;
                                i13 = i15;
                            } else {
                                int i17 = i15 / 2;
                                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i17);
                                float val = barEntry.getVal();
                                ValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                                float f18 = transformedValues[i15];
                                float f19 = transformedValues[i16];
                                if (val >= 0.0f) {
                                    f15 = f16;
                                } else {
                                    f15 = f17;
                                }
                                fArr3 = transformedValues;
                                i13 = i15;
                                drawValue(canvas, valueFormatter, val, barEntry, i14, f18, f19 + f15, iBarDataSet.getValueTextColor(i17));
                            }
                            i15 = i13 + 2;
                            transformedValues = fArr3;
                        }
                    } else {
                        float[] fArr4 = transformedValues;
                        int i18 = 0;
                        while (((float) i18) < ((float) (fArr4.length - 1)) * this.mAnimator.getPhaseX()) {
                            int i19 = i18 / 2;
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i19);
                            float[] vals = barEntry2.getVals();
                            if (vals != null) {
                                i10 = i18;
                                list = dataSets;
                                transformer = transformer2;
                                int valueTextColor = iBarDataSet.getValueTextColor(i19);
                                int length = vals.length * 2;
                                float[] fArr5 = new float[length];
                                float f20 = -barEntry2.getNegativeSum();
                                float f21 = 0.0f;
                                int i20 = 0;
                                int i21 = 0;
                                while (i20 < length) {
                                    float f22 = vals[i21];
                                    if (f22 >= 0.0f) {
                                        f21 += f22;
                                        f13 = f20;
                                        f20 = f21;
                                    } else {
                                        f13 = f20 - f22;
                                    }
                                    fArr5[i20 + 1] = f20 * this.mAnimator.getPhaseY();
                                    i20 += 2;
                                    i21++;
                                    f20 = f13;
                                    f21 = f21;
                                }
                                transformer.pointValuesToPixel(fArr5);
                                int i22 = 0;
                                while (i22 < length) {
                                    float f23 = fArr4[i10];
                                    float f24 = fArr5[i22 + 1];
                                    int i23 = i22 / 2;
                                    if (vals[i23] >= 0.0f) {
                                        f12 = f16;
                                    } else {
                                        f12 = f17;
                                    }
                                    float f25 = f24 + f12;
                                    if (!this.mViewPortHandler.isInBoundsRight(f23)) {
                                        break;
                                    }
                                    if (!this.mViewPortHandler.isInBoundsY(f25) || !this.mViewPortHandler.isInBoundsLeft(f23)) {
                                        i11 = i22;
                                        fArr = vals;
                                        fArr2 = fArr5;
                                        i12 = length;
                                    } else {
                                        float f26 = f25;
                                        i11 = i22;
                                        fArr = vals;
                                        fArr2 = fArr5;
                                        float f27 = f26;
                                        i12 = length;
                                        drawValue(canvas, iBarDataSet.getValueFormatter(), vals[i23], barEntry2, i14, f23, f27, valueTextColor);
                                    }
                                    i22 = i11 + 2;
                                    fArr5 = fArr2;
                                    length = i12;
                                    vals = fArr;
                                }
                            } else if (!this.mViewPortHandler.isInBoundsRight(fArr4[i18])) {
                                break;
                            } else {
                                int i24 = i18 + 1;
                                if (!this.mViewPortHandler.isInBoundsY(fArr4[i24]) || !this.mViewPortHandler.isInBoundsLeft(fArr4[i18])) {
                                    i10 = i18;
                                    list = dataSets;
                                    transformer = transformer2;
                                } else {
                                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                                    float val2 = barEntry2.getVal();
                                    float f28 = fArr4[i18];
                                    float f29 = fArr4[i24];
                                    if (barEntry2.getVal() >= 0.0f) {
                                        f14 = f16;
                                    } else {
                                        f14 = f17;
                                    }
                                    i10 = i18;
                                    list = dataSets;
                                    transformer = transformer2;
                                    drawValue(canvas, valueFormatter2, val2, barEntry2, i14, f28, f29 + f14, iBarDataSet.getValueTextColor(i19));
                                }
                            }
                            i18 = i10 + 2;
                            transformer2 = transformer;
                            dataSets = list;
                        }
                    }
                }
                i14++;
                dataSets = dataSets;
            }
        }
    }

    public float[] getTransformedValues(Transformer transformer, IBarDataSet iBarDataSet, int i10) {
        return transformer.generateTransformedValuesBarChart(iBarDataSet, i10, this.mChart.getBarData(), this.mAnimator.getPhaseY());
    }

    public void initBuffers() {
        int i10;
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i11 = 0; i11 < this.mBarBuffers.length; i11++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i11);
            BarBuffer[] barBufferArr = this.mBarBuffers;
            int entryCount = iBarDataSet.getEntryCount() * 4;
            if (iBarDataSet.isStacked()) {
                i10 = iBarDataSet.getStackSize();
            } else {
                i10 = 1;
            }
            barBufferArr[i11] = new BarBuffer(entryCount * i10, barData.getGroupSpace(), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* access modifiers changed from: protected */
    public boolean passesCheck() {
        if (((float) this.mChart.getBarData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void prepareBarHighlight(float f10, float f11, float f12, float f13, Transformer transformer) {
        this.mBarRect.set((f10 - 0.5f) + f13, f11, (f10 + 0.5f) - f13, f12);
        transformer.rectValueToPixel(this.mBarRect, this.mAnimator.getPhaseY());
    }
}
