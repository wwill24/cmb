package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler {
    protected float mChartHeight = 0.0f;
    protected float mChartWidth = 0.0f;
    protected RectF mContentRect = new RectF();
    protected final Matrix mMatrixTouch = new Matrix();
    private float mMaxScaleX = Float.MAX_VALUE;
    private float mMaxScaleY = Float.MAX_VALUE;
    private float mMinScaleX = 1.0f;
    private float mMinScaleY = 1.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mTransOffsetX = 0.0f;
    private float mTransOffsetY = 0.0f;
    private float mTransX = 0.0f;
    private float mTransY = 0.0f;
    protected final float[] matrixBuffer = new float[9];

    public boolean canZoomInMoreX() {
        return this.mScaleX < this.mMaxScaleX;
    }

    public boolean canZoomOutMoreX() {
        return this.mScaleX > this.mMinScaleX;
    }

    public void centerViewPort(float[] fArr, View view) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
        refresh(matrix, view, true);
    }

    public float contentBottom() {
        return this.mContentRect.bottom;
    }

    public float contentHeight() {
        return this.mContentRect.height();
    }

    public float contentLeft() {
        return this.mContentRect.left;
    }

    public float contentRight() {
        return this.mContentRect.right;
    }

    public float contentTop() {
        return this.mContentRect.top;
    }

    public float contentWidth() {
        return this.mContentRect.width();
    }

    public Matrix fitScreen() {
        this.mMinScaleX = 1.0f;
        this.mMinScaleY = 1.0f;
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
        return matrix;
    }

    public float getChartHeight() {
        return this.mChartHeight;
    }

    public float getChartWidth() {
        return this.mChartWidth;
    }

    public PointF getContentCenter() {
        return new PointF(this.mContentRect.centerX(), this.mContentRect.centerY());
    }

    public RectF getContentRect() {
        return this.mContentRect;
    }

    public Matrix getMatrixTouch() {
        return this.mMatrixTouch;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getTransX() {
        return this.mTransX;
    }

    public float getTransY() {
        return this.mTransY;
    }

    public boolean hasChartDimens() {
        return this.mChartHeight > 0.0f && this.mChartWidth > 0.0f;
    }

    public boolean hasNoDragOffset() {
        return this.mTransOffsetX <= 0.0f && this.mTransOffsetY <= 0.0f;
    }

    public boolean isFullyZoomedOut() {
        return isFullyZoomedOutX() && isFullyZoomedOutY();
    }

    public boolean isFullyZoomedOutX() {
        float f10 = this.mScaleX;
        float f11 = this.mMinScaleX;
        return f10 <= f11 && f11 <= 1.0f;
    }

    public boolean isFullyZoomedOutY() {
        float f10 = this.mScaleY;
        float f11 = this.mMinScaleY;
        return f10 <= f11 && f11 <= 1.0f;
    }

    public boolean isInBounds(float f10, float f11) {
        return isInBoundsX(f10) && isInBoundsY(f11);
    }

    public boolean isInBoundsBottom(float f10) {
        return this.mContentRect.bottom >= ((float) ((int) (f10 * 100.0f))) / 100.0f;
    }

    public boolean isInBoundsLeft(float f10) {
        return this.mContentRect.left <= f10;
    }

    public boolean isInBoundsRight(float f10) {
        return this.mContentRect.right >= ((float) ((int) (f10 * 100.0f))) / 100.0f;
    }

    public boolean isInBoundsTop(float f10) {
        return this.mContentRect.top <= f10;
    }

    public boolean isInBoundsX(float f10) {
        return isInBoundsLeft(f10) && isInBoundsRight(f10);
    }

    public boolean isInBoundsY(float f10) {
        return isInBoundsTop(f10) && isInBoundsBottom(f10);
    }

    public void limitTransAndScale(Matrix matrix, RectF rectF) {
        float f10;
        matrix.getValues(this.matrixBuffer);
        float[] fArr = this.matrixBuffer;
        float f11 = fArr[2];
        float f12 = fArr[0];
        float f13 = fArr[5];
        float f14 = fArr[4];
        this.mScaleX = Math.min(Math.max(this.mMinScaleX, f12), this.mMaxScaleX);
        this.mScaleY = Math.min(Math.max(this.mMinScaleY, f14), this.mMaxScaleY);
        float f15 = 0.0f;
        if (rectF != null) {
            f15 = rectF.width();
            f10 = rectF.height();
        } else {
            f10 = 0.0f;
        }
        this.mTransX = Math.min(Math.max(f11, ((-f15) * (this.mScaleX - 1.0f)) - this.mTransOffsetX), this.mTransOffsetX);
        float max = Math.max(Math.min(f13, (f10 * (this.mScaleY - 1.0f)) + this.mTransOffsetY), -this.mTransOffsetY);
        this.mTransY = max;
        float[] fArr2 = this.matrixBuffer;
        fArr2[2] = this.mTransX;
        fArr2[0] = this.mScaleX;
        fArr2[5] = max;
        fArr2[4] = this.mScaleY;
        matrix.setValues(fArr2);
    }

    public float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public float offsetLeft() {
        return this.mContentRect.left;
    }

    public float offsetRight() {
        return this.mChartWidth - this.mContentRect.right;
    }

    public float offsetTop() {
        return this.mContentRect.top;
    }

    public Matrix refresh(Matrix matrix, View view, boolean z10) {
        this.mMatrixTouch.set(matrix);
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
        if (z10) {
            view.invalidate();
        }
        matrix.set(this.mMatrixTouch);
        return matrix;
    }

    public void restrainViewPort(float f10, float f11, float f12, float f13) {
        this.mContentRect.set(f10, f11, this.mChartWidth - f12, this.mChartHeight - f13);
    }

    public void setChartDimens(float f10, float f11) {
        float offsetLeft = offsetLeft();
        float offsetTop = offsetTop();
        float offsetRight = offsetRight();
        float offsetBottom = offsetBottom();
        this.mChartHeight = f11;
        this.mChartWidth = f10;
        restrainViewPort(offsetLeft, offsetTop, offsetRight, offsetBottom);
    }

    public void setDragOffsetX(float f10) {
        this.mTransOffsetX = Utils.convertDpToPixel(f10);
    }

    public void setDragOffsetY(float f10) {
        this.mTransOffsetY = Utils.convertDpToPixel(f10);
    }

    public void setMaximumScaleX(float f10) {
        this.mMaxScaleX = f10;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleY(float f10) {
        this.mMaxScaleY = f10;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleX(float f10, float f11) {
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        this.mMinScaleX = f10;
        this.mMaxScaleX = f11;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleX(float f10) {
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        this.mMinScaleX = f10;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleY(float f10) {
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        this.mMinScaleY = f10;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public Matrix setZoom(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f10, f11);
        return matrix;
    }

    public Matrix translate(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
        return matrix;
    }

    public Matrix zoom(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f10, f11);
        return matrix;
    }

    public Matrix zoomIn(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.4f, 1.4f, f10, f11);
        return matrix;
    }

    public Matrix zoomOut(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(0.7f, 0.7f, f10, f11);
        return matrix;
    }

    public Matrix setZoom(float f10, float f11, float f12, float f13) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f10, f11, f12, f13);
        return matrix;
    }

    public Matrix zoom(float f10, float f11, float f12, float f13) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f10, f11, f12, f13);
        return matrix;
    }
}
