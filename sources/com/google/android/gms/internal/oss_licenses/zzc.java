package com.google.android.gms.internal.oss_licenses;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.api.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

public final class zzc {
    public static String zza(Context context, zza zza) {
        long zza2 = zza.zza();
        int zzb = zza.zzb();
        String path = zza.getPath();
        if (path.isEmpty()) {
            return zza(context, "third_party_licenses", zza2, zzb);
        }
        String zza3 = zza("res/raw/third_party_licenses", path, zza2, zzb);
        if (zza3 != null) {
            return zza3;
        }
        StringBuilder sb2 = new StringBuilder(path.length() + 46);
        sb2.append(path);
        sb2.append(" does not contain res/raw/third_party_licenses");
        throw new RuntimeException(sb2.toString());
    }

    private static String zza(Context context, String str, long j10, int i10) {
        Resources resources = context.getApplicationContext().getResources();
        return zza(resources.openRawResource(resources.getIdentifier(str, "raw", resources.getResourcePackageName(zzd.dummy_placeholder))), j10, i10);
    }

    private static String zza(InputStream inputStream, long j10, int i10) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream.skip(j10);
            if (i10 <= 0) {
                i10 = a.e.API_PRIORITY_OTHER;
            }
            while (i10 > 0) {
                int read = inputStream.read(bArr, 0, Math.min(i10, 1024));
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                i10 -= read;
            }
            inputStream.close();
            try {
                return byteArrayOutputStream.toString("UTF-8");
            } catch (UnsupportedEncodingException e10) {
                throw new RuntimeException("Unsupported encoding UTF8. This should always be supported.", e10);
            }
        } catch (IOException e11) {
            throw new RuntimeException("Failed to read license or metadata text.", e11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x002f A[SYNTHETIC, Splitter:B:26:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zza(java.lang.String r2, java.lang.String r3, long r4, int r6) {
        /*
            r0 = 0
            java.util.jar.JarFile r1 = new java.util.jar.JarFile     // Catch:{ IOException -> 0x0024 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0024 }
            java.util.jar.JarEntry r2 = r1.getJarEntry(r2)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            if (r2 != 0) goto L_0x0010
            r1.close()     // Catch:{ IOException -> 0x000f }
        L_0x000f:
            return r0
        L_0x0010:
            java.io.InputStream r2 = r1.getInputStream(r2)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            java.lang.String r2 = zza(r2, r4, r6)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            return r2
        L_0x001c:
            r2 = move-exception
            r0 = r1
            goto L_0x002d
        L_0x001f:
            r2 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0022:
            r2 = move-exception
            goto L_0x002d
        L_0x0024:
            r2 = move-exception
        L_0x0025:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0022 }
            java.lang.String r4 = "Failed to read license text."
            r3.<init>(r4, r2)     // Catch:{ all -> 0x0022 }
            throw r3     // Catch:{ all -> 0x0022 }
        L_0x002d:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.oss_licenses.zzc.zza(java.lang.String, java.lang.String, long, int):java.lang.String");
    }

    public static ArrayList<zza> zza(Context context) {
        String[] split = zza(context.getApplicationContext(), "third_party_license_metadata", 0, -1).split("\n");
        ArrayList<zza> arrayList = new ArrayList<>(split.length);
        int length = split.length;
        int i10 = 0;
        while (i10 < length) {
            String str = split[i10];
            int indexOf = str.indexOf(32);
            String[] split2 = str.substring(0, indexOf).split(CertificateUtil.DELIMITER);
            boolean z10 = split2.length == 2 && indexOf > 0;
            String concat = str.length() != 0 ? "Invalid license meta-data line:\n".concat(str) : new String("Invalid license meta-data line:\n");
            if (z10) {
                arrayList.add(zza.zza(str.substring(indexOf + 1), Long.parseLong(split2[0]), Integer.parseInt(split2[1]), ""));
                i10++;
            } else {
                throw new IllegalStateException(String.valueOf(concat));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
