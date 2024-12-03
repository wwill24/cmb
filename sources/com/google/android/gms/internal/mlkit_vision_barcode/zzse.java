package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzse> CREATOR = new zzst();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;
    private final String zzm;
    private final String zzn;

    public zzse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = str9;
        this.zzj = str10;
        this.zzk = str11;
        this.zzl = str12;
        this.zzm = str13;
        this.zzn = str14;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.C(parcel, 2, this.zzb, false);
        a.C(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.C(parcel, 5, this.zze, false);
        a.C(parcel, 6, this.zzf, false);
        a.C(parcel, 7, this.zzg, false);
        a.C(parcel, 8, this.zzh, false);
        a.C(parcel, 9, this.zzi, false);
        a.C(parcel, 10, this.zzj, false);
        a.C(parcel, 11, this.zzk, false);
        a.C(parcel, 12, this.zzl, false);
        a.C(parcel, 13, this.zzm, false);
        a.C(parcel, 14, this.zzn, false);
        a.b(parcel, a10);
    }

    public final String zza() {
        return this.zzg;
    }

    public final String zzb() {
        return this.zzh;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        return this.zzm;
    }

    public final String zzf() {
        return this.zza;
    }

    public final String zzg() {
        return this.zzl;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zze;
    }

    public final String zzj() {
        return this.zzk;
    }

    public final String zzk() {
        return this.zzn;
    }

    public final String zzl() {
        return this.zzd;
    }

    public final String zzm() {
        return this.zzj;
    }

    public final String zzn() {
        return this.zzc;
    }
}
