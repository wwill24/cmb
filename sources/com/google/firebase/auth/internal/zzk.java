package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.internal.p003firebaseauthapi.zzbf;
import com.google.android.gms.internal.p003firebaseauthapi.zzbk;
import com.google.android.gms.internal.p003firebaseauthapi.zzca;
import com.google.android.gms.internal.p003firebaseauthapi.zzla;
import com.google.android.gms.internal.p003firebaseauthapi.zzlf;
import com.google.android.gms.internal.p003firebaseauthapi.zzmh;
import com.google.android.gms.internal.p003firebaseauthapi.zzmj;
import com.google.android.gms.internal.p003firebaseauthapi.zzos;
import com.google.android.gms.internal.p003firebaseauthapi.zzq;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public final class zzk {
    private static zzk zza;
    private final String zzb;
    private final zzmj zzc;

    private zzk(Context context, String str, boolean z10) {
        zzmj zzmj;
        this.zzb = str;
        try {
            zzla.zza();
            zzmh zzmh = new zzmh();
            zzmh.zzf(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", new Object[]{str}));
            zzmh.zzd(zzlf.zza);
            zzmh.zze(String.format("android-keystore://firebear_master_key_id.%s", new Object[]{str}));
            zzmj = zzmh.zzg();
        } catch (IOException | GeneralSecurityException e10) {
            "Exception encountered during crypto setup:\n".concat(String.valueOf(e10.getMessage()));
            zzmj = null;
        }
        this.zzc = zzmj;
    }

    public static zzk zza(Context context, String str) {
        zzk zzk = zza;
        if (zzk == null || !zzq.zza(zzk.zzb, str)) {
            zza = new zzk(context, str, true);
        }
        return zza;
    }

    public final String zzb(String str) {
        String str2;
        zzmj zzmj = this.zzc;
        if (zzmj != null) {
            try {
                synchronized (zzmj) {
                    str2 = new String(((zzbk) this.zzc.zza().zze(zzos.zza(), zzbk.class)).zza(Base64.decode(str, 8), (byte[]) null), "UTF-8");
                }
                return str2;
            } catch (UnsupportedEncodingException | GeneralSecurityException e10) {
                "Exception encountered while decrypting bytes:\n".concat(String.valueOf(e10.getMessage()));
            }
        }
        return null;
    }

    public final String zzc() {
        if (this.zzc == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzca zza2 = zzbf.zza(byteArrayOutputStream);
        try {
            synchronized (this.zzc) {
                this.zzc.zza().zzb().zzg(zza2);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e10) {
            "Exception encountered when attempting to get Public Key:\n".concat(String.valueOf(e10.getMessage()));
            return null;
        }
    }
}
