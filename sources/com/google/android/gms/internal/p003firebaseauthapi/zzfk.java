package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfk  reason: invalid package */
public final class zzfk extends zzng {
    zzfk() {
        super(zztm.class, new zzfi(zzbd.class));
    }

    public static void zzg(boolean z10) throws GeneralSecurityException {
        if (zzh()) {
            zzcq.zzg(new zzfk(), true);
            int i10 = zzfu.zza;
            zzfu.zzc(zznt.zzc());
        }
    }

    private static boolean zzh() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final zznf zza() {
        return new zzfj(this, zztp.class);
    }

    public final zzwh zzb() {
        return zzwh.SYMMETRIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zztm.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zztm zztm = (zztm) zzalp;
        zzzl.zzc(zztm.zza(), 0);
        zzzl.zzb(zztm.zze().zzd());
    }
}
