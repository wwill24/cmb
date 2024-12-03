package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzahf;
import com.google.android.gms.internal.p003firebaseauthapi.zzaia;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzbc {
    public static MultiFactorInfo zza(zzahf zzahf) {
        if (zzahf == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzahf.zzf())) {
            return new PhoneMultiFactorInfo(zzahf.zze(), zzahf.zzd(), zzahf.zza(), p.g(zzahf.zzf()));
        }
        if (zzahf.zzc() != null) {
            return new TotpMultiFactorInfo(zzahf.zze(), zzahf.zzd(), zzahf.zza(), (zzaia) p.l(zzahf.zzc(), "totpInfo cannot be null."));
        }
        return null;
    }

    public static List zzb(List list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo zza = zza((zzahf) it.next());
            if (zza != null) {
                arrayList.add(zza);
            }
        }
        return arrayList;
    }
}
