package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
    private float[] mBodyBuffers = new float[4];
    protected CandleDataProvider mChart;
    private float[] mCloseBuffers = new float[4];
    private float[] mOpenBuffers = new float[4];
    private float[] mRangeBuffers = new float[4];
    private float[] mShadowBuffers = new float[8];

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = candleDataProvider;
    }

    public void drawData(Canvas canvas) {
        for (ICandleDataSet iCandleDataSet : this.mChart.getCandleData().getDataSets()) {
            if (iCandleDataSet.isVisible() && iCandleDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iCandleDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, ICandleDataSet iCandleDataSet) {
        boolean z10;
        char c10;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        ICandleDataSet iCandleDataSet2 = iCandleDataSet;
        Transformer transformer = this.mChart.getTransformer(iCandleDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float barSpace = iCandleDataSet.getBarSpace();
        boolean showCandleBar = iCandleDataSet.getShowCandleBar();
        char c11 = 0;
        int max = Math.max(this.mMinX, 0);
        boolean z11 = true;
        int min = Math.min(this.mMaxX + 1, iCandleDataSet.getEntryCount());
        this.mRenderPaint.setStrokeWidth(iCandleDataSet.getShadowWidth());
        int ceil = (int) Math.ceil((double) ((((float) (min - max)) * phaseX) + ((float) max)));
        int i15 = max;
        while (i15 < ceil) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet2.getEntryForIndex(i15);
            int xIndex = candleEntry.getXIndex();
            if (xIndex < max || xIndex >= min) {
                z10 = z11;
                c10 = c11;
            } else {
                float open = candleEntry.getOpen();
                float close = candleEntry.getClose();
                float high = candleEntry.getHigh();
                float low = candleEntry.getLow();
                if (showCandleBar) {
                    float[] fArr = this.mShadowBuffers;
                    float f10 = (float) xIndex;
                    fArr[c11] = f10;
                    fArr[2] = f10;
                    fArr[4] = f10;
                    fArr[6] = f10;
                    int i16 = (open > close ? 1 : (open == close ? 0 : -1));
                    if (i16 > 0) {
                        fArr[1] = high * phaseY;
                        fArr[3] = open * phaseY;
                        fArr[5] = low * phaseY;
                        fArr[7] = close * phaseY;
                    } else if (open < close) {
                        fArr[1] = high * phaseY;
                        fArr[3] = close * phaseY;
                        fArr[5] = low * phaseY;
                        fArr[7] = open * phaseY;
                    } else {
                        fArr[1] = high * phaseY;
                        float f11 = open * phaseY;
                        fArr[3] = f11;
                        fArr[5] = low * phaseY;
                        fArr[7] = f11;
                    }
                    transformer.pointValuesToPixel(fArr);
                    if (!iCandleDataSet.getShadowColorSameAsCandle()) {
                        Paint paint = this.mRenderPaint;
                        if (iCandleDataSet.getShadowColor() == -1) {
                            i11 = iCandleDataSet2.getColor(i15);
                        } else {
                            i11 = iCandleDataSet.getShadowColor();
                        }
                        paint.setColor(i11);
                    } else if (i16 > 0) {
                        Paint paint2 = this.mRenderPaint;
                        if (iCandleDataSet.getDecreasingColor() == -1) {
                            i14 = iCandleDataSet2.getColor(i15);
                        } else {
                            i14 = iCandleDataSet.getDecreasingColor();
                        }
                        paint2.setColor(i14);
                    } else if (open < close) {
                        Paint paint3 = this.mRenderPaint;
                        if (iCandleDataSet.getIncreasingColor() == -1) {
                            i13 = iCandleDataSet2.getColor(i15);
                        } else {
                            i13 = iCandleDataSet.getIncreasingColor();
                        }
                        paint3.setColor(i13);
                    } else {
                        Paint paint4 = this.mRenderPaint;
                        if (iCandleDataSet.getNeutralColor() == -1) {
                            i12 = iCandleDataSet2.getColor(i15);
                        } else {
                            i12 = iCandleDataSet.getNeutralColor();
                        }
                        paint4.setColor(i12);
                    }
                    this.mRenderPaint.setStyle(Paint.Style.STROKE);
                    canvas.drawLines(this.mShadowBuffers, this.mRenderPaint);
                    float[] fArr2 = this.mBodyBuffers;
                    fArr2[0] = (f10 - 0.5f) + barSpace;
                    fArr2[1] = close * phaseY;
                    fArr2[2] = (f10 + 0.5f) - barSpace;
                    fArr2[3] = open * phaseY;
                    transformer.pointValuesToPixel(fArr2);
                    if (i16 > 0) {
                        if (iCandleDataSet.getDecreasingColor() == -1) {
                            this.mRenderPaint.setColor(iCandleDataSet2.getColor(i15));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getDecreasingColor());
                        }
                        this.mRenderPaint.setStyle(iCandleDataSet.getDecreasingPaintStyle());
                        float[] fArr3 = this.mBodyBuffers;
                        canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.mRenderPaint);
                    } else if (open < close) {
                        if (iCandleDataSet.getIncreasingColor() == -1) {
                            this.mRenderPaint.setColor(iCandleDataSet2.getColor(i15));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getIncreasingColor());
                        }
                        this.mRenderPaint.setStyle(iCandleDataSet.getIncreasingPaintStyle());
                        float[] fArr4 = this.mBodyBuffers;
                        canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.mRenderPaint);
                    } else {
                        if (iCandleDataSet.getNeutralColor() == -1) {
                            this.mRenderPaint.setColor(iCandleDataSet2.getColor(i15));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getNeutralColor());
                        }
                        float[] fArr5 = this.mBodyBuffers;
                        canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.mRenderPaint);
                    }
                    c10 = 0;
                    z10 = true;
                } else {
                    float[] fArr6 = this.mRangeBuffers;
                    float f12 = (float) xIndex;
                    fArr6[0] = f12;
                    fArr6[1] = high * phaseY;
                    fArr6[2] = f12;
                    fArr6[3] = low * phaseY;
                    float[] fArr7 = this.mOpenBuffers;
                    fArr7[0] = (f12 - 0.5f) + barSpace;
                    float f13 = open * phaseY;
                    fArr7[1] = f13;
                    fArr7[2] = f12;
                    fArr7[3] = f13;
                    float[] fArr8 = this.mCloseBuffers;
                    fArr8[0] = (f12 + 0.5f) - barSpace;
                    float f14 = close * phaseY;
                    fArr8[1] = f14;
                    fArr8[2] = f12;
                    fArr8[3] = f14;
                    transformer.pointValuesToPixel(fArr6);
                    transformer.pointValuesToPixel(this.mOpenBuffers);
                    transformer.pointValuesToPixel(this.mCloseBuffers);
                    if (open > close) {
                        if (iCandleDataSet.getDecreasingColor() == -1) {
                            i10 = iCandleDataSet2.getColor(i15);
                        } else {
                            i10 = iCandleDataSet.getDecreasingColor();
                        }
                    } else if (open < close) {
                        if (iCandleDataSet.getIncreasingColor() == -1) {
                            i10 = iCandleDataSet2.getColor(i15);
                        } else {
                            i10 = iCandleDataSet.getIncreasingColor();
                        }
                    } else if (iCandleDataSet.getNeutralColor() == -1) {
                        i10 = iCandleDataSet2.getColor(i15);
                    } else {
                        i10 = iCandleDataSet.getNeutralColor();
                    }
                    this.mRenderPaint.setColor(i10);
                    float[] fArr9 = this.mRangeBuffers;
                    Canvas canvas2 = canvas;
                    canvas2.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.mRenderPaint);
                    float[] fArr10 = this.mOpenBuffers;
                    canvas2.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.mRenderPaint);
                    float[] fArr11 = this.mCloseBuffers;
                    c10 = 0;
                    z10 = true;
                    canvas2.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.mRenderPaint);
                }
            }
            i15++;
            c11 = c10;
            z11 = z10;
        }
    }

    public void drawExtras(Canvas canvas) {
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        CandleEntry candleEntry;
        for (int i10 = 0; i10 < highlightArr.length; i10++) {
            int xIndex = highlightArr[i10].getXIndex();
            ICandleDataSet iCandleDataSet = (ICandleDataSet) this.mChart.getCandleData().getDataSetByIndex(highlightArr[i10].getDataSetIndex());
            if (iCandleDataSet != null && iCandleDataSet.isHighlightEnabled() && (candleEntry = (CandleEntry) iCandleDataSet.getEntryForXIndex(xIndex)) != null && candleEntry.getXIndex() == xIndex) {
                this.mChart.getYChartMin();
                this.mChart.getYChartMax();
                float[] fArr = {(float) xIndex, ((candleEntry.getLow() * this.mAnimator.getPhaseY()) + (candleEntry.getHigh() * this.mAnimator.getPhaseY())) / 2.0f};
                this.mChart.getTransformer(iCandleDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                drawHighlightLines(canvas, fArr, iCandleDataSet);
            }
        }
    }

    public void drawValues(Canvas canvas) {
        int i10;
        if (((float) this.mChart.getCandleData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX()) {
            List dataSets = this.mChart.getCandleData().getDataSets();
            for (int i11 = 0; i11 < dataSets.size(); i11++) {
                ICandleDataSet iCandleDataSet = (ICandleDataSet) dataSets.get(i11);
                if (iCandleDataSet.isDrawValuesEnabled() && iCandleDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iCandleDataSet);
                    Transformer transformer = this.mChart.getTransformer(iCandleDataSet.getAxisDependency());
                    int max = Math.max(this.mMinX, 0);
                    float[] generateTransformedValuesCandle = transformer.generateTransformedValuesCandle(iCandleDataSet, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), max, Math.min(this.mMaxX + 1, iCandleDataSet.getEntryCount()));
                    float convertDpToPixel = Utils.convertDpToPixel(5.0f);
                    int i12 = 0;
                    while (i12 < generateTransformedValuesCandle.length) {
                        float f10 = generateTransformedValuesCandle[i12];
                        float f11 = generateTransformedValuesCandle[i12 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f10)) {
                            break;
                        }
                        if (!this.mViewPortHandler.isInBoundsLeft(f10) || !this.mViewPortHandler.isInBoundsY(f11)) {
                            i10 = i12;
                        } else {
                            int i13 = i12 / 2;
                            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex(i13 + max);
                            i10 = i12;
                            drawValue(canvas, iCandleDataSet.getValueFormatter(), candleEntry.getHigh(), candleEntry, i11, f10, f11 - convertDpToPixel, iCandleDataSet.getValueTextColor(i13));
                        }
                        i12 = i10 + 2;
                    }
                }
            }
        }
    }

    public void initBuffers() {
    }
}
