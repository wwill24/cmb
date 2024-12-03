package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

class NavigationBarView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<NavigationBarView$SavedState> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    Bundle f19906c;

    class a implements Parcelable.ClassLoaderCreator<NavigationBarView$SavedState> {
        a() {
        }

        /* renamed from: a */
        public NavigationBarView$SavedState createFromParcel(@NonNull Parcel parcel) {
            return new NavigationBarView$SavedState(parcel, (ClassLoader) null);
        }

        @NonNull
        /* renamed from: b */
        public NavigationBarView$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new NavigationBarView$SavedState(parcel, classLoader);
        }

        @NonNull
        /* renamed from: c */
        public NavigationBarView$SavedState[] newArray(int i10) {
            return new NavigationBarView$SavedState[i10];
        }
    }

    public NavigationBarView$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        c(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
    }

    private void c(@NonNull Parcel parcel, ClassLoader classLoader) {
        this.f19906c = parcel.readBundle(classLoader);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeBundle(this.f19906c);
    }
}
