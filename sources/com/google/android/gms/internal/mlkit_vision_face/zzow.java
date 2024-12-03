package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public final class zzow extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzow> CREATOR = new zzox();
    private final int zza;
    private final Rect zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final float zzf;
    private final float zzg;
    private final float zzh;
    private final float zzi;
    private final List zzj;
    private final List zzk;

    public zzow(int i10, Rect rect, float f10, float f11, float f12, float f13, float f14, float f15, float f16, List list, List list2) {
        this.zza = i10;
        this.zzb = rect;
        this.zzc = f10;
        this.zzd = f11;
        this.zze = f12;
        this.zzf = f13;
        this.zzg = f14;
        this.zzh = f15;
        this.zzi = f16;
        this.zzj = list;
        this.zzk = list2;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.A(parcel, 2, this.zzb, i10, false);
        a.o(parcel, 3, this.zzc);
        a.o(parcel, 4, this.zzd);
        a.o(parcel, 5, this.zze);
        a.o(parcel, 6, this.zzf);
        a.o(parcel, 7, this.zzg);
        a.o(parcel, 8, this.zzh);
        a.o(parcel, 9, this.zzi);
        a.G(parcel, 10, this.zzj, false);
        a.G(parcel, 11, this.zzk, false);
        a.b(parcel, a10);
    }

    public final float zza() {
        return this.zzf;
    }

    public final float zzb() {
        return this.zzd;
    }

    public final float zzc() {
        return this.zzg;
    }

    public final float zzd() {
        return this.zzc;
    }

    public final float zze() {
        return this.zzh;
    }

    public final float zzf() {
        return this.zze;
    }

    public final int zzg() {
        return this.zza;
    }

    public final Rect zzh() {
        return this.zzb;
    }

    public final List zzi() {
        return this.zzk;
    }

    public final List zzj() {
        return this.zzj;
    }
}
