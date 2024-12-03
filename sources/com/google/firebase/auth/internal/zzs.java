package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zze;

public final class zzs implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        zzx zzx = null;
        zzp zzp = null;
        zze zze = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                zzx = (zzx) SafeParcelReader.n(parcel, B, zzx.CREATOR);
            } else if (u10 == 2) {
                zzp = (zzp) SafeParcelReader.n(parcel, B, zzp.CREATOR);
            } else if (u10 != 3) {
                SafeParcelReader.J(parcel, B);
            } else {
                zze = (zze) SafeParcelReader.n(parcel, B, zze.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzr(zzx, zzp, zze);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzr[i10];
    }
}
