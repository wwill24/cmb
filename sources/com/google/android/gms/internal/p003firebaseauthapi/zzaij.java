package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaij  reason: invalid package */
public final class zzaij implements zzaej {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzaij() {
    }

    public static zzaij zzb(String str, String str2, boolean z10) {
        zzaij zzaij = new zzaij();
        zzaij.zzb = p.g(str);
        zzaij.zzc = p.g(str2);
        zzaij.zzf = z10;
        return zzaij;
    }

    public static zzaij zzc(String str, String str2, boolean z10) {
        zzaij zzaij = new zzaij();
        zzaij.zza = p.g(str);
        zzaij.zzd = p.g(str2);
        zzaij.zzf = z10;
        return zzaij;
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        if (!TextUtils.isEmpty(this.zzd)) {
            bVar.put("phoneNumber", (Object) this.zza);
            bVar.put("temporaryProof", (Object) this.zzd);
        } else {
            bVar.put("sessionInfo", (Object) this.zzb);
            bVar.put("code", (Object) this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            bVar.put("idToken", (Object) str);
        }
        if (!this.zzf) {
            bVar.put("operation", 2);
        }
        return bVar.toString();
    }

    public final void zzd(String str) {
        this.zze = str;
    }
}
