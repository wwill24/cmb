package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzu();
    public zzl zza;
    public String zzb;
    public String zzc;
    public zzm[] zzd;
    public zzj[] zze;
    public String[] zzf;
    public zze[] zzg;

    public zzh() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 2, this.zza, i10, false);
        a.C(parcel, 3, this.zzb, false);
        a.C(parcel, 4, this.zzc, false);
        a.F(parcel, 5, this.zzd, i10, false);
        a.F(parcel, 6, this.zze, i10, false);
        a.D(parcel, 7, this.zzf, false);
        a.F(parcel, 8, this.zzg, i10, false);
        a.b(parcel, a10);
    }

    public zzh(zzl zzl, String str, String str2, zzm[] zzmArr, zzj[] zzjArr, String[] strArr, zze[] zzeArr) {
        this.zza = zzl;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzmArr;
        this.zze = zzjArr;
        this.zzf = strArr;
        this.zzg = zzeArr;
    }
}
