package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzg extends AbstractSafeParcelable implements j {
    public static final Parcelable.Creator<zzg> CREATOR = new zzh();
    public static final zzg zza = new zzg(Status.f38500g);
    private final Status zzb;

    public zzg(Status status) {
        this.zzb = status;
    }

    public final Status getStatus() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, this.zzb, i10, false);
        a.b(parcel, a10);
    }
}
