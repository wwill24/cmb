package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();
    public final int zza;
    public final int zzb;
    public final float zzc;
    public final float zzd;
    public final float zze;
    public final float zzf;
    public final float zzg;
    public final float zzh;
    public final float zzi;
    public final zzn[] zzj;
    public final float zzk;
    public final float zzl;
    public final float zzm;
    public final zzd[] zzn;
    public final float zzo;

    public zzf(int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, zzn[] zznArr, float f17, float f18, float f19, zzd[] zzdArr, float f20) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = f10;
        this.zzd = f11;
        this.zze = f12;
        this.zzf = f13;
        this.zzg = f14;
        this.zzh = f15;
        this.zzi = f16;
        this.zzj = zznArr;
        this.zzk = f17;
        this.zzl = f18;
        this.zzm = f19;
        this.zzn = zzdArr;
        this.zzo = f20;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.s(parcel, 2, this.zzb);
        a.o(parcel, 3, this.zzc);
        a.o(parcel, 4, this.zzd);
        a.o(parcel, 5, this.zze);
        a.o(parcel, 6, this.zzf);
        a.o(parcel, 7, this.zzg);
        a.o(parcel, 8, this.zzh);
        a.F(parcel, 9, this.zzj, i10, false);
        a.o(parcel, 10, this.zzk);
        a.o(parcel, 11, this.zzl);
        a.o(parcel, 12, this.zzm);
        a.F(parcel, 13, this.zzn, i10, false);
        a.o(parcel, 14, this.zzi);
        a.o(parcel, 15, this.zzo);
        a.b(parcel, a10);
    }
}
