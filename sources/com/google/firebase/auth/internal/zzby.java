package com.google.firebase.auth.internal;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import fe.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public final class zzby {
    static final Map zza;
    public static final /* synthetic */ int zzb = 0;

    static {
        HashMap hashMap = new HashMap();
        zza = hashMap;
        hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        hashMap.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        hashMap.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        hashMap.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        hashMap.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static Status zza(Intent intent) {
        p.k(intent);
        p.a(zzc(intent));
        return (Status) b.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }

    public static Status zzb(String str) {
        try {
            org.json.b bVar = new org.json.b(str);
            String string = bVar.getString("code");
            String string2 = bVar.getString("message");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Map map = zza;
                if (map.containsKey(string)) {
                    return zzai.zza(((String) map.get(string)) + CertificateUtil.DELIMITER + string2);
                }
            }
            return zzai.zza("WEB_INTERNAL_ERROR:" + str);
        } catch (JSONException e10) {
            String localizedMessage = e10.getLocalizedMessage();
            return zzai.zza("WEB_INTERNAL_ERROR:" + str + "[ " + localizedMessage + " ]");
        }
    }

    public static boolean zzc(Intent intent) {
        p.k(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }
}
