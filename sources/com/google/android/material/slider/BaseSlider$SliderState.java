package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;

class BaseSlider$SliderState extends View.BaseSavedState {
    public static final Parcelable.Creator<BaseSlider$SliderState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    float f20063a;

    /* renamed from: b  reason: collision with root package name */
    float f20064b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<Float> f20065c;

    /* renamed from: d  reason: collision with root package name */
    float f20066d;

    /* renamed from: e  reason: collision with root package name */
    boolean f20067e;

    class a implements Parcelable.Creator<BaseSlider$SliderState> {
        a() {
        }

        @NonNull
        /* renamed from: a */
        public BaseSlider$SliderState createFromParcel(@NonNull Parcel parcel) {
            return new BaseSlider$SliderState(parcel, (a) null);
        }

        @NonNull
        /* renamed from: b */
        public BaseSlider$SliderState[] newArray(int i10) {
            return new BaseSlider$SliderState[i10];
        }
    }

    /* synthetic */ BaseSlider$SliderState(Parcel parcel, a aVar) {
        this(parcel);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f20063a);
        parcel.writeFloat(this.f20064b);
        parcel.writeList(this.f20065c);
        parcel.writeFloat(this.f20066d);
        parcel.writeBooleanArray(new boolean[]{this.f20067e});
    }

    private BaseSlider$SliderState(@NonNull Parcel parcel) {
        super(parcel);
        this.f20063a = parcel.readFloat();
        this.f20064b = parcel.readFloat();
        ArrayList<Float> arrayList = new ArrayList<>();
        this.f20065c = arrayList;
        parcel.readList(arrayList, Float.class.getClassLoader());
        this.f20066d = parcel.readFloat();
        this.f20067e = parcel.createBooleanArray()[0];
    }
}
