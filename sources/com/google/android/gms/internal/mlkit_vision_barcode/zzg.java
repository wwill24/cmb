package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzt();
    public String zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public zzf zzf;
    public zzf zzg;

    public zzg() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, this.zza, false);
        a.C(parcel, 3, this.zzb, false);
        a.C(parcel, 4, this.zzc, false);
        a.C(parcel, 5, this.zzd, false);
        a.C(parcel, 6, this.zze, false);
        a.A(parcel, 7, this.zzf, i10, false);
        a.A(parcel, 8, this.zzg, i10, false);
        a.b(parcel, a10);
    }

    public zzg(String str, String str2, String str3, String str4, String str5, zzf zzf2, zzf zzf3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = zzf2;
        this.zzg = zzf3;
    }
}
