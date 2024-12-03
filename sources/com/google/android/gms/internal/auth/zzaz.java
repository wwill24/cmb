package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzaz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaz> CREATOR = new zzba();
    final int zza;
    public final String zzb;
    public final byte[] zzc;

    zzaz(int i10, String str, byte[] bArr) {
        this.zza = 1;
        this.zzb = (String) p.k(str);
        this.zzc = (byte[]) p.k(bArr);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.C(parcel, 2, this.zzb, false);
        a.k(parcel, 3, this.zzc, false);
        a.b(parcel, a10);
    }

    public zzaz(String str, byte[] bArr) {
        this(1, str, bArr);
    }
}
