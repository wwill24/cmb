package com.github.mikephil.charting.data.realm.base;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import io.realm.RealmObject;
import io.realm.RealmResults;

public abstract class RealmLineScatterCandleRadarDataSet<T extends RealmObject, S extends Entry> extends RealmBarLineScatterCandleBubbleDataSet<T, S> implements ILineScatterCandleRadarDataSet<S> {
    protected boolean mDrawHorizontalHighlightIndicator = true;
    protected boolean mDrawVerticalHighlightIndicator = true;
    protected DashPathEffect mHighlightDashPathEffect = null;
    protected float mHighlightLineWidth = 0.5f;

    public RealmLineScatterCandleRadarDataSet(RealmResults<T> realmResults, String str) {
        super(realmResults, str);
    }

    public void disableDashedHighlightLine() {
        this.mHighlightDashPathEffect = null;
    }

    public void enableDashedHighlightLine(float f10, float f11, float f12) {
        this.mHighlightDashPathEffect = new DashPathEffect(new float[]{f10, f11}, f12);
    }

    public DashPathEffect getDashPathEffectHighlight() {
        return this.mHighlightDashPathEffect;
    }

    public float getHighlightLineWidth() {
        return this.mHighlightLineWidth;
    }

    public boolean isDashedHighlightLineEnabled() {
        return this.mHighlightDashPathEffect != null;
    }

    public boolean isHorizontalHighlightIndicatorEnabled() {
        return this.mDrawHorizontalHighlightIndicator;
    }

    public boolean isVerticalHighlightIndicatorEnabled() {
        return this.mDrawVerticalHighlightIndicator;
    }

    public void setDrawHighlightIndicators(boolean z10) {
        setDrawVerticalHighlightIndicator(z10);
        setDrawHorizontalHighlightIndicator(z10);
    }

    public void setDrawHorizontalHighlightIndicator(boolean z10) {
        this.mDrawHorizontalHighlightIndicator = z10;
    }

    public void setDrawVerticalHighlightIndicator(boolean z10) {
        this.mDrawVerticalHighlightIndicator = z10;
    }

    public void setHighlightLineWidth(float f10) {
        this.mHighlightLineWidth = Utils.convertDpToPixel(f10);
    }

    public RealmLineScatterCandleRadarDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str, str2);
    }
}
