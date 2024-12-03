package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzsj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsj> CREATOR = new zztc();
    private final String zza;
    private final String zzb;

    public zzsj(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.C(parcel, 2, this.zzb, false);
        a.b(parcel, a10);
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
