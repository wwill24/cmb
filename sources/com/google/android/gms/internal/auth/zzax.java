package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzax> CREATOR = new zzay();
    final int zza;
    public final String zzb;

    zzax(int i10, String str) {
        this.zza = 1;
        this.zzb = (String) p.k(str);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.C(parcel, 2, this.zzb, false);
        a.b(parcel, a10);
    }

    public zzax(String str) {
        this(1, str);
    }
}
