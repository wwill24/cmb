package com.google.android.gms.internal.mlkit_vision_text_common;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public final class zzpa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpa> CREATOR = new zzpb();
    private final String zza;
    private final Rect zzb;
    private final List zzc;
    private final String zzd;
    private final List zze;

    public zzpa(String str, Rect rect, List list, String str2, List list2) {
        this.zza = str;
        this.zzb = rect;
        this.zzc = list;
        this.zzd = str2;
        this.zze = list2;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.A(parcel, 2, this.zzb, i10, false);
        a.G(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.G(parcel, 5, this.zze, false);
        a.b(parcel, a10);
    }

    public final Rect zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final List zzd() {
        return this.zzc;
    }

    public final List zze() {
        return this.zze;
    }
}
