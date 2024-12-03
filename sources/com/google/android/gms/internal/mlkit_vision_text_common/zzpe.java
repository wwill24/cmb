package com.google.android.gms.internal.mlkit_vision_text_common;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public final class zzpe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpe> CREATOR = new zzpf();
    private final String zza;
    private final Rect zzb;
    private final List zzc;
    private final String zzd;
    private final List zze;
    private final float zzf;
    private final float zzg;

    public zzpe(String str, Rect rect, List list, String str2, List list2, float f10, float f11) {
        this.zza = str;
        this.zzb = rect;
        this.zzc = list;
        this.zzd = str2;
        this.zze = list2;
        this.zzf = f10;
        this.zzg = f11;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.A(parcel, 2, this.zzb, i10, false);
        a.G(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.G(parcel, 5, this.zze, false);
        a.o(parcel, 6, this.zzf);
        a.o(parcel, 7, this.zzg);
        a.b(parcel, a10);
    }

    public final float zza() {
        return this.zzg;
    }

    public final float zzb() {
        return this.zzf;
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
        return this.zze;
    }
}
