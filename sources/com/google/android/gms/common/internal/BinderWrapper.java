package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new i1();

    /* renamed from: a  reason: collision with root package name */
    private IBinder f38918a;

    /* synthetic */ BinderWrapper(Parcel parcel, j1 j1Var) {
        this.f38918a = parcel.readStrongBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeStrongBinder(this.f38918a);
    }
}
