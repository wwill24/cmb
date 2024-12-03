package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import org.jivesoftware.smack.util.StringUtils;

public final class zzbi extends zzbs {
    public static boolean zza;
    private AdvertisingIdClient.Info zzb;
    private final zzfo zzc;
    private String zzd;
    private boolean zze = false;
    private final Object zzf = new Object();

    zzbi(zzbv zzbv) {
        super(zzbv);
        this.zzc = new zzfo(zzbv.zzr());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0159, code lost:
        if (r0 == false) goto L_0x015e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032 A[Catch:{ IllegalStateException -> 0x0028, Exception -> 0x001b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[Catch:{ IllegalStateException -> 0x0028, Exception -> 0x001b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003e A[Catch:{ IllegalStateException -> 0x0028, Exception -> 0x001b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[Catch:{ IllegalStateException -> 0x0028, Exception -> 0x001b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzc() {
        /*
            r11 = this;
            monitor-enter(r11)
            com.google.android.gms.internal.gtm.zzfo r0 = r11.zzc     // Catch:{ all -> 0x0174 }
            r1 = 1000(0x3e8, double:4.94E-321)
            boolean r0 = r0.zzc(r1)     // Catch:{ all -> 0x0174 }
            if (r0 == 0) goto L_0x0170
            com.google.android.gms.internal.gtm.zzfo r0 = r11.zzc     // Catch:{ all -> 0x0174 }
            r0.zzb()     // Catch:{ all -> 0x0174 }
            r0 = 1
            r1 = 0
            android.content.Context r2 = r11.zzo()     // Catch:{ IllegalStateException -> 0x0028, Exception -> 0x001b }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r2)     // Catch:{ IllegalStateException -> 0x0028, Exception -> 0x001b }
            goto L_0x002e
        L_0x001b:
            r2 = move-exception
            boolean r3 = zza     // Catch:{ all -> 0x0174 }
            if (r3 != 0) goto L_0x002d
            zza = r0     // Catch:{ all -> 0x0174 }
            java.lang.String r3 = "Error getting advertiser id"
            r11.zzS(r3, r2)     // Catch:{ all -> 0x0174 }
            goto L_0x002d
        L_0x0028:
            java.lang.String r2 = "IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details."
            r11.zzR(r2)     // Catch:{ all -> 0x0174 }
        L_0x002d:
            r2 = r1
        L_0x002e:
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r3 = r11.zzb     // Catch:{ all -> 0x0174 }
            if (r2 != 0) goto L_0x0034
            r4 = r1
            goto L_0x0038
        L_0x0034:
            java.lang.String r4 = r2.getId()     // Catch:{ all -> 0x0174 }
        L_0x0038:
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0174 }
            if (r5 == 0) goto L_0x0040
            goto L_0x015b
        L_0x0040:
            com.google.android.gms.internal.gtm.zzcn r5 = r11.zzv()     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = r5.zzb()     // Catch:{ all -> 0x0174 }
            java.lang.Object r6 = r11.zzf     // Catch:{ all -> 0x0174 }
            monitor-enter(r6)     // Catch:{ all -> 0x0174 }
            boolean r7 = r11.zze     // Catch:{ all -> 0x016d }
            r8 = 0
            if (r7 != 0) goto L_0x00a7
            android.content.Context r3 = r11.zzo()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            java.lang.String r7 = "gaClientIdData"
            java.io.FileInputStream r3 = r3.openFileInput(r7)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            r7 = 128(0x80, float:1.794E-43)
            byte[] r9 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            int r7 = r3.read(r9, r8, r7)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            int r10 = r3.available()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            if (r10 <= 0) goto L_0x007a
            java.lang.String r7 = "Hash file seems corrupted, deleting it."
            r11.zzR(r7)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            r3.close()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            android.content.Context r3 = r11.zzo()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            java.lang.String r7 = "gaClientIdData"
            r3.deleteFile(r7)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            goto L_0x00a2
        L_0x007a:
            if (r7 > 0) goto L_0x0085
            java.lang.String r7 = "Hash file is empty."
            r11.zzO(r7)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            r3.close()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            goto L_0x00a2
        L_0x0085:
            java.lang.String r10 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            r10.<init>(r9, r8, r7)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x0090 }
            r3.close()     // Catch:{ FileNotFoundException -> 0x00a1, IOException -> 0x008e }
            goto L_0x00a1
        L_0x008e:
            r1 = move-exception
            goto L_0x0093
        L_0x0090:
            r3 = move-exception
            r10 = r1
            r1 = r3
        L_0x0093:
            java.lang.String r3 = "Error reading Hash file, deleting it"
            r11.zzS(r3, r1)     // Catch:{ all -> 0x016d }
            android.content.Context r1 = r11.zzo()     // Catch:{ all -> 0x016d }
            java.lang.String r3 = "gaClientIdData"
            r1.deleteFile(r3)     // Catch:{ all -> 0x016d }
        L_0x00a1:
            r1 = r10
        L_0x00a2:
            r11.zzd = r1     // Catch:{ all -> 0x016d }
            r11.zze = r0     // Catch:{ all -> 0x016d }
            goto L_0x00f2
        L_0x00a7:
            java.lang.String r0 = r11.zzd     // Catch:{ all -> 0x016d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x016d }
            if (r0 == 0) goto L_0x00f2
            if (r3 != 0) goto L_0x00b2
            goto L_0x00b6
        L_0x00b2:
            java.lang.String r1 = r3.getId()     // Catch:{ all -> 0x016d }
        L_0x00b6:
            if (r1 != 0) goto L_0x00d8
            java.lang.String r0 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x016d }
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x016d }
            int r3 = r1.length()     // Catch:{ all -> 0x016d }
            if (r3 == 0) goto L_0x00cb
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x016d }
            goto L_0x00d1
        L_0x00cb:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x016d }
            r1.<init>(r0)     // Catch:{ all -> 0x016d }
            r0 = r1
        L_0x00d1:
            boolean r0 = r11.zzf(r0)     // Catch:{ all -> 0x016d }
            monitor-exit(r6)     // Catch:{ all -> 0x016d }
            goto L_0x0159
        L_0x00d8:
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x016d }
            int r3 = r0.length()     // Catch:{ all -> 0x016d }
            if (r3 == 0) goto L_0x00e7
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x016d }
            goto L_0x00ec
        L_0x00e7:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x016d }
            r0.<init>(r1)     // Catch:{ all -> 0x016d }
        L_0x00ec:
            java.lang.String r0 = zze(r0)     // Catch:{ all -> 0x016d }
            r11.zzd = r0     // Catch:{ all -> 0x016d }
        L_0x00f2:
            java.lang.String r0 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x016d }
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x016d }
            int r3 = r1.length()     // Catch:{ all -> 0x016d }
            if (r3 == 0) goto L_0x0105
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x016d }
            goto L_0x010b
        L_0x0105:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x016d }
            r1.<init>(r0)     // Catch:{ all -> 0x016d }
            r0 = r1
        L_0x010b:
            java.lang.String r0 = zze(r0)     // Catch:{ all -> 0x016d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x016d }
            if (r1 == 0) goto L_0x0117
            monitor-exit(r6)     // Catch:{ all -> 0x016d }
            goto L_0x015e
        L_0x0117:
            java.lang.String r1 = r11.zzd     // Catch:{ all -> 0x016d }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x016d }
            if (r0 == 0) goto L_0x0121
            monitor-exit(r6)     // Catch:{ all -> 0x016d }
            goto L_0x015b
        L_0x0121:
            java.lang.String r0 = r11.zzd     // Catch:{ all -> 0x016d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x016d }
            if (r0 != 0) goto L_0x013b
            java.lang.String r0 = "Resetting the client id because Advertising Id changed."
            r11.zzO(r0)     // Catch:{ all -> 0x016d }
            com.google.android.gms.internal.gtm.zzcn r0 = r11.zzv()     // Catch:{ all -> 0x016d }
            java.lang.String r5 = r0.zze()     // Catch:{ all -> 0x016d }
            java.lang.String r0 = "New client Id"
            r11.zzP(r0, r5)     // Catch:{ all -> 0x016d }
        L_0x013b:
            java.lang.String r0 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x016d }
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x016d }
            int r3 = r1.length()     // Catch:{ all -> 0x016d }
            if (r3 == 0) goto L_0x014e
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x016d }
            goto L_0x0154
        L_0x014e:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x016d }
            r1.<init>(r0)     // Catch:{ all -> 0x016d }
            r0 = r1
        L_0x0154:
            boolean r0 = r11.zzf(r0)     // Catch:{ all -> 0x016d }
            monitor-exit(r6)     // Catch:{ all -> 0x016d }
        L_0x0159:
            if (r0 == 0) goto L_0x015e
        L_0x015b:
            r11.zzb = r2     // Catch:{ all -> 0x0174 }
            goto L_0x0170
        L_0x015e:
            java.lang.String r0 = "Failed to reset client id on adid change. Not using adid"
            r11.zzJ(r0)     // Catch:{ all -> 0x0174 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$Info     // Catch:{ all -> 0x0174 }
            java.lang.String r1 = ""
            r0.<init>(r1, r8)     // Catch:{ all -> 0x0174 }
            r11.zzb = r0     // Catch:{ all -> 0x0174 }
            goto L_0x0170
        L_0x016d:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x016d }
            throw r0     // Catch:{ all -> 0x0174 }
        L_0x0170:
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = r11.zzb     // Catch:{ all -> 0x0174 }
            monitor-exit(r11)
            return r0
        L_0x0174:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbi.zzc():com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    private static String zze(String str) {
        MessageDigest zze2 = zzfs.zze(StringUtils.MD5);
        if (zze2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zze2.digest(str.getBytes()))});
    }

    private final boolean zzf(String str) {
        try {
            String zze2 = zze(str);
            zzO("Storing hashed adid.");
            FileOutputStream openFileOutput = zzo().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zze2.getBytes());
            openFileOutput.close();
            this.zzd = zze2;
            return true;
        } catch (IOException e10) {
            zzK("Error creating hash file", e10);
            return false;
        }
    }

    public final String zza() {
        String str;
        zzW();
        AdvertisingIdClient.Info zzc2 = zzc();
        if (zzc2 != null) {
            str = zzc2.getId();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public final boolean zzb() {
        zzW();
        AdvertisingIdClient.Info zzc2 = zzc();
        if (zzc2 == null || zzc2.isLimitAdTrackingEnabled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
    }
}
