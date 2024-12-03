package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ParcelableSparseArray;

class NavigationBarPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<NavigationBarPresenter$SavedState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    int f19904a;

    /* renamed from: b  reason: collision with root package name */
    ParcelableSparseArray f19905b;

    class a implements Parcelable.Creator<NavigationBarPresenter$SavedState> {
        a() {
        }

        @NonNull
        /* renamed from: a */
        public NavigationBarPresenter$SavedState createFromParcel(@NonNull Parcel parcel) {
            return new NavigationBarPresenter$SavedState(parcel);
        }

        @NonNull
        /* renamed from: b */
        public NavigationBarPresenter$SavedState[] newArray(int i10) {
            return new NavigationBarPresenter$SavedState[i10];
        }
    }

    NavigationBarPresenter$SavedState() {
    }

    NavigationBarPresenter$SavedState(@NonNull Parcel parcel) {
        this.f19904a = parcel.readInt();
        this.f19905b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeInt(this.f19904a);
        parcel.writeParcelable(this.f19905b, 0);
    }
}
