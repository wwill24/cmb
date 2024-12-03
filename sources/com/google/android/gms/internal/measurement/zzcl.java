package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzcl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcl> CREATOR = new zzcm();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final Bundle zzg;
    public final String zzh;

    public zzcl(long j10, long j11, boolean z10, String str, String str2, String str3, Bundle bundle, String str4) {
        this.zza = j10;
        this.zzb = j11;
        this.zzc = z10;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = bundle;
        this.zzh = str4;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.v(parcel, 1, this.zza);
        a.v(parcel, 2, this.zzb);
        a.g(parcel, 3, this.zzc);
        a.C(parcel, 4, this.zzd, false);
        a.C(parcel, 5, this.zze, false);
        a.C(parcel, 6, this.zzf, false);
        a.j(parcel, 7, this.zzg, false);
        a.C(parcel, 8, this.zzh, false);
        a.b(parcel, a10);
    }
}
