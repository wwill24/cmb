package ig;

import ag.c;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class d implements c {

    /* renamed from: c  reason: collision with root package name */
    private static final Collection<Integer> f23496c = Arrays.asList(new Integer[]{64});

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f23497d = new byte[16];

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f23498e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* renamed from: a  reason: collision with root package name */
    private final r f23499a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f23500b;

    public d(byte[] bArr) throws GeneralSecurityException {
        if (f23496c.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.f23500b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.f23499a = new r(copyOfRange);
            return;
        }
        throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
    }

    private byte[] c(byte[]... bArr) throws GeneralSecurityException {
        byte[] bArr2;
        if (bArr.length == 0) {
            return this.f23499a.a(f23498e, 16);
        }
        byte[] a10 = this.f23499a.a(f23497d, 16);
        for (int i10 = 0; i10 < bArr.length - 1; i10++) {
            byte[] bArr3 = bArr[i10];
            if (bArr3 == null) {
                bArr3 = new byte[0];
            }
            a10 = g.e(e.b(a10), this.f23499a.a(bArr3, 16));
        }
        byte[] bArr4 = bArr[bArr.length - 1];
        if (bArr4.length >= 16) {
            bArr2 = g.f(bArr4, a10);
        } else {
            bArr2 = g.e(e.a(bArr4), e.b(a10));
        }
        return this.f23499a.a(bArr2, 16);
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483631) {
            Cipher a10 = m.f23528f.a("AES/CTR/NoPadding");
            byte[] c10 = c(bArr2, bArr);
            byte[] bArr3 = (byte[]) c10.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            a10.init(1, new SecretKeySpec(this.f23500b, "AES"), new IvParameterSpec(bArr3));
            return g.a(c10, a10.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 16) {
            Cipher a10 = m.f23528f.a("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr3 = (byte[]) copyOfRange.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            a10.init(2, new SecretKeySpec(this.f23500b, "AES"), new IvParameterSpec(bArr3));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
            byte[] doFinal = a10.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && v.b()) {
                doFinal = new byte[0];
            }
            if (g.b(copyOfRange, c(bArr2, doFinal))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
