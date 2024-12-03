package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.firebase.FirebaseApp;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaen  reason: invalid package */
public final class zzaen {
    private final Context zza;
    private zzafi zzb;
    private final String zzc;
    private final FirebaseApp zzd;
    private boolean zze = false;
    private String zzf;

    public zzaen(Context context, FirebaseApp firebaseApp, String str) {
        this.zza = (Context) p.k(context);
        this.zzd = (FirebaseApp) p.k(firebaseApp);
        this.zzc = String.format("Android/%s/%s", new Object[]{"Fallback", str});
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.net.URLConnection r6) {
        /*
            r5 = this;
            boolean r0 = r5.zze
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r5.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "/FirebaseUI-Android"
            java.lang.String r0 = r0.concat(r1)
            goto L_0x001d
        L_0x0011:
            java.lang.String r0 = r5.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "/FirebaseCore-Android"
            java.lang.String r0 = r0.concat(r1)
        L_0x001d:
            com.google.android.gms.internal.firebase-auth-api.zzafi r1 = r5.zzb
            if (r1 != 0) goto L_0x002e
            android.content.Context r1 = r5.zza
            com.google.android.gms.internal.firebase-auth-api.zzafi r2 = new com.google.android.gms.internal.firebase-auth-api.zzafi
            java.lang.String r3 = r1.getPackageName()
            r2.<init>(r1, r3)
            r5.zzb = r2
        L_0x002e:
            com.google.android.gms.internal.firebase-auth-api.zzafi r1 = r5.zzb
            java.lang.String r1 = r1.zzb()
            java.lang.String r2 = "X-Android-Package"
            r6.setRequestProperty(r2, r1)
            com.google.android.gms.internal.firebase-auth-api.zzafi r1 = r5.zzb
            java.lang.String r1 = r1.zza()
            java.lang.String r2 = "X-Android-Cert"
            r6.setRequestProperty(r2, r1)
            java.lang.String r1 = com.google.android.gms.internal.p003firebaseauthapi.zzaeo.zza()
            java.lang.String r2 = "Accept-Language"
            r6.setRequestProperty(r2, r1)
            java.lang.String r1 = "X-Client-Version"
            r6.setRequestProperty(r1, r0)
            java.lang.String r0 = r5.zzf
            java.lang.String r1 = "X-Firebase-Locale"
            r6.setRequestProperty(r1, r0)
            com.google.firebase.FirebaseApp r0 = r5.zzd
            com.google.firebase.FirebaseOptions r0 = r0.getOptions()
            java.lang.String r0 = r0.getApplicationId()
            java.lang.String r1 = "X-Firebase-GMPID"
            r6.setRequestProperty(r1, r0)
            com.google.firebase.FirebaseApp r0 = r5.zzd
            com.google.firebase.auth.FirebaseAuth r0 = com.google.firebase.auth.FirebaseAuth.getInstance(r0)
            com.google.firebase.inject.Provider r0 = r0.zzF()
            java.lang.Object r0 = r0.get()
            com.google.firebase.heartbeatinfo.HeartBeatController r0 = (com.google.firebase.heartbeatinfo.HeartBeatController) r0
            r1 = 0
            if (r0 == 0) goto L_0x0096
            com.google.android.gms.tasks.Task r0 = r0.getHeartBeatsHeader()     // Catch:{ ExecutionException -> 0x0088, InterruptedException -> 0x0086 }
            java.lang.Object r0 = com.google.android.gms.tasks.Tasks.await(r0)     // Catch:{ ExecutionException -> 0x0088, InterruptedException -> 0x0086 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ExecutionException -> 0x0088, InterruptedException -> 0x0086 }
            goto L_0x0097
        L_0x0086:
            r0 = move-exception
            goto L_0x0089
        L_0x0088:
            r0 = move-exception
        L_0x0089:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Unable to get heartbeats: "
            r2.concat(r0)
        L_0x0096:
            r0 = r1
        L_0x0097:
            java.lang.String r2 = "X-Firebase-Client"
            r6.setRequestProperty(r2, r0)
            com.google.firebase.FirebaseApp r0 = r5.zzd
            com.google.firebase.auth.FirebaseAuth r0 = com.google.firebase.auth.FirebaseAuth.getInstance(r0)
            com.google.firebase.inject.Provider r0 = r0.zzE()
            java.lang.Object r0 = r0.get()
            com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider r0 = (com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider) r0
            if (r0 != 0) goto L_0x00b0
        L_0x00ae:
            r0 = r1
            goto L_0x00ec
        L_0x00b0:
            r2 = 0
            com.google.android.gms.tasks.Task r0 = r0.getToken(r2)     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            java.lang.Object r0 = com.google.android.gms.tasks.Tasks.await(r0)     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            com.google.firebase.appcheck.AppCheckTokenResult r0 = (com.google.firebase.appcheck.AppCheckTokenResult) r0     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            java.lang.Exception r2 = r0.getError()     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            if (r2 == 0) goto L_0x00d6
            java.lang.Exception r2 = r0.getError()     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            r3.<init>()     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            java.lang.String r4 = "Error getting App Check token; using placeholder token instead. Error: "
            r3.append(r4)     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            r3.append(r2)     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
        L_0x00d6:
            java.lang.String r0 = r0.getToken()     // Catch:{ ExecutionException -> 0x00dd, InterruptedException -> 0x00db }
            goto L_0x00ec
        L_0x00db:
            r0 = move-exception
            goto L_0x00de
        L_0x00dd:
            r0 = move-exception
        L_0x00de:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Unexpected error getting App Check token: "
            r2.concat(r0)
            goto L_0x00ae
        L_0x00ec:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x00f7
            java.lang.String r2 = "X-Firebase-AppCheck"
            r6.setRequestProperty(r2, r0)
        L_0x00f7:
            r5.zzf = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzaen.zza(java.net.URLConnection):void");
    }

    public final void zzb(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }

    public final void zzc(String str) {
        this.zzf = str;
    }
}
