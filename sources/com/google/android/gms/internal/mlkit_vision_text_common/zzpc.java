package com.google.android.gms.internal.mlkit_vision_text_common;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public final class zzpc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpc> CREATOR = new zzpd();
    private final String zza;
    private final Rect zzb;
    private final List zzc;
    private final String zzd;
    private final float zze;
    private final float zzf;
    private final List zzg;

    public zzpc(String str, Rect rect, List list, String str2, float f10, float f11, List list2) {
        this.zza = str;
        this.zzb = rect;
        this.zzc = list;
        this.zzd = str2;
        this.zze = f10;
        this.zzf = f11;
        this.zzg = list2;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.A(parcel, 2, this.zzb, i10, false);
        a.G(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.o(parcel, 5, this.zze);
        a.o(parcel, 6, this.zzf);
        a.G(parcel, 7, this.zzg, false);
        a.b(parcel, a10);
    }

    public final float zza() {
        return this.zzf;
    }

    public final float zzb() {
        return this.zze;
    }

    public final Rect zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zza;
    }

    public final List zzf() {
        return this.zzc;
    }

    public final List zzg() {
        return this.zzg;
    }
}
