package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzaa();
    public String zza;
    public String zzb;

    public zzn() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, this.zza, false);
        a.C(parcel, 3, this.zzb, false);
        a.b(parcel, a10);
    }

    public zzn(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }
}
