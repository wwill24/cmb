package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.CircleBuffer;
import com.github.mikephil.charting.buffer.LineBuffer;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

public class LineChartRenderer extends LineRadarRenderer {
    protected Path cubicFillPath = new Path();
    protected Path cubicPath = new Path();
    protected Canvas mBitmapCanvas;
    protected Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    protected LineDataProvider mChart;
    protected CircleBuffer[] mCircleBuffers;
    protected Paint mCirclePaintInner;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected LineBuffer[] mLineBuffers;

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = lineDataProvider;
        Paint paint = new Paint(1);
        this.mCirclePaintInner = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCirclePaintInner.setColor(-1);
    }

    private Path generateFilledPath(ILineDataSet iLineDataSet, int i10, int i11) {
        float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        Path path = new Path();
        Entry entryForIndex = iLineDataSet.getEntryForIndex(i10);
        path.moveTo((float) entryForIndex.getXIndex(), fillLinePosition);
        path.lineTo((float) entryForIndex.getXIndex(), entryForIndex.getVal() * phaseY);
        double d10 = (double) ((((float) (i11 - i10)) * phaseX) + ((float) i10));
        int ceil = (int) Math.ceil(d10);
        for (int i12 = i10 + 1; i12 < ceil; i12++) {
            Entry entryForIndex2 = iLineDataSet.getEntryForIndex(i12);
            path.lineTo((float) entryForIndex2.getXIndex(), entryForIndex2.getVal() * phaseY);
        }
        path.lineTo((float) iLineDataSet.getEntryForIndex(Math.max(Math.min(((int) Math.ceil(d10)) - 1, iLineDataSet.getEntryCount() - 1), 0)).getXIndex(), fillLinePosition);
        path.close();
        return path;
    }

    /* access modifiers changed from: protected */
    public void drawCircles(Canvas canvas) {
        float f10;
        Canvas canvas2 = canvas;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        List dataSets = this.mChart.getLineData().getDataSets();
        int i10 = 0;
        int i11 = 0;
        while (i11 < dataSets.size()) {
            ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i11);
            if (iLineDataSet.isVisible() && iLineDataSet.isDrawCirclesEnabled() && iLineDataSet.getEntryCount() != 0) {
                this.mCirclePaintInner.setColor(iLineDataSet.getCircleHoleColor());
                Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
                int entryCount = iLineDataSet.getEntryCount();
                int i12 = this.mMinX;
                if (i12 < 0) {
                    i12 = i10;
                }
                Entry entryForXIndex = iLineDataSet.getEntryForXIndex(i12, DataSet.Rounding.DOWN);
                Entry entryForXIndex2 = iLineDataSet.getEntryForXIndex(this.mMaxX, DataSet.Rounding.UP);
                int max = Math.max(iLineDataSet.getEntryIndex(entryForXIndex), i10);
                int min = Math.min(iLineDataSet.getEntryIndex(entryForXIndex2) + 1, entryCount);
                CircleBuffer circleBuffer = this.mCircleBuffers[i11];
                circleBuffer.setPhases(phaseX, phaseY);
                circleBuffer.limitFrom(max);
                circleBuffer.limitTo(min);
                circleBuffer.feed(iLineDataSet);
                transformer.pointValuesToPixel(circleBuffer.buffer);
                float circleRadius = iLineDataSet.getCircleRadius() / 2.0f;
                int ceil = ((int) Math.ceil((double) ((((float) (min - max)) * phaseX) + ((float) max)))) * 2;
                int i13 = i10;
                while (i13 < ceil) {
                    float[] fArr = circleBuffer.buffer;
                    float f11 = fArr[i13];
                    float f12 = fArr[i13 + 1];
                    if (!this.mViewPortHandler.isInBoundsRight(f11)) {
                        break;
                    }
                    if (!this.mViewPortHandler.isInBoundsLeft(f11) || !this.mViewPortHandler.isInBoundsY(f12)) {
                        f10 = phaseX;
                    } else {
                        int circleColor = iLineDataSet.getCircleColor((i13 / 2) + max);
                        this.mRenderPaint.setColor(circleColor);
                        f10 = phaseX;
                        canvas2.drawCircle(f11, f12, iLineDataSet.getCircleRadius(), this.mRenderPaint);
                        if (iLineDataSet.isDrawCircleHoleEnabled() && circleColor != this.mCirclePaintInner.getColor()) {
                            canvas2.drawCircle(f11, f12, circleRadius, this.mCirclePaintInner);
                        }
                    }
                    i13 += 2;
                    phaseX = f10;
                }
            }
            i11++;
            phaseX = phaseX;
            i10 = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void drawCubic(Canvas canvas, ILineDataSet iLineDataSet) {
        int i10;
        int i11;
        int i12;
        ILineDataSet iLineDataSet2 = iLineDataSet;
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        int entryCount = iLineDataSet.getEntryCount();
        int i13 = this.mMinX;
        if (i13 < 0) {
            i13 = 0;
        }
        Entry entryForXIndex = iLineDataSet2.getEntryForXIndex(i13, DataSet.Rounding.DOWN);
        Entry entryForXIndex2 = iLineDataSet2.getEntryForXIndex(this.mMaxX, DataSet.Rounding.UP);
        if (entryForXIndex == entryForXIndex2) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        int max = Math.max((iLineDataSet2.getEntryIndex(entryForXIndex) - i10) - 1, 0);
        int min = Math.min(iLineDataSet2.getEntryIndex(entryForXIndex2) + 1, entryCount);
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float cubicIntensity = iLineDataSet.getCubicIntensity();
        this.cubicPath.reset();
        int ceil = (int) Math.ceil((double) ((((float) (min - max)) * phaseX) + ((float) max)));
        if (ceil - max >= 2) {
            Entry entryForIndex = iLineDataSet2.getEntryForIndex(max);
            int i14 = max + 1;
            Entry entryForIndex2 = iLineDataSet2.getEntryForIndex(i14);
            this.cubicPath.moveTo((float) entryForIndex.getXIndex(), entryForIndex.getVal() * phaseY);
            this.cubicPath.cubicTo(((float) entryForIndex.getXIndex()) + (((float) (entryForIndex.getXIndex() - entryForIndex.getXIndex())) * cubicIntensity), (entryForIndex.getVal() + ((entryForIndex.getVal() - entryForIndex.getVal()) * cubicIntensity)) * phaseY, ((float) entryForIndex.getXIndex()) - (((float) (entryForIndex2.getXIndex() - entryForIndex.getXIndex())) * cubicIntensity), (entryForIndex.getVal() - ((entryForIndex2.getVal() - entryForIndex.getVal()) * cubicIntensity)) * phaseY, (float) entryForIndex.getXIndex(), entryForIndex.getVal() * phaseY);
            int i15 = entryCount - 1;
            int min2 = Math.min(ceil, i15);
            while (i14 < min2) {
                if (i14 == 1) {
                    i12 = 0;
                } else {
                    i12 = i14 - 2;
                }
                Entry entryForIndex3 = iLineDataSet2.getEntryForIndex(i12);
                Entry entryForIndex4 = iLineDataSet2.getEntryForIndex(i14 - 1);
                Entry entryForIndex5 = iLineDataSet2.getEntryForIndex(i14);
                int i16 = i14 + 1;
                Entry entryForIndex6 = iLineDataSet2.getEntryForIndex(i16);
                int i17 = min2;
                this.cubicPath.cubicTo(((float) entryForIndex4.getXIndex()) + (((float) (entryForIndex5.getXIndex() - entryForIndex3.getXIndex())) * cubicIntensity), (entryForIndex4.getVal() + ((entryForIndex5.getVal() - entryForIndex3.getVal()) * cubicIntensity)) * phaseY, ((float) entryForIndex5.getXIndex()) - (((float) (entryForIndex6.getXIndex() - entryForIndex4.getXIndex())) * cubicIntensity), (entryForIndex5.getVal() - ((entryForIndex6.getVal() - entryForIndex4.getVal()) * cubicIntensity)) * phaseY, (float) entryForIndex5.getXIndex(), entryForIndex5.getVal() * phaseY);
                min2 = i17;
                i14 = i16;
            }
            if (ceil > i15) {
                if (entryCount >= 3) {
                    i11 = entryCount - 3;
                } else {
                    i11 = entryCount - 2;
                }
                Entry entryForIndex7 = iLineDataSet2.getEntryForIndex(i11);
                Entry entryForIndex8 = iLineDataSet2.getEntryForIndex(entryCount - 2);
                Entry entryForIndex9 = iLineDataSet2.getEntryForIndex(i15);
                this.cubicPath.cubicTo(((float) entryForIndex8.getXIndex()) + (((float) (entryForIndex9.getXIndex() - entryForIndex7.getXIndex())) * cubicIntensity), (entryForIndex8.getVal() + ((entryForIndex9.getVal() - entryForIndex7.getVal()) * cubicIntensity)) * phaseY, ((float) entryForIndex9.getXIndex()) - (((float) (entryForIndex9.getXIndex() - entryForIndex8.getXIndex())) * cubicIntensity), (entryForIndex9.getVal() - ((entryForIndex9.getVal() - entryForIndex8.getVal()) * cubicIntensity)) * phaseY, (float) entryForIndex9.getXIndex(), entryForIndex9.getVal() * phaseY);
            }
        }
        if (iLineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(this.mBitmapCanvas, iLineDataSet, this.cubicFillPath, transformer, entryForXIndex.getXIndex(), entryForXIndex.getXIndex() + ceil);
        }
        this.mRenderPaint.setColor(iLineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        transformer.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void drawCubicFill(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, int i10, int i11) {
        float f10;
        if (i11 - i10 > 1) {
            float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
            Entry entryForIndex = iLineDataSet.getEntryForIndex(i11 - 1);
            Entry entryForIndex2 = iLineDataSet.getEntryForIndex(i10);
            float f11 = 0.0f;
            if (entryForIndex == null) {
                f10 = 0.0f;
            } else {
                f10 = (float) entryForIndex.getXIndex();
            }
            if (entryForIndex2 != null) {
                f11 = (float) entryForIndex2.getXIndex();
            }
            path.lineTo(f10, fillLinePosition);
            path.lineTo(f11, fillLinePosition);
            path.close();
            transformer.pathValueToPixel(path);
            Drawable fillDrawable = iLineDataSet.getFillDrawable();
            if (fillDrawable != null) {
                drawFilledPath(canvas, path, fillDrawable);
            } else {
                drawFilledPath(canvas, path, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha());
            }
        }
    }

    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (!(weakReference != null && weakReference.get().getWidth() == chartWidth && this.mDrawBitmap.get().getHeight() == chartHeight)) {
            if (chartWidth > 0 && chartHeight > 0) {
                this.mDrawBitmap = new WeakReference<>(Bitmap.createBitmap(chartWidth, chartHeight, this.mBitmapConfig));
                this.mBitmapCanvas = new Canvas(this.mDrawBitmap.get());
            } else {
                return;
            }
        }
        this.mDrawBitmap.get().eraseColor(0);
        for (ILineDataSet iLineDataSet : this.mChart.getLineData().getDataSets()) {
            if (iLineDataSet.isVisible() && iLineDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iLineDataSet);
            }
        }
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, this.mRenderPaint);
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, ILineDataSet iLineDataSet) {
        if (iLineDataSet.getEntryCount() >= 1) {
            this.mRenderPaint.setStrokeWidth(iLineDataSet.getLineWidth());
            this.mRenderPaint.setPathEffect(iLineDataSet.getDashPathEffect());
            if (iLineDataSet.isDrawCubicEnabled()) {
                drawCubic(canvas, iLineDataSet);
            } else {
                drawLinear(canvas, iLineDataSet);
            }
            this.mRenderPaint.setPathEffect((PathEffect) null);
        }
    }

    public void drawExtras(Canvas canvas) {
        drawCircles(canvas);
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        for (int i10 = 0; i10 < highlightArr.length; i10++) {
            ILineDataSet iLineDataSet = (ILineDataSet) this.mChart.getLineData().getDataSetByIndex(highlightArr[i10].getDataSetIndex());
            if (iLineDataSet != null && iLineDataSet.isHighlightEnabled()) {
                int xIndex = highlightArr[i10].getXIndex();
                float f10 = (float) xIndex;
                if (f10 <= this.mChart.getXChartMax() * this.mAnimator.getPhaseX()) {
                    float yValForXIndex = iLineDataSet.getYValForXIndex(xIndex);
                    if (yValForXIndex != Float.NaN) {
                        float[] fArr = {f10, yValForXIndex * this.mAnimator.getPhaseY()};
                        this.mChart.getTransformer(iLineDataSet.getAxisDependency()).pointValuesToPixel(fArr);
                        drawHighlightLines(canvas, fArr, iLineDataSet);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawLinear(Canvas canvas, ILineDataSet iLineDataSet) {
        Canvas canvas2;
        int i10;
        ILineDataSet iLineDataSet2 = iLineDataSet;
        int entryCount = iLineDataSet.getEntryCount();
        int indexOfDataSet = this.mChart.getLineData().getIndexOfDataSet(iLineDataSet2);
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (iLineDataSet.isDashedLineEnabled()) {
            canvas2 = this.mBitmapCanvas;
        } else {
            canvas2 = canvas;
        }
        int i11 = this.mMinX;
        if (i11 < 0) {
            i11 = 0;
        }
        Entry entryForXIndex = iLineDataSet2.getEntryForXIndex(i11, DataSet.Rounding.DOWN);
        Entry entryForXIndex2 = iLineDataSet2.getEntryForXIndex(this.mMaxX, DataSet.Rounding.UP);
        int max = Math.max(iLineDataSet2.getEntryIndex(entryForXIndex), 0);
        int min = Math.min(iLineDataSet2.getEntryIndex(entryForXIndex2) + 1, entryCount);
        int i12 = ((min - max) * 4) - 4;
        LineBuffer lineBuffer = this.mLineBuffers[indexOfDataSet];
        lineBuffer.setPhases(phaseX, phaseY);
        lineBuffer.limitFrom(max);
        lineBuffer.limitTo(min);
        lineBuffer.feed(iLineDataSet2);
        transformer.pointValuesToPixel(lineBuffer.buffer);
        if (iLineDataSet.getColors().size() > 1) {
            int i13 = 0;
            while (i13 < i12 && this.mViewPortHandler.isInBoundsRight(lineBuffer.buffer[i13])) {
                int i14 = i13 + 2;
                if (this.mViewPortHandler.isInBoundsLeft(lineBuffer.buffer[i14])) {
                    int i15 = i13 + 1;
                    if ((this.mViewPortHandler.isInBoundsTop(lineBuffer.buffer[i15]) || this.mViewPortHandler.isInBoundsBottom(lineBuffer.buffer[i13 + 3])) && (this.mViewPortHandler.isInBoundsTop(lineBuffer.buffer[i15]) || this.mViewPortHandler.isInBoundsBottom(lineBuffer.buffer[i13 + 3]))) {
                        this.mRenderPaint.setColor(iLineDataSet2.getColor((i13 / 4) + max));
                        float[] fArr = lineBuffer.buffer;
                        float f10 = fArr[i13];
                        float f11 = fArr[i15];
                        float f12 = fArr[i14];
                        float f13 = f10;
                        float f14 = f12;
                        float f15 = fArr[i13 + 3];
                        i10 = i12;
                        canvas2.drawLine(f13, f11, f14, f15, this.mRenderPaint);
                        i13 += 4;
                        i12 = i10;
                    }
                }
                i10 = i12;
                i13 += 4;
                i12 = i10;
            }
        } else {
            this.mRenderPaint.setColor(iLineDataSet.getColor());
            canvas2.drawLines(lineBuffer.buffer, 0, i12, this.mRenderPaint);
        }
        this.mRenderPaint.setPathEffect((PathEffect) null);
        if (iLineDataSet.isDrawFilledEnabled() && entryCount > 0) {
            drawLinearFill(canvas, iLineDataSet, max, min, transformer);
        }
    }

    /* access modifiers changed from: protected */
    public void drawLinearFill(Canvas canvas, ILineDataSet iLineDataSet, int i10, int i11, Transformer transformer) {
        Path generateFilledPath = generateFilledPath(iLineDataSet, i10, i11);
        transformer.pathValueToPixel(generateFilledPath);
        Drawable fillDrawable = iLineDataSet.getFillDrawable();
        if (fillDrawable != null) {
            drawFilledPath(canvas, generateFilledPath, fillDrawable);
        } else {
            drawFilledPath(canvas, generateFilledPath, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha());
        }
    }

    public void drawValues(Canvas canvas) {
        int i10;
        float[] fArr;
        if (((float) this.mChart.getLineData().getYValCount()) < ((float) this.mChart.getMaxVisibleCount()) * this.mViewPortHandler.getScaleX()) {
            List dataSets = this.mChart.getLineData().getDataSets();
            for (int i11 = 0; i11 < dataSets.size(); i11++) {
                ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i11);
                if (iLineDataSet.isDrawValuesEnabled() && iLineDataSet.getEntryCount() != 0) {
                    applyValueTextStyle(iLineDataSet);
                    Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
                    int circleRadius = (int) (iLineDataSet.getCircleRadius() * 1.75f);
                    if (!iLineDataSet.isDrawCirclesEnabled()) {
                        circleRadius /= 2;
                    }
                    int i12 = circleRadius;
                    int entryCount = iLineDataSet.getEntryCount();
                    int i13 = this.mMinX;
                    if (i13 < 0) {
                        i13 = 0;
                    }
                    Entry entryForXIndex = iLineDataSet.getEntryForXIndex(i13, DataSet.Rounding.DOWN);
                    Entry entryForXIndex2 = iLineDataSet.getEntryForXIndex(this.mMaxX, DataSet.Rounding.UP);
                    int max = Math.max(iLineDataSet.getEntryIndex(entryForXIndex), 0);
                    float[] generateTransformedValuesLine = transformer.generateTransformedValuesLine(iLineDataSet, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), max, Math.min(iLineDataSet.getEntryIndex(entryForXIndex2) + 1, entryCount));
                    int i14 = 0;
                    while (i14 < generateTransformedValuesLine.length) {
                        float f10 = generateTransformedValuesLine[i14];
                        float f11 = generateTransformedValuesLine[i14 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f10)) {
                            break;
                        }
                        if (!this.mViewPortHandler.isInBoundsLeft(f10) || !this.mViewPortHandler.isInBoundsY(f11)) {
                            i10 = i14;
                            fArr = generateTransformedValuesLine;
                        } else {
                            int i15 = i14 / 2;
                            Entry entryForIndex = iLineDataSet.getEntryForIndex(i15 + max);
                            i10 = i14;
                            fArr = generateTransformedValuesLine;
                            drawValue(canvas, iLineDataSet.getValueFormatter(), entryForIndex.getVal(), entryForIndex, i11, f10, f11 - ((float) i12), iLineDataSet.getValueTextColor(i15));
                        }
                        i14 = i10 + 2;
                        generateTransformedValuesLine = fArr;
                    }
                }
            }
        }
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public void initBuffers() {
        LineData lineData = this.mChart.getLineData();
        this.mLineBuffers = new LineBuffer[lineData.getDataSetCount()];
        this.mCircleBuffers = new CircleBuffer[lineData.getDataSetCount()];
        for (int i10 = 0; i10 < this.mLineBuffers.length; i10++) {
            ILineDataSet iLineDataSet = (ILineDataSet) lineData.getDataSetByIndex(i10);
            this.mLineBuffers[i10] = new LineBuffer((iLineDataSet.getEntryCount() * 4) - 4);
            this.mCircleBuffers[i10] = new CircleBuffer(iLineDataSet.getEntryCount() * 2);
        }
    }

    public void releaseBitmap() {
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            weakReference.get().recycle();
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        releaseBitmap();
    }
}
