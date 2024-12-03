package com.google.android.gms.internal.mlkit_vision_text_common;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public final class zzpi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpi> CREATOR = new zzpj();
    private final String zza;
    private final Rect zzb;
    private final List zzc;
    private final float zzd;
    private final float zze;

    public zzpi(String str, Rect rect, List list, float f10, float f11) {
        this.zza = str;
        this.zzb = rect;
        this.zzc = list;
        this.zzd = f10;
        this.zze = f11;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.A(parcel, 2, this.zzb, i10, false);
        a.G(parcel, 3, this.zzc, false);
        a.o(parcel, 4, this.zzd);
        a.o(parcel, 5, this.zze);
        a.b(parcel, a10);
    }

    public final float zza() {
        return this.zze;
    }

    public final float zzb() {
        return this.zzd;
    }

    public final Rect zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zza;
    }

    public final List zze() {
        return this.zzc;
    }
}
