package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    public final zzn[] zza;
    public final zzf zzb;
    public final zzf zzc;
    public final String zzd;
    public final float zze;
    public final String zzf;
    public final boolean zzg;

    public zzr(zzn[] zznArr, zzf zzf2, zzf zzf3, String str, float f10, String str2, boolean z10) {
        this.zza = zznArr;
        this.zzb = zzf2;
        this.zzc = zzf3;
        this.zzd = str;
        this.zze = f10;
        this.zzf = str2;
        this.zzg = z10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.F(parcel, 2, this.zza, i10, false);
        a.A(parcel, 3, this.zzb, i10, false);
        a.A(parcel, 4, this.zzc, i10, false);
        a.C(parcel, 5, this.zzd, false);
        a.o(parcel, 6, this.zze);
        a.C(parcel, 7, this.zzf, false);
        a.g(parcel, 8, this.zzg);
        a.b(parcel, a10);
    }
}
