package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRenderer extends AxisRenderer {
    private Path mLimitLinePath = new Path();
    float[] mLimitLineSegmentsBuffer = new float[4];
    protected XAxis mXAxis;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer);
        this.mXAxis = xAxis;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    public void computeAxis(float f10, List<String> list) {
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        StringBuilder sb2 = new StringBuilder();
        int round = Math.round(f10);
        for (int i10 = 0; i10 < round; i10++) {
            sb2.append('h');
        }
        float f11 = Utils.calcTextSize(this.mAxisLabelPaint, sb2.toString()).width;
        float calcTextHeight = (float) Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
        FSize sizeOfRotatedRectangleByDegrees = Utils.getSizeOfRotatedRectangleByDegrees(f11, calcTextHeight, this.mXAxis.getLabelRotationAngle());
        StringBuilder sb3 = new StringBuilder();
        int spaceBetweenLabels = this.mXAxis.getSpaceBetweenLabels();
        for (int i11 = 0; i11 < spaceBetweenLabels; i11++) {
            sb3.append('h');
        }
        FSize calcTextSize = Utils.calcTextSize(this.mAxisLabelPaint, sb3.toString());
        this.mXAxis.mLabelWidth = Math.round(f11 + calcTextSize.width);
        this.mXAxis.mLabelHeight = Math.round(calcTextHeight);
        this.mXAxis.mLabelRotatedWidth = Math.round(sizeOfRotatedRectangleByDegrees.width + calcTextSize.width);
        this.mXAxis.mLabelRotatedHeight = Math.round(sizeOfRotatedRectangleByDegrees.height);
        this.mXAxis.setValues(list);
    }

    /* access modifiers changed from: protected */
    public void drawLabel(Canvas canvas, String str, int i10, float f10, float f11, PointF pointF, float f12) {
        String str2 = str;
        int i11 = i10;
        Utils.drawText(canvas, this.mXAxis.getValueFormatter().getXValue(str, i10, this.mViewPortHandler), f10, f11, this.mAxisLabelPaint, pointF, f12);
    }

    /* access modifiers changed from: protected */
    public void drawLabels(Canvas canvas, float f10, PointF pointF) {
        float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
        float[] fArr = {0.0f, 0.0f};
        int i10 = this.mMinX;
        while (i10 <= this.mMaxX) {
            fArr[0] = (float) i10;
            this.mTrans.pointValuesToPixel(fArr);
            if (this.mViewPortHandler.isInBoundsX(fArr[0])) {
                String str = this.mXAxis.getValues().get(i10);
                if (this.mXAxis.isAvoidFirstLastClippingEnabled()) {
                    if (i10 == this.mXAxis.getValues().size() - 1 && this.mXAxis.getValues().size() > 1) {
                        float calcTextWidth = (float) Utils.calcTextWidth(this.mAxisLabelPaint, str);
                        if (calcTextWidth > this.mViewPortHandler.offsetRight() * 2.0f && fArr[0] + calcTextWidth > this.mViewPortHandler.getChartWidth()) {
                            fArr[0] = fArr[0] - (calcTextWidth / 2.0f);
                        }
                    } else if (i10 == 0) {
                        fArr[0] = fArr[0] + (((float) Utils.calcTextWidth(this.mAxisLabelPaint, str)) / 2.0f);
                    }
                }
                drawLabel(canvas, str, i10, fArr[0], f10, pointF, labelRotationAngle);
            }
            i10 += this.mXAxis.mAxisLabelModulus;
        }
    }

    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float yOffset = this.mXAxis.getYOffset();
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {
                drawLabels(canvas, this.mViewPortHandler.contentTop() - yOffset, new PointF(0.5f, 1.0f));
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) {
                drawLabels(canvas, this.mViewPortHandler.contentTop() + yOffset + ((float) this.mXAxis.mLabelRotatedHeight), new PointF(0.5f, 1.0f));
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) {
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + yOffset, new PointF(0.5f, 0.0f));
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                drawLabels(canvas, (this.mViewPortHandler.contentBottom() - yOffset) - ((float) this.mXAxis.mLabelRotatedHeight), new PointF(0.5f, 0.0f));
            } else {
                drawLabels(canvas, this.mViewPortHandler.contentTop() - yOffset, new PointF(0.5f, 1.0f));
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + yOffset, new PointF(0.5f, 0.0f));
            }
        }
    }

    public void renderAxisLine(Canvas canvas) {
        if (this.mXAxis.isDrawAxisLineEnabled() && this.mXAxis.isEnabled()) {
            this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP || this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    public void renderGridLines(Canvas canvas) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            float[] fArr = {0.0f, 0.0f};
            this.mGridPaint.setColor(this.mXAxis.getGridColor());
            this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
            this.mGridPaint.setPathEffect(this.mXAxis.getGridDashPathEffect());
            Path path = new Path();
            int i10 = this.mMinX;
            while (i10 <= this.mMaxX) {
                fArr[0] = (float) i10;
                this.mTrans.pointValuesToPixel(fArr);
                if (fArr[0] >= this.mViewPortHandler.offsetLeft() && fArr[0] <= this.mViewPortHandler.getChartWidth()) {
                    path.moveTo(fArr[0], this.mViewPortHandler.contentBottom());
                    path.lineTo(fArr[0], this.mViewPortHandler.contentTop());
                    canvas.drawPath(path, this.mGridPaint);
                }
                path.reset();
                i10 += this.mXAxis.mAxisLabelModulus;
            }
        }
    }

    public void renderLimitLineLabel(Canvas canvas, LimitLine limitLine, float[] fArr, float f10) {
        String label = limitLine.getLabel();
        if (label != null && !label.equals("")) {
            this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
            this.mLimitLinePaint.setPathEffect((PathEffect) null);
            this.mLimitLinePaint.setColor(limitLine.getTextColor());
            this.mLimitLinePaint.setStrokeWidth(0.5f);
            this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
            float lineWidth = limitLine.getLineWidth() + limitLine.getXOffset();
            LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
            if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentTop() + f10 + ((float) Utils.calcTextHeight(this.mLimitLinePaint, label)), this.mLimitLinePaint);
            } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentBottom() - f10, this.mLimitLinePaint);
            } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentTop() + f10 + ((float) Utils.calcTextHeight(this.mLimitLinePaint, label)), this.mLimitLinePaint);
            } else {
                this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentBottom() - f10, this.mLimitLinePaint);
            }
        }
    }

    public void renderLimitLineLine(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.mLimitLineSegmentsBuffer;
        fArr2[0] = fArr[0];
        fArr2[1] = this.mViewPortHandler.contentTop();
        float[] fArr3 = this.mLimitLineSegmentsBuffer;
        fArr3[2] = fArr[0];
        fArr3[3] = this.mViewPortHandler.contentBottom();
        this.mLimitLinePath.reset();
        Path path = this.mLimitLinePath;
        float[] fArr4 = this.mLimitLineSegmentsBuffer;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.mLimitLinePath;
        float[] fArr5 = this.mLimitLineSegmentsBuffer;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
        this.mLimitLinePaint.setColor(limitLine.getLineColor());
        this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
        this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
        canvas.drawPath(this.mLimitLinePath, this.mLimitLinePaint);
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mXAxis.getLimitLines();
        if (limitLines != null && limitLines.size() > 0) {
            float[] fArr = new float[2];
            for (int i10 = 0; i10 < limitLines.size(); i10++) {
                LimitLine limitLine = limitLines.get(i10);
                if (limitLine.isEnabled()) {
                    fArr[0] = limitLine.getLimit();
                    fArr[1] = 0.0f;
                    this.mTrans.pointValuesToPixel(fArr);
                    renderLimitLineLine(canvas, limitLine, fArr);
                    renderLimitLineLabel(canvas, limitLine, fArr, limitLine.getYOffset() + 2.0f);
                }
            }
        }
    }
}
