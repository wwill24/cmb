package com.google.android.gms.internal.measurement;

public final class zzho {
    private static volatile zzii zza;

    private zzho() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        throw r14;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0143 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzii zza(android.content.Context r14) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzho> r0 = com.google.android.gms.internal.measurement.zzho.class
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzii r1 = zza     // Catch:{ all -> 0x015e }
            if (r1 != 0) goto L_0x015c
            java.lang.String r1 = android.os.Build.TYPE     // Catch:{ all -> 0x015e }
            java.lang.String r2 = android.os.Build.TAGS     // Catch:{ all -> 0x015e }
            java.lang.String r3 = "eng"
            boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x015e }
            if (r3 != 0) goto L_0x001b
            java.lang.String r3 = "userdebug"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x015e }
            if (r1 == 0) goto L_0x002c
        L_0x001b:
            java.lang.String r1 = "dev-keys"
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x015e }
            if (r1 != 0) goto L_0x0033
            java.lang.String r1 = "test-keys"
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x015e }
            if (r1 == 0) goto L_0x002c
            goto L_0x0033
        L_0x002c:
            com.google.android.gms.internal.measurement.zzii r14 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch:{ all -> 0x015e }
        L_0x0030:
            r1 = r14
            goto L_0x0154
        L_0x0033:
            boolean r1 = com.google.android.gms.internal.measurement.zzhb.zzb()     // Catch:{ all -> 0x015e }
            if (r1 == 0) goto L_0x0043
            boolean r1 = r14.isDeviceProtectedStorage()     // Catch:{ all -> 0x015e }
            if (r1 != 0) goto L_0x0043
            android.content.Context r14 = r14.createDeviceProtectedStorageContext()     // Catch:{ all -> 0x015e }
        L_0x0043:
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ all -> 0x015e }
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0157 }
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ RuntimeException -> 0x0068 }
            java.lang.String r4 = "phenotype_hermetic"
            java.io.File r4 = r14.getDir(r4, r2)     // Catch:{ RuntimeException -> 0x0068 }
            java.lang.String r5 = "overrides.txt"
            r3.<init>(r4, r5)     // Catch:{ RuntimeException -> 0x0068 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0157 }
            if (r4 == 0) goto L_0x0063
            com.google.android.gms.internal.measurement.zzii r3 = com.google.android.gms.internal.measurement.zzii.zzd(r3)     // Catch:{ all -> 0x0157 }
            goto L_0x006c
        L_0x0063:
            com.google.android.gms.internal.measurement.zzii r3 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch:{ all -> 0x0157 }
            goto L_0x006c
        L_0x0068:
            com.google.android.gms.internal.measurement.zzii r3 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch:{ all -> 0x0157 }
        L_0x006c:
            boolean r4 = r3.zzb()     // Catch:{ all -> 0x0157 }
            if (r4 == 0) goto L_0x014b
            java.lang.Object r3 = r3.zza()     // Catch:{ all -> 0x0157 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0144 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0144 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0144 }
            r7 = r3
            java.io.File r7 = (java.io.File) r7     // Catch:{ IOException -> 0x0144 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0144 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0144 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0144 }
            r5 = 1
            androidx.collection.g r6 = new androidx.collection.g     // Catch:{ all -> 0x0128 }
            r6.<init>()     // Catch:{ all -> 0x0128 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0128 }
            r7.<init>()     // Catch:{ all -> 0x0128 }
        L_0x0093:
            java.lang.String r8 = r4.readLine()     // Catch:{ all -> 0x0128 }
            if (r8 == 0) goto L_0x00fe
            java.lang.String r9 = " "
            r10 = 3
            java.lang.String[] r9 = r8.split(r9, r10)     // Catch:{ all -> 0x0128 }
            int r11 = r9.length     // Catch:{ all -> 0x0128 }
            if (r11 == r10) goto L_0x00b1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r9.<init>()     // Catch:{ all -> 0x0128 }
            java.lang.String r10 = "Invalid: "
            r9.append(r10)     // Catch:{ all -> 0x0128 }
            r9.append(r8)     // Catch:{ all -> 0x0128 }
            goto L_0x0093
        L_0x00b1:
            r8 = r9[r2]     // Catch:{ all -> 0x0128 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x0128 }
            r10.<init>(r8)     // Catch:{ all -> 0x0128 }
            r8 = r9[r5]     // Catch:{ all -> 0x0128 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0128 }
            r11.<init>(r8)     // Catch:{ all -> 0x0128 }
            java.lang.String r8 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0128 }
            r11 = 2
            r12 = r9[r11]     // Catch:{ all -> 0x0128 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ all -> 0x0128 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0128 }
            if (r12 != 0) goto L_0x00e6
            r9 = r9[r11]     // Catch:{ all -> 0x0128 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0128 }
            r11.<init>(r9)     // Catch:{ all -> 0x0128 }
            java.lang.String r12 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0128 }
            int r9 = r12.length()     // Catch:{ all -> 0x0128 }
            r13 = 1024(0x400, float:1.435E-42)
            if (r9 < r13) goto L_0x00e3
            if (r12 != r11) goto L_0x00e6
        L_0x00e3:
            r7.put(r11, r12)     // Catch:{ all -> 0x0128 }
        L_0x00e6:
            boolean r9 = r6.containsKey(r10)     // Catch:{ all -> 0x0128 }
            if (r9 != 0) goto L_0x00f4
            androidx.collection.g r9 = new androidx.collection.g     // Catch:{ all -> 0x0128 }
            r9.<init>()     // Catch:{ all -> 0x0128 }
            r6.put(r10, r9)     // Catch:{ all -> 0x0128 }
        L_0x00f4:
            java.lang.Object r9 = r6.get(r10)     // Catch:{ all -> 0x0128 }
            androidx.collection.g r9 = (androidx.collection.g) r9     // Catch:{ all -> 0x0128 }
            r9.put(r8, r12)     // Catch:{ all -> 0x0128 }
            goto L_0x0093
        L_0x00fe:
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0128 }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r7.<init>()     // Catch:{ all -> 0x0128 }
            java.lang.String r8 = "Parsed "
            r7.append(r8)     // Catch:{ all -> 0x0128 }
            r7.append(r3)     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = " for Android package "
            r7.append(r3)     // Catch:{ all -> 0x0128 }
            r7.append(r14)     // Catch:{ all -> 0x0128 }
            com.google.android.gms.internal.measurement.zzhh r14 = new com.google.android.gms.internal.measurement.zzhh     // Catch:{ all -> 0x0128 }
            r14.<init>(r6)     // Catch:{ all -> 0x0128 }
            r4.close()     // Catch:{ IOException -> 0x0144 }
            com.google.android.gms.internal.measurement.zzii r14 = com.google.android.gms.internal.measurement.zzii.zzd(r14)     // Catch:{ all -> 0x0157 }
            goto L_0x014f
        L_0x0128:
            r14 = move-exception
            r4.close()     // Catch:{ all -> 0x012d }
            goto L_0x0143
        L_0x012d:
            r3 = move-exception
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            java.lang.String r6 = "addSuppressed"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0143 }
            java.lang.Class<java.lang.Throwable> r8 = java.lang.Throwable.class
            r7[r2] = r8     // Catch:{ Exception -> 0x0143 }
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r7)     // Catch:{ Exception -> 0x0143 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0143 }
            r5[r2] = r3     // Catch:{ Exception -> 0x0143 }
            r4.invoke(r14, r5)     // Catch:{ Exception -> 0x0143 }
        L_0x0143:
            throw r14     // Catch:{ IOException -> 0x0144 }
        L_0x0144:
            r14 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0157 }
            r2.<init>(r14)     // Catch:{ all -> 0x0157 }
            throw r2     // Catch:{ all -> 0x0157 }
        L_0x014b:
            com.google.android.gms.internal.measurement.zzii r14 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch:{ all -> 0x0157 }
        L_0x014f:
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x015e }
            goto L_0x0030
        L_0x0154:
            zza = r1     // Catch:{ all -> 0x015e }
            goto L_0x015c
        L_0x0157:
            r14 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x015e }
            throw r14     // Catch:{ all -> 0x015e }
        L_0x015c:
            monitor-exit(r0)     // Catch:{ all -> 0x015e }
            return r1
        L_0x015e:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x015e }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzho.zza(android.content.Context):com.google.android.gms.internal.measurement.zzii");
    }
}
