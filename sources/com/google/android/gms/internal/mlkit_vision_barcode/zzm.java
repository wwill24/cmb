package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzz();
    public int zza;
    public String zzb;

    public zzm() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, this.zza);
        a.C(parcel, 3, this.zzb, false);
        a.b(parcel, a10);
    }

    public zzm(int i10, String str) {
        this.zza = i10;
        this.zzb = str;
    }
}
