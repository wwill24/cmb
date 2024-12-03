package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public final class zzj {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;
    private static final String[] zzd;

    static {
        String[] strArr = new String[2];
        strArr[0] = "media";
        String str = Build.HARDWARE;
        String str2 = "";
        strArr[1] = true != (str.equals("goldfish") || str.equals("ranchu")) ? str2 : "androidx.test.services.storage.runfiles";
        zzc = strArr;
        String[] strArr2 = new String[3];
        int i10 = Build.VERSION.SDK_INT;
        strArr2[0] = i10 <= 25 ? "com.google.android.inputmethod.latin.inputcontent" : str2;
        if (i10 <= 25) {
            str2 = "com.google.android.inputmethod.latin.dev.inputcontent";
        }
        strArr2[1] = str2;
        strArr2[2] = "com.google.android.apps.docs.storage.legacy";
        zzd = strArr2;
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String str) throws FileNotFoundException {
        zzi zzi = zzi.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri zzc2 = zzc(uri);
        String scheme = zzc2.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(zzc2, StreamManagement.AckRequest.ELEMENT);
        }
        if ("content".equals(scheme)) {
            if (zzi(context, zzc2, 1, zzi)) {
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(zzc2, StreamManagement.AckRequest.ELEMENT);
                zzd(openAssetFileDescriptor);
                return openAssetFileDescriptor;
            }
            throw new FileNotFoundException("Can't open content uri.");
        } else if ("file".equals(scheme)) {
            AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(zzc2, StreamManagement.AckRequest.ELEMENT);
            zzd(openAssetFileDescriptor2);
            try {
                zzh(context, openAssetFileDescriptor2.getParcelFileDescriptor(), zzc2, zzi);
                return openAssetFileDescriptor2;
            } catch (FileNotFoundException e10) {
                zzf(openAssetFileDescriptor2, e10);
                throw e10;
            } catch (IOException e11) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                fileNotFoundException.initCause(e11);
                zzf(openAssetFileDescriptor2, fileNotFoundException);
                throw fileNotFoundException;
            }
        } else {
            throw new FileNotFoundException("Unsupported scheme");
        }
    }

    public static InputStream zzb(Context context, Uri uri, zzi zzi) throws FileNotFoundException {
        ContentResolver contentResolver = context.getContentResolver();
        Uri zzc2 = zzc(uri);
        String scheme = zzc2.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openInputStream(zzc2);
        }
        if ("content".equals(scheme)) {
            if (zzi(context, zzc2, 1, zzi)) {
                InputStream openInputStream = contentResolver.openInputStream(zzc2);
                zzd(openInputStream);
                return openInputStream;
            }
            throw new FileNotFoundException("Can't open content uri.");
        } else if ("file".equals(scheme)) {
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(zzc2.getPath()).getCanonicalFile()), StreamManagement.AckRequest.ELEMENT);
                try {
                    zzh(context, openFileDescriptor, zzc2, zzi);
                    return new ParcelFileDescriptor.AutoCloseInputStream(openFileDescriptor);
                } catch (FileNotFoundException e10) {
                    zzg(openFileDescriptor, e10);
                    throw e10;
                } catch (IOException e11) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                    fileNotFoundException.initCause(e11);
                    zzg(openFileDescriptor, fileNotFoundException);
                    throw fileNotFoundException;
                }
            } catch (IOException e12) {
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
                fileNotFoundException2.initCause(e12);
                throw fileNotFoundException2;
            }
        } else {
            throw new FileNotFoundException("Unsupported scheme");
        }
    }

    private static Uri zzc(Uri uri) {
        return Build.VERSION.SDK_INT < 30 ? Uri.parse(uri.toString()) : uri;
    }

    private static Object zzd(Object obj) throws FileNotFoundException {
        if (obj != null) {
            return obj;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }

    private static String zze(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (!canonicalPath.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return canonicalPath.concat(RemoteSettings.FORWARD_SLASH_STRING);
        }
        return canonicalPath;
    }

    private static void zzf(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
        } catch (IOException e10) {
            zzb.zza(fileNotFoundException, e10);
        }
    }

    private static void zzg(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e10) {
            zzb.zza(fileNotFoundException, e10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzh(android.content.Context r7, android.os.ParcelFileDescriptor r8, android.net.Uri r9, com.google.android.gms.internal.mlkit_common.zzi r10) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r9 = r9.getPath()
            r0.<init>(r9)
            java.lang.String r9 = r0.getCanonicalPath()
            java.io.FileDescriptor r8 = r8.getFileDescriptor()
            com.google.android.gms.internal.mlkit_common.zzq r8 = com.google.android.gms.internal.mlkit_common.zzq.zza(r8)
            com.google.android.gms.internal.mlkit_common.zzq r0 = com.google.android.gms.internal.mlkit_common.zzq.zzb(r9)
            boolean r1 = r0.zzc
            java.lang.String r2 = "Can't open file: "
            if (r1 != 0) goto L_0x00da
            long r3 = r8.zza
            long r5 = r0.zza
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00cc
            long r3 = r8.zzb
            long r0 = r0.zzb
            int r8 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r8 != 0) goto L_0x00cc
            java.lang.String r8 = "/proc/"
            boolean r8 = r9.startsWith(r8)
            if (r8 != 0) goto L_0x00c2
            java.lang.String r8 = "/data/misc/"
            boolean r8 = r9.startsWith(r8)
            if (r8 != 0) goto L_0x00c2
            boolean unused = r10.zze
            java.io.File r8 = androidx.core.content.a.getDataDir(r7)
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L_0x0057
            java.lang.String r8 = zze(r8)
            boolean r8 = r9.startsWith(r8)
            if (r8 == 0) goto L_0x0066
        L_0x0054:
            r0 = r1
            goto L_0x00bb
        L_0x0057:
            java.io.File r8 = android.os.Environment.getDataDirectory()
            java.lang.String r8 = zze(r8)
            boolean r8 = r9.startsWith(r8)
            if (r8 == 0) goto L_0x0066
            goto L_0x0054
        L_0x0066:
            android.content.Context r8 = androidx.core.content.a.createDeviceProtectedStorageContext(r7)
            if (r8 == 0) goto L_0x007d
            java.io.File r8 = androidx.core.content.a.getDataDir(r8)
            if (r8 == 0) goto L_0x007d
            java.lang.String r8 = zze(r8)
            boolean r8 = r9.startsWith(r8)
            if (r8 == 0) goto L_0x007d
            goto L_0x0054
        L_0x007d:
            com.google.android.gms.internal.mlkit_common.zzc r8 = new com.google.android.gms.internal.mlkit_common.zzc
            r8.<init>(r7)
            java.io.File[] r8 = zzj(r8)
            int r3 = r8.length
            r4 = r0
        L_0x0088:
            if (r4 >= r3) goto L_0x009c
            r5 = r8[r4]
            if (r5 == 0) goto L_0x0099
            java.lang.String r5 = zze(r5)
            boolean r5 = r9.startsWith(r5)
            if (r5 == 0) goto L_0x0099
            goto L_0x0054
        L_0x0099:
            int r4 = r4 + 1
            goto L_0x0088
        L_0x009c:
            com.google.android.gms.internal.mlkit_common.zzd r8 = new com.google.android.gms.internal.mlkit_common.zzd
            r8.<init>(r7)
            java.io.File[] r7 = zzj(r8)
            int r8 = r7.length
            r3 = r0
        L_0x00a7:
            if (r3 >= r8) goto L_0x00bb
            r4 = r7[r3]
            if (r4 == 0) goto L_0x00b8
            java.lang.String r4 = zze(r4)
            boolean r4 = r9.startsWith(r4)
            if (r4 == 0) goto L_0x00b8
            goto L_0x0054
        L_0x00b8:
            int r3 = r3 + 1
            goto L_0x00a7
        L_0x00bb:
            boolean r7 = r10.zzd
            if (r0 != r7) goto L_0x00c2
            return
        L_0x00c2:
            java.io.FileNotFoundException r7 = new java.io.FileNotFoundException
            java.lang.String r8 = r2.concat(r9)
            r7.<init>(r8)
            throw r7
        L_0x00cc:
            java.lang.String r7 = java.lang.String.valueOf(r9)
            java.io.FileNotFoundException r8 = new java.io.FileNotFoundException
            java.lang.String r7 = r2.concat(r7)
            r8.<init>(r7)
            throw r8
        L_0x00da:
            java.lang.String r7 = java.lang.String.valueOf(r9)
            java.io.FileNotFoundException r8 = new java.io.FileNotFoundException
            java.lang.String r7 = r2.concat(r7)
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzj.zzh(android.content.Context, android.os.ParcelFileDescriptor, android.net.Uri, com.google.android.gms.internal.mlkit_common.zzi):void");
    }

    private static boolean zzi(Context context, Uri uri, int i10, zzi zzi) {
        String authority = uri.getAuthority();
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (resolveContentProvider == null) {
            int lastIndexOf = authority.lastIndexOf(64);
            if (lastIndexOf >= 0) {
                authority = authority.substring(lastIndexOf + 1);
                resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (resolveContentProvider == null) {
                if (!zzi.zzd) {
                    return true;
                }
                return false;
            }
        }
        if (zzi.zzc(zzi, context, new zzr(uri, resolveContentProvider, authority)) - 1 == 1) {
            return false;
        }
        if (context.getPackageName().equals(resolveContentProvider.packageName)) {
            return zzi.zzd;
        }
        if (zzi.zzd) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) != 0 && resolveContentProvider.exported) {
            String[] strArr = zzc;
            int length = strArr.length;
            for (int i11 = 0; i11 < 2; i11++) {
                if (strArr[i11].equals(authority)) {
                    return true;
                }
            }
            String[] strArr2 = zzd;
            int length2 = strArr2.length;
            for (int i12 = 0; i12 < 3; i12++) {
                if (strArr2[i12].equals(authority)) {
                    return true;
                }
            }
            String[] strArr3 = zzb;
            for (int i13 = 0; i13 < 6; i13++) {
                String str = strArr3[i13];
                if (str.charAt(str.length() - 1) == '.') {
                    if (resolveContentProvider.packageName.startsWith(str)) {
                        return false;
                    }
                } else if (resolveContentProvider.packageName.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static File[] zzj(Callable callable) {
        try {
            return (File[]) callable.call();
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }
}
