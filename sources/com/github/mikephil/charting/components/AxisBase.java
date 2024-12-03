package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase extends ComponentBase {
    private int mAxisLineColor = -7829368;
    private float mAxisLineWidth = 1.0f;
    protected boolean mDrawAxisLine = true;
    protected boolean mDrawGridLines = true;
    protected boolean mDrawLabels = true;
    protected boolean mDrawLimitLineBehindData = false;
    private int mGridColor = -7829368;
    private DashPathEffect mGridDashPathEffect = null;
    private float mGridLineWidth = 1.0f;
    protected List<LimitLine> mLimitLines;

    public AxisBase() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(5.0f);
        this.mLimitLines = new ArrayList();
    }

    public void addLimitLine(LimitLine limitLine) {
        this.mLimitLines.add(limitLine);
        this.mLimitLines.size();
    }

    public void disableGridDashedLine() {
        this.mGridDashPathEffect = null;
    }

    public void enableGridDashedLine(float f10, float f11, float f12) {
        this.mGridDashPathEffect = new DashPathEffect(new float[]{f10, f11}, f12);
    }

    public int getAxisLineColor() {
        return this.mAxisLineColor;
    }

    public float getAxisLineWidth() {
        return this.mAxisLineWidth;
    }

    public int getGridColor() {
        return this.mGridColor;
    }

    public DashPathEffect getGridDashPathEffect() {
        return this.mGridDashPathEffect;
    }

    public float getGridLineWidth() {
        return this.mGridLineWidth;
    }

    public List<LimitLine> getLimitLines() {
        return this.mLimitLines;
    }

    public abstract String getLongestLabel();

    public boolean isDrawAxisLineEnabled() {
        return this.mDrawAxisLine;
    }

    public boolean isDrawGridLinesEnabled() {
        return this.mDrawGridLines;
    }

    public boolean isDrawLabelsEnabled() {
        return this.mDrawLabels;
    }

    public boolean isDrawLimitLinesBehindDataEnabled() {
        return this.mDrawLimitLineBehindData;
    }

    public boolean isGridDashedLineEnabled() {
        return this.mGridDashPathEffect != null;
    }

    public void removeAllLimitLines() {
        this.mLimitLines.clear();
    }

    public void removeLimitLine(LimitLine limitLine) {
        this.mLimitLines.remove(limitLine);
    }

    public void setAxisLineColor(int i10) {
        this.mAxisLineColor = i10;
    }

    public void setAxisLineWidth(float f10) {
        this.mAxisLineWidth = Utils.convertDpToPixel(f10);
    }

    public void setDrawAxisLine(boolean z10) {
        this.mDrawAxisLine = z10;
    }

    public void setDrawGridLines(boolean z10) {
        this.mDrawGridLines = z10;
    }

    public void setDrawLabels(boolean z10) {
        this.mDrawLabels = z10;
    }

    public void setDrawLimitLinesBehindData(boolean z10) {
        this.mDrawLimitLineBehindData = z10;
    }

    public void setGridColor(int i10) {
        this.mGridColor = i10;
    }

    public void setGridLineWidth(float f10) {
        this.mGridLineWidth = Utils.convertDpToPixel(f10);
    }
}
