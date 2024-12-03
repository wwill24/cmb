package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds = new RectF();
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    private Path mHoleCirclePath = new Path();
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer = new RectF();
    private Path mPathBuffer = new Path();
    private RectF[] mRectBuffer = {new RectF(), new RectF(), new RectF()};
    protected Paint mTransparentCirclePaint;

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(-16777216);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
    }

    /* access modifiers changed from: protected */
    public float calculateMinimumRadiusForSpacedSlice(PointF pointF, float f10, float f11, float f12, float f13, float f14, float f15) {
        PointF pointF2 = pointF;
        double d10 = (double) ((f14 + f15) * 0.017453292f);
        float cos = pointF2.x + (((float) Math.cos(d10)) * f10);
        float sin = pointF2.y + (((float) Math.sin(d10)) * f10);
        double d11 = (double) ((f14 + (f15 / 2.0f)) * 0.017453292f);
        return (float) (((double) (f10 - ((float) ((Math.sqrt(Math.pow((double) (cos - f12), 2.0d) + Math.pow((double) (sin - f13), 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f11)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((double) ((pointF2.x + (((float) Math.cos(d11)) * f10)) - ((cos + f12) / 2.0f)), 2.0d) + Math.pow((double) ((pointF2.y + (((float) Math.sin(d11)) * f10)) - ((sin + f13) / 2.0f)), 2.0d)));
    }

    /* access modifiers changed from: protected */
    public void drawCenterText(Canvas canvas) {
        float f10;
        CharSequence centerText = this.mChart.getCenterText();
        if (this.mChart.isDrawCenterTextEnabled() && centerText != null) {
            PointF centerCircleBox = this.mChart.getCenterCircleBox();
            if (!this.mChart.isDrawHoleEnabled() || this.mChart.isDrawSlicesUnderHoleEnabled()) {
                f10 = this.mChart.getRadius();
            } else {
                f10 = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
            }
            RectF[] rectFArr = this.mRectBuffer;
            RectF rectF = rectFArr[0];
            float f11 = centerCircleBox.x;
            rectF.left = f11 - f10;
            float f12 = centerCircleBox.y;
            rectF.top = f12 - f10;
            rectF.right = f11 + f10;
            rectF.bottom = f12 + f10;
            RectF rectF2 = rectFArr[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
            if (((double) centerTextRadiusPercent) > 0.0d) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
                this.mCenterTextLastBounds.set(rectF2);
                this.mCenterTextLastValue = centerText;
                this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil((double) this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            }
            canvas.save();
            Path path = new Path();
            path.addOval(rectF, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - ((float) this.mCenterTextLayout.getHeight())) / 2.0f));
            this.mCenterTextLayout.draw(canvas);
            canvas.restore();
        }
    }

    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (!(weakReference != null && weakReference.get().getWidth() == chartWidth && this.mDrawBitmap.get().getHeight() == chartHeight)) {
            if (chartWidth > 0 && chartHeight > 0) {
                this.mDrawBitmap = new WeakReference<>(Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444));
                this.mBitmapCanvas = new Canvas(this.mDrawBitmap.get());
            } else {
                return;
            }
        }
        this.mDrawBitmap.get().eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        float f10;
        RectF rectF;
        float[] fArr;
        int i10;
        float f11;
        int i11;
        PointF pointF;
        float f12;
        int i12;
        float f13;
        float f14;
        float f15;
        int i13;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = this.mChart.getRotationAngle();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        RectF circleBox = this.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = this.mChart.getDrawAngles();
        float sliceSpace = iPieDataSet.getSliceSpace();
        PointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        if (!this.mChart.isDrawHoleEnabled() || this.mChart.isDrawSlicesUnderHoleEnabled()) {
            f10 = 0.0f;
        } else {
            f10 = (this.mChart.getHoleRadius() / 100.0f) * radius;
        }
        int i14 = 0;
        for (int i15 = 0; i15 < entryCount; i15++) {
            if (((double) Math.abs(iPieDataSet2.getEntryForIndex(i15).getVal())) > 1.0E-6d) {
                i14++;
            }
        }
        int i16 = 0;
        float f21 = 0.0f;
        while (i16 < entryCount) {
            float f22 = drawAngles[i16];
            Entry entryForIndex = iPieDataSet2.getEntryForIndex(i16);
            if (((double) Math.abs(entryForIndex.getVal())) <= 1.0E-6d || this.mChart.needsHighlight(entryForIndex.getXIndex(), ((PieData) this.mChart.getData()).getIndexOfDataSet(iPieDataSet2))) {
                i11 = i16;
                f11 = radius;
                rectF = circleBox;
                i10 = entryCount;
                fArr = drawAngles;
                i12 = i14;
                f12 = f10;
                pointF = centerCircleBox;
                f13 = rotationAngle;
            } else {
                this.mRenderPaint.setColor(iPieDataSet2.getColor(i16));
                if (i14 == 1) {
                    f14 = 0.0f;
                } else {
                    f14 = sliceSpace / (radius * 0.017453292f);
                }
                float f23 = ((f21 + (f14 / 2.0f)) * phaseY) + rotationAngle;
                float f24 = (f22 - f14) * phaseY;
                if (f24 < 0.0f) {
                    f24 = 0.0f;
                }
                this.mPathBuffer.reset();
                int i17 = ((f24 % 360.0f) > 0.0f ? 1 : ((f24 % 360.0f) == 0.0f ? 0 : -1));
                if (i17 == 0) {
                    i11 = i16;
                    i13 = i14;
                    f15 = f10;
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, radius, Path.Direction.CW);
                    i10 = entryCount;
                    fArr = drawAngles;
                    f17 = 0.0f;
                    f16 = 0.0f;
                } else {
                    i11 = i16;
                    i13 = i14;
                    f15 = f10;
                    double d10 = (double) (f23 * 0.017453292f);
                    i10 = entryCount;
                    fArr = drawAngles;
                    float cos = centerCircleBox.x + (((float) Math.cos(d10)) * radius);
                    f16 = centerCircleBox.y + (((float) Math.sin(d10)) * radius);
                    this.mPathBuffer.moveTo(cos, f16);
                    this.mPathBuffer.arcTo(circleBox, f23, f24);
                    f17 = cos;
                }
                if (sliceSpace > 0.0f) {
                    float f25 = radius;
                    rectF = circleBox;
                    i12 = i13;
                    f18 = f15;
                    f11 = radius;
                    float f26 = f23;
                    pointF = centerCircleBox;
                    f19 = Math.max(f18, calculateMinimumRadiusForSpacedSlice(centerCircleBox, f25, f22 * phaseY, f17, f16, f26, f24));
                } else {
                    pointF = centerCircleBox;
                    rectF = circleBox;
                    i12 = i13;
                    f18 = f15;
                    f11 = radius;
                    f19 = f18;
                }
                RectF rectF2 = this.mInnerRectBuffer;
                float f27 = pointF.x;
                float f28 = pointF.y;
                rectF2.set(f27 - f19, f28 - f19, f27 + f19, f28 + f19);
                if (((double) f19) > 0.0d) {
                    if (i12 == 1) {
                        f20 = 0.0f;
                    } else {
                        f20 = sliceSpace / (f19 * 0.017453292f);
                    }
                    float f29 = ((f21 + (f20 / 2.0f)) * phaseY) + rotationAngle;
                    float f30 = (f22 - f20) * phaseY;
                    if (f30 < 0.0f) {
                        f30 = 0.0f;
                    }
                    float f31 = f29 + f30;
                    if (i17 == 0) {
                        this.mPathBuffer.addCircle(pointF.x, pointF.y, f19, Path.Direction.CCW);
                        f12 = f18;
                        f13 = rotationAngle;
                    } else {
                        double d11 = (double) (f31 * 0.017453292f);
                        f12 = f18;
                        f13 = rotationAngle;
                        this.mPathBuffer.lineTo(pointF.x + (((float) Math.cos(d11)) * f19), pointF.y + (f19 * ((float) Math.sin(d11))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f31, -f30);
                    }
                } else {
                    f12 = f18;
                    f13 = rotationAngle;
                    if (i17 != 0) {
                        this.mPathBuffer.lineTo(pointF.x, pointF.y);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            }
            f21 += f22 * phaseX;
            i16 = i11 + 1;
            iPieDataSet2 = iPieDataSet;
            rotationAngle = f13;
            i14 = i12;
            f10 = f12;
            centerCircleBox = pointF;
            radius = f11;
            entryCount = i10;
            drawAngles = fArr;
            circleBox = rectF;
        }
    }

    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float f10;
        float[] fArr;
        float[] fArr2;
        float f11;
        int i10;
        float f12;
        float f13;
        float f14;
        RectF rectF;
        IPieDataSet dataSetByIndex;
        float f15;
        float f16;
        float f17;
        float f18;
        int i11;
        float f19;
        float f20;
        float f21;
        Highlight[] highlightArr2 = highlightArr;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        PointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        if (!this.mChart.isDrawHoleEnabled() || this.mChart.isDrawSlicesUnderHoleEnabled()) {
            f10 = 0.0f;
        } else {
            f10 = (this.mChart.getHoleRadius() / 100.0f) * radius;
        }
        RectF rectF2 = new RectF();
        int i12 = 0;
        while (i12 < highlightArr2.length) {
            int xIndex = highlightArr2[i12].getXIndex();
            if (xIndex < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i12].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i13 = 0;
                int i14 = 0;
                while (i13 < entryCount) {
                    int i15 = entryCount;
                    float f22 = phaseY;
                    float f23 = rotationAngle;
                    if (((double) Math.abs(dataSetByIndex.getEntryForIndex(i13).getVal())) > 1.0E-6d) {
                        i14++;
                    }
                    i13++;
                    entryCount = i15;
                    phaseY = f22;
                    rotationAngle = f23;
                }
                f13 = phaseY;
                f12 = rotationAngle;
                if (xIndex == 0) {
                    f15 = 0.0f;
                } else {
                    f15 = absoluteAngles[xIndex - 1] * phaseX;
                }
                float sliceSpace = dataSetByIndex.getSliceSpace();
                float f24 = drawAngles[xIndex];
                if (i14 == 1) {
                    f16 = 0.0f;
                } else {
                    f16 = sliceSpace / (radius * 0.017453292f);
                }
                float selectionShift = dataSetByIndex.getSelectionShift();
                int i16 = i14;
                float f25 = radius + selectionShift;
                int i17 = i12;
                rectF2.set(this.mChart.getCircleBox());
                float f26 = -selectionShift;
                rectF2.inset(f26, f26);
                this.mRenderPaint.setColor(dataSetByIndex.getColor(xIndex));
                float f27 = f12 + (((f16 / 2.0f) + f15) * f13);
                float f28 = (f24 - f16) * f13;
                if (f28 < 0.0f) {
                    f17 = 0.0f;
                } else {
                    f17 = f28;
                }
                this.mPathBuffer.reset();
                int i18 = ((f17 % 360.0f) > 0.0f ? 1 : ((f17 % 360.0f) == 0.0f ? 0 : -1));
                if (i18 == 0) {
                    f18 = f10;
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f25, Path.Direction.CW);
                    f11 = phaseX;
                    fArr2 = drawAngles;
                    fArr = absoluteAngles;
                } else {
                    f18 = f10;
                    f11 = phaseX;
                    double d10 = (double) (f27 * 0.017453292f);
                    fArr2 = drawAngles;
                    fArr = absoluteAngles;
                    this.mPathBuffer.moveTo(centerCircleBox.x + (((float) Math.cos(d10)) * f25), centerCircleBox.y + (f25 * ((float) Math.sin(d10))));
                    this.mPathBuffer.arcTo(rectF2, f27, f17);
                }
                if (sliceSpace > 0.0f) {
                    double d11 = (double) (f27 * 0.017453292f);
                    i11 = i16;
                    float cos = (((float) Math.cos(d11)) * radius) + centerCircleBox.x;
                    float f29 = f27;
                    i10 = i17;
                    float sin = centerCircleBox.y + (((float) Math.sin(d11)) * radius);
                    rectF = rectF2;
                    f14 = f18;
                    f19 = Math.max(f14, calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f24 * f13, cos, sin, f29, f17));
                } else {
                    rectF = rectF2;
                    i11 = i16;
                    i10 = i17;
                    f14 = f18;
                    f19 = f14;
                }
                RectF rectF3 = this.mInnerRectBuffer;
                float f30 = centerCircleBox.x;
                float f31 = centerCircleBox.y;
                rectF3.set(f30 - f19, f31 - f19, f30 + f19, f31 + f19);
                if (((double) f19) > 0.0d) {
                    if (i11 == 1) {
                        f20 = 0.0f;
                    } else {
                        f20 = sliceSpace / (f19 * 0.017453292f);
                    }
                    float f32 = f12 + ((f15 + (f20 / 2.0f)) * f13);
                    float f33 = (f24 - f20) * f13;
                    if (f33 < 0.0f) {
                        f21 = 0.0f;
                    } else {
                        f21 = f33;
                    }
                    float f34 = f32 + f21;
                    if (i18 == 0) {
                        this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f19, Path.Direction.CCW);
                    } else {
                        double d12 = (double) (f34 * 0.017453292f);
                        this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d12)) * f19), centerCircleBox.y + (f19 * ((float) Math.sin(d12))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f34, -f21);
                    }
                } else if (i18 != 0) {
                    this.mPathBuffer.lineTo(centerCircleBox.x, centerCircleBox.y);
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                i10 = i12;
                rectF = rectF2;
                f11 = phaseX;
                f13 = phaseY;
                f12 = rotationAngle;
                fArr2 = drawAngles;
                fArr = absoluteAngles;
                f14 = f10;
            }
            i12 = i10 + 1;
            rectF2 = rectF;
            f10 = f14;
            phaseY = f13;
            rotationAngle = f12;
            phaseX = f11;
            drawAngles = fArr2;
            absoluteAngles = fArr;
            highlightArr2 = highlightArr;
        }
    }

    /* access modifiers changed from: protected */
    public void drawHole(Canvas canvas) {
        if (this.mChart.isDrawHoleEnabled()) {
            float radius = this.mChart.getRadius();
            float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
            PointF centerCircleBox = this.mChart.getCenterCircleBox();
            if (Color.alpha(this.mHolePaint.getColor()) > 0) {
                this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, this.mHolePaint);
            }
            if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
                int alpha = this.mTransparentCirclePaint.getAlpha();
                float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
                this.mTransparentCirclePaint.setAlpha((int) (((float) alpha) * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
                this.mHoleCirclePath.reset();
                this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, transparentCircleRadius, Path.Direction.CW);
                this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, Path.Direction.CCW);
                this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
                this.mTransparentCirclePaint.setAlpha(alpha);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawRoundedSlices(Canvas canvas) {
        float f10;
        float f11;
        float[] fArr;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                PointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i10 = 0;
                while (i10 < dataSet.getEntryCount()) {
                    float f12 = drawAngles[i10];
                    if (((double) Math.abs(dataSet.getEntryForIndex(i10).getVal())) > 1.0E-6d) {
                        double d10 = (double) (radius - holeRadius);
                        double d11 = (double) ((rotationAngle + f12) * phaseY);
                        f10 = phaseY;
                        fArr = drawAngles;
                        f11 = rotationAngle;
                        float cos = (float) (((double) centerCircleBox.x) + (Math.cos(Math.toRadians(d11)) * d10));
                        float sin = (float) ((d10 * Math.sin(Math.toRadians(d11))) + ((double) centerCircleBox.y));
                        this.mRenderPaint.setColor(dataSet.getColor(i10));
                        this.mBitmapCanvas.drawCircle(cos, sin, holeRadius, this.mRenderPaint);
                    } else {
                        f10 = phaseY;
                        fArr = drawAngles;
                        f11 = rotationAngle;
                    }
                    rotationAngle = f11 + (f12 * phaseX);
                    i10++;
                    phaseY = f10;
                    drawAngles = fArr;
                }
            }
        }
    }

    public void drawValues(Canvas canvas) {
        float f10;
        float[] fArr;
        float f11;
        int i10;
        List list;
        float f12;
        float f13;
        float f14;
        int i11;
        int i12;
        IPieDataSet iPieDataSet;
        IPieDataSet iPieDataSet2;
        int i13;
        IPieDataSet iPieDataSet3;
        Canvas canvas2 = canvas;
        PointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        float phaseX = this.mAnimator.getPhaseX();
        this.mAnimator.getPhaseY();
        float f15 = (radius / 10.0f) * 3.6f;
        if (this.mChart.isDrawHoleEnabled()) {
            f15 = (radius - ((radius / 100.0f) * this.mChart.getHoleRadius())) / 2.0f;
        }
        float f16 = radius - f15;
        PieData pieData = (PieData) this.mChart.getData();
        List dataSets = pieData.getDataSets();
        float yValueSum = pieData.getYValueSum();
        boolean isDrawSliceTextEnabled = this.mChart.isDrawSliceTextEnabled();
        int i14 = 0;
        int i15 = 0;
        while (i15 < dataSets.size()) {
            IPieDataSet iPieDataSet4 = (IPieDataSet) dataSets.get(i15);
            if (iPieDataSet4.isDrawValuesEnabled() || isDrawSliceTextEnabled) {
                applyValueTextStyle(iPieDataSet4);
                float calcTextHeight = ((float) Utils.calcTextHeight(this.mValuePaint, "Q")) + Utils.convertDpToPixel(4.0f);
                int entryCount = iPieDataSet4.getEntryCount();
                int min = Math.min((int) Math.ceil((double) (((float) entryCount) * phaseX)), entryCount);
                int i16 = i14;
                int i17 = 0;
                while (i17 < min) {
                    Entry entryForIndex = iPieDataSet4.getEntryForIndex(i17);
                    if (i16 == 0) {
                        f12 = 0.0f;
                    } else {
                        f12 = absoluteAngles[i16 - 1] * phaseX;
                    }
                    double d10 = (double) f16;
                    int i18 = i15;
                    List list2 = dataSets;
                    double sliceSpace = (double) (f12 + ((drawAngles[i16] - ((iPieDataSet4.getSliceSpace() / (0.017453292f * f16)) / 2.0f)) / 2.0f) + rotationAngle);
                    float f17 = rotationAngle;
                    float[] fArr2 = drawAngles;
                    float cos = (float) ((Math.cos(Math.toRadians(sliceSpace)) * d10) + ((double) centerCircleBox.x));
                    float sin = (float) ((d10 * Math.sin(Math.toRadians(sliceSpace))) + ((double) centerCircleBox.y));
                    if (this.mChart.isUsePercentValuesEnabled()) {
                        f13 = (entryForIndex.getVal() / yValueSum) * 100.0f;
                    } else {
                        f13 = entryForIndex.getVal();
                    }
                    float f18 = f13;
                    ValueFormatter valueFormatter = iPieDataSet4.getValueFormatter();
                    boolean isDrawValuesEnabled = iPieDataSet4.isDrawValuesEnabled();
                    if (!isDrawSliceTextEnabled || !isDrawValuesEnabled) {
                        i11 = min;
                        iPieDataSet2 = iPieDataSet4;
                        f14 = f16;
                        i13 = i17;
                        if (!isDrawSliceTextEnabled) {
                            iPieDataSet3 = iPieDataSet2;
                            if (isDrawValuesEnabled) {
                                int valueTextColor = iPieDataSet3.getValueTextColor(i13);
                                float f19 = cos;
                                iPieDataSet = iPieDataSet3;
                                float f20 = sin + (calcTextHeight / 2.0f);
                                i12 = i13;
                                drawValue(canvas, valueFormatter, f18, entryForIndex, 0, f19, f20, valueTextColor);
                                i16++;
                                i17 = i12 + 1;
                                iPieDataSet4 = iPieDataSet;
                                dataSets = list2;
                                i15 = i18;
                                min = i11;
                                rotationAngle = f17;
                                drawAngles = fArr2;
                                f16 = f14;
                            }
                        } else if (i13 < pieData.getXValCount()) {
                            iPieDataSet3 = iPieDataSet2;
                            this.mValuePaint.setColor(iPieDataSet3.getValueTextColor(i13));
                            canvas2.drawText(pieData.getXVals().get(i13), cos, sin + (calcTextHeight / 2.0f), this.mValuePaint);
                        }
                        iPieDataSet = iPieDataSet3;
                        i12 = i13;
                        i16++;
                        i17 = i12 + 1;
                        iPieDataSet4 = iPieDataSet;
                        dataSets = list2;
                        i15 = i18;
                        min = i11;
                        rotationAngle = f17;
                        drawAngles = fArr2;
                        f16 = f14;
                    } else {
                        i11 = min;
                        iPieDataSet2 = iPieDataSet4;
                        f14 = f16;
                        drawValue(canvas, valueFormatter, f18, entryForIndex, 0, cos, sin, iPieDataSet4.getValueTextColor(i17));
                        i13 = i17;
                        if (i13 < pieData.getXValCount()) {
                            canvas2.drawText(pieData.getXVals().get(i13), cos, sin + calcTextHeight, this.mValuePaint);
                        }
                    }
                    i12 = i13;
                    iPieDataSet = iPieDataSet2;
                    i16++;
                    i17 = i12 + 1;
                    iPieDataSet4 = iPieDataSet;
                    dataSets = list2;
                    i15 = i18;
                    min = i11;
                    rotationAngle = f17;
                    drawAngles = fArr2;
                    f16 = f14;
                }
                i10 = i15;
                list = dataSets;
                f10 = f16;
                f11 = rotationAngle;
                fArr = drawAngles;
                i14 = i16;
            } else {
                i10 = i15;
                list = dataSets;
                f10 = f16;
                f11 = rotationAngle;
                fArr = drawAngles;
            }
            i15 = i10 + 1;
            dataSets = list;
            rotationAngle = f11;
            drawAngles = fArr;
            f16 = f10;
        }
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public void initBuffers() {
    }

    public void releaseBitmap() {
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            weakReference.get().recycle();
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
