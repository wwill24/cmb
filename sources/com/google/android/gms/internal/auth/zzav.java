package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
    final int zza;
    public final String zzb;
    public final int zzc;

    zzav(int i10, String str, int i11) {
        this.zza = 1;
        this.zzb = (String) p.k(str);
        this.zzc = i11;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.C(parcel, 2, this.zzb, false);
        a.s(parcel, 3, this.zzc);
        a.b(parcel, a10);
    }

    public zzav(String str, int i10) {
        this(1, str, i10);
    }
}
