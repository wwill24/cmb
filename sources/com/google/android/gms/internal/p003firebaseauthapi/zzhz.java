package com.google.android.gms.internal.p003firebaseauthapi;

import android.os.Build;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jivesoftware.smack.util.SystemUtil;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhz  reason: invalid package */
public final class zzhz {
    private static final ThreadLocal zza = new zzhy();
    private final SecretKey zzb;
    private final boolean zzc;

    public zzhz(byte[] bArr, boolean z10) throws GeneralSecurityException {
        if (zzij.zza(2)) {
            zzzl.zzb(bArr.length);
            this.zzb = new SecretKeySpec(bArr, "AES");
            this.zzc = z10;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        int i10;
        AlgorithmParameterSpec algorithmParameterSpec;
        int i11 = 12;
        if (bArr.length == 12) {
            boolean z10 = this.zzc;
            if (true != z10) {
                i10 = 16;
            } else {
                i10 = 28;
            }
            int length = bArr2.length;
            if (length < i10) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (!z10 || ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
                String property = System.getProperty(SystemUtil.PROPERTY_JAVA_VENDOR);
                Integer num = null;
                if (property == "The Android Project" || (property != null && property.equals("The Android Project"))) {
                    num = Integer.valueOf(Build.VERSION.SDK_INT);
                }
                if (num == null || num.intValue() > 19) {
                    algorithmParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
                } else {
                    algorithmParameterSpec = new IvParameterSpec(bArr, 0, 12);
                }
                ThreadLocal threadLocal = zza;
                ((Cipher) threadLocal.get()).init(2, this.zzb, algorithmParameterSpec);
                boolean z11 = this.zzc;
                if (true != z11) {
                    i11 = 0;
                }
                if (z11) {
                    length -= 12;
                }
                return ((Cipher) threadLocal.get()).doFinal(bArr2, i11, length);
            } else {
                throw new GeneralSecurityException("iv does not match prepended iv");
            }
        } else {
            throw new GeneralSecurityException("iv is wrong size");
        }
    }
}
