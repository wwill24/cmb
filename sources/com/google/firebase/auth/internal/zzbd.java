package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import fe.a;
import java.util.ArrayList;
import java.util.List;

public final class zzbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();
    private final List zza;
    private final List zzb;

    zzbd(List list, List list2) {
        this.zza = list == null ? new ArrayList() : list;
        this.zzb = list2 == null ? new ArrayList() : list2;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.zza;
        int a10 = a.a(parcel);
        a.G(parcel, 1, list, false);
        a.G(parcel, 2, this.zzb, false);
        a.b(parcel, a10);
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo add : this.zza) {
            arrayList.add(add);
        }
        for (TotpMultiFactorInfo add2 : this.zzb) {
            arrayList.add(add2);
        }
        return arrayList;
    }
}
