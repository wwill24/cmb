package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzsc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsc> CREATOR = new zzsr();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final zzsb zzf;
    private final zzsb zzg;

    public zzsc(String str, String str2, String str3, String str4, String str5, zzsb zzsb, zzsb zzsb2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = zzsb;
        this.zzg = zzsb2;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.C(parcel, 2, this.zzb, false);
        a.C(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.C(parcel, 5, this.zze, false);
        a.A(parcel, 6, this.zzf, i10, false);
        a.A(parcel, 7, this.zzg, i10, false);
        a.b(parcel, a10);
    }

    public final zzsb zza() {
        return this.zzg;
    }

    public final zzsb zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd;
    }

    public final String zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zza;
    }
}
