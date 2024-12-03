package com.google.android.gms.internal.p003firebaseauthapi;

import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzml  reason: invalid package */
public final class zzml implements zzcb {
    private static final Object zza = new Object();
    private static final String zzb = "zzml";
    private KeyStore zzc;

    public zzml() throws GeneralSecurityException {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            this.zzc = instance;
        } catch (IOException | GeneralSecurityException e10) {
            throw new IllegalStateException(e10);
        }
    }

    static boolean zzc(String str) throws GeneralSecurityException {
        zzml zzml = new zzml();
        synchronized (zza) {
            if (zzml.zzd(str)) {
                return false;
            }
            String zza2 = zzzl.zza("android-keystore://", str);
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(new KeyGenParameterSpec.Builder(zza2, 3).setKeySize(256).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
            instance.generateKey();
            return true;
        }
    }

    public final synchronized zzbd zza(String str) throws GeneralSecurityException {
        zzmk zzmk;
        zzmk = new zzmk(zzzl.zza("android-keystore://", str), this.zzc);
        byte[] zzb2 = zzor.zzb(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(zzb2, zzmk.zza(zzmk.zzb(zzb2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzmk;
    }

    public final synchronized boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        java.lang.Thread.sleep((long) ((int) (java.lang.Math.random() * 40.0d)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0 = java.security.KeyStore.getInstance("AndroidKeyStore");
        r4.zzc = r0;
        r0.load((java.security.KeyStore.LoadStoreParameter) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        return r4.zzc.containsAlias(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        throw new java.security.GeneralSecurityException(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzd(java.lang.String r5) throws java.security.GeneralSecurityException {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "android-keystore://"
            java.lang.String r5 = com.google.android.gms.internal.p003firebaseauthapi.zzzl.zza(r0, r5)     // Catch:{ all -> 0x0036 }
            java.security.KeyStore r0 = r4.zzc     // Catch:{ NullPointerException -> 0x000f }
            boolean r5 = r0.containsAlias(r5)     // Catch:{ NullPointerException -> 0x000f }
            monitor-exit(r4)
            return r5
        L_0x000f:
            double r0 = java.lang.Math.random()     // Catch:{ IOException -> 0x002f }
            r2 = 4630826316843712512(0x4044000000000000, double:40.0)
            double r0 = r0 * r2
            int r0 = (int) r0
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x001b }
        L_0x001b:
            java.lang.String r0 = "AndroidKeyStore"
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ IOException -> 0x002f }
            r4.zzc = r0     // Catch:{ IOException -> 0x002f }
            r1 = 0
            r0.load(r1)     // Catch:{ IOException -> 0x002f }
            java.security.KeyStore r0 = r4.zzc     // Catch:{ all -> 0x0036 }
            boolean r5 = r0.containsAlias(r5)     // Catch:{ all -> 0x0036 }
            monitor-exit(r4)
            return r5
        L_0x002f:
            r5 = move-exception
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0036 }
            r0.<init>(r5)     // Catch:{ all -> 0x0036 }
            throw r0     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzml.zzd(java.lang.String):boolean");
    }
}
