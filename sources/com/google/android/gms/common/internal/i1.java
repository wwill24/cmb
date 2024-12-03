package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class i1 implements Parcelable.Creator {
    i1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (j1) null);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new BinderWrapper[i10];
    }
}
