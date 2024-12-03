package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import fe.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzag extends MultiFactorSession {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    private String zza;
    private String zzb;
    private List zzc;
    private List zzd;
    private zzx zze;

    private zzag() {
    }

    public static zzag zzb(String str, zzx zzx) {
        p.g(str);
        zzag zzag = new zzag();
        zzag.zza = str;
        zzag.zze = zzx;
        return zzag;
    }

    public static zzag zzc(List list, String str) {
        p.k(list);
        p.g(str);
        zzag zzag = new zzag();
        zzag.zzc = new ArrayList();
        zzag.zzd = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzag.zzc.add((PhoneMultiFactorInfo) multiFactorInfo);
            } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                zzag.zzd.add((TotpMultiFactorInfo) multiFactorInfo);
            } else {
                throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: ".concat(String.valueOf(multiFactorInfo.getFactorId())));
            }
        }
        zzag.zzb = str;
        return zzag;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.zza, false);
        a.C(parcel, 2, this.zzb, false);
        a.G(parcel, 3, this.zzc, false);
        a.G(parcel, 4, this.zzd, false);
        a.A(parcel, 5, this.zze, i10, false);
        a.b(parcel, a10);
    }

    public final zzx zza() {
        return this.zze;
    }

    public final String zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zzb;
    }

    public final boolean zzf() {
        return this.zza != null;
    }

    zzag(String str, String str2, List list, List list2, zzx zzx) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
        this.zzd = list2;
        this.zze = zzx;
    }
}
