package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

public class NavigationView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<NavigationView$SavedState> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public Bundle f19907c;

    class a implements Parcelable.ClassLoaderCreator<NavigationView$SavedState> {
        a() {
        }

        /* renamed from: a */
        public NavigationView$SavedState createFromParcel(@NonNull Parcel parcel) {
            return new NavigationView$SavedState(parcel, (ClassLoader) null);
        }

        @NonNull
        /* renamed from: b */
        public NavigationView$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new NavigationView$SavedState(parcel, classLoader);
        }

        @NonNull
        /* renamed from: c */
        public NavigationView$SavedState[] newArray(int i10) {
            return new NavigationView$SavedState[i10];
        }
    }

    public NavigationView$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f19907c = parcel.readBundle(classLoader);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeBundle(this.f19907c);
    }
}
