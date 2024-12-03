package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahl  reason: invalid package */
public final class zzahl implements zzaej {
    private final String zza;
    private final long zzb;
    private final boolean zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private zzafy zzi;

    public zzahl(String str, long j10, boolean z10, String str2, String str3, String str4, String str5, boolean z11) {
        this.zza = p.g(str);
        this.zzb = j10;
        this.zzc = z10;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = str4;
        this.zzg = str5;
        this.zzh = z11;
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("phoneNumber", (Object) this.zza);
        String str = this.zze;
        if (str != null) {
            bVar.put("tenantId", (Object) str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            bVar.put("recaptchaToken", (Object) str2);
        }
        zzafy zzafy = this.zzi;
        if (zzafy != null) {
            bVar.put("autoRetrievalInfo", (Object) zzafy.zza());
        }
        String str3 = this.zzg;
        if (str3 != null) {
            bVar.put("playIntegrityToken", (Object) str3);
        }
        return bVar.toString();
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zza;
    }

    public final void zze(zzafy zzafy) {
        this.zzi = zzafy;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        return this.zzh;
    }
}
