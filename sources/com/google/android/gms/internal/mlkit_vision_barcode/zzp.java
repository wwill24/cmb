package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzac();
    public String zza;
    public String zzb;
    public int zzc;

    public zzp() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, this.zza, false);
        a.C(parcel, 3, this.zzb, false);
        a.s(parcel, 4, this.zzc);
        a.b(parcel, a10);
    }

    public zzp(String str, String str2, int i10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i10;
    }
}
