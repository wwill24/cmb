package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.ScatterBuffer;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    protected ScatterBuffer[] mScatterBuffers;

    /* renamed from: com.github.mikephil.charting.renderer.ScatterChartRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape[] r0 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape = r0
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.SQUARE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.CIRCLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.TRIANGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.CROSS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.X     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.ScatterChartRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = scatterDataProvider;
    }

    public void drawData(Canvas canvas) {
        for (IScatterDataSet iScatterDataSet : this.mChart.getScatterData().getDataSets()) {
            if (iScatterDataSet.isVisible()) {
                drawDataSet(canvas, iScatterDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IScatterDataSet iScatterDataSet) {
        int i10;
        int i11;
        Canvas canvas2 = canvas;
        IScatterDataSet iScatterDataSet2 = iScatterDataSet;
        Transformer transformer = this.mChart.getTransformer(iScatterDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeSize());
        float f10 = convertDpToPixel / 2.0f;
        float convertDpToPixel2 = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeHoleRadius());
        float f11 = convertDpToPixel2 * 2.0f;
        int scatterShapeHoleColor = iScatterDataSet.getScatterShapeHoleColor();
        float f12 = (convertDpToPixel - f11) / 2.0f;
        float f13 = f12 / 2.0f;
        ScatterChart.ScatterShape scatterShape = iScatterDataSet.getScatterShape();
        ScatterBuffer scatterBuffer = this.mScatterBuffers[this.mChart.getScatterData().getIndexOfDataSet(iScatterDataSet2)];
        scatterBuffer.setPhases(phaseX, phaseY);
        scatterBuffer.feed(iScatterDataSet2);
        transformer.pointValuesToPixel(scatterBuffer.buffer);
        int i12 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[scatterShape.ordinal()];
        int i13 = -1;
        int i14 = 0;
        if (i12 == 1) {
            int i15 = 0;
            while (i15 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i15])) {
                if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i15])) {
                    int i16 = i15 + 1;
                    if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i16])) {
                        this.mRenderPaint.setColor(iScatterDataSet2.getColor(i15 / 2));
                        if (((double) f11) > 0.0d) {
                            this.mRenderPaint.setStyle(Paint.Style.STROKE);
                            this.mRenderPaint.setStrokeWidth(f12);
                            float[] fArr = scatterBuffer.buffer;
                            float f14 = fArr[i15];
                            float f15 = fArr[i16];
                            float f16 = f14 + convertDpToPixel2 + f13;
                            float f17 = f16;
                            i10 = i15;
                            i11 = i13;
                            canvas.drawRect((f14 - convertDpToPixel2) - f13, (f15 - convertDpToPixel2) - f13, f17, f15 + convertDpToPixel2 + f13, this.mRenderPaint);
                            if (scatterShapeHoleColor != i11) {
                                this.mRenderPaint.setStyle(Paint.Style.FILL);
                                this.mRenderPaint.setColor(scatterShapeHoleColor);
                                float[] fArr2 = scatterBuffer.buffer;
                                float f18 = fArr2[i10];
                                float f19 = fArr2[i16];
                                canvas.drawRect(f18 - convertDpToPixel2, f19 - convertDpToPixel2, f18 + convertDpToPixel2, f19 + convertDpToPixel2, this.mRenderPaint);
                            }
                        } else {
                            i10 = i15;
                            i11 = i13;
                            this.mRenderPaint.setStyle(Paint.Style.FILL);
                            float[] fArr3 = scatterBuffer.buffer;
                            float f20 = fArr3[i10];
                            float f21 = fArr3[i16];
                            canvas.drawRect(f20 - f10, f21 - f10, f20 + f10, f21 + f10, this.mRenderPaint);
                        }
                        i15 = i10 + 2;
                        i13 = i11;
                        Canvas canvas3 = canvas;
                    }
                }
                i10 = i15;
                i11 = i13;
                i15 = i10 + 2;
                i13 = i11;
                Canvas canvas32 = canvas;
            }
        } else if (i12 == 2) {
            while (i14 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i14])) {
                if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i14])) {
                    int i17 = i14 + 1;
                    if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i17])) {
                        this.mRenderPaint.setColor(iScatterDataSet2.getColor(i14 / 2));
                        if (((double) f11) > 0.0d) {
                            this.mRenderPaint.setStyle(Paint.Style.STROKE);
                            this.mRenderPaint.setStrokeWidth(f12);
                            float[] fArr4 = scatterBuffer.buffer;
                            Canvas canvas4 = canvas;
                            canvas4.drawCircle(fArr4[i14], fArr4[i17], convertDpToPixel2 + f13, this.mRenderPaint);
                            if (scatterShapeHoleColor != -1) {
                                this.mRenderPaint.setStyle(Paint.Style.FILL);
                                this.mRenderPaint.setColor(scatterShapeHoleColor);
                                float[] fArr5 = scatterBuffer.buffer;
                                canvas4.drawCircle(fArr5[i14], fArr5[i17], convertDpToPixel2, this.mRenderPaint);
                            }
                        } else {
                            this.mRenderPaint.setStyle(Paint.Style.FILL);
                            float[] fArr6 = scatterBuffer.buffer;
                            canvas.drawCircle(fArr6[i14], fArr6[i17], f10, this.mRenderPaint);
                        }
                    }
                }
                i14 += 2;
            }
        } else if (i12 == 3) {
            this.mRenderPaint.setStyle(Paint.Style.FILL);
            Path path = new Path();
            while (i14 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i14])) {
                if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i14])) {
                    int i18 = i14 + 1;
                    if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i18])) {
                        this.mRenderPaint.setColor(iScatterDataSet2.getColor(i14 / 2));
                        float[] fArr7 = scatterBuffer.buffer;
                        path.moveTo(fArr7[i14], fArr7[i18] - f10);
                        float[] fArr8 = scatterBuffer.buffer;
                        path.lineTo(fArr8[i14] + f10, fArr8[i18] + f10);
                        float[] fArr9 = scatterBuffer.buffer;
                        path.lineTo(fArr9[i14] - f10, fArr9[i18] + f10);
                        int i19 = (((double) f11) > 0.0d ? 1 : (((double) f11) == 0.0d ? 0 : -1));
                        if (i19 > 0) {
                            float[] fArr10 = scatterBuffer.buffer;
                            path.lineTo(fArr10[i14], fArr10[i18] - f10);
                            float[] fArr11 = scatterBuffer.buffer;
                            path.moveTo((fArr11[i14] - f10) + f12, (fArr11[i18] + f10) - f12);
                            float[] fArr12 = scatterBuffer.buffer;
                            path.lineTo((fArr12[i14] + f10) - f12, (fArr12[i18] + f10) - f12);
                            float[] fArr13 = scatterBuffer.buffer;
                            path.lineTo(fArr13[i14], (fArr13[i18] - f10) + f12);
                            float[] fArr14 = scatterBuffer.buffer;
                            path.lineTo((fArr14[i14] - f10) + f12, (fArr14[i18] + f10) - f12);
                        }
                        path.close();
                        canvas2.drawPath(path, this.mRenderPaint);
                        path.reset();
                        if (i19 > 0 && scatterShapeHoleColor != -1) {
                            this.mRenderPaint.setColor(scatterShapeHoleColor);
                            float[] fArr15 = scatterBuffer.buffer;
                            path.moveTo(fArr15[i14], (fArr15[i18] - f10) + f12);
                            float[] fArr16 = scatterBuffer.buffer;
                            path.lineTo((fArr16[i14] + f10) - f12, (fArr16[i18] + f10) - f12);
                            float[] fArr17 = scatterBuffer.buffer;
                            path.lineTo((fArr17[i14] - f10) + f12, (fArr17[i18] + f10) - f12);
                            path.close();
                            canvas2.drawPath(path, this.mRenderPaint);
                            path.reset();
                        }
                    }
                }
                i14 += 2;
            }
        } else if (i12 == 4) {
            this.mRenderPaint.setStyle(Paint.Style.STROKE);
            this.mRenderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
            int i20 = 0;
            while (i20 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i20])) {
                if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i20])) {
                    int i21 = i20 + 1;
                    if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i21])) {
                        this.mRenderPaint.setColor(iScatterDataSet2.getColor(i20 / 2));
                        float[] fArr18 = scatterBuffer.buffer;
                        float f22 = fArr18[i20];
                        float f23 = fArr18[i21];
                        canvas.drawLine(f22 - f10, f23, f22 + f10, f23, this.mRenderPaint);
                        float[] fArr19 = scatterBuffer.buffer;
                        float f24 = fArr19[i20];
                        float f25 = fArr19[i21];
                        canvas.drawLine(f24, f25 - f10, f24, f25 + f10, this.mRenderPaint);
                    }
                }
                i20 += 2;
            }
        } else if (i12 == 5) {
            this.mRenderPaint.setStyle(Paint.Style.STROKE);
            this.mRenderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
            int i22 = 0;
            while (i22 < scatterBuffer.size() && this.mViewPortHandler.isInBoundsRight(scatterBuffer.buffer[i22])) {
                if (this.mViewPortHandler.isInBoundsLeft(scatterBuffer.buffer[i22])) {
                    int i23 = i22 + 1;
                    if (this.mViewPortHandler.isInBoundsY(scatterBuffer.buffer[i23])) {
                        this.mRenderPaint.setColor(iScatterDataSet2.getColor(i22 / 2));
                        float[] fArr20 = scatterBuffer.buffer;
                        float f26 = fArr20[i22];
                        float f27 = fArr20[i23];
                        canvas.drawLine(f26 - f10, f27 - f10, f26 + f10, f27 + f10, this.mRenderPaint);
                        float[] fArr21 = scatterBuffer.buffer;
                        float f28 = fArr21[i22];
                        float f29 = fArr21[i23];
                        canvas.drawLine(f28 + f10, f29 - f10, f28 - f10, f29 + f10, this.mRenderPaint);
                    }
                }
                i22 += 2;
            }
        }
    }

    public void drawExtras(Canvas canvas) {
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        for (int i10 = 0; i10 < highlightArr.length; i10++) {
            IScatterDataSet iScatterDataSet = (IScatterDataSet) this.mChart.getScatterData().getDataSetByIndex(highlightArr[i10].getDataSetIndex());
            if (iScatterDataSet != null && iScatterDataSet.isHighlightEnabled()) {
                int xIndex = highlightArr[i10].getXIndex();
                float f10 = (float) xIndex;
                if (f10 <= this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) {
                    float yValForXIndex = iScatterDataSet.getYValForXIndex(xIndex);
                    if (yValForXIndex != Float.NaN) {
                        float[] fArr = {f10, yValForXIndex * this.mAnimator.getPhaseY()};
                        this.mChart.getTransformer(iScatterDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                        drawHighlightLines(canvas, fArr, iScatterDataSet);
                    }
                }
            }
        }
    }

    public void drawValues(Canvas canvas) {
        int i10;
        if (((float) this.mChart.getScatterData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX()) {
            List dataSets = this.mChart.getScatterData().getDataSets();
            for (int i11 = 0; i11 < this.mChart.getScatterData().getDataSetCount(); i11++) {
                IScatterDataSet iScatterDataSet = (IScatterDataSet) dataSets.get(i11);
                if (iScatterDataSet.isDrawValuesEnabled() && iScatterDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iScatterDataSet);
                    float[] generateTransformedValuesScatter = this.mChart.getTransformer(iScatterDataSet.getAxisDependency()).generateTransformedValuesScatter(iScatterDataSet, this.mAnimator.getPhaseY());
                    float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeSize());
                    int i12 = 0;
                    while (((float) i12) < ((float) generateTransformedValuesScatter.length) * this.mAnimator.getPhaseX() && this.mViewPortHandler.isInBoundsRight(generateTransformedValuesScatter[i12])) {
                        if (this.mViewPortHandler.isInBoundsLeft(generateTransformedValuesScatter[i12])) {
                            int i13 = i12 + 1;
                            if (this.mViewPortHandler.isInBoundsY(generateTransformedValuesScatter[i13])) {
                                int i14 = i12 / 2;
                                Entry entryForIndex = iScatterDataSet.getEntryForIndex(i14);
                                i10 = i12;
                                drawValue(canvas, iScatterDataSet.getValueFormatter(), entryForIndex.getVal(), entryForIndex, i11, generateTransformedValuesScatter[i12], generateTransformedValuesScatter[i13] - convertDpToPixel, iScatterDataSet.getValueTextColor(i14));
                                i12 = i10 + 2;
                            }
                        }
                        i10 = i12;
                        i12 = i10 + 2;
                    }
                }
            }
        }
    }

    public void initBuffers() {
        ScatterData scatterData = this.mChart.getScatterData();
        this.mScatterBuffers = new ScatterBuffer[scatterData.getDataSetCount()];
        for (int i10 = 0; i10 < this.mScatterBuffers.length; i10++) {
            this.mScatterBuffers[i10] = new ScatterBuffer(((IScatterDataSet) scatterData.getDataSetByIndex(i10)).getEntryCount() * 2);
        }
    }
}
