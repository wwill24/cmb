package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzsm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsm> CREATOR = new zzsn();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final byte[] zzd;
    private final Point[] zze;
    private final int zzf;
    private final zzsf zzg;
    private final zzsi zzh;
    private final zzsj zzi;
    private final zzsl zzj;
    private final zzsk zzk;
    private final zzsg zzl;
    private final zzsc zzm;
    private final zzsd zzn;
    private final zzse zzo;

    public zzsm(int i10, String str, String str2, byte[] bArr, Point[] pointArr, int i11, zzsf zzsf, zzsi zzsi, zzsj zzsj, zzsl zzsl, zzsk zzsk, zzsg zzsg, zzsc zzsc, zzsd zzsd, zzse zzse) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i11;
        this.zzg = zzsf;
        this.zzh = zzsi;
        this.zzi = zzsj;
        this.zzj = zzsl;
        this.zzk = zzsk;
        this.zzl = zzsg;
        this.zzm = zzsc;
        this.zzn = zzsd;
        this.zzo = zzse;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.C(parcel, 2, this.zzb, false);
        a.C(parcel, 3, this.zzc, false);
        a.k(parcel, 4, this.zzd, false);
        a.F(parcel, 5, this.zze, i10, false);
        a.s(parcel, 6, this.zzf);
        a.A(parcel, 7, this.zzg, i10, false);
        a.A(parcel, 8, this.zzh, i10, false);
        a.A(parcel, 9, this.zzi, i10, false);
        a.A(parcel, 10, this.zzj, i10, false);
        a.A(parcel, 11, this.zzk, i10, false);
        a.A(parcel, 12, this.zzl, i10, false);
        a.A(parcel, 13, this.zzm, i10, false);
        a.A(parcel, 14, this.zzn, i10, false);
        a.A(parcel, 15, this.zzo, i10, false);
        a.b(parcel, a10);
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzf;
    }

    public final zzsc zzc() {
        return this.zzm;
    }

    public final zzsd zzd() {
        return this.zzn;
    }

    public final zzse zze() {
        return this.zzo;
    }

    public final zzsf zzf() {
        return this.zzg;
    }

    public final zzsg zzg() {
        return this.zzl;
    }

    public final zzsi zzh() {
        return this.zzh;
    }

    public final zzsj zzi() {
        return this.zzi;
    }

    public final zzsk zzj() {
        return this.zzk;
    }

    public final zzsl zzk() {
        return this.zzj;
    }

    public final String zzl() {
        return this.zzb;
    }

    public final String zzm() {
        return this.zzc;
    }

    public final byte[] zzn() {
        return this.zzd;
    }

    public final Point[] zzo() {
        return this.zze;
    }
}
