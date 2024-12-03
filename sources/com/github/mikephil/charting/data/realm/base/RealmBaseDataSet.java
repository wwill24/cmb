package com.github.mikephil.charting.data.realm.base;

import com.github.mikephil.charting.data.BaseDataSet;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;
import java.util.ArrayList;
import java.util.List;

public abstract class RealmBaseDataSet<T extends RealmObject, S extends Entry> extends BaseDataSet<S> {
    protected String mIndexField;
    protected List<S> mValues;
    protected String mValuesField;
    protected float mYMax = 0.0f;
    protected float mYMin = 0.0f;
    protected RealmResults<T> results;

    public RealmBaseDataSet(RealmResults<T> realmResults, String str) {
        this.results = realmResults;
        this.mValuesField = str;
        this.mValues = new ArrayList();
        String str2 = this.mIndexField;
        if (str2 != null) {
            this.results.sort(str2, Sort.ASCENDING);
        }
    }

    public boolean addEntry(S s10) {
        if (s10 == null) {
            return false;
        }
        float val = s10.getVal();
        if (this.mValues == null) {
            this.mValues = new ArrayList();
        }
        if (this.mValues.size() == 0) {
            this.mYMax = val;
            this.mYMin = val;
        } else {
            if (this.mYMax < val) {
                this.mYMax = val;
            }
            if (this.mYMin > val) {
                this.mYMin = val;
            }
        }
        this.mValues.add(s10);
        return true;
    }

    public void addEntryOrdered(S s10) {
        if (s10 != null) {
            float val = s10.getVal();
            if (this.mValues == null) {
                this.mValues = new ArrayList();
            }
            if (this.mValues.size() == 0) {
                this.mYMax = val;
                this.mYMin = val;
            } else {
                if (this.mYMax < val) {
                    this.mYMax = val;
                }
                if (this.mYMin > val) {
                    this.mYMin = val;
                }
            }
            if (this.mValues.size() > 0) {
                List<S> list = this.mValues;
                if (((Entry) list.get(list.size() - 1)).getXIndex() > s10.getXIndex()) {
                    this.mValues.add(getEntryIndex(s10.getXIndex(), DataSet.Rounding.UP), s10);
                    return;
                }
            }
            this.mValues.add(s10);
        }
    }

    public abstract void build(RealmResults<T> realmResults);

    public void calcMinMax(int i10, int i11) {
        int size;
        List<S> list = this.mValues;
        if (list != null && (size = list.size()) != 0) {
            if (i11 == 0 || i11 >= size) {
                i11 = size - 1;
            }
            this.mYMin = Float.MAX_VALUE;
            this.mYMax = -3.4028235E38f;
            while (i10 <= i11) {
                Entry entry = (Entry) this.mValues.get(i10);
                if (entry != null && !Float.isNaN(entry.getVal())) {
                    if (entry.getVal() < this.mYMin) {
                        this.mYMin = entry.getVal();
                    }
                    if (entry.getVal() > this.mYMax) {
                        this.mYMax = entry.getVal();
                    }
                }
                i10++;
            }
            if (this.mYMin == Float.MAX_VALUE) {
                this.mYMin = 0.0f;
                this.mYMax = 0.0f;
            }
        }
    }

    public void clear() {
        this.mValues.clear();
        notifyDataSetChanged();
    }

    public int getEntryCount() {
        return this.mValues.size();
    }

    public S getEntryForIndex(int i10) {
        return (Entry) this.mValues.get(i10);
    }

    public S getEntryForXIndex(int i10) {
        return getEntryForXIndex(i10, DataSet.Rounding.CLOSEST);
    }

    public int getEntryIndex(int i10, DataSet.Rounding rounding) {
        int size = this.mValues.size() - 1;
        int i11 = 0;
        int i12 = -1;
        while (i11 <= size) {
            i12 = (size + i11) / 2;
            if (i10 == ((Entry) this.mValues.get(i12)).getXIndex()) {
                while (i12 > 0 && ((Entry) this.mValues.get(i12 - 1)).getXIndex() == i10) {
                    i12--;
                }
                return i12;
            } else if (i10 > ((Entry) this.mValues.get(i12)).getXIndex()) {
                i11 = i12 + 1;
            } else {
                size = i12 - 1;
            }
        }
        if (i12 == -1) {
            return i12;
        }
        int xIndex = ((Entry) this.mValues.get(i12)).getXIndex();
        if (rounding != DataSet.Rounding.UP) {
            return (rounding != DataSet.Rounding.DOWN || xIndex <= i10 || i12 <= 0) ? i12 : i12 - 1;
        }
        if (xIndex >= i10 || i12 >= this.mValues.size() - 1) {
            return i12;
        }
        return i12 + 1;
    }

    public String getIndexField() {
        return this.mIndexField;
    }

    public RealmResults<T> getResults() {
        return this.results;
    }

    public List<S> getValues() {
        return this.mValues;
    }

    public String getValuesField() {
        return this.mValuesField;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getYMin() {
        return this.mYMin;
    }

    public float getYValForXIndex(int i10) {
        Entry entryForXIndex = getEntryForXIndex(i10);
        if (entryForXIndex == null || entryForXIndex.getXIndex() != i10) {
            return Float.NaN;
        }
        return entryForXIndex.getVal();
    }

    public boolean removeEntry(S s10) {
        List<S> list;
        if (s10 == null || (list = this.mValues) == null) {
            return false;
        }
        boolean remove = list.remove(s10);
        if (remove) {
            calcMinMax(0, this.mValues.size());
        }
        return remove;
    }

    public void setIndexField(String str) {
        this.mIndexField = str;
    }

    public void setValuesField(String str) {
        this.mValuesField = str;
    }

    public S getEntryForXIndex(int i10, DataSet.Rounding rounding) {
        int entryIndex = getEntryIndex(i10, rounding);
        if (entryIndex > -1) {
            return (Entry) this.mValues.get(entryIndex);
        }
        return null;
    }

    public RealmBaseDataSet(RealmResults<T> realmResults, String str, String str2) {
        this.results = realmResults;
        this.mValuesField = str;
        this.mIndexField = str2;
        this.mValues = new ArrayList();
        String str3 = this.mIndexField;
        if (str3 != null) {
            this.results.sort(str3, Sort.ASCENDING);
        }
    }

    public int getEntryIndex(S s10) {
        return this.mValues.indexOf(s10);
    }
}
