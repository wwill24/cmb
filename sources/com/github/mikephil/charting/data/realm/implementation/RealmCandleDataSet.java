package com.github.mikephil.charting.data.realm.implementation;

import android.graphics.Paint;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.realm.base.RealmLineScatterCandleRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.Utils;
import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;
import java.util.List;

public class RealmCandleDataSet<T extends RealmObject> extends RealmLineScatterCandleRadarDataSet<T, CandleEntry> implements ICandleDataSet {
    private float mBarSpace = 0.1f;
    private String mCloseField;
    protected int mDecreasingColor = -1;
    protected Paint.Style mDecreasingPaintStyle = Paint.Style.FILL;
    private String mHighField;
    protected int mIncreasingColor = -1;
    protected Paint.Style mIncreasingPaintStyle = Paint.Style.STROKE;
    private String mLowField;
    protected int mNeutralColor = -1;
    private String mOpenField;
    protected int mShadowColor = -1;
    private boolean mShadowColorSameAsCandle = false;
    private float mShadowWidth = 3.0f;
    private boolean mShowCandleBar = true;

    public RealmCandleDataSet(RealmResults<T> realmResults, String str, String str2, String str3, String str4) {
        super(realmResults, (String) null);
        this.mHighField = str;
        this.mLowField = str2;
        this.mOpenField = str3;
        this.mCloseField = str4;
        build(this.results);
        calcMinMax(0, this.results.size());
    }

    public void build(RealmResults<T> realmResults) {
        if (this.mIndexField == null) {
            int i10 = 0;
            Iterator it = realmResults.iterator();
            while (it.hasNext()) {
                DynamicRealmObject dynamicRealmObject = new DynamicRealmObject((RealmObject) it.next());
                this.mValues.add(new CandleEntry(i10, dynamicRealmObject.getFloat(this.mHighField), dynamicRealmObject.getFloat(this.mLowField), dynamicRealmObject.getFloat(this.mOpenField), dynamicRealmObject.getFloat(this.mCloseField)));
                i10++;
            }
            return;
        }
        Iterator it2 = realmResults.iterator();
        while (it2.hasNext()) {
            DynamicRealmObject dynamicRealmObject2 = new DynamicRealmObject((RealmObject) it2.next());
            this.mValues.add(new CandleEntry(dynamicRealmObject2.getInt(this.mIndexField), dynamicRealmObject2.getFloat(this.mHighField), dynamicRealmObject2.getFloat(this.mLowField), dynamicRealmObject2.getFloat(this.mOpenField), dynamicRealmObject2.getFloat(this.mCloseField)));
        }
    }

    public void calcMinMax(int i10, int i11) {
        List<S> list = this.mValues;
        if (list != null && list.size() != 0) {
            if (i11 == 0 || i11 >= this.mValues.size()) {
                i11 = this.mValues.size() - 1;
            }
            this.mYMin = Float.MAX_VALUE;
            this.mYMax = -3.4028235E38f;
            while (i10 <= i11) {
                CandleEntry candleEntry = (CandleEntry) this.mValues.get(i10);
                if (candleEntry.getLow() < this.mYMin) {
                    this.mYMin = candleEntry.getLow();
                }
                if (candleEntry.getHigh() > this.mYMax) {
                    this.mYMax = candleEntry.getHigh();
                }
                i10++;
            }
        }
    }

    public float getBarSpace() {
        return this.mBarSpace;
    }

    public int getDecreasingColor() {
        return this.mDecreasingColor;
    }

    public Paint.Style getDecreasingPaintStyle() {
        return this.mDecreasingPaintStyle;
    }

    public int getIncreasingColor() {
        return this.mIncreasingColor;
    }

    public Paint.Style getIncreasingPaintStyle() {
        return this.mIncreasingPaintStyle;
    }

    public int getNeutralColor() {
        return this.mNeutralColor;
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    public boolean getShadowColorSameAsCandle() {
        return this.mShadowColorSameAsCandle;
    }

    public float getShadowWidth() {
        return this.mShadowWidth;
    }

    public boolean getShowCandleBar() {
        return this.mShowCandleBar;
    }

    public void setBarSpace(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 0.45f) {
            f10 = 0.45f;
        }
        this.mBarSpace = f10;
    }

    public void setDecreasingColor(int i10) {
        this.mDecreasingColor = i10;
    }

    public void setDecreasingPaintStyle(Paint.Style style) {
        this.mDecreasingPaintStyle = style;
    }

    public void setIncreasingColor(int i10) {
        this.mIncreasingColor = i10;
    }

    public void setIncreasingPaintStyle(Paint.Style style) {
        this.mIncreasingPaintStyle = style;
    }

    public void setNeutralColor(int i10) {
        this.mNeutralColor = i10;
    }

    public void setShadowColor(int i10) {
        this.mShadowColor = i10;
    }

    public void setShadowColorSameAsCandle(boolean z10) {
        this.mShadowColorSameAsCandle = z10;
    }

    public void setShadowWidth(float f10) {
        this.mShadowWidth = Utils.convertDpToPixel(f10);
    }

    public void setShadowWidth(boolean z10) {
        this.mShowCandleBar = z10;
    }

    public RealmCandleDataSet(RealmResults<T> realmResults, String str, String str2, String str3, String str4, String str5) {
        super(realmResults, (String) null, str5);
        this.mHighField = str;
        this.mLowField = str2;
        this.mOpenField = str3;
        this.mCloseField = str4;
        build(this.results);
        calcMinMax(0, this.results.size());
    }
}
