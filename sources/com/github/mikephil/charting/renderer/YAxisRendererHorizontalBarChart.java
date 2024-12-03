package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.PointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererHorizontalBarChart extends YAxisRenderer {
    public YAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, yAxis, transformer);
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
    }

    public void computeAxis(float f10, float f11) {
        if (this.mViewPortHandler.contentHeight() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutX()) {
            PointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            PointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
            if (!this.mYAxis.isInverted()) {
                f10 = (float) valuesByTouchPoint.f37954x;
                f11 = (float) valuesByTouchPoint2.f37954x;
            } else {
                float f12 = (float) valuesByTouchPoint2.f37954x;
                f11 = (float) valuesByTouchPoint.f37954x;
                f10 = f12;
            }
        }
        computeAxisValues(f10, f11);
    }

    /* access modifiers changed from: protected */
    public void drawYLabels(Canvas canvas, float f10, float[] fArr, float f11) {
        this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
        int i10 = 0;
        while (true) {
            YAxis yAxis = this.mYAxis;
            if (i10 < yAxis.mEntryCount) {
                String formattedLabel = yAxis.getFormattedLabel(i10);
                if (this.mYAxis.isDrawTopYLabelEntryEnabled() || i10 < this.mYAxis.mEntryCount - 1) {
                    canvas.drawText(formattedLabel, fArr[i10 * 2], f10 - f11, this.mAxisLabelPaint);
                    i10++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void renderAxisLabels(Canvas canvas) {
        float f10;
        float f11;
        float f12;
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            int i10 = this.mYAxis.mEntryCount * 2;
            float[] fArr = new float[i10];
            for (int i11 = 0; i11 < i10; i11 += 2) {
                fArr[i11] = this.mYAxis.mEntries[i11 / 2];
            }
            this.mTrans.pointValuesToPixel(fArr);
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
            float convertDpToPixel = Utils.convertDpToPixel(2.5f);
            float calcTextHeight = (float) Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
            YAxis.AxisDependency axisDependency = this.mYAxis.getAxisDependency();
            YAxis.YAxisLabelPosition labelPosition = this.mYAxis.getLabelPosition();
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    f12 = this.mViewPortHandler.contentTop();
                } else {
                    f12 = this.mViewPortHandler.contentTop();
                }
                f10 = f12 - convertDpToPixel;
            } else {
                if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    f11 = this.mViewPortHandler.contentBottom();
                } else {
                    f11 = this.mViewPortHandler.contentBottom();
                }
                f10 = f11 + calcTextHeight + convertDpToPixel;
            }
            drawYLabels(canvas, f10, fArr, this.mYAxis.getYOffset());
        }
    }

    public void renderAxisLine(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawAxisLineEnabled()) {
            this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
            if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
                return;
            }
            canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        }
    }

    public void renderGridLines(Canvas canvas) {
        if (this.mYAxis.isEnabled()) {
            float[] fArr = new float[2];
            if (this.mYAxis.isDrawGridLinesEnabled()) {
                this.mGridPaint.setColor(this.mYAxis.getGridColor());
                this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
                int i10 = 0;
                while (true) {
                    YAxis yAxis = this.mYAxis;
                    if (i10 >= yAxis.mEntryCount) {
                        break;
                    }
                    fArr[0] = yAxis.mEntries[i10];
                    this.mTrans.pointValuesToPixel(fArr);
                    canvas.drawLine(fArr[0], this.mViewPortHandler.contentTop(), fArr[0], this.mViewPortHandler.contentBottom(), this.mGridPaint);
                    i10++;
                }
            }
            if (this.mYAxis.isDrawZeroLineEnabled()) {
                fArr[0] = 0.0f;
                this.mTrans.pointValuesToPixel(fArr);
                float f10 = fArr[0];
                drawZeroLine(canvas, f10 + 1.0f, f10 + 1.0f, this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentBottom());
            }
        }
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines != null && limitLines.size() > 0) {
            float[] fArr = new float[4];
            Path path = new Path();
            for (int i10 = 0; i10 < limitLines.size(); i10++) {
                LimitLine limitLine = limitLines.get(i10);
                if (limitLine.isEnabled()) {
                    fArr[0] = limitLine.getLimit();
                    fArr[2] = limitLine.getLimit();
                    this.mTrans.pointValuesToPixel(fArr);
                    fArr[1] = this.mViewPortHandler.contentTop();
                    fArr[3] = this.mViewPortHandler.contentBottom();
                    path.moveTo(fArr[0], fArr[1]);
                    path.lineTo(fArr[2], fArr[3]);
                    this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
                    this.mLimitLinePaint.setColor(limitLine.getLineColor());
                    this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                    this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                    canvas.drawPath(path, this.mLimitLinePaint);
                    path.reset();
                    String label = limitLine.getLabel();
                    if (label != null && !label.equals("")) {
                        this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
                        this.mLimitLinePaint.setPathEffect((PathEffect) null);
                        this.mLimitLinePaint.setColor(limitLine.getTextColor());
                        this.mLimitLinePaint.setTypeface(limitLine.getTypeface());
                        this.mLimitLinePaint.setStrokeWidth(0.5f);
                        this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
                        float lineWidth = limitLine.getLineWidth() + limitLine.getXOffset();
                        float convertDpToPixel = Utils.convertDpToPixel(2.0f) + limitLine.getYOffset();
                        LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
                        if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentTop() + convertDpToPixel + ((float) Utils.calcTextHeight(this.mLimitLinePaint, label)), this.mLimitLinePaint);
                        } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentBottom() - convertDpToPixel, this.mLimitLinePaint);
                        } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentTop() + convertDpToPixel + ((float) Utils.calcTextHeight(this.mLimitLinePaint, label)), this.mLimitLinePaint);
                        } else {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentBottom() - convertDpToPixel, this.mLimitLinePaint);
                        }
                    }
                }
            }
        }
    }
}
