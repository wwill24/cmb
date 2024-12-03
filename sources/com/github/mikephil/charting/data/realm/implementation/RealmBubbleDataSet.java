package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.realm.base.RealmBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;
import java.util.List;

public class RealmBubbleDataSet<T extends RealmObject> extends RealmBarLineScatterCandleBubbleDataSet<T, BubbleEntry> implements IBubbleDataSet {
    private float mHighlightCircleWidth = 2.5f;
    protected float mMaxSize;
    private String mSizeField;
    protected float mXMax;
    protected float mXMin;

    public RealmBubbleDataSet(RealmResults<T> realmResults, String str, String str2) {
        super(realmResults, str);
        this.mSizeField = str2;
        build(this.results);
        calcMinMax(0, this.results.size());
    }

    private float largestSize(BubbleEntry bubbleEntry) {
        return bubbleEntry.getSize();
    }

    private float xMax(BubbleEntry bubbleEntry) {
        return (float) bubbleEntry.getXIndex();
    }

    private float xMin(BubbleEntry bubbleEntry) {
        return (float) bubbleEntry.getXIndex();
    }

    private float yMax(BubbleEntry bubbleEntry) {
        return bubbleEntry.getVal();
    }

    private float yMin(BubbleEntry bubbleEntry) {
        return bubbleEntry.getVal();
    }

    public void build(RealmResults<T> realmResults) {
        if (this.mIndexField == null) {
            int i10 = 0;
            Iterator it = realmResults.iterator();
            while (it.hasNext()) {
                DynamicRealmObject dynamicRealmObject = new DynamicRealmObject((RealmObject) it.next());
                this.mValues.add(new BubbleEntry(i10, dynamicRealmObject.getFloat(this.mValuesField), dynamicRealmObject.getFloat(this.mSizeField)));
                i10++;
            }
            return;
        }
        Iterator it2 = realmResults.iterator();
        while (it2.hasNext()) {
            DynamicRealmObject dynamicRealmObject2 = new DynamicRealmObject((RealmObject) it2.next());
            this.mValues.add(new BubbleEntry(dynamicRealmObject2.getInt(this.mIndexField), dynamicRealmObject2.getFloat(this.mValuesField), dynamicRealmObject2.getFloat(this.mSizeField)));
        }
    }

    public void calcMinMax(int i10, int i11) {
        List<S> list = this.mValues;
        if (list != null && list.size() != 0) {
            if (i11 == 0 || i11 >= this.mValues.size()) {
                i11 = this.mValues.size() - 1;
            }
            this.mYMin = yMin((BubbleEntry) this.mValues.get(i10));
            this.mYMax = yMax((BubbleEntry) this.mValues.get(i10));
            while (i10 < i11) {
                BubbleEntry bubbleEntry = (BubbleEntry) this.mValues.get(i10);
                float yMin = yMin(bubbleEntry);
                float yMax = yMax(bubbleEntry);
                if (yMin < this.mYMin) {
                    this.mYMin = yMin;
                }
                if (yMax > this.mYMax) {
                    this.mYMax = yMax;
                }
                float xMin = xMin(bubbleEntry);
                float xMax = xMax(bubbleEntry);
                if (xMin < this.mXMin) {
                    this.mXMin = xMin;
                }
                if (xMax > this.mXMax) {
                    this.mXMax = xMax;
                }
                float largestSize = largestSize(bubbleEntry);
                if (largestSize > this.mMaxSize) {
                    this.mMaxSize = largestSize;
                }
                i10++;
            }
        }
    }

    public float getHighlightCircleWidth() {
        return this.mHighlightCircleWidth;
    }

    public float getMaxSize() {
        return this.mMaxSize;
    }

    public String getSizeField() {
        return this.mSizeField;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public void setHighlightCircleWidth(float f10) {
        this.mHighlightCircleWidth = Utils.convertDpToPixel(f10);
    }

    public void setSizeField(String str) {
        this.mSizeField = str;
    }

    public RealmBubbleDataSet(RealmResults<T> realmResults, String str, String str2, String str3) {
        super(realmResults, str, str2);
        this.mSizeField = str3;
        build(this.results);
        calcMinMax(0, this.results.size());
    }
}
