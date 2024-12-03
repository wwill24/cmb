package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahy  reason: invalid package */
public final class zzahy extends zzahs {
    private static final String zza = "zzahy";
    private String zzb;
    private String zzc;
    private int zzd;
    private String zze;
    private int zzf;
    private long zzg;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        zzg(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzahs zzb(String str) throws zzaca {
        zzg(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final int zze() {
        return this.zzd;
    }

    public final long zzf() {
        return this.zzg;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.p003firebaseauthapi.zzahy zzg(java.lang.String r4) throws com.google.android.gms.internal.p003firebaseauthapi.zzaca {
        /*
            r3 = this;
            org.json.b r0 = new org.json.b     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            r0.<init>((java.lang.String) r4)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = "totpSessionInfo"
            org.json.b r0 = r0.optJSONObject(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            if (r0 == 0) goto L_0x0062
            java.lang.String r1 = "sharedSecretKey"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = com.google.android.gms.internal.p003firebaseauthapi.zzac.zza(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            r3.zzc = r1     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = "verificationCodeLength"
            int r1 = r0.optInt(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            r3.zzd = r1     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = "hashingAlgorithm"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = com.google.android.gms.internal.p003firebaseauthapi.zzac.zza(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            r3.zze = r1     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = "periodSec"
            int r1 = r0.optInt(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            r3.zzf = r1     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = "sessionInfo"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = com.google.android.gms.internal.p003firebaseauthapi.zzac.zza(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            r3.zzb = r1     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r1 = "finalizeEnrollmentTime"
            java.lang.String r0 = r0.optString(r1)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            com.google.android.gms.internal.firebase-auth-api.zzamt r1 = com.google.android.gms.internal.p003firebaseauthapi.zzano.zzb(r0)     // Catch:{ ParseException -> 0x0055 }
            com.google.android.gms.internal.p003firebaseauthapi.zzano.zza(r1)     // Catch:{ ParseException -> 0x0055 }
            long r1 = r1.zzb()     // Catch:{ ParseException -> 0x0055 }
            r3.zzg = r1     // Catch:{ ParseException -> 0x0055 }
            goto L_0x0062
        L_0x0055:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            r1.<init>()     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            java.lang.String r2 = "Failed to parse timestamp: "
            r1.append(r2)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
            r1.append(r0)     // Catch:{ JSONException -> 0x0065, NullPointerException -> 0x0063 }
        L_0x0062:
            return r3
        L_0x0063:
            r0 = move-exception
            goto L_0x0066
        L_0x0065:
            r0 = move-exception
        L_0x0066:
            java.lang.String r1 = zza
            com.google.android.gms.internal.firebase-auth-api.zzaca r4 = com.google.android.gms.internal.p003firebaseauthapi.zzain.zza(r0, r1, r4)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzahy.zzg(java.lang.String):com.google.android.gms.internal.firebase-auth-api.zzahy");
    }

    public final String zzh() {
        return this.zze;
    }

    public final String zzi() {
        return this.zzc;
    }
}
