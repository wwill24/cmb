package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.DefaultYAxisValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.Utils;

public class YAxis extends AxisBase {
    private AxisDependency mAxisDependency;
    public float mAxisMaximum;
    public float mAxisMinimum;
    public float mAxisRange;
    protected float mCustomAxisMax;
    protected float mCustomAxisMin;
    public int mDecimals;
    private boolean mDrawTopYLabelEntry;
    protected boolean mDrawZeroLine;
    public float[] mEntries;
    public int mEntryCount;
    protected boolean mForceLabels;
    protected boolean mInverted;
    private int mLabelCount;
    private YAxisLabelPosition mPosition;
    protected boolean mShowOnlyMinMax;
    protected float mSpacePercentBottom;
    protected float mSpacePercentTop;
    protected YAxisValueFormatter mYAxisValueFormatter;
    protected int mZeroLineColor;
    protected float mZeroLineWidth;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.mEntries = new float[0];
        this.mLabelCount = 6;
        this.mDrawTopYLabelEntry = true;
        this.mShowOnlyMinMax = false;
        this.mInverted = false;
        this.mForceLabels = false;
        this.mDrawZeroLine = true;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mCustomAxisMin = Float.NaN;
        this.mCustomAxisMax = Float.NaN;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mAxisMaximum = 0.0f;
        this.mAxisMinimum = 0.0f;
        this.mAxisRange = 0.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mAxisDependency = AxisDependency.LEFT;
        this.mYOffset = 0.0f;
    }

    public AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public float getAxisMaxValue() {
        return this.mCustomAxisMax;
    }

    public float getAxisMinValue() {
        return this.mCustomAxisMin;
    }

    public String getFormattedLabel(int i10) {
        if (i10 < 0 || i10 >= this.mEntries.length) {
            return "";
        }
        return getValueFormatter().getFormattedValue(this.mEntries[i10], this);
    }

    public int getLabelCount() {
        return this.mLabelCount;
    }

    public YAxisLabelPosition getLabelPosition() {
        return this.mPosition;
    }

    public String getLongestLabel() {
        String str = "";
        for (int i10 = 0; i10 < this.mEntries.length; i10++) {
            String formattedLabel = getFormattedLabel(i10);
            if (str.length() < formattedLabel.length()) {
                str = formattedLabel;
            }
        }
        return str;
    }

    public float getRequiredHeightSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return ((float) Utils.calcTextHeight(paint, getLongestLabel())) + (getYOffset() * 2.0f);
    }

    public float getRequiredWidthSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return ((float) Utils.calcTextWidth(paint, getLongestLabel())) + (getXOffset() * 2.0f);
    }

    public float getSpaceBottom() {
        return this.mSpacePercentBottom;
    }

    public float getSpaceTop() {
        return this.mSpacePercentTop;
    }

    public YAxisValueFormatter getValueFormatter() {
        if (this.mYAxisValueFormatter == null) {
            this.mYAxisValueFormatter = new DefaultYAxisValueFormatter(this.mDecimals);
        }
        return this.mYAxisValueFormatter;
    }

    public int getZeroLineColor() {
        return this.mZeroLineColor;
    }

    public float getZeroLineWidth() {
        return this.mZeroLineWidth;
    }

    public boolean isDrawTopYLabelEntryEnabled() {
        return this.mDrawTopYLabelEntry;
    }

    public boolean isDrawZeroLineEnabled() {
        return this.mDrawZeroLine;
    }

    public boolean isForceLabelsEnabled() {
        return this.mForceLabels;
    }

    public boolean isInverted() {
        return this.mInverted;
    }

    public boolean isShowOnlyMinMaxEnabled() {
        return this.mShowOnlyMinMax;
    }

    public boolean needsDefaultFormatter() {
        YAxisValueFormatter yAxisValueFormatter = this.mYAxisValueFormatter;
        if (yAxisValueFormatter != null && !(yAxisValueFormatter instanceof DefaultValueFormatter)) {
            return false;
        }
        return true;
    }

    public boolean needsOffset() {
        return isEnabled() && isDrawLabelsEnabled() && getLabelPosition() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public void resetAxisMaxValue() {
        this.mCustomAxisMax = Float.NaN;
    }

    public void resetAxisMinValue() {
        this.mCustomAxisMin = Float.NaN;
    }

    public void setAxisMaxValue(float f10) {
        this.mCustomAxisMax = f10;
    }

    public void setAxisMinValue(float f10) {
        this.mCustomAxisMin = f10;
    }

    public void setDrawTopYLabelEntry(boolean z10) {
        this.mDrawTopYLabelEntry = z10;
    }

    public void setDrawZeroLine(boolean z10) {
        this.mDrawZeroLine = z10;
    }

    public void setInverted(boolean z10) {
        this.mInverted = z10;
    }

    public void setLabelCount(int i10, boolean z10) {
        if (i10 > 25) {
            i10 = 25;
        }
        if (i10 < 2) {
            i10 = 2;
        }
        this.mLabelCount = i10;
        this.mForceLabels = z10;
    }

    public void setPosition(YAxisLabelPosition yAxisLabelPosition) {
        this.mPosition = yAxisLabelPosition;
    }

    public void setShowOnlyMinMax(boolean z10) {
        this.mShowOnlyMinMax = z10;
    }

    public void setSpaceBottom(float f10) {
        this.mSpacePercentBottom = f10;
    }

    public void setSpaceTop(float f10) {
        this.mSpacePercentTop = f10;
    }

    @Deprecated
    public void setStartAtZero(boolean z10) {
        if (z10) {
            setAxisMinValue(0.0f);
        } else {
            resetAxisMinValue();
        }
    }

    public void setValueFormatter(YAxisValueFormatter yAxisValueFormatter) {
        if (yAxisValueFormatter == null) {
            this.mYAxisValueFormatter = new DefaultYAxisValueFormatter(this.mDecimals);
        } else {
            this.mYAxisValueFormatter = yAxisValueFormatter;
        }
    }

    public void setZeroLineColor(int i10) {
        this.mZeroLineColor = i10;
    }

    public void setZeroLineWidth(float f10) {
        this.mZeroLineWidth = Utils.convertDpToPixel(f10);
    }

    public YAxis(AxisDependency axisDependency) {
        this.mEntries = new float[0];
        this.mLabelCount = 6;
        this.mDrawTopYLabelEntry = true;
        this.mShowOnlyMinMax = false;
        this.mInverted = false;
        this.mForceLabels = false;
        this.mDrawZeroLine = true;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mCustomAxisMin = Float.NaN;
        this.mCustomAxisMax = Float.NaN;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mAxisMaximum = 0.0f;
        this.mAxisMinimum = 0.0f;
        this.mAxisRange = 0.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mAxisDependency = axisDependency;
        this.mYOffset = 0.0f;
    }
}
