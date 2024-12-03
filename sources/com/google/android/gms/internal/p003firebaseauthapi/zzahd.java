package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import java.io.UnsupportedEncodingException;
import java.util.List;
import me.c;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahd  reason: invalid package */
public final class zzahd {
    public static long zza(String str) {
        p.g(str);
        List zzd = zzab.zzb(zzj.zzb('.')).zzd(str);
        if (zzd.size() >= 2) {
            try {
                zzahe zza = zzahe.zza(new String(c.b((String) zzd.get(1)), "UTF-8"));
                return zza.zzb().longValue() - zza.zzc().longValue();
            } catch (UnsupportedEncodingException e10) {
                throw new RuntimeException("Unable to decode token", e10);
            }
        } else {
            throw new RuntimeException("Invalid idToken ".concat(String.valueOf(str)));
        }
    }
}
