package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

public class Entry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        public Entry[] newArray(int i10) {
            return new Entry[i10];
        }
    };
    private Object mData;
    private float mVal;
    private int mXIndex;

    public Entry(float f10, int i10) {
        this.mData = null;
        this.mVal = f10;
        this.mXIndex = i10;
    }

    public Entry copy() {
        return new Entry(this.mVal, this.mXIndex, this.mData);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equalTo(Entry entry) {
        if (entry != null && entry.mData == this.mData && entry.mXIndex == this.mXIndex && Math.abs(entry.mVal - this.mVal) <= 1.0E-5f) {
            return true;
        }
        return false;
    }

    public Object getData() {
        return this.mData;
    }

    public float getVal() {
        return this.mVal;
    }

    public int getXIndex() {
        return this.mXIndex;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setVal(float f10) {
        this.mVal = f10;
    }

    public void setXIndex(int i10) {
        this.mXIndex = i10;
    }

    public String toString() {
        return "Entry, xIndex: " + this.mXIndex + " val (sum): " + getVal();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.mVal);
        parcel.writeInt(this.mXIndex);
        Object obj = this.mData;
        if (obj == null) {
            parcel.writeInt(0);
        } else if (obj instanceof Parcelable) {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) this.mData, i10);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }

    public Entry(float f10, int i10, Object obj) {
        this(f10, i10);
        this.mData = obj;
    }

    protected Entry(Parcel parcel) {
        this.mVal = 0.0f;
        this.mXIndex = 0;
        this.mData = null;
        this.mVal = parcel.readFloat();
        this.mXIndex = parcel.readInt();
        if (parcel.readInt() == 1) {
            this.mData = parcel.readParcelable(Object.class.getClassLoader());
        }
    }
}
