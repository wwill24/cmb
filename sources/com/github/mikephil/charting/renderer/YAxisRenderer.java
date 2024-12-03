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

public class YAxisRenderer extends AxisRenderer {
    protected YAxis mYAxis;
    protected Paint mZeroLinePaint;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer);
        this.mYAxis = yAxis;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
        Paint paint = new Paint(1);
        this.mZeroLinePaint = paint;
        paint.setColor(-7829368);
        this.mZeroLinePaint.setStrokeWidth(1.0f);
        this.mZeroLinePaint.setStyle(Paint.Style.STROKE);
    }

    public void computeAxis(float f10, float f11) {
        if (this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            PointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            PointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (!this.mYAxis.isInverted()) {
                float f12 = (float) valuesByTouchPoint2.f37955y;
                f11 = (float) valuesByTouchPoint.f37955y;
                f10 = f12;
            } else {
                f10 = (float) valuesByTouchPoint.f37955y;
                f11 = (float) valuesByTouchPoint2.f37955y;
            }
        }
        computeAxisValues(f10, f11);
    }

    /* access modifiers changed from: protected */
    public void computeAxisValues(float f10, float f11) {
        float f12 = f10;
        float f13 = f11;
        int labelCount = this.mYAxis.getLabelCount();
        double abs = (double) Math.abs(f13 - f12);
        if (labelCount == 0 || abs <= 0.0d) {
            YAxis yAxis = this.mYAxis;
            yAxis.mEntries = new float[0];
            yAxis.mEntryCount = 0;
            return;
        }
        double roundToNextSignificant = (double) Utils.roundToNextSignificant(abs / ((double) labelCount));
        double pow = Math.pow(10.0d, (double) ((int) Math.log10(roundToNextSignificant)));
        if (((int) (roundToNextSignificant / pow)) > 5) {
            roundToNextSignificant = Math.floor(pow * 10.0d);
        }
        if (this.mYAxis.isForceLabelsEnabled()) {
            float f14 = ((float) abs) / ((float) (labelCount - 1));
            YAxis yAxis2 = this.mYAxis;
            yAxis2.mEntryCount = labelCount;
            if (yAxis2.mEntries.length < labelCount) {
                yAxis2.mEntries = new float[labelCount];
            }
            for (int i10 = 0; i10 < labelCount; i10++) {
                this.mYAxis.mEntries[i10] = f12;
                f12 += f14;
            }
        } else if (this.mYAxis.isShowOnlyMinMaxEnabled()) {
            YAxis yAxis3 = this.mYAxis;
            yAxis3.mEntryCount = 2;
            float[] fArr = new float[2];
            yAxis3.mEntries = fArr;
            fArr[0] = f12;
            fArr[1] = f13;
        } else {
            double ceil = Math.ceil(((double) f12) / roundToNextSignificant) * roundToNextSignificant;
            int i11 = 0;
            for (double d10 = ceil; d10 <= Utils.nextUp(Math.floor(((double) f13) / roundToNextSignificant) * roundToNextSignificant); d10 += roundToNextSignificant) {
                i11++;
            }
            YAxis yAxis4 = this.mYAxis;
            yAxis4.mEntryCount = i11;
            if (yAxis4.mEntries.length < i11) {
                yAxis4.mEntries = new float[i11];
            }
            for (int i12 = 0; i12 < i11; i12++) {
                if (ceil == 0.0d) {
                    ceil = 0.0d;
                }
                this.mYAxis.mEntries[i12] = (float) ceil;
                ceil += roundToNextSignificant;
            }
        }
        if (roundToNextSignificant < 1.0d) {
            this.mYAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
            return;
        }
        this.mYAxis.mDecimals = 0;
    }

    /* access modifiers changed from: protected */
    public void drawYLabels(Canvas canvas, float f10, float[] fArr, float f11) {
        int i10 = 0;
        while (true) {
            YAxis yAxis = this.mYAxis;
            if (i10 < yAxis.mEntryCount) {
                String formattedLabel = yAxis.getFormattedLabel(i10);
                if (this.mYAxis.isDrawTopYLabelEntryEnabled() || i10 < this.mYAxis.mEntryCount - 1) {
                    canvas.drawText(formattedLabel, f10, fArr[(i10 * 2) + 1] + f11, this.mAxisLabelPaint);
                    i10++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawZeroLine(Canvas canvas, float f10, float f11, float f12, float f13) {
        this.mZeroLinePaint.setColor(this.mYAxis.getZeroLineColor());
        this.mZeroLinePaint.setStrokeWidth(this.mYAxis.getZeroLineWidth());
        Path path = new Path();
        path.moveTo(f10, f12);
        path.lineTo(f11, f13);
        canvas.drawPath(path, this.mZeroLinePaint);
    }

    public void renderAxisLabels(Canvas canvas) {
        float f10;
        float f11;
        float f12;
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            int i10 = this.mYAxis.mEntryCount * 2;
            float[] fArr = new float[i10];
            for (int i11 = 0; i11 < i10; i11 += 2) {
                fArr[i11 + 1] = this.mYAxis.mEntries[i11 / 2];
            }
            this.mTrans.pointValuesToPixel(fArr);
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            float xOffset = this.mYAxis.getXOffset();
            float calcTextHeight = (((float) Utils.calcTextHeight(this.mAxisLabelPaint, "A")) / 2.5f) + this.mYAxis.getYOffset();
            YAxis.AxisDependency axisDependency = this.mYAxis.getAxisDependency();
            YAxis.YAxisLabelPosition labelPosition = this.mYAxis.getLabelPosition();
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                    f11 = this.mViewPortHandler.offsetLeft();
                    f10 = f11 - xOffset;
                    drawYLabels(canvas, f10, fArr, calcTextHeight);
                }
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                f12 = this.mViewPortHandler.offsetLeft();
            } else if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                f12 = this.mViewPortHandler.contentRight();
            } else {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                f11 = this.mViewPortHandler.contentRight();
                f10 = f11 - xOffset;
                drawYLabels(canvas, f10, fArr, calcTextHeight);
            }
            f10 = f12 + xOffset;
            drawYLabels(canvas, f10, fArr, calcTextHeight);
        }
    }

    public void renderAxisLine(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawAxisLineEnabled()) {
            this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
            if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
                return;
            }
            canvas.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        }
    }

    public void renderGridLines(Canvas canvas) {
        if (this.mYAxis.isEnabled()) {
            float[] fArr = new float[2];
            if (this.mYAxis.isDrawGridLinesEnabled()) {
                this.mGridPaint.setColor(this.mYAxis.getGridColor());
                this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
                this.mGridPaint.setPathEffect(this.mYAxis.getGridDashPathEffect());
                Path path = new Path();
                int i10 = 0;
                while (true) {
                    YAxis yAxis = this.mYAxis;
                    if (i10 >= yAxis.mEntryCount) {
                        break;
                    }
                    fArr[1] = yAxis.mEntries[i10];
                    this.mTrans.pointValuesToPixel(fArr);
                    path.moveTo(this.mViewPortHandler.offsetLeft(), fArr[1]);
                    path.lineTo(this.mViewPortHandler.contentRight(), fArr[1]);
                    canvas.drawPath(path, this.mGridPaint);
                    path.reset();
                    i10++;
                }
            }
            if (this.mYAxis.isDrawZeroLineEnabled()) {
                fArr[1] = 0.0f;
                this.mTrans.pointValuesToPixel(fArr);
                float offsetLeft = this.mViewPortHandler.offsetLeft();
                float contentRight = this.mViewPortHandler.contentRight();
                float f10 = fArr[1];
                drawZeroLine(canvas, offsetLeft, contentRight, f10 - 1.0f, f10 - 1.0f);
            }
        }
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines != null && limitLines.size() > 0) {
            float[] fArr = new float[2];
            Path path = new Path();
            for (int i10 = 0; i10 < limitLines.size(); i10++) {
                LimitLine limitLine = limitLines.get(i10);
                if (limitLine.isEnabled()) {
                    this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
                    this.mLimitLinePaint.setColor(limitLine.getLineColor());
                    this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                    this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                    fArr[1] = limitLine.getLimit();
                    this.mTrans.pointValuesToPixel(fArr);
                    path.moveTo(this.mViewPortHandler.contentLeft(), fArr[1]);
                    path.lineTo(this.mViewPortHandler.contentRight(), fArr[1]);
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
                        float calcTextHeight = (float) Utils.calcTextHeight(this.mLimitLinePaint, label);
                        float convertDpToPixel = Utils.convertDpToPixel(4.0f) + limitLine.getXOffset();
                        float lineWidth = limitLine.getLineWidth() + calcTextHeight + limitLine.getYOffset();
                        LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
                        if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(label, this.mViewPortHandler.contentRight() - convertDpToPixel, (fArr[1] - lineWidth) + calcTextHeight, this.mLimitLinePaint);
                        } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(label, this.mViewPortHandler.contentRight() - convertDpToPixel, fArr[1] + lineWidth, this.mLimitLinePaint);
                        } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(label, this.mViewPortHandler.contentLeft() + convertDpToPixel, (fArr[1] - lineWidth) + calcTextHeight, this.mLimitLinePaint);
                        } else {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(label, this.mViewPortHandler.offsetLeft() + convertDpToPixel, fArr[1] + lineWidth, this.mLimitLinePaint);
                        }
                    }
                }
            }
        }
    }
}
