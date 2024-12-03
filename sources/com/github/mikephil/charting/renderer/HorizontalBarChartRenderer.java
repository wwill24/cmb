package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class HorizontalBarChartRenderer extends BarChartRenderer {
    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
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
        while (i11 < barBuffer.size()) {
            int i12 = i11 + 3;
            if (this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i12])) {
                int i13 = i11 + 1;
                if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i13])) {
                    if (this.mChart.isDrawBarShadowEnabled()) {
                        canvas.drawRect(this.mViewPortHandler.contentLeft(), barBuffer.buffer[i13], this.mViewPortHandler.contentRight(), barBuffer.buffer[i12], this.mShadowPaint);
                    }
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i11 / 4));
                    float[] fArr = barBuffer.buffer;
                    canvas.drawRect(fArr[i11], fArr[i13], fArr[i11 + 2], fArr[i12], this.mRenderPaint);
                }
                i11 += 4;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawValue(Canvas canvas, String str, float f10, float f11, int i10) {
        this.mValuePaint.setColor(i10);
        canvas.drawText(str, f10, f11, this.mValuePaint);
    }

    public void drawValues(Canvas canvas) {
        boolean z10;
        List list;
        Transformer transformer;
        IBarDataSet iBarDataSet;
        float f10;
        float f11;
        int i10;
        float[] fArr;
        int i11;
        Transformer transformer2;
        BarEntry barEntry;
        IBarDataSet iBarDataSet2;
        float[] fArr2;
        IBarDataSet iBarDataSet3;
        float f12;
        float f13;
        float f14;
        boolean z11;
        List list2;
        float[] fArr3;
        int i12;
        float f15;
        float f16;
        if (passesCheck()) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i13 = 0;
            while (i13 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet4 = (IBarDataSet) dataSets.get(i13);
                if (iBarDataSet4.isDrawValuesEnabled() && iBarDataSet4.getEntryCount() != 0) {
                    boolean isInverted = this.mChart.isInverted(iBarDataSet4.getAxisDependency());
                    applyValueTextStyle(iBarDataSet4);
                    float calcTextHeight = ((float) Utils.calcTextHeight(this.mValuePaint, "10")) / 2.0f;
                    ValueFormatter valueFormatter = iBarDataSet4.getValueFormatter();
                    Transformer transformer3 = this.mChart.getTransformer(iBarDataSet4.getAxisDependency());
                    float[] transformedValues = getTransformedValues(transformer3, iBarDataSet4, i13);
                    if (!iBarDataSet4.isStacked()) {
                        int i14 = 0;
                        while (((float) i14) < ((float) transformedValues.length) * this.mAnimator.getPhaseX()) {
                            int i15 = i14 + 1;
                            if (!this.mViewPortHandler.isInBoundsTop(transformedValues[i15])) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsX(transformedValues[i14]) && this.mViewPortHandler.isInBoundsBottom(transformedValues[i15])) {
                                int i16 = i14 / 2;
                                BarEntry barEntry2 = (BarEntry) iBarDataSet4.getEntryForIndex(i16);
                                float val = barEntry2.getVal();
                                String formattedValue = valueFormatter.getFormattedValue(val, barEntry2, i13, this.mViewPortHandler);
                                float calcTextWidth = (float) Utils.calcTextWidth(this.mValuePaint, formattedValue);
                                list2 = dataSets;
                                if (isDrawValueAboveBarEnabled) {
                                    f15 = convertDpToPixel;
                                } else {
                                    f15 = -(calcTextWidth + convertDpToPixel);
                                }
                                z11 = isDrawValueAboveBarEnabled;
                                if (isDrawValueAboveBarEnabled) {
                                    f16 = -(calcTextWidth + convertDpToPixel);
                                } else {
                                    f16 = convertDpToPixel;
                                }
                                if (isInverted) {
                                    f15 = (-f15) - calcTextWidth;
                                    f16 = (-f16) - calcTextWidth;
                                }
                                float f17 = transformedValues[i14];
                                if (val < 0.0f) {
                                    f15 = f16;
                                }
                                float f18 = f17 + f15;
                                fArr3 = transformedValues;
                                float f19 = transformedValues[i15] + calcTextHeight;
                                i12 = i14;
                                drawValue(canvas, formattedValue, f18, f19, iBarDataSet4.getValueTextColor(i16));
                            } else {
                                fArr3 = transformedValues;
                                list2 = dataSets;
                                z11 = isDrawValueAboveBarEnabled;
                                i12 = i14;
                            }
                            i14 = i12 + 2;
                            transformedValues = fArr3;
                            dataSets = list2;
                            isDrawValueAboveBarEnabled = z11;
                        }
                    } else {
                        float[] fArr4 = transformedValues;
                        list = dataSets;
                        z10 = isDrawValueAboveBarEnabled;
                        int i17 = 0;
                        while (((float) i17) < ((float) (fArr4.length - 1)) * this.mAnimator.getPhaseX()) {
                            int i18 = i17 / 2;
                            BarEntry barEntry3 = (BarEntry) iBarDataSet4.getEntryForIndex(i18);
                            float[] vals = barEntry3.getVals();
                            if (vals == null) {
                                int i19 = i17 + 1;
                                if (!this.mViewPortHandler.isInBoundsTop(fArr4[i19])) {
                                    break;
                                }
                                if (this.mViewPortHandler.isInBoundsX(fArr4[i17]) && this.mViewPortHandler.isInBoundsBottom(fArr4[i19])) {
                                    String formattedValue2 = valueFormatter.getFormattedValue(barEntry3.getVal(), barEntry3, i13, this.mViewPortHandler);
                                    float calcTextWidth2 = (float) Utils.calcTextWidth(this.mValuePaint, formattedValue2);
                                    if (z10) {
                                        f13 = convertDpToPixel;
                                    } else {
                                        f13 = -(calcTextWidth2 + convertDpToPixel);
                                    }
                                    Transformer transformer4 = transformer3;
                                    if (z10) {
                                        f14 = -(calcTextWidth2 + convertDpToPixel);
                                    } else {
                                        f14 = convertDpToPixel;
                                    }
                                    if (isInverted) {
                                        f13 = (-f13) - calcTextWidth2;
                                        f14 = (-f14) - calcTextWidth2;
                                    }
                                    float f20 = fArr4[i17];
                                    if (barEntry3.getVal() < 0.0f) {
                                        f13 = f14;
                                    }
                                    drawValue(canvas, formattedValue2, f13 + f20, fArr4[i19] + calcTextHeight, iBarDataSet4.getValueTextColor(i18));
                                    transformer = transformer4;
                                } else {
                                    transformer = transformer3;
                                }
                                iBarDataSet = iBarDataSet4;
                            } else {
                                int length = vals.length * 2;
                                float[] fArr5 = new float[length];
                                float f21 = -barEntry3.getNegativeSum();
                                int i20 = i18;
                                float f22 = 0.0f;
                                int i21 = 0;
                                int i22 = 0;
                                while (i21 < length) {
                                    float f23 = vals[i22];
                                    if (f23 >= 0.0f) {
                                        f22 += f23;
                                        f12 = f21;
                                        iBarDataSet3 = iBarDataSet4;
                                        f21 = f22;
                                    } else {
                                        f12 = f21 - f23;
                                        iBarDataSet3 = iBarDataSet4;
                                    }
                                    fArr5[i21] = f21 * this.mAnimator.getPhaseY();
                                    i21 += 2;
                                    i22++;
                                    f21 = f12;
                                    iBarDataSet4 = iBarDataSet3;
                                }
                                IBarDataSet iBarDataSet5 = iBarDataSet4;
                                transformer3.pointValuesToPixel(fArr5);
                                int i23 = 0;
                                while (i23 < length) {
                                    float f24 = vals[i23 / 2];
                                    String formattedValue3 = valueFormatter.getFormattedValue(f24, barEntry3, i13, this.mViewPortHandler);
                                    int i24 = length;
                                    float calcTextWidth3 = (float) Utils.calcTextWidth(this.mValuePaint, formattedValue3);
                                    float[] fArr6 = vals;
                                    if (z10) {
                                        f10 = convertDpToPixel;
                                    } else {
                                        f10 = -(calcTextWidth3 + convertDpToPixel);
                                    }
                                    BarEntry barEntry4 = barEntry3;
                                    if (z10) {
                                        f11 = -(calcTextWidth3 + convertDpToPixel);
                                    } else {
                                        f11 = convertDpToPixel;
                                    }
                                    if (isInverted) {
                                        f10 = (-f10) - calcTextWidth3;
                                        f11 = (-f11) - calcTextWidth3;
                                    }
                                    float f25 = fArr5[i23];
                                    if (f24 < 0.0f) {
                                        f10 = f11;
                                    }
                                    float f26 = f10 + f25;
                                    float f27 = fArr4[i17 + 1];
                                    if (!this.mViewPortHandler.isInBoundsTop(f27)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsX(f26) && this.mViewPortHandler.isInBoundsBottom(f27)) {
                                        float f28 = f27 + calcTextHeight;
                                        int i25 = i20;
                                        IBarDataSet iBarDataSet6 = iBarDataSet5;
                                        int valueTextColor = iBarDataSet6.getValueTextColor(i25);
                                        i11 = i25;
                                        fArr = fArr5;
                                        i10 = i24;
                                        iBarDataSet2 = iBarDataSet6;
                                        String str = formattedValue3;
                                        fArr2 = fArr6;
                                        barEntry = barEntry4;
                                        transformer2 = transformer3;
                                        drawValue(canvas, str, f26, f28, valueTextColor);
                                    } else {
                                        fArr = fArr5;
                                        i10 = i24;
                                        fArr2 = fArr6;
                                        barEntry = barEntry4;
                                        iBarDataSet2 = iBarDataSet5;
                                        transformer2 = transformer3;
                                        i11 = i20;
                                    }
                                    i23 += 2;
                                    vals = fArr2;
                                    barEntry3 = barEntry;
                                    transformer3 = transformer2;
                                    i20 = i11;
                                    fArr5 = fArr;
                                    length = i10;
                                    iBarDataSet5 = iBarDataSet2;
                                }
                                transformer = transformer3;
                                iBarDataSet = iBarDataSet5;
                            }
                            i17 += 2;
                            iBarDataSet4 = iBarDataSet;
                            transformer3 = transformer;
                        }
                        i13++;
                        dataSets = list;
                        isDrawValueAboveBarEnabled = z10;
                    }
                }
                list = dataSets;
                z10 = isDrawValueAboveBarEnabled;
                i13++;
                dataSets = list;
                isDrawValueAboveBarEnabled = z10;
            }
        }
    }

    public float[] getTransformedValues(Transformer transformer, IBarDataSet iBarDataSet, int i10) {
        return transformer.generateTransformedValuesHorizontalBarChart(iBarDataSet, i10, this.mChart.getBarData(), this.mAnimator.getPhaseY());
    }

    public void initBuffers() {
        int i10;
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i11 = 0; i11 < this.mBarBuffers.length; i11++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i11);
            BarBuffer[] barBufferArr = this.mBarBuffers;
            int entryCount = iBarDataSet.getEntryCount() * 4;
            if (iBarDataSet.isStacked()) {
                i10 = iBarDataSet.getStackSize();
            } else {
                i10 = 1;
            }
            barBufferArr[i11] = new HorizontalBarBuffer(entryCount * i10, barData.getGroupSpace(), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* access modifiers changed from: protected */
    public boolean passesCheck() {
        if (((float) this.mChart.getBarData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void prepareBarHighlight(float f10, float f11, float f12, float f13, Transformer transformer) {
        this.mBarRect.set(f11, (f10 - 0.5f) + f13, f12, (f10 + 0.5f) - f13);
        transformer.rectValueToPixelHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }
}
