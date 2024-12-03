package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

class RangeSlider$RangeSliderState extends AbsSavedState {
    public static final Parcelable.Creator<RangeSlider$RangeSliderState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private float f20068a;

    /* renamed from: b  reason: collision with root package name */
    private int f20069b;

    class a implements Parcelable.Creator<RangeSlider$RangeSliderState> {
        a() {
        }

        /* renamed from: a */
        public RangeSlider$RangeSliderState createFromParcel(Parcel parcel) {
            return new RangeSlider$RangeSliderState(parcel);
        }

        /* renamed from: b */
        public RangeSlider$RangeSliderState[] newArray(int i10) {
            return new RangeSlider$RangeSliderState[i10];
        }
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f20068a);
        parcel.writeInt(this.f20069b);
    }

    private RangeSlider$RangeSliderState(Parcel parcel) {
        super(parcel.readParcelable(RangeSlider$RangeSliderState.class.getClassLoader()));
        this.f20068a = parcel.readFloat();
        this.f20069b = parcel.readInt();
    }
}
