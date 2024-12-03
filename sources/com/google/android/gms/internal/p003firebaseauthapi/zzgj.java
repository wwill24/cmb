package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgj  reason: invalid package */
public final class zzgj implements zzbd {
    private static final byte[] zza = new byte[0];
    private static final Set zzb;
    private final zzwn zzc;
    private final zzbd zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    public zzgj(zzwn zzwn, zzbd zzbd) {
        if (zzc(zzwn.zzg())) {
            this.zzc = zzwn;
            this.zzd = zzbd;
            return;
        }
        String zzg = zzwn.zzg();
        throw new IllegalArgumentException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
    }

    public static boolean zzc(String str) {
        return zzb.contains(str);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i10 = wrap.getInt();
            if (i10 <= 0 || i10 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i10];
            wrap.get(bArr3, 0, i10);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            byte[] zza2 = this.zzd.zza(bArr3, zza);
            int i11 = zzcq.zza;
            zzajf zzajf = zzajf.zzb;
            return ((zzbd) zzcq.zze(this.zzc.zzg(), zzajf.zzn(zza2, 0, zza2.length), zzbd.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e10) {
            throw new GeneralSecurityException("invalid ciphertext", e10);
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
