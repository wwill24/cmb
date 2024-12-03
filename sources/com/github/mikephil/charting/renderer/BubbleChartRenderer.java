package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.facebook.appevents.AppEventsConstants;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BubbleChartRenderer extends DataRenderer {
    private float[] _hsvBuffer = new float[3];
    protected BubbleDataProvider mChart;
    private float[] pointBuffer = new float[2];
    private float[] sizeBuffer = new float[4];

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = bubbleDataProvider;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5f));
    }

    public void drawData(Canvas canvas) {
        for (IBubbleDataSet iBubbleDataSet : this.mChart.getBubbleData().getDataSets()) {
            if (iBubbleDataSet.isVisible() && iBubbleDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iBubbleDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IBubbleDataSet iBubbleDataSet) {
        Transformer transformer = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        int max = Math.max(iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMinX)), 0);
        int min = Math.min(iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMaxX)) + 1, iBubbleDataSet.getEntryCount());
        float[] fArr = this.sizeBuffer;
        fArr[0] = 0.0f;
        fArr[2] = 1.0f;
        transformer.pointValuesToPixel(fArr);
        float[] fArr2 = this.sizeBuffer;
        float min2 = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(fArr2[2] - fArr2[0]));
        for (int i10 = max; i10 < min; i10++) {
            BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getEntryForIndex(i10);
            this.pointBuffer[0] = (((float) (bubbleEntry.getXIndex() - max)) * phaseX) + ((float) max);
            this.pointBuffer[1] = bubbleEntry.getVal() * phaseY;
            transformer.pointValuesToPixel(this.pointBuffer);
            float shapeSize = getShapeSize(bubbleEntry.getSize(), iBubbleDataSet.getMaxSize(), min2) / 2.0f;
            if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + shapeSize) && this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - shapeSize) && this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + shapeSize)) {
                if (this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - shapeSize)) {
                    this.mRenderPaint.setColor(iBubbleDataSet.getColor(bubbleEntry.getXIndex()));
                    float[] fArr3 = this.pointBuffer;
                    canvas.drawCircle(fArr3[0], fArr3[1], shapeSize, this.mRenderPaint);
                } else {
                    return;
                }
            }
        }
    }

    public void drawExtras(Canvas canvas) {
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        char c10;
        Highlight[] highlightArr2 = highlightArr;
        BubbleData bubbleData = this.mChart.getBubbleData();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        int length = highlightArr2.length;
        char c11 = 0;
        int i10 = 0;
        while (i10 < length) {
            Highlight highlight = highlightArr2[i10];
            IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) bubbleData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBubbleDataSet != null && iBubbleDataSet.isHighlightEnabled()) {
                int entryIndex = iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMinX));
                int min = Math.min(iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMaxX)) + 1, iBubbleDataSet.getEntryCount());
                BubbleEntry bubbleEntry = (BubbleEntry) bubbleData.getEntryForHighlight(highlight);
                if (bubbleEntry != null && bubbleEntry.getXIndex() == highlight.getXIndex()) {
                    Transformer transformer = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency());
                    float[] fArr = this.sizeBuffer;
                    fArr[c11] = 0.0f;
                    fArr[2] = 1.0f;
                    transformer.pointValuesToPixel(fArr);
                    float[] fArr2 = this.sizeBuffer;
                    float min2 = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(fArr2[2] - fArr2[c11]));
                    this.pointBuffer[0] = (((float) (bubbleEntry.getXIndex() - entryIndex)) * phaseX) + ((float) entryIndex);
                    this.pointBuffer[1] = bubbleEntry.getVal() * phaseY;
                    transformer.pointValuesToPixel(this.pointBuffer);
                    float shapeSize = getShapeSize(bubbleEntry.getSize(), iBubbleDataSet.getMaxSize(), min2) / 2.0f;
                    if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + shapeSize) && this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - shapeSize)) {
                        if (!this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + shapeSize)) {
                            Canvas canvas2 = canvas;
                            c10 = 0;
                        } else if (this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - shapeSize)) {
                            if (highlight.getXIndex() >= entryIndex && highlight.getXIndex() < min) {
                                int color = iBubbleDataSet.getColor(bubbleEntry.getXIndex());
                                Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), this._hsvBuffer);
                                float[] fArr3 = this._hsvBuffer;
                                fArr3[2] = fArr3[2] * 0.5f;
                                this.mHighlightPaint.setColor(Color.HSVToColor(Color.alpha(color), this._hsvBuffer));
                                this.mHighlightPaint.setStrokeWidth(iBubbleDataSet.getHighlightCircleWidth());
                                float[] fArr4 = this.pointBuffer;
                                c10 = 0;
                                canvas.drawCircle(fArr4[0], fArr4[1], shapeSize, this.mHighlightPaint);
                            }
                        } else {
                            return;
                        }
                        i10++;
                        highlightArr2 = highlightArr;
                        c11 = c10;
                    }
                    Canvas canvas3 = canvas;
                    c10 = 0;
                    i10++;
                    highlightArr2 = highlightArr;
                    c11 = c10;
                }
            }
            Canvas canvas4 = canvas;
            c10 = c11;
            i10++;
            highlightArr2 = highlightArr;
            c11 = c10;
        }
    }

    public void drawValues(Canvas canvas) {
        float f10;
        int i10;
        float[] fArr;
        BubbleData bubbleData = this.mChart.getBubbleData();
        if (bubbleData != null && bubbleData.getYValCount() < ((int) Math.ceil((double) (((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX())))) {
            List dataSets = bubbleData.getDataSets();
            float calcTextHeight = (float) Utils.calcTextHeight(this.mValuePaint, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            for (int i11 = 0; i11 < dataSets.size(); i11++) {
                IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) dataSets.get(i11);
                if (iBubbleDataSet.isDrawValuesEnabled() && iBubbleDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iBubbleDataSet);
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    int entryIndex = iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMinX));
                    float[] generateTransformedValuesBubble = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency()).generateTransformedValuesBubble(iBubbleDataSet, phaseX, phaseY, entryIndex, Math.min(iBubbleDataSet.getEntryIndex((BubbleEntry) iBubbleDataSet.getEntryForXIndex(this.mMaxX)) + 1, iBubbleDataSet.getEntryCount()));
                    if (phaseX == 1.0f) {
                        f10 = phaseY;
                    } else {
                        f10 = phaseX;
                    }
                    int i12 = 0;
                    while (i12 < generateTransformedValuesBubble.length) {
                        int i13 = (i12 / 2) + entryIndex;
                        int valueTextColor = iBubbleDataSet.getValueTextColor(i13);
                        int argb = Color.argb(Math.round(255.0f * f10), Color.red(valueTextColor), Color.green(valueTextColor), Color.blue(valueTextColor));
                        float f11 = generateTransformedValuesBubble[i12];
                        float f12 = generateTransformedValuesBubble[i12 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f11)) {
                            break;
                        }
                        if (!this.mViewPortHandler.isInBoundsLeft(f11) || !this.mViewPortHandler.isInBoundsY(f12)) {
                            i10 = i12;
                            fArr = generateTransformedValuesBubble;
                        } else {
                            BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getEntryForIndex(i13);
                            i10 = i12;
                            float f13 = f12 + (0.5f * calcTextHeight);
                            fArr = generateTransformedValuesBubble;
                            drawValue(canvas, iBubbleDataSet.getValueFormatter(), bubbleEntry.getSize(), bubbleEntry, i11, f11, f13, argb);
                        }
                        i12 = i10 + 2;
                        generateTransformedValuesBubble = fArr;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public float getShapeSize(float f10, float f11, float f12) {
        return f12 * (f11 == 0.0f ? 1.0f : (float) Math.sqrt((double) (f10 / f11)));
    }

    public void initBuffers() {
    }
}
