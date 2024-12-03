package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    public final PointF[] zza;
    public final int zzb;

    public zzd(PointF[] pointFArr, int i10) {
        this.zza = pointFArr;
        this.zzb = i10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.F(parcel, 2, this.zza, i10, false);
        a.s(parcel, 3, this.zzb);
        a.b(parcel, a10);
    }
}
