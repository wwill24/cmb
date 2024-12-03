package com.google.android.gms.internal.p003firebaseauthapi;

import android.app.Activity;
import androidx.collection.a;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;
import me.i;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafn  reason: invalid package */
public final class zzafn {
    private static final Map zza = new a();

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzaez zzaez) {
        zze(str, zzaez);
        return new zzafl(onVerificationStateChangedCallbacks, str);
    }

    public static void zzc() {
        zza.clear();
    }

    public static boolean zzd(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map map = zza;
        if (map.containsKey(str)) {
            zzafm zzafm = (zzafm) map.get(str);
            if (i.c().currentTimeMillis() - zzafm.zzb < 120000) {
                zzaez zzaez = zzafm.zza;
                if (zzaez == null) {
                    return true;
                }
                zzaez.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
                return true;
            }
            zze(str, (zzaez) null);
            return false;
        }
        zze(str, (zzaez) null);
        return false;
    }

    private static void zze(String str, zzaez zzaez) {
        zza.put(str, new zzafm(zzaez, i.c().currentTimeMillis()));
    }
}
