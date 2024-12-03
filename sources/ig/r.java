package ig;

import gg.a;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class r implements a {

    /* renamed from: a  reason: collision with root package name */
    private final SecretKey f23538a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f23539b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f23540c;

    public r(byte[] bArr) throws GeneralSecurityException {
        w.a(bArr.length);
        this.f23538a = new SecretKeySpec(bArr, "AES");
        b();
    }

    private void b() throws GeneralSecurityException {
        Cipher c10 = c();
        c10.init(1, this.f23538a);
        byte[] b10 = e.b(c10.doFinal(new byte[16]));
        this.f23539b = b10;
        this.f23540c = e.b(b10);
    }

    private static Cipher c() throws GeneralSecurityException {
        return m.f23528f.a("AES/ECB/NoPadding");
    }

    public byte[] a(byte[] bArr, int i10) throws GeneralSecurityException {
        boolean z10;
        byte[] bArr2;
        if (i10 <= 16) {
            Cipher c10 = c();
            c10.init(1, this.f23538a);
            int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
            if (max * 16 == bArr.length) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                bArr2 = g.d(bArr, (max - 1) * 16, this.f23539b, 0, 16);
            } else {
                bArr2 = g.e(e.a(Arrays.copyOfRange(bArr, (max - 1) * 16, bArr.length)), this.f23540c);
            }
            byte[] bArr3 = new byte[16];
            for (int i11 = 0; i11 < max - 1; i11++) {
                bArr3 = c10.doFinal(g.d(bArr3, 0, bArr, i11 * 16, 16));
            }
            return Arrays.copyOf(c10.doFinal(g.e(bArr2, bArr3)), i10);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
