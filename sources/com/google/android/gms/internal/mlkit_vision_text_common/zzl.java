package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    public final zzr[] zza;
    public final zzf zzb;
    public final zzf zzc;
    public final zzf zzd;
    public final String zze;
    public final float zzf;
    public final String zzg;
    public final int zzh;
    public final boolean zzi;
    public final int zzj;
    public final int zzk;

    public zzl(zzr[] zzrArr, zzf zzf2, zzf zzf3, zzf zzf4, String str, float f10, String str2, int i10, boolean z10, int i11, int i12) {
        this.zza = zzrArr;
        this.zzb = zzf2;
        this.zzc = zzf3;
        this.zzd = zzf4;
        this.zze = str;
        this.zzf = f10;
        this.zzg = str2;
        this.zzh = i10;
        this.zzi = z10;
        this.zzj = i11;
        this.zzk = i12;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.F(parcel, 2, this.zza, i10, false);
        a.A(parcel, 3, this.zzb, i10, false);
        a.A(parcel, 4, this.zzc, i10, false);
        a.A(parcel, 5, this.zzd, i10, false);
        a.C(parcel, 6, this.zze, false);
        a.o(parcel, 7, this.zzf);
        a.C(parcel, 8, this.zzg, false);
        a.s(parcel, 9, this.zzh);
        a.g(parcel, 10, this.zzi);
        a.s(parcel, 11, this.zzj);
        a.s(parcel, 12, this.zzk);
        a.b(parcel, a10);
    }
}
