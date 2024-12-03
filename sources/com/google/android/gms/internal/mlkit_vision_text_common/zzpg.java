package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public final class zzpg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpg> CREATOR = new zzph();
    private final String zza;
    private final List zzb;

    public zzpg(String str, List list) {
        this.zza = str;
        this.zzb = list;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.G(parcel, 2, this.zzb, false);
        a.b(parcel, a10);
    }

    public final String zza() {
        return this.zza;
    }

    public final List zzb() {
        return this.zzb;
    }
}
