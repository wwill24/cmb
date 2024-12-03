package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

public class Transformer {
    private Matrix mMBuffer1 = new Matrix();
    private Matrix mMBuffer2 = new Matrix();
    protected Matrix mMatrixOffset = new Matrix();
    protected Matrix mMatrixValueToPx = new Matrix();
    protected ViewPortHandler mViewPortHandler;

    public Transformer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }

    public float[] generateTransformedValuesBarChart(IBarDataSet iBarDataSet, int i10, BarData barData, float f10) {
        int entryCount = iBarDataSet.getEntryCount() * 2;
        float[] fArr = new float[entryCount];
        int dataSetCount = barData.getDataSetCount();
        float groupSpace = barData.getGroupSpace();
        for (int i11 = 0; i11 < entryCount; i11 += 2) {
            Entry entryForIndex = iBarDataSet.getEntryForIndex(i11 / 2);
            int xIndex = entryForIndex.getXIndex();
            float val = entryForIndex.getVal();
            fArr[i11] = ((float) (entryForIndex.getXIndex() + ((dataSetCount - 1) * xIndex) + i10)) + (((float) xIndex) * groupSpace) + (groupSpace / 2.0f);
            fArr[i11 + 1] = val * f10;
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesBubble(IBubbleDataSet iBubbleDataSet, float f10, float f11, int i10, int i11) {
        int ceil = ((int) Math.ceil((double) (i11 - i10))) * 2;
        float[] fArr = new float[ceil];
        for (int i12 = 0; i12 < ceil; i12 += 2) {
            Entry entryForIndex = iBubbleDataSet.getEntryForIndex((i12 / 2) + i10);
            if (entryForIndex != null) {
                fArr[i12] = (((float) (entryForIndex.getXIndex() - i10)) * f10) + ((float) i10);
                fArr[i12 + 1] = entryForIndex.getVal() * f11;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesCandle(ICandleDataSet iCandleDataSet, float f10, float f11, int i10, int i11) {
        int ceil = ((int) Math.ceil((double) (((float) (i11 - i10)) * f10))) * 2;
        float[] fArr = new float[ceil];
        for (int i12 = 0; i12 < ceil; i12 += 2) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex((i12 / 2) + i10);
            if (candleEntry != null) {
                fArr[i12] = (float) candleEntry.getXIndex();
                fArr[i12 + 1] = candleEntry.getHigh() * f11;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesHorizontalBarChart(IBarDataSet iBarDataSet, int i10, BarData barData, float f10) {
        int entryCount = iBarDataSet.getEntryCount() * 2;
        float[] fArr = new float[entryCount];
        int dataSetCount = barData.getDataSetCount();
        float groupSpace = barData.getGroupSpace();
        for (int i11 = 0; i11 < entryCount; i11 += 2) {
            Entry entryForIndex = iBarDataSet.getEntryForIndex(i11 / 2);
            int xIndex = entryForIndex.getXIndex();
            fArr[i11] = entryForIndex.getVal() * f10;
            fArr[i11 + 1] = ((float) (((dataSetCount - 1) * xIndex) + xIndex + i10)) + (((float) xIndex) * groupSpace) + (groupSpace / 2.0f);
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesLine(ILineDataSet iLineDataSet, float f10, float f11, int i10, int i11) {
        int ceil = ((int) Math.ceil((double) (((float) (i11 - i10)) * f10))) * 2;
        float[] fArr = new float[ceil];
        for (int i12 = 0; i12 < ceil; i12 += 2) {
            Entry entryForIndex = iLineDataSet.getEntryForIndex((i12 / 2) + i10);
            if (entryForIndex != null) {
                fArr[i12] = (float) entryForIndex.getXIndex();
                fArr[i12 + 1] = entryForIndex.getVal() * f11;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesScatter(IScatterDataSet iScatterDataSet, float f10) {
        int entryCount = iScatterDataSet.getEntryCount() * 2;
        float[] fArr = new float[entryCount];
        for (int i10 = 0; i10 < entryCount; i10 += 2) {
            Entry entryForIndex = iScatterDataSet.getEntryForIndex(i10 / 2);
            if (entryForIndex != null) {
                fArr[i10] = (float) entryForIndex.getXIndex();
                fArr[i10 + 1] = entryForIndex.getVal() * f10;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public Matrix getOffsetMatrix() {
        return this.mMatrixOffset;
    }

    public Matrix getPixelToValueMatrix() {
        getValueToPixelMatrix().invert(this.mMBuffer2);
        return this.mMBuffer2;
    }

    public Matrix getValueMatrix() {
        return this.mMatrixValueToPx;
    }

    public Matrix getValueToPixelMatrix() {
        this.mMBuffer1.set(this.mMatrixValueToPx);
        this.mMBuffer1.postConcat(this.mViewPortHandler.mMatrixTouch);
        this.mMBuffer1.postConcat(this.mMatrixOffset);
        return this.mMBuffer1;
    }

    public PointD getValuesByTouchPoint(float f10, float f11) {
        float[] fArr = {f10, f11};
        pixelsToValue(fArr);
        return new PointD((double) fArr[0], (double) fArr[1]);
    }

    public void pathValueToPixel(Path path) {
        path.transform(this.mMatrixValueToPx);
        path.transform(this.mViewPortHandler.getMatrixTouch());
        path.transform(this.mMatrixOffset);
    }

    public void pathValuesToPixel(List<Path> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            pathValueToPixel(list.get(i10));
        }
    }

    public void pixelsToValue(float[] fArr) {
        Matrix matrix = new Matrix();
        this.mMatrixOffset.invert(matrix);
        matrix.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().invert(matrix);
        matrix.mapPoints(fArr);
        this.mMatrixValueToPx.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void pointValuesToPixel(float[] fArr) {
        this.mMatrixValueToPx.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().mapPoints(fArr);
        this.mMatrixOffset.mapPoints(fArr);
    }

    public void prepareMatrixOffset(boolean z10) {
        this.mMatrixOffset.reset();
        if (!z10) {
            this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
            return;
        }
        this.mMatrixOffset.setTranslate(this.mViewPortHandler.offsetLeft(), -this.mViewPortHandler.offsetTop());
        this.mMatrixOffset.postScale(1.0f, -1.0f);
    }

    public void prepareMatrixValuePx(float f10, float f11, float f12, float f13) {
        float contentWidth = this.mViewPortHandler.contentWidth() / f11;
        float contentHeight = this.mViewPortHandler.contentHeight() / f12;
        if (Float.isInfinite(contentWidth)) {
            contentWidth = 0.0f;
        }
        if (Float.isInfinite(contentHeight)) {
            contentHeight = 0.0f;
        }
        this.mMatrixValueToPx.reset();
        this.mMatrixValueToPx.postTranslate(-f10, -f13);
        this.mMatrixValueToPx.postScale(contentWidth, -contentHeight);
    }

    public void rectValueToPixel(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixelHorizontal(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValuesToPixel(List<RectF> list) {
        Matrix valueToPixelMatrix = getValueToPixelMatrix();
        for (int i10 = 0; i10 < list.size(); i10++) {
            valueToPixelMatrix.mapRect(list.get(i10));
        }
    }

    public void rectValueToPixel(RectF rectF, float f10) {
        rectF.top *= f10;
        rectF.bottom *= f10;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixelHorizontal(RectF rectF, float f10) {
        rectF.left *= f10;
        rectF.right *= f10;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }
}
