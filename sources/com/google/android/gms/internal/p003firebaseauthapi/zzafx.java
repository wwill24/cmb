package com.google.android.gms.internal.p003firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.collection.a;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafx  reason: invalid package */
public final class zzafx {
    private static final Map zza = new a();
    private static final Map zzb = new a();

    @NonNull
    public static String zza(String str) {
        zzafv zzafv;
        Map map = zza;
        synchronized (map) {
            zzafv = (zzafv) map.get(str);
        }
        if (zzafv != null) {
            return zzh(zzafv.zzb(), zzafv.zza(), zzafv.zzb().contains(CertificateUtil.DELIMITER)).concat("emulator/auth/handler");
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    @NonNull
    public static String zzb(String str) {
        zzafv zzafv;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzafv = (zzafv) map.get(str);
        }
        if (zzafv != null) {
            str2 = "".concat(zzh(zzafv.zzb(), zzafv.zza(), zzafv.zzb().contains(CertificateUtil.DELIMITER)));
        } else {
            str2 = "https://";
        }
        return str2.concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    @NonNull
    public static String zzc(String str) {
        zzafv zzafv;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzafv = (zzafv) map.get(str);
        }
        if (zzafv != null) {
            str2 = "".concat(zzh(zzafv.zzb(), zzafv.zza(), zzafv.zzb().contains(CertificateUtil.DELIMITER)));
        } else {
            str2 = "https://";
        }
        return str2.concat("identitytoolkit.googleapis.com/v2");
    }

    @NonNull
    public static String zzd(String str) {
        zzafv zzafv;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzafv = (zzafv) map.get(str);
        }
        if (zzafv != null) {
            str2 = "".concat(zzh(zzafv.zzb(), zzafv.zza(), zzafv.zzb().contains(CertificateUtil.DELIMITER)));
        } else {
            str2 = "https://";
        }
        return str2.concat("securetoken.googleapis.com/v1");
    }

    public static void zze(String str, zzafw zzafw) {
        Map map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                ((List) map.get(str)).add(new WeakReference(zzafw));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference(zzafw));
                map.put(str, arrayList);
            }
        }
    }

    public static void zzf(@NonNull FirebaseApp firebaseApp, @NonNull String str, int i10) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map map = zza;
        synchronized (map) {
            map.put(apiKey, new zzafv(str, i10));
        }
        Map map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                boolean z10 = false;
                for (WeakReference weakReference : (List) map2.get(apiKey)) {
                    zzafw zzafw = (zzafw) weakReference.get();
                    if (zzafw != null) {
                        zzafw.zzk();
                        z10 = true;
                    }
                }
                if (!z10) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static boolean zzg(@NonNull FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }

    private static String zzh(String str, int i10, boolean z10) {
        if (z10) {
            return "http://[" + str + "]:" + i10 + RemoteSettings.FORWARD_SLASH_STRING;
        }
        return "http://" + str + CertificateUtil.DELIMITER + i10 + RemoteSettings.FORWARD_SLASH_STRING;
    }
}
