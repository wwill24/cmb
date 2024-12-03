package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Context;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmh  reason: invalid package */
public final class zzmh {
    /* access modifiers changed from: private */
    public Context zza = null;
    /* access modifiers changed from: private */
    public String zzb = null;
    /* access modifiers changed from: private */
    public String zzc = null;
    private String zzd = null;
    /* access modifiers changed from: private */
    public zzbd zze = null;
    private zzbv zzf = null;
    private zzwn zzg = null;
    /* access modifiers changed from: private */
    public zzbz zzh;

    private final zzbd zzj() throws GeneralSecurityException {
        if (!zzmj.zzd()) {
            String unused = zzmj.zzb;
            return null;
        }
        zzml zzml = new zzml();
        try {
            boolean zzc2 = zzml.zzc(this.zzd);
            try {
                return zzml.zza(this.zzd);
            } catch (GeneralSecurityException | ProviderException e10) {
                if (zzc2) {
                    String unused2 = zzmj.zzb;
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.zzd}), e10);
            }
        } catch (GeneralSecurityException | ProviderException unused3) {
            String unused4 = zzmj.zzb;
            return null;
        }
    }

    private final zzbz zzk(byte[] bArr) throws GeneralSecurityException, IOException {
        try {
            this.zze = new zzml().zza(this.zzd);
            try {
                return zzbz.zzf(zzby.zzh(zzbe.zzc(bArr), this.zze));
            } catch (IOException | GeneralSecurityException e10) {
                try {
                    return zzl(bArr);
                } catch (IOException unused) {
                    throw e10;
                }
            }
        } catch (GeneralSecurityException | ProviderException e11) {
            try {
                zzbz zzl = zzl(bArr);
                String unused2 = zzmj.zzb;
                return zzl;
            } catch (IOException unused3) {
                throw e11;
            }
        }
    }

    private static final zzbz zzl(byte[] bArr) throws GeneralSecurityException, IOException {
        return zzbz.zzf(zzbg.zzb(zzbe.zzc(bArr)));
    }

    public final zzmh zzd(zzwn zzwn) {
        this.zzg = zzwn;
        return this;
    }

    public final zzmh zze(String str) {
        if (str.startsWith("android-keystore://")) {
            this.zzd = str;
            return this;
        }
        throw new IllegalArgumentException("key URI must start with android-keystore://");
    }

    public final zzmh zzf(Context context, String str, String str2) throws IOException {
        if (context != null) {
            this.zza = context;
            this.zzb = "GenericIdpKeyset";
            this.zzc = str2;
            return this;
        }
        throw new IllegalArgumentException("need an Android context");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:66|67|68) */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0110, code lost:
        throw new java.io.CharConversionException(java.lang.String.format("can't read keyset; the pref value %s is not a valid hex string", new java.lang.Object[]{r2}));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x0100 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:66:0x0100=Splitter:B:66:0x0100, B:45:0x00c6=Splitter:B:45:0x00c6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.p003firebaseauthapi.zzmj zzg() throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = r11.zzb     // Catch:{ all -> 0x0124 }
            if (r0 == 0) goto L_0x011c
            com.google.android.gms.internal.firebase-auth-api.zzwn r0 = r11.zzg     // Catch:{ all -> 0x0124 }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.firebase-auth-api.zzbv r1 = r11.zzf     // Catch:{ all -> 0x0124 }
            if (r1 != 0) goto L_0x001b
            byte[] r0 = r0.zzq()     // Catch:{ all -> 0x0124 }
            com.google.android.gms.internal.firebase-auth-api.zzce r0 = com.google.android.gms.internal.p003firebaseauthapi.zzcs.zza(r0)     // Catch:{ all -> 0x0124 }
            com.google.android.gms.internal.firebase-auth-api.zzbv r0 = com.google.android.gms.internal.p003firebaseauthapi.zzbv.zza(r0)     // Catch:{ all -> 0x0124 }
            r11.zzf = r0     // Catch:{ all -> 0x0124 }
        L_0x001b:
            java.lang.Object r0 = com.google.android.gms.internal.p003firebaseauthapi.zzmj.zza     // Catch:{ all -> 0x0124 }
            monitor-enter(r0)     // Catch:{ all -> 0x0124 }
            android.content.Context r1 = r11.zza     // Catch:{ all -> 0x0119 }
            java.lang.String r2 = r11.zzb     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r11.zzc     // Catch:{ all -> 0x0119 }
            if (r2 == 0) goto L_0x0111
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0119 }
            r4 = 0
            if (r3 != 0) goto L_0x0034
            android.content.SharedPreferences r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r1)     // Catch:{ all -> 0x0119 }
            goto L_0x0038
        L_0x0034:
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r3, r4)     // Catch:{ all -> 0x0119 }
        L_0x0038:
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            if (r1 != 0) goto L_0x0041
            r6 = r3
            goto L_0x0080
        L_0x0041:
            int r5 = r1.length()     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x00f8
            int r5 = r1.length()     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            int r5 = r5 / 2
            byte[] r6 = new byte[r5]     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            r7 = r4
        L_0x0052:
            if (r7 >= r5) goto L_0x0080
            int r8 = r7 + r7
            char r9 = r1.charAt(r8)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            r10 = 16
            int r9 = java.lang.Character.digit(r9, r10)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            int r8 = r8 + 1
            char r8 = r1.charAt(r8)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            int r8 = java.lang.Character.digit(r8, r10)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            r10 = -1
            if (r9 == r10) goto L_0x0078
            if (r8 == r10) goto L_0x0078
            int r9 = r9 * 16
            int r9 = r9 + r8
            byte r8 = (byte) r9     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            r6[r7] = r8     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            int r7 = r7 + 1
            goto L_0x0052
        L_0x0078:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            java.lang.String r3 = "input is not hexadecimal"
            r1.<init>(r3)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            throw r1     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
        L_0x0080:
            if (r6 != 0) goto L_0x00d8
            java.lang.String r1 = r11.zzd     // Catch:{ all -> 0x0119 }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.firebase-auth-api.zzbd r1 = r11.zzj()     // Catch:{ all -> 0x0119 }
            r11.zze = r1     // Catch:{ all -> 0x0119 }
        L_0x008c:
            com.google.android.gms.internal.firebase-auth-api.zzbv r1 = r11.zzf     // Catch:{ all -> 0x0119 }
            if (r1 == 0) goto L_0x00d0
            com.google.android.gms.internal.firebase-auth-api.zzbz r1 = com.google.android.gms.internal.p003firebaseauthapi.zzbz.zze()     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.firebase-auth-api.zzbv r2 = r11.zzf     // Catch:{ all -> 0x0119 }
            r1.zzc(r2)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.firebase-auth-api.zzby r2 = r1.zzb()     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.firebase-auth-api.zzxa r2 = r2.zzd()     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.firebase-auth-api.zzwz r2 = r2.zzb(r4)     // Catch:{ all -> 0x0119 }
            int r2 = r2.zza()     // Catch:{ all -> 0x0119 }
            r1.zzd(r2)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.firebase-auth-api.zzmm r2 = new com.google.android.gms.internal.firebase-auth-api.zzmm     // Catch:{ all -> 0x0119 }
            android.content.Context r4 = r11.zza     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = r11.zzb     // Catch:{ all -> 0x0119 }
            java.lang.String r6 = r11.zzc     // Catch:{ all -> 0x0119 }
            r2.<init>(r4, r5, r6)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.firebase-auth-api.zzby r4 = r1.zzb()     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.firebase-auth-api.zzbd r5 = r11.zze     // Catch:{ all -> 0x0119 }
            if (r5 == 0) goto L_0x00c3
            r4.zzf(r2, r5)     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00c6
        L_0x00c3:
            com.google.android.gms.internal.p003firebaseauthapi.zzbg.zza(r4, r2)     // Catch:{ IOException -> 0x00c9 }
        L_0x00c6:
            r11.zzh = r1     // Catch:{ all -> 0x0119 }
            goto L_0x00f0
        L_0x00c9:
            r1 = move-exception
            java.security.GeneralSecurityException r2 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0119 }
            r2.<init>(r1)     // Catch:{ all -> 0x0119 }
            throw r2     // Catch:{ all -> 0x0119 }
        L_0x00d0:
            java.security.GeneralSecurityException r1 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0119 }
            java.lang.String r2 = "cannot read or generate keyset"
            r1.<init>(r2)     // Catch:{ all -> 0x0119 }
            throw r1     // Catch:{ all -> 0x0119 }
        L_0x00d8:
            java.lang.String r1 = r11.zzd     // Catch:{ all -> 0x0119 }
            if (r1 == 0) goto L_0x00ea
            boolean r1 = com.google.android.gms.internal.p003firebaseauthapi.zzmj.zzd()     // Catch:{ all -> 0x0119 }
            if (r1 != 0) goto L_0x00e3
            goto L_0x00ea
        L_0x00e3:
            com.google.android.gms.internal.firebase-auth-api.zzbz r1 = r11.zzk(r6)     // Catch:{ all -> 0x0119 }
            r11.zzh = r1     // Catch:{ all -> 0x0119 }
            goto L_0x00f0
        L_0x00ea:
            com.google.android.gms.internal.firebase-auth-api.zzbz r1 = zzl(r6)     // Catch:{ all -> 0x0119 }
            r11.zzh = r1     // Catch:{ all -> 0x0119 }
        L_0x00f0:
            com.google.android.gms.internal.firebase-auth-api.zzmj r1 = new com.google.android.gms.internal.firebase-auth-api.zzmj     // Catch:{ all -> 0x0119 }
            r1.<init>(r11, r3)     // Catch:{ all -> 0x0119 }
            monitor-exit(r0)     // Catch:{ all -> 0x0119 }
            monitor-exit(r11)
            return r1
        L_0x00f8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            java.lang.String r3 = "Expected a string of even length"
            r1.<init>(r3)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
            throw r1     // Catch:{ ClassCastException | IllegalArgumentException -> 0x0100 }
        L_0x0100:
            java.io.CharConversionException r1 = new java.io.CharConversionException     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = "can't read keyset; the pref value %s is not a valid hex string"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0119 }
            r5[r4] = r2     // Catch:{ all -> 0x0119 }
            java.lang.String r2 = java.lang.String.format(r3, r5)     // Catch:{ all -> 0x0119 }
            r1.<init>(r2)     // Catch:{ all -> 0x0119 }
            throw r1     // Catch:{ all -> 0x0119 }
        L_0x0111:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0119 }
            java.lang.String r2 = "keysetName cannot be null"
            r1.<init>(r2)     // Catch:{ all -> 0x0119 }
            throw r1     // Catch:{ all -> 0x0119 }
        L_0x0119:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0119 }
            throw r1     // Catch:{ all -> 0x0124 }
        L_0x011c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0124 }
            java.lang.String r1 = "keysetName cannot be null"
            r0.<init>(r1)     // Catch:{ all -> 0x0124 }
            throw r0     // Catch:{ all -> 0x0124 }
        L_0x0124:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzmh.zzg():com.google.android.gms.internal.firebase-auth-api.zzmj");
    }
}
