package com.google.android.recaptcha.internal;

import java.io.IOException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract class zzeb {
    private static final zzeb zza;
    private static final zzeb zzb;
    private static final zzeb zzc;
    private static final zzeb zzd;
    private static final zzeb zze = new zzdx("base16()", "0123456789ABCDEF");

    static {
        Character valueOf = Character.valueOf(SignatureVisitor.INSTANCEOF);
        zza = new zzdy("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        zzb = new zzdy("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        zzc = new zzea("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        zzd = new zzea("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
    }

    zzeb() {
    }

    public static zzeb zzg() {
        return zza;
    }

    public static zzeb zzh() {
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(byte[] bArr, CharSequence charSequence) throws zzdz;

    /* access modifiers changed from: package-private */
    public abstract void zzb(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i10);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i10);

    /* access modifiers changed from: package-private */
    public CharSequence zze(CharSequence charSequence) {
        throw null;
    }

    public final String zzi(byte[] bArr, int i10, int i11) {
        zzdi.zzd(0, i11, bArr.length);
        StringBuilder sb2 = new StringBuilder(zzd(i11));
        try {
            zzb(sb2, bArr, 0, i11);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public final byte[] zzj(CharSequence charSequence) {
        try {
            CharSequence zze2 = zze(charSequence);
            int zzc2 = zzc(zze2.length());
            byte[] bArr = new byte[zzc2];
            int zza2 = zza(bArr, zze2);
            if (zza2 == zzc2) {
                return bArr;
            }
            byte[] bArr2 = new byte[zza2];
            System.arraycopy(bArr, 0, bArr2, 0, zza2);
            return bArr2;
        } catch (zzdz e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
