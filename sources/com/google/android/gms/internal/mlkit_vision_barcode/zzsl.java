package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzsl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsl> CREATOR = new zzte();
    private final String zza;
    private final String zzb;
    private final int zzc;

    public zzsl(String str, String str2, int i10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.C(parcel, 2, this.zzb, false);
        a.s(parcel, 3, this.zzc);
        a.b(parcel, a10);
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
