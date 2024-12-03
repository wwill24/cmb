package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzsd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsd> CREATOR = new zzss();
    private final zzsh zza;
    private final String zzb;
    private final String zzc;
    private final zzsi[] zzd;
    private final zzsf[] zze;
    private final String[] zzf;
    private final zzsa[] zzg;

    public zzsd(zzsh zzsh, String str, String str2, zzsi[] zzsiArr, zzsf[] zzsfArr, String[] strArr, zzsa[] zzsaArr) {
        this.zza = zzsh;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzsiArr;
        this.zze = zzsfArr;
        this.zzf = strArr;
        this.zzg = zzsaArr;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, this.zza, i10, false);
        a.C(parcel, 2, this.zzb, false);
        a.C(parcel, 3, this.zzc, false);
        a.F(parcel, 4, this.zzd, i10, false);
        a.F(parcel, 5, this.zze, i10, false);
        a.D(parcel, 6, this.zzf, false);
        a.F(parcel, 7, this.zzg, i10, false);
        a.b(parcel, a10);
    }

    public final zzsh zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final zzsa[] zzd() {
        return this.zzg;
    }

    public final zzsf[] zze() {
        return this.zze;
    }

    public final zzsi[] zzf() {
        return this.zzd;
    }

    public final String[] zzg() {
        return this.zzf;
    }
}
