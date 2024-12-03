package com.google.android.recaptcha.internal;

import java.util.Set;
import kotlin.jvm.internal.j;

public final class zzbj {
    public static final zzbj zza = new zzbj();
    private static Set zzb;
    private static Set zzc;
    private static Long zzd;
    private static int zze;

    private zzbj() {
    }

    public static final void zza(zzlr zzlr) {
        zzb = CollectionsKt___CollectionsKt.B0(zzlr.zzf().zzi());
        zzc = CollectionsKt___CollectionsKt.B0(zzlr.zzg().zzi());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object zzb(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, android.content.Context r22, com.google.android.recaptcha.internal.zzr r23, kotlin.coroutines.c r24) {
        /*
            r0 = r18
            java.lang.String r1 = "&"
            java.lang.String r2 = "="
            java.lang.String r3 = "UTF-8"
            java.util.Set r4 = zzb
            if (r4 == 0) goto L_0x0014
            java.util.Set r4 = zzc
            if (r4 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            kotlin.Unit r0 = kotlin.Unit.f32013a
            return r0
        L_0x0014:
            r4 = 0
            com.google.android.recaptcha.internal.zzai r5 = com.google.android.recaptcha.internal.zzai.zza     // Catch:{ Exception -> 0x0123 }
            com.google.android.recaptcha.internal.zzaf r5 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ Exception -> 0x0123 }
            com.google.android.recaptcha.internal.zzkw r12 = com.google.android.recaptcha.internal.zzkw.FETCH_ALLOWLIST     // Catch:{ Exception -> 0x0123 }
            r11 = 0
            r6 = r5
            r7 = r12
            r8 = r20
            r9 = r21
            r10 = r21
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0123 }
            com.google.android.recaptcha.internal.zzs r6 = new com.google.android.recaptcha.internal.zzs     // Catch:{ Exception -> 0x0123 }
            r6.<init>()     // Catch:{ Exception -> 0x0123 }
            com.google.android.recaptcha.internal.zzai.zzb(r5, r0, r6)     // Catch:{ Exception -> 0x0123 }
            zzd = r4     // Catch:{ Exception -> 0x0123 }
            r5 = 0
            zze = r5     // Catch:{ Exception -> 0x0123 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x0123 }
            java.lang.String r6 = "k"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r3)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r7 = "msv"
            java.lang.String r8 = "18.1.2"
            java.lang.String r8 = java.net.URLEncoder.encode(r8, r3)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r9 = "mst"
            r10 = r19
            java.lang.String r10 = java.net.URLEncoder.encode(r10, r3)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r11 = "mov"
            java.lang.String r13 = com.google.android.recaptcha.internal.zzu.zzb()     // Catch:{ Exception -> 0x0123 }
            java.lang.String r3 = java.net.URLEncoder.encode(r13, r3)     // Catch:{ Exception -> 0x0123 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0123 }
            r13.<init>()     // Catch:{ Exception -> 0x0123 }
            r14 = r17
            r13.append(r14)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r14 = "?"
            r13.append(r14)     // Catch:{ Exception -> 0x0123 }
            r13.append(r6)     // Catch:{ Exception -> 0x0123 }
            r13.append(r2)     // Catch:{ Exception -> 0x0123 }
            r13.append(r0)     // Catch:{ Exception -> 0x0123 }
            r13.append(r1)     // Catch:{ Exception -> 0x0123 }
            r13.append(r7)     // Catch:{ Exception -> 0x0123 }
            r13.append(r2)     // Catch:{ Exception -> 0x0123 }
            r13.append(r8)     // Catch:{ Exception -> 0x0123 }
            r13.append(r1)     // Catch:{ Exception -> 0x0123 }
            r13.append(r9)     // Catch:{ Exception -> 0x0123 }
            r13.append(r2)     // Catch:{ Exception -> 0x0123 }
            r13.append(r10)     // Catch:{ Exception -> 0x0123 }
            r13.append(r1)     // Catch:{ Exception -> 0x0123 }
            r13.append(r11)     // Catch:{ Exception -> 0x0123 }
            r13.append(r2)     // Catch:{ Exception -> 0x0123 }
            r13.append(r3)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x0123 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0123 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0123 }
            long r0 = r0.getId()     // Catch:{ Exception -> 0x0123 }
            int r0 = (int) r0     // Catch:{ Exception -> 0x0123 }
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ Exception -> 0x0123 }
            java.net.URLConnection r0 = r5.openConnection()     // Catch:{ Exception -> 0x0123 }
            java.lang.String r1 = "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection"
            kotlin.jvm.internal.j.e(r0, r1)     // Catch:{ Exception -> 0x0123 }
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x0123 }
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x0123 }
            r1 = 1
            r0.setDoInput(r1)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r1 = "Accept"
            java.lang.String r2 = "application/x-protobuffer"
            r0.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x0123 }
            r0.connect()     // Catch:{ Exception -> 0x0123 }
            int r1 = r0.getResponseCode()     // Catch:{ Exception -> 0x0123 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x0103
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x0123 }
            com.google.android.recaptcha.internal.zzlr r0 = com.google.android.recaptcha.internal.zzlr.zzj(r0)     // Catch:{ Exception -> 0x0123 }
            zza(r0)     // Catch:{ Exception -> 0x0123 }
            com.google.android.recaptcha.internal.zzaf r0 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ Exception -> 0x0123 }
            r11 = 0
            r6 = r0
            r7 = r12
            r8 = r20
            r9 = r21
            r10 = r21
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0123 }
            java.lang.Long r1 = zzd     // Catch:{ Exception -> 0x0123 }
            int r2 = zze     // Catch:{ Exception -> 0x0123 }
            com.google.android.recaptcha.internal.zzai.zza(r0, r1, r2)     // Catch:{ Exception -> 0x0123 }
            com.google.android.recaptcha.internal.zzaf r0 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ Exception -> 0x0123 }
            r11 = 0
            r6 = r0
            r7 = r12
            r8 = r20
            r9 = r21
            r10 = r21
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0123 }
            r1 = r22
            r2 = r23
            com.google.android.recaptcha.internal.zzai.zzc(r0, r1, r2)     // Catch:{ Exception -> 0x0121 }
            r10 = r4
            goto L_0x0165
        L_0x0103:
            r1 = r22
            r2 = r23
            com.google.android.recaptcha.internal.zzh r3 = new com.google.android.recaptcha.internal.zzh     // Catch:{ Exception -> 0x0121 }
            com.google.android.recaptcha.internal.zzf r5 = com.google.android.recaptcha.internal.zzf.zzk     // Catch:{ Exception -> 0x0121 }
            com.google.android.recaptcha.internal.zzd r6 = new com.google.android.recaptcha.internal.zzd     // Catch:{ Exception -> 0x0121 }
            int r7 = r0.getResponseCode()     // Catch:{ Exception -> 0x0121 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0121 }
            r3.<init>(r5, r6)     // Catch:{ Exception -> 0x0121 }
            int r0 = r0.getResponseCode()     // Catch:{ Exception -> 0x0121 }
            kotlin.coroutines.jvm.internal.a.b(r0)     // Catch:{ Exception -> 0x0121 }
            r10 = r4
            r4 = r3
            goto L_0x0165
        L_0x0121:
            r0 = move-exception
            goto L_0x0128
        L_0x0123:
            r0 = move-exception
            r1 = r22
            r2 = r23
        L_0x0128:
            boolean r3 = r0 instanceof java.net.MalformedURLException
            if (r3 == 0) goto L_0x0137
            com.google.android.recaptcha.internal.zzh r3 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r4 = com.google.android.recaptcha.internal.zzf.zze
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzc
            r3.<init>(r4, r5)
        L_0x0135:
            r4 = r3
            goto L_0x015d
        L_0x0137:
            boolean r3 = r0 instanceof com.google.android.recaptcha.internal.zzgy
            if (r3 == 0) goto L_0x0145
            com.google.android.recaptcha.internal.zzh r3 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r4 = com.google.android.recaptcha.internal.zzf.zze
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzS
            r3.<init>(r4, r5)
            goto L_0x0135
        L_0x0145:
            boolean r3 = r0 instanceof java.io.IOException
            if (r3 == 0) goto L_0x0153
            com.google.android.recaptcha.internal.zzh r3 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r4 = com.google.android.recaptcha.internal.zzf.zze
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzR
            r3.<init>(r4, r5)
            goto L_0x0135
        L_0x0153:
            com.google.android.recaptcha.internal.zzh r3 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r4 = com.google.android.recaptcha.internal.zzf.zzb
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzb
            r3.<init>(r4, r5)
            goto L_0x0135
        L_0x015d:
            java.lang.String r3 = r0.getMessage()
            r0.toString()
            r10 = r3
        L_0x0165:
            if (r4 == 0) goto L_0x0194
            com.google.android.recaptcha.internal.zzai r0 = com.google.android.recaptcha.internal.zzai.zza
            com.google.android.recaptcha.internal.zzaf r5 = new com.google.android.recaptcha.internal.zzaf
            com.google.android.recaptcha.internal.zzkw r12 = com.google.android.recaptcha.internal.zzkw.FETCH_ALLOWLIST
            r16 = 0
            r11 = r5
            r13 = r20
            r14 = r21
            r15 = r21
            r11.<init>(r12, r13, r14, r15, r16)
            com.google.android.recaptcha.internal.zzf r0 = r4.zzb()
            int r0 = r0.zza()
            java.lang.String r6 = java.lang.String.valueOf(r0)
            com.google.android.recaptcha.internal.zzd r0 = r4.zza()
            int r7 = r0.zza()
            r8 = r22
            r9 = r23
            com.google.android.recaptcha.internal.zzai.zzd(r5, r6, r7, r8, r9, r10)
        L_0x0194:
            kotlin.Unit r0 = kotlin.Unit.f32013a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbj.zzb(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context, com.google.android.recaptcha.internal.zzr, kotlin.coroutines.c):java.lang.Object");
    }

    public static final boolean zzc(String str) {
        Set set = zzb;
        if (set == null || zzc == null) {
            if (zzd == null) {
                zzd = Long.valueOf(System.currentTimeMillis());
            }
            zze++;
            return true;
        }
        j.e(set, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (set.isEmpty()) {
            return true;
        }
        Set set2 = zzc;
        j.e(set2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (zzd(str, set2)) {
            return false;
        }
        return zzd(str, set);
    }

    private static final boolean zzd(String str, Set set) {
        String str2 = "";
        for (String valueOf : StringsKt__StringsKt.B0(str, new char[]{'.'}, false, 0, 6, (Object) null)) {
            String concat = str2.concat(String.valueOf(valueOf));
            if (set.contains(concat)) {
                return true;
            }
            str2 = concat.concat(".");
        }
        return false;
    }
}
