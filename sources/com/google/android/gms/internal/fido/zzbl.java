package com.google.android.gms.internal.fido;

import java.io.IOException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract class zzbl {
    private static final zzbl zza;
    private static final zzbl zzb;
    private static final zzbl zzc;
    private static final zzbl zzd;
    private static final zzbl zze = new zzbi("base16()", "0123456789ABCDEF");

    static {
        Character valueOf = Character.valueOf(SignatureVisitor.INSTANCEOF);
        zza = new zzbj("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        zzb = new zzbj("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        zzc = new zzbk("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        zzd = new zzbk("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
    }

    zzbl() {
    }

    public static zzbl zzd() {
        return zze;
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract int zzb(int i10);

    public final String zze(byte[] bArr, int i10, int i11) {
        zzas.zze(0, i11, bArr.length);
        StringBuilder sb2 = new StringBuilder(zzb(i11));
        try {
            zza(sb2, bArr, 0, i11);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
