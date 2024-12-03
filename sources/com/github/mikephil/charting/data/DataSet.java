package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected float mYMax = 0.0f;
    protected float mYMin = 0.0f;
    protected List<T> mYVals;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.mYVals = list;
        if (list == null) {
            this.mYVals = new ArrayList();
        }
        calcMinMax(0, this.mYVals.size());
    }

    public boolean addEntry(T t10) {
        if (t10 == null) {
            return false;
        }
        float val = t10.getVal();
        List yVals = getYVals();
        if (yVals == null) {
            yVals = new ArrayList();
        }
        if (yVals.size() == 0) {
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
        yVals.add(t10);
        return true;
    }

    public void addEntryOrdered(T t10) {
        if (t10 != null) {
            float val = t10.getVal();
            if (this.mYVals == null) {
                this.mYVals = new ArrayList();
            }
            if (this.mYVals.size() == 0) {
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
            if (this.mYVals.size() > 0) {
                List<T> list = this.mYVals;
                if (((Entry) list.get(list.size() - 1)).getXIndex() > t10.getXIndex()) {
                    this.mYVals.add(getEntryIndex(t10.getXIndex(), Rounding.UP), t10);
                    return;
                }
            }
            this.mYVals.add(t10);
        }
    }

    public void calcMinMax(int i10, int i11) {
        int size;
        List<T> list = this.mYVals;
        if (list != null && (size = list.size()) != 0) {
            if (i11 == 0 || i11 >= size) {
                i11 = size - 1;
            }
            this.mYMin = Float.MAX_VALUE;
            this.mYMax = -3.4028235E38f;
            while (i10 <= i11) {
                Entry entry = (Entry) this.mYVals.get(i10);
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
        this.mYVals.clear();
        notifyDataSetChanged();
    }

    public abstract DataSet<T> copy();

    public List<T> getEntriesForXIndex(int i10) {
        ArrayList arrayList = new ArrayList();
        int size = this.mYVals.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (size + i11) / 2;
            Entry entry = (Entry) this.mYVals.get(i12);
            if (i10 == entry.getXIndex()) {
                while (i12 > 0 && ((Entry) this.mYVals.get(i12 - 1)).getXIndex() == i10) {
                    i12--;
                }
                size = this.mYVals.size();
                while (i12 < size) {
                    entry = (Entry) this.mYVals.get(i12);
                    if (entry.getXIndex() != i10) {
                        break;
                    }
                    arrayList.add(entry);
                    i12++;
                }
            }
            if (i10 > entry.getXIndex()) {
                i11 = i12 + 1;
            } else {
                size = i12 - 1;
            }
        }
        return arrayList;
    }

    public int getEntryCount() {
        return this.mYVals.size();
    }

    public T getEntryForIndex(int i10) {
        return (Entry) this.mYVals.get(i10);
    }

    public T getEntryForXIndex(int i10, Rounding rounding) {
        int entryIndex = getEntryIndex(i10, rounding);
        if (entryIndex > -1) {
            return (Entry) this.mYVals.get(entryIndex);
        }
        return null;
    }

    public int getEntryIndex(Entry entry) {
        return this.mYVals.indexOf(entry);
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

    public List<T> getYVals() {
        return this.mYVals;
    }

    public boolean removeEntry(T t10) {
        List<T> list;
        if (t10 == null || (list = this.mYVals) == null) {
            return false;
        }
        boolean remove = list.remove(t10);
        if (remove) {
            calcMinMax(0, this.mYVals.size());
        }
        return remove;
    }

    public String toSimpleString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DataSet, label: ");
        if (getLabel() == null) {
            str = "";
        } else {
            str = getLabel();
        }
        sb2.append(str);
        sb2.append(", entries: ");
        sb2.append(this.mYVals.size());
        sb2.append("\n");
        stringBuffer.append(sb2.toString());
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(toSimpleString());
        for (int i10 = 0; i10 < this.mYVals.size(); i10++) {
            stringBuffer.append(((Entry) this.mYVals.get(i10)).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public int getEntryIndex(int i10, Rounding rounding) {
        int size = this.mYVals.size() - 1;
        int i11 = 0;
        int i12 = -1;
        while (i11 <= size) {
            i12 = (size + i11) / 2;
            if (i10 == ((Entry) this.mYVals.get(i12)).getXIndex()) {
                while (i12 > 0 && ((Entry) this.mYVals.get(i12 - 1)).getXIndex() == i10) {
                    i12--;
                }
                return i12;
            } else if (i10 > ((Entry) this.mYVals.get(i12)).getXIndex()) {
                i11 = i12 + 1;
            } else {
                size = i12 - 1;
            }
        }
        if (i12 == -1) {
            return i12;
        }
        int xIndex = ((Entry) this.mYVals.get(i12)).getXIndex();
        if (rounding != Rounding.UP) {
            return (rounding != Rounding.DOWN || xIndex <= i10 || i12 <= 0) ? i12 : i12 - 1;
        }
        if (xIndex >= i10 || i12 >= this.mYVals.size() - 1) {
            return i12;
        }
        return i12 + 1;
    }

    public T getEntryForXIndex(int i10) {
        return getEntryForXIndex(i10, Rounding.CLOSEST);
    }
}
